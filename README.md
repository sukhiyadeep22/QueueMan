# QueueMan
Script to create table:
-- Table: users

-- DROP TABLE users;
CREATE TABLE users ( username character(255)  NOT NULL, password character(255)  NOT NULL, "mailid" character(255)  NOT NULL, "isfirstlogin" boolean NOT NULL, "accesstoken" character(255)  NOT NULL, name character(255) , isadmin boolean NOT NULL, id serial NOT NULL, CONSTRAINT primary_key PRIMARY KEY (id), CONSTRAINT mailid_unique UNIQUE ("mailid") ) WITH ( OIDS=FALSE ); ALTER TABLE users OWNER TO postgres; COMMENT ON TABLE users IS 'this is a users table ';




INSERT INTO public.users(
            username, password, mailid, isfirstlogin, accesstoken, name, 
            isadmin)
    VALUES ('dsukhiya', 'cliqr', 'dsukhiya@cliqr.com', true, 'a', 'deepak', 
            true);

