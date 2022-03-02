create table products (
     p_no       number(5)      primary key,
     p_name     varchar2(200)  not null,
     kind       char(1)        not null,
     price      number(7)      not null,
     p_content	varchar2(1000),
     image      varchar2(100),
     reg_date   date           sysdate
     );