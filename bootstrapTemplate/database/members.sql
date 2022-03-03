create table members (
	id 		     varchar2(30) 	primary key,
	password 	 varchar2(100)  not null,	
	name         varchar2(20)   not null,
	address	     varchar2(500)  not null,
	tel          varchar2(20)   not null,
	email        varchar2(50)   not null,
	join_date    date           sysdate,
	author       varchar2(10)   default user
);
