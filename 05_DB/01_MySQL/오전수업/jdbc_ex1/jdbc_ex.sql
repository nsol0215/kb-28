create table users (
    ID varchar(12) not null primary key,
    PASSWORD varchar(12) not null,
    NAME varchar(30) not null,
    ROLE varchar(6) not null
);

insert into users(ID, PASSWORD, NAME, ROLE)
values('guest','guest123','방문자','USER');

INSERT INTO USERS(ID, PASSWORD, NAME, ROLE)
VALUES('admin', 'admin123', '관리자', 'ADMIN');

INSERT INTO USERS(ID, PASSWORD, NAME, ROLE)
VALUES('member', 'member123', '일반회원', 'USER');

select * from users;