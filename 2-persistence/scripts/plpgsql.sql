/*
 * PL/pgsql - Procedural Language Extension of PostgreSQL 
 * 
 * - NOT a sublanguage of SQL
 * - Allows devs to create:
 * 		- stored functions
 * 		- stored procedures
 * 		- triggers
 * 		- custom types (enums)
 * 
 *- Adds procedural features to the normally declarative sql scripts
 * 		- loops
 * 		- exception handling
 * 		- if statements
 * 
 * Stored Functions (return a value)
 * 
		create [or replace] function [name] (params)
		returns [type]
		as '
			begin
				[logic]
			end
		'
		language plpgsql;
 */

-- Build a multiply function in plpgsql
CREATE OR REPLACE FUNCTION muliply(x INTEGER, y INTEGER)
RETURNS INTEGER 
AS $$

	BEGIN
		
		RETURN x * y;
		
	END


$$ 
LANGUAGE plpgsql;

-- how do we call the above function?

SELECT muliply(5, 3);
SELECT muliply('100', 10); -- postgresqlhas TYPE coersion

CREATE TABLE colors (

	id SERIAL PRIMARY KEY,
	color VARCHAR(40)

);

CREATE TABLE sizes(

	id SERIAL PRIMARY KEY,
	size_desc VARCHAR(40) -- xs s, m, l, xl, xxl

);



INSERT INTO sizes(size_desc) 
	VALUES ('S', 'M', 'L');

INSERT INTO colors(color)
	VALUES ('red'), ('orange'), ('yellow');


-- a function that will check the value of the color, and check IF it's blue
-- we don't insert it into the table

-- we need to define a TRIGGER (this defines WHEN to run the function)


CREATE OR REPLACE FUNCTION no_more_blues() 
RETURNS TRIGGER
AS $$

	BEGIN 
		
		IF (NEW.color = 'blue') THEN
		
		RETURN NULL; -- will NOT ADD ANYTHING INTO THE TABLE
	
		END IF;
	
		-- IF THE ABOVE STATEMENT IS NOT TRUE
		RETURN NEW; -- ALLOW IT TO BE PERSISTED INTO THE TABLE
		
	END

$$ 
LANGUAGE plpgsql;

-- here we tell the database WHEN to invoke the above function
CREATE TRIGGER no_blue
	BEFORE INSERT OR UPDATE ON colors
	FOR EACH ROW
	EXECUTE FUNCTION no_more_blues();


SELECT * FROM COLORS;

INSERT INTO colors (color)
	VALUES ('red'), ('orange'), ('yellow');

INSERT INTO colors (color) VALUES ('chartruese');
INSERT INTO colors (color) VALUES ('blue');






