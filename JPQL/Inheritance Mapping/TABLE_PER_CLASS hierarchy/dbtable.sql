use mydb;

create table card(
	id int primary key,
    amount decimal(8.3),
    cardnumber varchar(20)
);

create table bankcard(
	id int primary key,
    amount decimal(8.3),
    checknumber varchar(20)
);
