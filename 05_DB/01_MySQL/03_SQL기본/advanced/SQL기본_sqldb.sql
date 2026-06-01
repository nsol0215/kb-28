use sqldb;

select * from buytbl;

select userID as 사용자아이디, sum(amount) as 총구매개수 from buytbl;

select userId as 사용자아이디, sum(amount*price) as 총구매액
from buytbl
group by userId;

select AVG(amount) as 평균구매개수
from buytbl;

select userID, AVG(amount) as 평균구매개수
from buytbl
group by userID;

select  * from usertbl;

select name, height
from usertbl
where height = (select max(height) from usertbl)
      or height = (select min(height) from usertbl);

select count(mobile1) as '휴대폰이 있는 사용자'
from usertbl;

select userId as 사용자아이디, sum(amount*price) as 총구매액
from buytbl
group by userId
having sum(amount*price) > 1000;




