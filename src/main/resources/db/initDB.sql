DROP TABLE IF EXISTS user_roles ;
DROP TABLE IF EXISTS dishes ;
DROP TABLE IF EXISTS restaurants ;
DROP TABLE IF EXISTS users ;
DROP SEQUENCE IF EXISTS global_seq ;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR(255),
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  date_of_last_vote TIMESTAMP DEFAULT '2000-01-01 00:00:00'
);
CREATE UNIQUE INDEX users_unique_email_idx ON USERS ( email );

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY ( user_id ) REFERENCES USERS ( id ) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR(255) NOT NULL,
  votes INTEGER DEFAULT '0'
);
CREATE UNIQUE INDEX restaurants_unique_name_idx ON restaurants ( name );

CREATE TABLE dishes
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR(255) NOT NULL,
  price    INT DEFAULT '0',
  restaurant_id INTEGER NOT NULL,
  FOREIGN KEY ( restaurant_id ) REFERENCES restaurants ( id ) ON DELETE CASCADE
);
CREATE UNIQUE INDEX dishes_unique_name_restaurant_id_idx ON dishes ( name,restaurant_id );