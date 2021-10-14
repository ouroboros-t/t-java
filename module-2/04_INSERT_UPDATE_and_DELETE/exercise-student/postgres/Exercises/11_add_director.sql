-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. Add yourself to the person table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)
SELECT * FROM movie WHERE title = 'The Blob';

SELECT * FROM person WHERE person_name = 'Tay Black';

INSERT INTO person(person_name, birthday, biography) VALUES('Tay Black', '1994-06-28','Taking Hollywood by storm one SQL at a time!');

BEGIN transaction;
UPDATE movie SET director_id = (SELECT person_id FROM person WHERE person_name = 'Tay Black') WHERE title = 'The Blob';
COMMIT;

SELECT title, person_name AS director FROM person JOIN movie ON movie.director_id = person.person_id WHERE person_name = 'Tay Black'