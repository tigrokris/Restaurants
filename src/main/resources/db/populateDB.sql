DELETE FROM user_roles;
DELETE FROM dishes;
DELETE FROM RESTAURANTS;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', '$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO RESTAURANTS (NAME) VALUES
  ('LUXURY'),
  ('PAPA CARLO'),
  ('Луна и яичница'),
  ('Лев и кастрюля'),
  ('Столовая №5');


INSERT INTO DISHES (NAME, PRICE, RESTAURANT_ID) VALUES
  ('лосось по купечески', 750, 100002),
  ('штрудель яблочный', 100, 100003),
  ('окорок кобана', 600, 100002),
  ('дессерт парижский', 500, 100002),
  ('Комплексный обед', 1000, 100006),
  ('Шведский стол', 510, 100004),
  ('Бизнес ланч', 510, 100005),
  ( 'Сытный ужин', 1500, 100003);
