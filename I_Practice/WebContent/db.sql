create table prac_member (
	m_id varchar2(10 char) primary key, 	-- id
	m_pw varchar2(10 char) not null, 		-- pw
	m_name varchar2(10 char) not null,		-- �̸�
	m_addr varchar2(10 char) not null,		-- ������
	m_birthday date not null,				-- �������
	m_img varchar2(100 char) not null		-- ����
);

select * from PRAC_MEMBER;