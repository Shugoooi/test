drop database if exists mamazon;
create database mamazon DEFAULT CHARACTER SET utf8;

use mamazon;

create table user_info(id varchar(32) primary key,
						pass varchar(32),
						name varchar(32),
						tel varchar(11),
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

create table cart_info(owner varchar(32),
						goods_name varchar(255),
						purchase_number int);

create table purchase_history(purchaser varchar(32) NOT NULL,
								goods_name varchar(255),
								goods_price int,
								purchase_number int,
								purchase_date datetime);


INSERT INTO user_info(id, pass, name, tel, mail, address) VALUES
( "f", "f", "me", "0801234567", "sldkfj@sldkfj.cm", "まち"),
( "a", "a", "admin", "1234567890", "test@gasdf.com", "東京");

INSERT INTO goods_info(name, img_located, category, price, stock, create_date) VALUES
("普通の消火器", "img/普通の消火器.jpg", "fire_extinguisher", 1500, 10, NOW()),
("置くやつ付きの消火器", "img/置くやつ付きの消火器.jpg", "fire_extinguisher", 2000, 10, NOW()),
("消火器風の何か", "img/消火器風の何か.jpg", "fire_extinguisher", 12000, 3, NOW()),
("高性能消火器", "img/高性能消火器.jpg", "fire_extinguisher", 5000, 10, NOW()),
("普通の火炎放射器", "img/普通の火炎放射器.jpg", "flame_thrower", 8000, 10, NOW()),
("比較的小型な火炎放射器", "img/比較的小型な火炎放射器.jpg", "flame_thrower", 15000, 3, NOW()),
("高出力火炎放射器", "img/高出力火炎放射器.jpg", "flame_thrower", 28800, 8, NOW()),
("お兄さん愛用の火炎放射器", "img/お兄さん愛用の火炎放射器.jpg", "flame_thrower", 230000, 0, NOW()),
("ただの苗木", "img/ただの苗木.jpg", "seedling", 200, 10, NOW()),
("水で増える苗木", "img/水で増える苗木.jpg", "seedling", 500, 1, NOW()),
("葉が多い苗木", "img/葉が多い苗木.jpg", "seedling", 1400, 10, NOW()),
("枯れ木", "img/枯れ木.jpg", "seedling", 30, 100, NOW());