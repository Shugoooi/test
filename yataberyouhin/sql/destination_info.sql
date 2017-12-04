DROP TABLE if exists destination_info;
CREATE TABLE  destination_info;
use  destination_info;


CREATE TABLE destination_info(id int PRIMARY KEY NOT NULL,
                               user_id varchar(16) UNIQUE KEY NOT NULL,
                               family_name varchar(16) NOT NULL,
                               first_name varchar(16) NOT NULL,
                               family_name_kana varchar(16) NOT NULL,
                               first_name_kana varchar(16) NOT NULL,
                               email varchar(32) NOT NULL,
                               tel_number varchar(13) NOT NULL,
                               user_address varchar(50) NOT NULL,
                               insert_date datetime NOT NULL,
                               update_date datetime,
                               FOREIGN KEY(user_id) REFERENCES user_info(user_id) ON
UPDATE CASCADE ON DELETE CASCADE);
