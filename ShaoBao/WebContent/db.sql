create table shaobao_comments(
	sc_no number(3) primary key,		 -- 글 번호
	sc_title varchar2(50 char) not null, -- 글 제목
	sc_txt varchar2(200 char) not null,  -- 글 내용
	sc_date date not null				 -- 날짜
);

create sequence shaobao_comments_seq;

select * from shaobao_comments;

insert into shaobao_comments values(
	shaobao_comments_seq.nextval,
	?,
	?,
	sysdate
);










