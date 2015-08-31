package com.magzim.creditcard;

import com.magzim.creditcard.matcher.ModelMatcher;
import com.magzim.creditcard.model.BaseEntity;
import com.magzim.creditcard.model.UserCard;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Function;

import static java.time.LocalDateTime.of;

/**
 * Created by max on 7/22/15.
 */
public class CardTestData {
    public static final LoggerWrapper LOG = LoggerWrapper.get(CardTestData.class);

    public static final int CARD1_ID = BaseEntity.START_SEQ + 2;

    public static final UserCard CARD1 = new UserCard(CARD1_ID, 3000.00, "password", of(2015, 1, 8, 18, 0), false);
    public static final UserCard CARD2 = new UserCard(CARD1_ID + 1, 999999.99, "12344", of(2015, 1, 8, 18, 0), false);
    public static final UserCard CARD3 = new UserCard(CARD1_ID + 2, 400, "admin", of(2015, 1, 8, 18, 0), false);
    public static final UserCard CARD4 = new UserCard(CARD1_ID + 3, 1.50, "54321", of(2015, 1, 8, 18, 0), false);

    public static UserCard getCreated() {return new UserCard(null, 100.00, "pazzword", of(2015, 1, 8, 18, 0), false); }

    public static UserCard getUpdated() {
        UserCard updated = new UserCard(CARD1);
        updated.setAmount(2500);
        return updated;
    }

    public static class TestCard extends UserCard{
        public TestCard(UserCard uCard) {this(uCard.getId(), uCard.getAmount(), uCard.getPassword(), uCard.getLastUsed(), uCard.isBlocked()); }

        public TestCard(Integer id, double amount, String password, LocalDateTime lastUsed, boolean blocked) {
            super(id, amount, password, lastUsed, blocked);
        }

        public TestCard(double amount, String password, LocalDateTime lastUsed, boolean blocked) {
            this(null, amount, password, lastUsed, blocked);
        }

        public UserCard asCard() {return new UserCard(this);}

        @Override
        public String toString() {
            return "UserCard (" +
                    "id=" + id +
                    ", amount=" + amount +
                    ", password=" + password +
                    ", lastUsed=" + lastUsed +
                    ", blocked=" + blocked +
                    ")";
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TestCard that = (TestCard) o;

            return Objects.equals(this.password, that.password)
                    && Objects.equals(this.id, that.id)
                    && Objects.equals(this.amount, that.amount)
                    && Objects.equals(this.blocked, that.blocked);
        }
    }

    public static final ModelMatcher<UserCard, TestCard> MATCHER = new ModelMatcher<>(
            new Function<UserCard, TestCard>() {
                @Override
                public TestCard apply(UserCard uCard) {
                    return ((uCard instanceof TestCard) ? (TestCard) uCard : new TestCard(uCard)); }
            });
}
