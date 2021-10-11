-- 10. The name and area of parks that have an area less than or equal to 700 square kilometers and provides camping (21 rows)
--SELECT park_name, has_camping FROM park; --this line just tells me how the boolean is written in the database (true, not t or something like that.)
SELECT park_name, area FROM park WHERE area <= 700 AND has_camping = 'true';

