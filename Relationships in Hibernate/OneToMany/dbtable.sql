use mydb;

create table customer(
id int primary key auto_increment,
name varchar(20)
);

create table phone_number(
id int primary key auto_increment,
customer_id int,
number varchar(20),
type varchar(20),
foreign key(customer_id) references customer(id)
);

select * from customer;
select * from phone_number;
