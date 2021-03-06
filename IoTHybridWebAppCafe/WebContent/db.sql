create table ihwac_msg(
	im_no number(7) primary key,
	im_from varchar2(10 char) not null,
	im_to varchar2(10 char) not null,
	im_txt varchar2(350 char) not null,
	im_date date not null
);
create sequence ihwac_msg_seq;
select * from ihwac_msg;
--------------------------------------------------
create table ihwac_sns(
	is_no number(5) primary key,			-- 글 번호
	is_owner varchar2(10 char) not null,	-- 글쓴이 id
	is_txt varchar2(350 char) not null,
	is_date date not null
);
create sequence ihwac_sns_seq;
select * from ihwac_sns;
--------------------------------------------------
create table ihwac_sns_repl(
	isr_no number(7) primary key,			-- 댓글 번호
	isr_is_no number(5) not null,			-- 소속 글 번호
	isr_owner varchar2(10 char) not null,	-- 댓글 쓴 사람
	isr_txt varchar2(150 char) not null,	-- 댓글 내용
	isr_date date not null
);
delete from IHWAC_SNS_REPL where isr_txt='ㅁㄴㅇ';
select * from ihwac_sns_repl;
create sequence ihwac_sns_repl_seq;
--------------------------------------------------
create table ihwac_member(
	im_id varchar2(10 char) primary key, 	-- id
	im_pw varchar2(10 char) not null, 		-- pw
	im_name varchar2(10 char) not null,		-- 이름
	im_addr varchar2(10 char) not null,		-- 거주지
	im_birthday date not null,				-- 생년월일
	im_img varchar2(100 char) not null		-- 사진
);
select * from ihwac_member;
select *
from ihwac_sns, ihwac_member
where is_owner = im_id
order by is_date;
--------------------------------------------------
















