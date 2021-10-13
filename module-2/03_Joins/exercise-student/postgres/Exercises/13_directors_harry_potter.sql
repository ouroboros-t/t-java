-- 13. The directors of the movies in the "Harry Potter Collection" (4 rows)

SELECT person_name

FROM person

JOIN movie ON movie.director_id = person.person_id
JOIN collection ON movie.collection_id = collection.collection_id

WHERE collection_name = 'Harry Potter Collection'

GROUP BY
        person_name;



