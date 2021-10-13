-- 18. The average length of movies in the "Science Fiction" genre. Name the column 'average_length'.
-- (1 row, expected result around 110-120)
SELECT AVG(movie.length_minutes) AS average_length

FROM movie

JOIN movie_genre AS mg ON movie.movie_id = mg.movie_id

JOIN genre ON mg.genre_id = genre.genre_id

WHERE genre_name = 'Science Fiction';


