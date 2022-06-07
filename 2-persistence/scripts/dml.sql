-- DML: Data Manipulation Language
-- managing the data WITHIN the tables
-- DML Commands -------- DQL (Data QUery Language )
-- INSERT          
-- UPDATE
-- DELETE
-- (SELECT) ... shares a command with DQL



-- INSERTION ANATOMY
-- INSERT INTO table_name(column1, column2, …)
--		VALUES (value1, value2, …) 

-- TRUNCATE only wipes data from the table, it doens't drop the table
TRUNCATE TABLE users CASCADE;
-- CASCADE  allows us to bypass deleting data
-- upon which another table may rely on

INSERT INTO users (first_name, last_name, email, pwd)
	VALUES ('Hayden', 'Hayes', 'hayden@mail.com', 'supersecret');

SELECT * FROM users; -- highlight OVER AND press ctrl + enter

--UPDATE users 
--	SET id = 9000
--	WHERE first_name = 'Hayden';

INSERT INTO users (first_name, last_name, email, pwd)
	VALUES ('Test', 'testing', 'test@mail.com', 'test');

DROP TABLE users CASCADE; -- just recreate the users TABLE

-- inser multiple rows 
INSERT INTO users (first_name, last_name, email, pwd) 
	VALUES ('Abby', 'Adams', 'abby@aol.com', 'pass'),
		   ('Billy', 'Bob', 'billy@yahoo.com', '123pass'),
		   ('Cathy', 'Carter', 'cathy@gmail.com', '8888'),
		   ('Danny', 'DaVito', 'danny@mail.com', 'supersecret');

SELECT * FROM users;
SELECT first_name, last_name FROM users; -- DQL

SELECT * FROM users ORDER BY last_name DESC;

-- UPDATE bILLY bOB'S LAST NAME TO bINGO
UPDATE users SET last_name = 'Bingo' WHERE id = 2;

-- CHALLENGE:
-- PROVIDE DATA FOR THE OTHER 2 TABLES (posts & likes) 

-- Abby should post a message on Billy's wall, which Danny likes
-- Cathy should post a message on her own wall, which both Abby and 
-- Danny like
-- Billy will post a message on Danny's wall, which Cathy and Billy like

SELECT * FROM users ORDER BY id;

INSERT INTO posts (author_id, wall_user_id, post_content)
	VALUES (1, 2, 'Hey Billy its Abby'),
			(3, 3, 'MY NAME IS CATHY I AM HERE'),
			(2, 4, 'Hey Danny its Billy');

SELECT * FROM posts;

INSERT INTO likes (user_id, post_id)
	VALUES (4, 1),
		   (1, 2),
		   (4, 2),
		   (3, 3),
		   (2, 3);
		  
SELECT * FROM likes;




