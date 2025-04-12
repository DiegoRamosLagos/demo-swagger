create table if not exists employee (
id serial primary key,
first_name varchar(255) not null,
last_name varchar(255) not null
);

delete from employee;
insert into employee (first_name, last_name) values ('John', 'Doe');
insert into employee (first_name, last_name) values ('Jane', 'Smith');