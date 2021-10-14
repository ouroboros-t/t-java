-- 3. Did you know Eric Stoltz was originally cast as Marty McFly in "Back to the Future"? Add Eric Stoltz to the list of actors for "Back to the Future" (1 row)
SELECT * FROM person WHERE person_name = 'Eric Stoltz';

INSERT INTO movie_actor(movie_id, actor_id) VALUES((SELECT movie_id FROM movie WHERE title = 'Back to the Future'), (SELECT person_id FROM person WHERE person_name = 'Eric Stoltz'));

SELECT person_name 

FROM person AS p

JOIN movie_actor AS ma ON ma.actor_id = p.person_id

JOIN movie AS m ON ma.movie_id = m.movie_id WHERE m.title = 'Back to the Future';

