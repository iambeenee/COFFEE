create sequence order_seq
start with 10000
increment by 1
nomaxvalue
nominvalue;

create table orders (
	order_no   number        primary key,
	id         varchar2(20)  foreign key for members(id),
	order_date date          sysdate
);

