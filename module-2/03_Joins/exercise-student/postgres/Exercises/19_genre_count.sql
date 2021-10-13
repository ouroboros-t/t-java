-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'. 
-- (19 rows, expected result for Action is around 180).
SELECT genre.genre_name, COUNT(*) AS num_of_movies

FROM genre

LEFT JOIN movie_genre AS mg ON mg.genre_id = genre.genre_id

LEFT JOIN movie ON movie.movie_id = mg.genre_id

GROUP BY genre.genre_name





