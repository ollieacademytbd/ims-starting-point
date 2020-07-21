create database if not exists ims_test;
create table if not exists ims_test.customers(customer_id int primary key auto_increment, first_name varchar(40), last_name varchar(40));
create table if not exists ims_test.product(product_id int primary key auto_increment, product_name varchar(40), price int);
create table if not exists ims_test.orders(order_id int primary key auto_increment,customer_id int NOT NULL,product_id int NOT NULL, quantity int, total double, FOREIGN KEY (customer_id) REFERENCES customers (customer_id), FOREIGN KEY (product_id) REFERENCES product (product_id));
