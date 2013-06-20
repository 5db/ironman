import groovy.sql.Sql

/**
 * Creates dummy data
 *
 * @author Jatinder Singh on 19, June 2013 at 09:31 PM
 */
class DataCreator  {
    static void main(String[] args) {
        println "Running IronManCreator."
        Creator creator = new IronManCreator()
        creator.create()
        println "Finished running IronManCreator."
    }
}

/**
 * Creates dummy data for the iron man project
 */
class IronManCreator extends AbstractCreator {
    public static final String PG_INSERT_INTO_LISTINGS = """
        INSERT INTO LISTINGS(LISTING_ID, LISTED_PRICE, BEDROOMS, BATHROOMS, PROPERTY_TYPE, PROPERTY_TAX,
                    DESCRIPTION, LISTING_STATUS, PROVINCE, CITY, POSTAL_CODE, DATE_CREATED, DATE_UPDATED)
        VALUES(nextval('listing_pkey_seq'), ?, ?, ?, ?, ?, 
            ?, ?, ?, ?, ?, NOW(), NOW()) """
    public static final int totalData = 50000

    @Override
    void create() {
        int counter = 0

        while(counter < totalData) {
            postgreSqlDb.execute(PG_INSERT_INTO_LISTINGS, [
                    new Random().nextInt(1000000 - 400000) + 400000,
                    new Random().nextInt(5 - 1) + 1,
                    new Random().nextInt(4 - 1) + 1,
                    getPropertyTypeData(),
                    new Random().nextInt(7000 - 2000) + 2000,
                    getStringData(),
                    getListingStatusData(),
                    "ON",
                    getCityData(),
                    getPostalCodeData()
            ])
            counter++
        }
    }

    String getStringData() {
        int length = new Random().nextInt(3999 - 300) + 300
        char [] subset = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random r = new Random()
        char[] buf = new char[length];
        for (int i=0;i<buf.length;i++) {
            int index = r.nextInt(subset.length);
            buf[i] = subset[index];
        }
        return new String(buf);
    }

    String getPropertyTypeData() {
        def propertyTypes = ["SINGLE", "SEMI", "TOWNHOUSE", "CONDOMINIUM"]
        return propertyTypes.get(new Random().nextInt(propertyTypes.size()))
    }

    String getListingStatusData() {
        def statuses = ["SOLD", "AVAILABLE", "HAS_OFFER", "HOLD", "REMOVED"]
        return statuses.get(new Random().nextInt(statuses.size()))
    }

    String getCityData() {
        def provinces = ["MISSISSAUGA", "TORONTO", "BRAMPTON", "HAMILTON", "MILTON", "WOODBRIDGE",
                "ETOBICOKE", "BOLTON", "PICKERING", "AJAX"]
        return provinces.get(new Random().nextInt(provinces.size()))
    }

    String getPostalCodeData() {
        def postalCodes = ["M9Z3G9", "M9G3G7", "L5G9D9", "B7U3R4", "U8Y3R4", "N7H2H0",
                "G7GT7T", "L6P2Y2", "R4RT5T", "F9H3D9"]
        return postalCodes.get(new Random().nextInt(postalCodes.size()))
    }
}

abstract class AbstractCreator implements Creator {
    Sql postgreSqlDb

    AbstractCreator() {
        postgreSqlDb = Sql.newInstance('jdbc:postgresql://localhost:5432/webdb',
                'jsingh', 'postgresql', 'org.postgresql.Driver')
    }

    abstract void create()
}

interface Creator {
    void create()
}