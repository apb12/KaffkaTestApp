DROP TABLE IF EXISTS EMPLOYERS;
create table EMPLOYERS (
 id  bigserial not null,
 age int4,
 name varchar(255),
 primary key (id)
 );