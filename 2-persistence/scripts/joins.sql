-- Inner Join 
-- Outer Join 
-- Left Join 
-- Right Join
-- Self Join 

SELECT * FROM "Artist";
SELECT * FROM "Album";

-- RETURN THE ALBUM ID, Album  TITLE AND ARTIST NAME
-- bY JOINING BOTH THE ARTIST AND ALBUMS TABLES

CREATE VIEW simple_album_artist_view AS
SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Album" alb
	LEFT JOIN "Artist" art
	ON alb."AlbumId" = art."ArtistId"; 


SELECT * FROM simple_album_artist_view;

SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Album" alb
	JOIN "Artist" art
	ON alb."ArtistId" = art."ArtistId"; 

/**
 * right join CLAUSE JOIN 2 OR MORE TABLES and returns
 * all rows from the right hand table (right of the stament)
 * If there are unmatches records from the left side table
 * it returns null
 */

SELECT * FROM "Artist"
	NATURAL JOIN "Album"; -- naturally joining it ON the ID

SELECT * FROM "Employee";

-- SELF JOIN
SELECT e1."FirstName", e1."Title", e2."FirstName" AS boss_first_name, 
e2."Title" AS boss_title 
	FROM "Employee" e1
	JOIN "Employee" e2 
	ON e1."ReportsTo" = e2."EmployeeId";  

SELECT * FROM "Track";
SELECT * FROM "InvoiceLine";

SELECT a."TrackId", a."Name", b."InvoiceLineId", b."InvoiceId" 
	FROM "Track" AS a 
	LEFT JOIN "InvoiceLine" AS b 
	ON a."TrackId" = b."TrackId";


