DROP TABLE IF EXISTS yataberyouhin.user_info;

CREATE TABLE yataberyouhin.user_info(id int PRIMARY KEY NOT NULL,
			                         user_id varchar(16) UNIQUE KEY NOT NULL,
			                         password varchar(16) NOT NULL,
			                         family_name varchar(16) NOT NULL,
			                         first_name varchar(16) NOT NULL,
			                         family_name_kana varchar(16) NOT NULL,
			                         first_name_kana varchar(16) NOT NULL,
			                         sex tinyint NOT NULL DEFAULT 0,
			                         email varchar(32) NOT NULL,
			                         status tinyint NOT NULL DEFAULT 1,
			                         logined tinyint NOT NULL DEFAULT 0,
			                         insert_date datetime NOT NULL,
			                         update_date datetime);