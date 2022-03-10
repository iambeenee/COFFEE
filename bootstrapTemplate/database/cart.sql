create sequence cart_seq
start with 1
increment by 1
nomaxvalue
nominvalue;


create table cart (
	c_no         number        not null 	primary key,
	id           varchar2(30)  not null 	references members(id),
	p_no         number	       not null 	references products(p_no),
	amount       number        default 0
);

-- 3개의 테이블(memebers, products, cart)을 join한다.
select name, image, p_name, price, amount, price*amount money
from   members m, products p, cart c
where  m.id = c.id and p.p_no = c.p_no;




