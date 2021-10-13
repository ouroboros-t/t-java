SELECT * FROM state WHERE state_abbreviation IN (SELECT state_abbreviation FROM park_state);

-- INNER JOIN
SELECT city_name, state_abbreviation FROM city WHERE city_name = 'Columbus';
-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database


-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
--Start with one table and then JOIN to another
SELECT city_name,state_name FROM city JOIN state ON city.state_abbreviation = state.state_abbreviation;
--joins all rows from city table where state_abbreviations in city table equal state_abbreviation in state table
--we select what we want, then SQL works backwards to find state_abbreviations in both tables (where they are equal) and now we have access to both tables
--this is an INNER JOIN where both tables HAVE to have a match (state_abbreviation) for it to work.

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park_name, state_abbreviation FROM park JOIN park_state ON park.park_id = park_state.park_id;
--What is the connector(variable that exists in both tables), in this case it is park_id, so we JOIN based on that variable. 

-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park_name, state_name FROM park AS p JOIN park_state AS ps ON p.park_id = ps.park_id
        --can add the 
        JOIN state ON ps.state_abbreviation = state.state_abbreviation ORDER BY state.state_abbreviation;
       
--You can have multiple join statements
--JOIN where park table and park_state were similar (park_id) THEN JOIN where park_state and state table were similar (state_abbreviation)
--This give me access to both park_name and state_name.


-- Modify the previous query to include the name of the state's capital city.
SELECT park_name, state_name, city_name AS capital_city FROM park JOIN park_state ON park.park_id = park_state.park_id
        JOIN state ON park_state.state_abbreviation = state.state_abbreviation
        JOIN city ON city.city_id = state.capital;


-- Modify the previous query to include the area of each park.
SELECT park_name, park.area, state_name, city_name AS capital_city FROM park JOIN park_state ON park.park_id = park_state.park_id
        JOIN state ON park_state.state_abbreviation = state.state_abbreviation
        JOIN city ON city.city_id = state.capital;

--STRAT: Select Everything from the tables you want to join, then go back and select that specific columns
-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT city_name, city.population AS city_population FROM city JOIN state ON city.state_abbreviation = state.state_abbreviation WHERE census_region = 'Midwest' ORDER BY city_name;
--


-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT state.state_abbreviation AS s_a, COUNT(*) AS num_cities FROM city JOIN state ON city.state_abbreviation = state.state_abbreviation WHERE census_region = 'Midwest' GROUP BY s_a ORDER BY s_a;


-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT state.state_abbreviation AS s_a, COUNT(*) AS num_cities FROM city JOIN state ON city.state_abbreviation = state.state_abbreviation WHERE census_region = 'Midwest' GROUP BY s_a ORDER BY s_a DESC;


-- LEFT JOIN
--When you want to keep ALL the data when there may be a data type that doesn't have a corresponding type:
--Example; you want to KEEP an actor that hasn't acted on the same films in the film table
--normally when you JOIN the actor and film table together, this actor is gone because the film_id doesn't match...A LEFT JOIN keeps that actor even if there is no matching film id..

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.
SELECT 
        state_name, 
        MIN(date_established) AS earliest_date_established

FROM 
        state AS s
         JOIN park_state AS ps ON ps.state_abbreviation = s.state_abbreviation
         JOIN park AS p ON p.park_id = ps.park_id
        
GROUP BY
        state_name
ORDER BY
        state_name;



-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
SELECT 
        state_name, 
        MIN(date_established) AS earliest_date_established

FROM 
        state AS s
         LEFT JOIN park_state AS ps ON ps.state_abbreviation = s.state_abbreviation
         LEFT JOIN park AS p ON p.park_id = ps.park_id
        
GROUP BY
        state_name
ORDER BY
        state_name;



-- UNION
--Run two seperate select statements and collapse them back into one
--Both Select have to have the same column data type

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)
SELECT 
        city_name AS place_name, 'city' AS place_type
FROM 
        city
WHERE
        city_name LIKE 'W%'
UNION
SELECT
        state_name AS place_name, 'state' AS place_type
FROM
        state
WHERE
        state_name LIKE 'W%'

ORDER BY
        place_name;

-- Modify the previous query to include a column that indicates whether the place is a city or state.
--SEE LINE 101 and 108


-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in DbVisualizer and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres
SELECT genre_name
FROM genre;

-- The titles of all the Comedy movies
SELECT title
FROM genre
JOIN movie_genre ON genre.genre_id = movie_genre.genre_id
JOIN movie ON movie_genre.movie_id = movie.movie_id WHERE genre_name = 'Comedy'

