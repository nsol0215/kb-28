use sqldb;

select * from usertbl
where name = '김경호';

select * from usertbl
where birthYear >=1970 and height >=182;

select * from usertbl
where height between 180 and 183;

select * from usertbl
where addr in('경남', '전남', '경북');

select * from usertbl
where name like '김%';

select name, height from usertbl
where height > (select height from usertbl where name = '김경호');

select name, mDate from usertbl order by mDate asc;
select name, mDate from usertbl order by mDate desc;
select name, height from usertbl order by height desc, name;





















