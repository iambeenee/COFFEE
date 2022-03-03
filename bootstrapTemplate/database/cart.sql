create sequence cart_seq
start with 1
increment by 1
nomaxvalue
nominvalue;


create table cart (
	cart_num     number        primary key,
	id           varchar2(30)  foreign key for members(id),
	p_no         number(5)     foreign key for prodcuts(p_no),
	quantity     nember(5)
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


