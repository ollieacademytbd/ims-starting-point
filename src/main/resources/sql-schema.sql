create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), last_name varchar(40));
create table if not exists ims.product(product_id int primary key auto_increment, product_name varchar(40), price int);
create table if not exists ims.orders(order_id int primary key auto_increment,id int NOT NULL,product_id int NOT NULL, quantity int, total double, FOREIGN KEY (id) REFERENCES customers (id), FOREIGN KEY (product_id) REFERENCES product (product_id));




