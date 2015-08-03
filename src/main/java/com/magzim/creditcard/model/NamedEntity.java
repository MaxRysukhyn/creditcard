package com.magzim.creditcard.model;

/**
 * Created by max on 6/27/15.
 */
public class NamedEntity extends BaseEntity {

    protected String name;

    public NamedEntity() {}

    public NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    protected NamedEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
