create sequence product_seq
start with 10000
increment by 1
nomaxvalue
nominvalue;

create table products (
     p_no       number(5)      primary key,
     p_name     varchar2(200)  not null,
     kind       char(1)        not null,
     price      number(7)      not null,
     p_content	varchar2(1000),
     image      varchar2(100),
     reg_date   date           sysdate
     );
     
 --쿼리문 예시
insert into products values (prduct_seq.nextval, '예가체프', 'a', '30000', '최상의원두, 맛있어요!', '이미지파일주소', sysdate);