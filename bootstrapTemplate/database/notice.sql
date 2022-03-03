create sequence notice_seq
start with 1
increment by 1
nomaxvalue
nominvalue;


create table notice (
     notice_no  number(5)       primary key,
     n_subject  varchar2(50)    not null,
     n_content  varchar2(1000)  not null,
     n_date     date            default sysdate,
     hit        number(3)       default 0
     );
     
--쿼리문
insert into notice values (notice_seq.nextval, '오픈공지'', '3월30일오픈합니다', sysdate, 0);