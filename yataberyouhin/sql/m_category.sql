drop database if exists yataberyouhin;
create database yataberyouhin CHARACTER SET utf8;
use yataberyouhin;

CREATE TABLE m_category(
id int PRIMARY KEY NOT NULL,
category_id int UNIQUE KEY NOT NULL,
category_name varchar(20) UNIQUE KEY NOT NULL,
category_description varchar(100),
insert_date datetime NOT NULL,
update_date datetime
);

insert into m_category values
(1,1,"本","テストテストテスト",12月4日,12月4日);
