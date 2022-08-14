use mydb;

create table payment(
	id int primary key,
    amount decimal(8,3)
);
select * from payment;

create table card(
	id int ,
    cardnumber varchar(20),
    foreign key (id)references payment(id)
);
select * from card;

create table bankcheck(
	id int ,    
    checknumber varchar(20),
    foreign key (id)references payment(id)
);

select * from bankcheck;

