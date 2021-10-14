-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)
SELECT * 

FROM movie AS m 

JOIN movie_actor AS ma ON m.movie_id = ma.movie_id 

JOIN person AS p ON p.person_id = ma.actor_id

WHERE person_name = 'Bill Murray';

--create collection
--add all movies that have bill murray into it... 

INSERT INTO collection(collection_name) VALUES ('Bill Murray Collection');


BEGIN TRANSACTION;
UPDATE movie SET collection_id = (SELECT collection_id FROM collection WHERE collection_name = 'Bill Murray Collection') 
WHERE movie_id IN (SELECT movie_id FROM movie_actor AS ma JOIN person AS p ON ma.actor_id = p.person_id WHERE person_name = 'Bill Murray');
COMMIT;




SELECT m.title FROM movie AS m WHERE collection_id = (SELECT collection_id FROM collection WHERE collection_name = 'Bill Murray Collection');

--AS m JOIN collection AS c ON m.collection_id = c.collection_id  WHERE collection_name IN ('Bill Murray Collection');



