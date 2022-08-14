use mydb;

create table student(
	id int primary key auto_increment,
    lname varchar(20),
    fname varchar(20),
    score int
);

select * from student;
