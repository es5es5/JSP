create table shaobao_comments(
	sc_no number(3) primary key,		 -- �� ��ȣ
	sc_title varchar2(50 char) not null, -- �� ����
	sc_txt varchar2(200 char) not null,  -- �� ����
	sc_date date not null				 -- ��¥
);

create sequence shaobao_comments_seq;

select * from shaobao_comments;

create table shaobao_menu(
	sm_no number(3) primary key,			-- �޴� ��ȣ
	sm_name varchar2(20 char) not null,		-- �޴���
	sm_desc varchar2(150 char) not null,	-- �޴� ����
	sm_price varchar2(5 char) not null,		-- �޴� ����
	sm_img varchar2(100 char) not null		-- �޴� ����
);

create sequence shaobao_menu_seq;

select * from shaobao_menu;

delete from shaobao_menu where sm_no=4;













