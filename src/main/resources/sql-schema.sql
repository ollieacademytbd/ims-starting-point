create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), last_name varchar(40), email varchar(40), phone varchar(11));
create table if not exists ims.orders(order_id int primary key auto_increment, customer_id int NOT NULL, product_id int, total double);
create table if not exists ims.product(product_id int primary key auto_increment, product_name varchar(40), price int);

