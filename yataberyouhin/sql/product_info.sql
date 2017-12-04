drop database if exists yataberyouhin;
create database yataberyouhin CHARACTER SET utf8;
use yataberyouhin;

CREATE TABLE product_info(
id int PRIMARY KEY NOT NULL,
product_id int UNIQUE KEY NOT NULL,
product_name varchar(100) UNIQUE KEY NOT NULL,
product_name_kana varchar(100) UNIQUE KEY NOT NULL,
product_description varchar(255) NOT NULL,
category_id int UNIQUE KEY NOT NULL,
price int,
image_file_path varchar(100),
image_file_name varchar(50),
release_date datetime NOT NULL,
release_company varchar(50),
status tinyint NOT NULL DEFAULT 0,
insert_date datetime NOT NULL,
update_date datetime,
FOREIGN KEY(category_id) REFERENCES m.category_id(category_id) ON UPDATE CASCADE
);


insert into product_info varchar
(1,1,"本","ほん","赤い本",1,500,"test","testtest",12月,"やたべ良品",1,12月4日,12月4日);
(2,2,"本","ほん","青い本",1,600,"test","testtest",12月,"やたべ良品",1,12月4日,12月4日);
