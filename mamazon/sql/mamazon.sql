drop database if exists mamazon;
create database mamazon CHARACTER SET utf8;

use mamazon;

create table user_info(id varchar(32) primary key,
						pass varchar(32),
						name varchar(32),
						tel int(11),
						mail varchar(255),
						address varchar(255),
						birthday date,
						create_date datetime,
						update_date datetime);

create table goods_info(name varchar(255) primary key,
						img_located varchar(255),
						category enum("fire_extinguisher", "flame_thrower", "seedling"),
						price int,
						stock int,
						create_date datetime,
						update_time datetime);

create table cart_info(goods_name varchar(255),
						buy_count int,
						owner varchar(32));

create table purchase_history(purchaser varchar(32),
								goods_name varchar(255),
								goods_price int,
								purchase_count int,
								purchase_date datetime);


INSERT INTO user_info(id, pass, name, tel, address, birthday) VALUES
( "f", "f", "f", 0801234567, "sldkfj@sldkfj.cm", 0);

INSERT INTO goods_info(name, img_located, category, price, stock) VALUES
("C", "", "fire_extinguisher", 1000, 10),
("G", "", "fire_extinguisher", 3000, 10),
("S", "", "fire_extinguisher", 8000, 10),
("A", "", "flame_thrower", 10000, 10),
("J", "", "flame_thrower", 30000, 10),
("F", "", "flame_thrower", 80000, 10),
("sj", "", "seedling", 100, 10),
("mm", "", "seedling", 200, 10),
("sdf", "", "seedling", 2000, 10),
("jack", "", "seedling", 298000, 10);