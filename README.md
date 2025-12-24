CREATE DATABASE pg_accommodation_db;

USE pg_accommodation_db;

SHOW TABLES;



DELETE FROM CITY;

ALTER TABLE city AUTO_INCREMENT=1;



SELECT * FROM OWNER;
SELECT * from city;
SELECT * FROM LOCALITY;

SELECT * FROM PGPLACE;

SELECT place_id, availability
FROM pgplace
WHERE place_id = 1;

SELECT * FROM TENANT;

SELECT place_id, visitor_count FROM pgplace;

desc pgplace;
desc locality;
 ( this is complete sql file)
