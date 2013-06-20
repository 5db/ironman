package com.ironman.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jsingh on 2013-06-18 at 11:36 PM
 */
@MappedSuperclass
public class BaseObject implements Serializable {

    @Column(name = "DATE_CREATED", nullable = false, columnDefinition = "timestamp DEFAULT CURRENT_DATE")
    private Date dateCreated;

    @Column(name = "DATE_UPDATED", nullable = false, columnDefinition = "timestamp DEFAULT CURRENT_DATE")
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
