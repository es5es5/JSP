create table shaobao_comments(
	sc_no number(3) primary key,		 -- �� ��ȣ
	sc_title varchar2(50 char) not null, -- �� ����
	sc_txt varchar2(200 char) not null,  -- �� ����
	sc_date date not null				 -- ��¥
);

create sequence shaobao_comments_seq;

select * from shaobao_comments;

insert into shaobao_comments values(
	shaobao_comments_seq.nextval,
	?,
	?,
	sysdate
);










