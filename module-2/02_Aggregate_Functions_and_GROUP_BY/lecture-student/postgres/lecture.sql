-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
--ASC for ascending (default), DESC for descending
SELECT population FROM state ORDER BY population DESC;


-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
--Put your most specific conditions first! I want to sort by census region FIRST then state_name normally..
SELECT state_name, census_region FROM state ORDER BY census_region DESC, state_name ASC;


-- The biggest parks by area
SELECT park_name, area FROM park ORDER BY area DESC;



-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population FROM city ORDER BY population DESC LIMIT 10;


-- The 20 oldest parks from oldest to youngest in years then alphabetically 
SELECT park_name, date_established FROM park ORDER BY date_established ASC, park_name ASC LIMIT 20;
--dates list normally from oldest to newest entry by default (ASC) and newest to oldest with DESC. 

SELECT CURRENT_DATE; -- will return today's date, 9:52

SELECT park_name, ((CURRENT_DATE - date_established) / 365.21) AS age_in_years FROM park ORDER BY age_in_years DESC, park_name LIMIT 20;
                    --takes this and makes the date into days.. 

--stacked ones are one that were done with class, single lines are one done on my own attempts first... 

-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation as a single column result set
SELECT
        (city_name || ', '|| state_abbreviation) AS city_and_state
        -- use || to concatenate in SQL. 
FROM 
        city;


-- The all parks by name and date established as a single column result set
SELECT (park_name || ', ' || date_established) AS park_name_and_date_est FROM park;



-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT SUM(population) AS total_population,AVG(population) AS average_population FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS total_population FROM state WHERE census_region = 'West' OR census_region = 'South';

--above is written again below with the IN keyword

SELECT 
        SUM(population) 
FROM
        state 
WHERE 
        census_region IN ('West', 'South');


-- The number of cities with populations greater than 1 million
SELECT COUNT(*) FROM city WHERE population > 1000000; -- There are 10.


-- The number of state nicknames.
SELECT COUNT(*) FROM state WHERE state_nickname IS NOT NULL;


-- The area of the smallest and largest parks.
SELECT
        park_name,
        MIN(area) AS smallest_area,
        MAX(area) AS biggest_area
FROM
       park
GROUP BY
        park_name
ORDER BY
        smallest_area;




-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(*) AS num_cities FROM city GROUP BY state_abbreviation ORDER BY num_cities DESC;


-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) FROM park GROUP BY has_camping ORDER BY has_camping DESC;


-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS population_sum FROM state GROUP BY state_abbreviation ORDER BY state_abbreviation;

--can put multiple aggregate functions in one line:
SELECT 
        state_abbreviation,
        SUM(population) AS total_population,
        MIN(population) AS smallest_city_population,
        COUNT(*) AS num_cities
FROM    
        city
GROUP BY
        state_abbreviation;




-- The smallest city population in each state ordered by city population.
--how do I take it specifically and only list a state once?
SELECT state_abbreviation, MIN(population) AS smallest_city_population FROM city GROUP BY state_abbreviation ORDER BY smallest_city_population;



-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET you want to get "pages" of results.
SELECT
        city_name, state_abbreviation
FROM   
        city
ORDER BY
        state_abbreviation, city_name
LIMIT 10
OFFSET 10;
--OFFSET will say to pull the next 10 rows, but still limit to 10. 


-- SUBQUERIES (optional)
--SELECT statement within a SELECT statement

-- All of the cities in the Midwest census region
--census region is in the state table
--a subquery will select state abbreviation 

SELECT
        city_name,
        state_abbreviation
FROM
        city
WHERE
        state_abbreviation IN (
                SELECT 
                        state_abbreviation
                FROM
                        state
                WHERE
                        census_region = 'Midwest') -- closes the OUTER select
ORDER BY
        state_abbreviation, city_name;
       




-- All of the cities with their full state name
--DONT DO THIS! WE MAY SEE IT BUT MAYBE DONT'T WRITE IT THIS WAY lol.

SELECT
        city_name,
        (SELECT state_name FROM state WHERE city.state_abbreviation = state.state_abbreviation) AS state_full_name
FROM 
        city
        
ORDER BY
        state_full_name;

      



