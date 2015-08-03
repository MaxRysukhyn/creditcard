package com.magzim.creditcard.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by max on 6/27/15.
 */
public class UserCard extends BaseEntity {

    protected double amount;

    protected String password;

    protected LocalDateTime lastUsed;

    protected boolean blocked;

    private User user;

    public UserCard() {

    }

    public UserCard(UserCard uCard) {this(uCard.getId(), uCard.getAmount(), uCard.getPassword(), uCard.getLastUsed(), uCard.isBlocked()); }

    public UserCard(Integer id, double amount, String password, LocalDateTime lastUsed, boolean blocked) {
        super(id);
        this.amount = amount;
        this.password = password;
        this.lastUsed = lastUsed;
        this.blocked = blocked;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(LocalDateTime lastUsed) {
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
