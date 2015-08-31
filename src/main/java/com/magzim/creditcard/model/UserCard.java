package com.magzim.creditcard.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by max on 6/27/15.
 */
@NamedQueries({
        @NamedQuery(name = UserCard.GET, query = "SELECT c FROM UserCard c WHERE c.id=:id AND c.user.id=:userId"),
        @NamedQuery(name = UserCard.ALL_SORTED, query = "SELECT c FROM UserCard c WHERE c.user.id=:userId ORDER BY c.lastUsed DESC")
})
@Entity
@Table(name = "CARDS")
public class UserCard extends BaseEntity {

    public static final String GET = "UserCard.get";
    public static final String ALL_SORTED = "UserCard.getAll";

    @Column(name = "amount")
    protected double amount;

    @Column(name = "password", nullable = false)
    @NotEmpty
    protected String password;

    @Column(name = "lastused", nullable = false)
    protected LocalDateTime lastUsed;

    @Column(name = "blocked")
    protected boolean blocked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
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
