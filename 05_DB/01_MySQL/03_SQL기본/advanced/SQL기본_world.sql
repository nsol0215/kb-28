select * from world.city;

select sum(Population) from city
where CountryCode = 'KOR';

select min(Population) as 최소값 from city
where CountryCode = 'KOR';

select avg(Population) from city
where CountryCode = 'KOR';

select max(Population) as 최대값 from city
where CountryCode = 'KOR';

select name, char_length(name) as '글자수'
from country;

select upper(left(name,3)) from country;

select LifeExpectancy,ROUND(LifeExpectancy,0)
from country;

