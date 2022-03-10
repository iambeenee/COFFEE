drop sequence qna_seq;

drop table qna;

create sequence qna_seq
start with 1
increment by 1
nomaxvalue
nominvalue;

create table qna (
     q_no       number(5)       primary key,
     id			varchar2(20),
     q_subject  varchar2(50)    not null,
     q_content  varchar2(3000)	not null,
     q_date     date            default sysdate,
     hit        number(3)       default 0,
     q_rep		number(5)		default null
     );
     
--쿼리문 예시
insert into qna values (qna_seq.nextval, 'user1', '문의', '교환가능하나요', sysdate, 0, null);
insert into qna values (qna_seq.nextval, 'user2', '배송', '배송언제되나요', sysdate, 0, null);
insert into qna values (qna_seq.nextval, 'user3', '사이즈', '사이즈', sysdate, 0, null);

insert into qna values (qna_seq.nextval, 'admin', '문의답글', '교환가능', sysdate, 0, 1);
insert into qna values (qna_seq.nextval, 'admin', '배송답글', '오늘중', sysdate, 0, 2);
insert into qna values (qna_seq.nextval, 'admin', '사이즈답글', '정핏', sysdate, 0, 3);

select lpad('*',  2*level) a, q_no, id, q_subject, q_content
from qna
start with q_rep is null
connect by prior q_no = q_rep;