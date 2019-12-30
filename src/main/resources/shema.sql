DROP TABLE IF EXISTS USR;
create table USR (
 id  bigserial not null,
 age int4,
 name varchar(255),
 primary key (id)
 );