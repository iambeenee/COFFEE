create table reply(
	r_no		number(5)		references qna(q_no),
	r_content	varchar2(1000)	not null,
	r_date		date			default sysdate,
);