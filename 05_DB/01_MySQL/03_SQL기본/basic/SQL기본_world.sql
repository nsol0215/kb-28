use world;

show tables;

select * from world.city
         where CountryCode ='KOR'
         order by population desc;

select CountryCode, Population from city
order by Countrycode asc, population desc;

select count(*)
from world.city
where Countrycode = 'KOR';

select * from world.city
where CountryCode in('KOR','CHN','JPN');

select * from world.city
where CountryCode = 'KOR' and Population >= 1000000;

select * from world.city
where CountryCode = 'KOR'
order by Population desc
limit 10;

select * from world.city
where CountryCode = 'KOR'
  and Population between 1000000 and 5000000;
