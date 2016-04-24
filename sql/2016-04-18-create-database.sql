CREATE DATABASE slownews
ENCODING = 'UTF8';

CREATE TABLE "user"(
  id SERIAL PRIMARY KEY,
  username TEXT NOT NULL,
  password TEXT NOT NULL
);

CREATE TABLE news(
  id SERIAL PRIMARY KEY,
  title VARCHAR NOT NULL,
  description VARCHAR NOT NULL,
  imagepath VARCHAR,
  user_id integer references "user"(id)
);
