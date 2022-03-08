create sequence qna_seq
start with 1
increment by 1
nomaxvalue
nominvalue;


create table qna (
     q_no       number(5)       primary key,
     q_name		varchar2(20)	references members(name),
     q_subject  varchar2(50)    not null,
     q_content  varchar2(1000)  not null,
     reply      varchar2(1000),
     q_rep      char(1)         default 1,
     q_date     date            default sysdate,
     r_date     date			default sysdate
     );
 
     
--쿼리문 예시

insert into products values (qna_seq.nextval, '문의', '교환가능하나요', '가능합니다', 'user1', '2', sysdate);


