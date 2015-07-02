package com.magzim.creditcard.model;

import java.util.Date;

/**
 * Created by max on 6/27/15.
 */
public class UserCard extends BaseEntity {

    private int amount;

    private String password;

    private Date lastUsed = new Date();

    private boolean blocked;

    private User user;

    public UserCard() {

    }

    public UserCard(int amount, String password, Date lastUsed, boolean blocked, User user) {
        this.amount = amount;
        this.password = password;
        this.lastUsed = lastUsed;
        this.blocked = blocked;
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean block() { return this.blocked = true; }

    public boolean unblock() { return this.blocked = false; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
