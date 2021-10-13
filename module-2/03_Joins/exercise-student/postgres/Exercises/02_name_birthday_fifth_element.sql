-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
--actor name
--actor birthday
--movie_id match
--where title = 'The Fifth Element'

SELECT
        person_name, birthday
FROM movie_actor AS ma

JOIN person ON ma.actor_id = person_id
JOIN movie ON ma.movie_id = movie.movie_id

WHERE title = 'The Fifth Element';













