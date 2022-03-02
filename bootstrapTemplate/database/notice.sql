create sequence notice_seq
start with 1
increment by 1
nomaxvalue
nominvalue;


create table notice (
     notice_no  number(5)       primary key,
     n_subject  varchar2(50)    not null,
     n_content  varchar2(1000)  not null,
     n_date     date            sysdate,
     hit        number(3)       default 0
     );