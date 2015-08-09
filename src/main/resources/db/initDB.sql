DROP TABLE IF EXISTS USER_ROLES;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS CARDS;
DROP SEQUENCE IF EXISTS GLOBAL_SEQ;

CREATE SEQUENCE GLOBAL_SEQ START 1000;

CREATE TABLE USERS
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('GLOBAL_SEQ'),
  name              VARCHAR,
  email             VARCHAR NOT NULL,
  password          VARCHAR NOT NULL,
  registered        TIMESTAMP DEFAULT now(),
  enabled           BOOL DEFAULT TRUE
);
CREATE UNIQUE INDEX unique_email ON USERS (email);

CREATE TABLE USER_ROLES
(
  user_id           INTEGER NOT NULL,
  role              VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE CARDS (
  id                INTEGER PRIMARY KEY DEFAULT nextval('GLOBAL_SEQ'),
  user_id           INTEGER NOT NULL,
  amount            NUMERIC(10, 2),
  password          VARCHAR NOT NULL,
  blocked           BOOL DEFAULT FALSE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

