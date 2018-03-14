create table mar14_logintest(
	l_id varchar2(10 char) primary key,
	l_pw varchar2(10 char) not null,
	l_name varchar2(10 char) not null
);

select * from mar14_logintest;

insert into mar14_logintest values('hong', '1111', 'ȫ�浿');