select * from buytbl
inner join usertbl
         on buytbl.userID = usertbl.userID
         where usertbl.userID = 'JYP';


-- -----------


select * from usertbl;

select usertbl.userID, usertbl.name, buytbl.prodName, usertbl.addr,
       concat(usertbl.mobile1, usertbl.mobile2) as '연락처'
from usertbl
left outer join buytbl
on usertbl.userID = buytbl.userID
order by usertbl.userID;


-- ------------------


select name, concat(mobile1, mobile2) as '전화번호' from usertbl
where name not in (select name from usertbl where mobile1 is null);

select name, concat(mobile1, mobile2) as '전화번호' from usertbl
where name in (select name from usertbl where mobile1 is null);