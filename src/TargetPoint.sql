create database HeoMinYoung;

use HeoMinYoung;

create table score(
  b_user varchar(20),
  b_score int
);

insert into score values('허민영', 1000);
insert into score values('정종목', 3300);
insert into score values('박준형', 1250);
insert into score values('김환욱', 6750);
insert into score values('김기욱,qwee,qweqwe', 750);
insert into score values('장한별,qweq,aaaa', 10);

select * from score;

