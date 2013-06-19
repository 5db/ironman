package com.ironman.domain;

import java.util.Date;

/**
 * @author jsingh on 2013-06-18 at 11:36 PM
 */
public class BaseObject {
    private Date dateCreated;

    private Date dateUpdated;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
