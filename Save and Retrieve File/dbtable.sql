use mydb;

create table image(
	id bigint not null,
    name varchar(100) not null,
    data blob not null,
    primary key(id)
);

select * from image;
