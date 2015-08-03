DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM cards;

ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO users (name, email, password)
VALUES ('John', 'john@email.em', 'johnpassword');
INSERT INTO users (name, email, password)
VALUES ('admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 1000);
INSERT INTO user_roles (role, user_id) VALUES ('ROLE_ADMIN', 1001);

INSERT INTO cards (user_id, amount, password)
VALUES(1000, 3000.00, 'password');
INSERT INTO cards (user_id, amount, password)
VALUES(1000, 999999.99, '12344');
INSERT INTO cards (user_id, amount, password)
VALUES(1001, 400, 'admin');
INSERT INTO cards (user_id, amount, password)
VALUES(1001, 1.50, '54321');
