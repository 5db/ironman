DROP TABLE LISTINGS;

CREATE TABLE LISTINGS (LISTING_ID BIGINT NOT NULL,
                      PICTURE BYTEA,
                      LISTED_PRICE NUMERIC NOT NULL,
                      BEDROOMS FLOAT4 NOT NULL ,
                      BATHROOMS FLOAT4 NOT NULL ,
                      PROPERTY_TYPE VARCHAR(30) NOT NULL ,
                      PROPERTY_TAX NUMERIC,
                      DESCRIPTION TEXT,
                      LISTING_STATUS VARCHAR(30) NOT NULL ,
                      PROVINCE VARCHAR(2),
                      CITY VARCHAR(50),
                      POSTAL_CODE VARCHAR(6),
  CONSTRAINT listings_pkey PRIMARY KEY (LISTING_ID)
);

CREATE INDEX IDX_LISTINGS_CITY ON LISTINGS(CITY);
CREATE INDEX IDX_LISTINGS_PROVINCE ON LISTINGS(PROVINCE);
CREATE INDEX IDX_LISTINGS_PRICE ON LISTINGS(LISTED_PRICE);
CREATE INDEX IDX_LISTINGS_BEDROOMS ON LISTINGS(BEDROOMS);