# QueueMan
Script to create table:
-- Table: users

-- DROP TABLE users;

CREATE TABLE users
(
  username character(255)[] NOT NULL,
  password character(255)[] NOT NULL,
  "mailId" character(255)[] NOT NULL,
  "isFirstLogin" boolean NOT NULL,
  "AccessToken" character(255)[] NOT NULL,
  name character(255)[],
  isadmin boolean NOT NULL,
  id serial NOT NULL,
  CONSTRAINT primary_key PRIMARY KEY (id),
  CONSTRAINT mailid_unique UNIQUE ("mailId")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;
COMMENT ON TABLE users
  IS 'this is a users table ';

