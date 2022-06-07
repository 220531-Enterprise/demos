-- This is a comment in SQL
/*
	This is a multi
	line comment
*/

-- DDL: Data Definition Language
-- related to the creation and alteration
-- of tables and schema
-- Kinds of DDL Statements
-- CREATE -- create a new table
-- ALTER -- change an existing table 
-- DROP -- delete the table entirely
-- TRUNCATE -- keep the table, wipe all data within it

-- users, posts, likes

-- preferred way of execution is highlight and press ctrl + enter
DROP TABLE users;

CREATE TABLE IF NOT EXISTS users (

-- SERIAL implies an INTEGER type that automatically increment
	id SERIAL PRIMARY KEY, -- automatically indicates its UNIQUE/ NOT NULL
	first_name VARCHAR(50) NOT NULL, -- DATA TYPE & CONSTRAINT
	last_name VARCHAR(50),
	email VARCHAR(254) NOT NULL UNIQUE,
	pwd VARCHAR(30) NOT NULL
);

-- ALTER changes table structure
ALTER TABLE users
	ADD COLUMN tester INTEGER;
	
ALTER TABLE users 
	ALTER COLUMN tester SET DEFAULT 0;

ALTER TABLE users
	DROP COLUMN tester;

-- DQL: Data Query Language
SELECT * FROM users;

-- create a posts table

DROP TABLE posts;

CREATE TABLE IF NOT EXISTS posts (

	-- PK by default infers NOT NULL & UNIQUE
	id SERIAL PRIMARY KEY, 
	-- auhtor_id is FOREIGN KEY that POINTS TO a user's PK
	author_id INTEGER REFERENCES users(id) NOT NULL,
	wall_user_id INTEGER REFERENCES users(id) NOT NULL,
	post_content VARCHAR(250) NOT NULL
);

DROP TABLE likes;
-- likes table
CREATE TABLE IF NOT EXISTS likes (
	
	-- this column is a FK that references id in users table
	user_id INTEGER REFERENCES users(id) NOT NULL,
	post_id INTEGER REFERENCES posts(id) NOT NULL,
	PRIMARY KEY(user_id, post_id) -- composite KEY
);

-- ERD: Entity Relationship Diagram: shows us the tables 
-- in our schema

SELECT * FROM users;



