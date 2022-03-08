create sequence cart_seq
start with 1
increment by 1
nomaxvalue
nominvalue;


create table cart (
	c_no         number        primary key,
	id           varchar2(30)  REFERENCES members(id),
	p_no         number(5)     REFERENCES products(p_no),
	quantity     number(5)     not null,
	amount       number(10)    not null
);




--쿼리문 예시

insert into cart values (cart_seq.nextval, 'user1', 'p001',10);
insert into cart values (cart_seq.nextval, 'user1', 'p021',10);
insert into cart values (cart_seq.nextval, 'user1', 'p041',10);
insert into cart values (cart_seq.nextval, 'user1', 'p101',10);


insert into cart values (cart_seq.nextval, 'user10', 'p001',10);
insert into cart values (cart_seq.nextval, 'user10', 'p021',10);
insert into cart values (cart_seq.nextval, 'user10', 'p041',10);
insert into cart values (cart_seq.nextval, 'user10', 'p101',10);


select * from cart where id = 'user1';


