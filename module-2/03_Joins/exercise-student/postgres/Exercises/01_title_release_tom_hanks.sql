-- 1. The titles and release dates of movies that Tom Hanks has appeared in (47 rows)
--title
--movie release date
--where actor name is Tom Hanks (connect person to actor)
SELECT 
        title, release_date
FROM
        movie_actor
JOIN
        person ON person_id = actor_id
        
JOIN    movie ON movie.movie_id = movie_actor.movie_id

WHERE
        person_name = 'Tom Hanks';
    






