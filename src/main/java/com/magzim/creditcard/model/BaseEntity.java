package com.magzim.creditcard.model;

/**
 * Created by max on 6/27/15.
 */
public class BaseEntity {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {return (this.id == null); }
}
