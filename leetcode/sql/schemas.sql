create table customers(
    id int primary key,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255)
);

create table products(
    id int primary key,
    name varchar(255),
    description varchar(255),
    price float
);

create table orders(
    id int primary key,
    customer_id int,
    prodcut_id int,
    date_time TEXT
);