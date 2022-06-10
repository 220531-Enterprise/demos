-- Set operations are like joining tables vertically
-- Set operations only operate on results that
-- have the same number and type of columns

CREATE TABLE sophiag.one (
	
	c_1 INTEGER PRIMARY KEY,
	c_2 INTEGER

);

-- alt + up to highlight

CREATE TABLE sophiag.two (
	
	c_a INTEGER PRIMARY KEY,
	c_b INTEGER

);

INSERT INTO sophiag.one
	VALUES (1, 1),
		    (2, 2);

		   
INSERT INTO sophiag.two
	VALUES (100, 100),
		  (200, 200);
		   
		   
SELECT * FROM sophiag.two;  

SELECT * FROM sophiag.one UNION SELECT * FROM sophiag.two;

		   -- UNION combines all data into one table 
		   -- it excludes duplicates

INSERT INTO sophiag.two
	VALUES (1, 1);

-- UNION ALL include duplicates
SELECT * FROM sophiag.one UNION ALL SELECT * FROM sophiag.two;

-- https://www.tutorialspoint.com/sql_certificate/using_the_set_operators.htm
		   
		   

