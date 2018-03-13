create table shaobao_comments(
	sc_no number(3) primary key,		 -- 글 번호
	sc_title varchar2(50 char) not null, -- 글 제목
	sc_txt varchar2(200 char) not null,  -- 글 내용
	sc_date date not null				 -- 날짜
);

create sequence shaobao_comments_seq;

select * from shaobao_comments;

create table shaobao_menu(
	sm_no number(3) primary key,			-- 메뉴 번호
	sm_name varchar2(20 char) not null,		-- 메뉴명
	sm_desc varchar2(150 char) not null,	-- 메뉴 설명
	sm_price varchar2(5 char) not null,		-- 메뉴 가격
	sm_img varchar2(100 char) not null		-- 메뉴 사진
);

create sequence shaobao_menu_seq;

select * from shaobao_menu;

delete from shaobao_menu where sm_no=4;













