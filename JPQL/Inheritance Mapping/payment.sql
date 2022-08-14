use mydb;

-- for SINGLE_TABLE inheritance type
create table payment(
	id int primary key,
    pmode varchar(2),
    amount decimal(8.3),
    cardnumber varchar(20),
    checknumber varchar(20)
);

select * from payment;
