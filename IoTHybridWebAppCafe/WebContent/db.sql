create table ihwac_member(
	im_id varchar2(10 char) primary key, 	-- id
	im_pw varchar2(10 char) not null, 		-- pw
	im_name varchar2(10 char) not null,		-- 이름
	im_addr varchar2(10 char) not null,		-- 거주지
	im_birthday date not null,				-- 생년월일
	im_img varchar2(100 char) not null		-- 사진
);

select * from IHWAC_MEMBER;