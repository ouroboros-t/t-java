-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)

SELECT genre_name
FROM movie

JOIN movie_genre ON movie_genre.movie_id = movie.movie_id

JOIN genre ON movie_genre.genre_id = genre.genre_id

WHERE title = 'Coach Carter'; -- Shows all the genres associated with the movie

INSERT INTO genre(genre_name) VALUES ('Sports');

SELECT genre_name, genre_id -- shows that Sports genre successfully added
FROM genre;

INSERT INTO movie_genre(movie_id, genre_id) VALUES((SELECT movie_id FROM movie WHERE title = 'Coach Carter'), (SELECT genre_id FROM genre WHERE genre_name = 'Sports'));
--connects Coach Carter to Sports genre. 
