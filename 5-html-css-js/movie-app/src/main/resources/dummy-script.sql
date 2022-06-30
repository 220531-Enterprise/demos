INSERT INTO users (username, pwd)
	VALUES ('homersimpson', 'donuts'),
	       ('bugsbunny', 'carrots');
	       
	      
INSERT INTO movies (imageurl, rating, title)
	VALUES ('https://m.media-amazon.com/images/M/MV5BYzg0NGM2NjAtNmIxOC00MDJmLTg5ZmYtYzM0MTE4NWE2NzlhXkEyXkFqcGdeQXVyMTA4NjE0NjEy._V1_.jpg',
	4, 'Tenet'),
	
	('https://resizing.flixster.com/9ulMcbVWtxvAW4so_JAhh75_cQE=/206x305/v2/https://flxt.tmsimg.com/assets/p8174_p_v8_ai.jpg',
	3, 'Jaws');
	
SELECT * FROM MOVIES;


SELECT * FROM USERS;
SELECT * FROM users_movies;

INSERT INTO users_movies (user_id, movies_id) 
	VALUES (3, 1),
		(4, 2);
	
