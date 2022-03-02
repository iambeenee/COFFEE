create sequence qna_seq
start with 1
increment by 1
nomaxvalue
nominvalue;


create table products (
     q_no       number(5)       primary key,
     q_subject  varchar2(50)    not null,
     q_content  varchar2(1000)  not null,
     q_reply    varchar2(1000)  not null,
     id         varchar2(20)    foreign key for members(id),
     q_rep      char(1)         default 1,
     q_date     date            sysdate
     );