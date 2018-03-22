create table prac_member (
	m_id varchar2(10 char) primary key, 	-- id
	m_pw varchar2(10 char) not null, 		-- pw
	m_name varchar2(10 char) not null,		-- 이름
	m_addr varchar2(10 char) not null,		-- 거주지
	m_birthday date not null,				-- 생년월일
	m_img varchar2(100 char) not null		-- 사진
);

select * from PRAC_MEMBER;