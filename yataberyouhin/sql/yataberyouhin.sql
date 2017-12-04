データベース名が実際のものと違います

登録日、更新日のフィールド名を適切なものに変更してあります

宛先情報テーブルのフィールドuser_idは会員情報テーブルの上の同名のフィールドのFOREIGNKEYとしてあります(多分そうした方がいいと思ったので勝手にやりました。異論歓迎)

---以下実際のコードになります。---

DROP DATABASE IF EXISTS yryohintest;
CREATE DATABASE yryohintest CHARACTER SET utf8;

use yryohintest;

CREATE TABLE user_info(id int PRIMARY KEY NOT NULL,
                        user_id varchar(16) UNIQUE KEY NOT NULL,
                        password varchar(16) NOT NULL,
                        family_name varchar(16) NOT NULL,
                        first_name varchar(16) NOT NULL,
                        family_name_kana varchar(16) NOT NULL,
                        first_name_kana varchar(16) NOT NULL,
                        sex tinyint NOT NULL default 0,
                        email varchar(32) NOT NULL,
                        status tinyint NOT NULL DEFAULT 0,
                        logined tinyint NOT NULL DEFAULT 0,
                        register_date datetime NOT NULL,
                        update_date datetime);


CREATE TABLE m_category(id int PRIMARY KEY NOT NULL,
                         category_id int UNIQUE KEY NOT NULL,
                         category_name varchar(20) UNIQUE KEY NOT NULL,
                         category_description varchar(100),
                         register_date datetime NOT NULL,
                         update_date datetime);


CREATE TABLE product_info(id int PRIMARY KEY NOT NULL,
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
                           register_date datetime NOT NULL,
                           update_date datetime,
                           FOREIGN KEY(category_id) REFERENCES m_category(category_id) ON
UPDATE CASCADE);


CREATE TABLE cart_info(id int primary key NOT NULL,
                        user_id varchar(16) UNIQUE KEY NOT NULL,
                        product_id int UNIQUE KEY NOT NULL,
                        register_date datetime NOT NULL,
                        update_date datetime,
                        FOREIGN KEY(user_id) REFERENCES user_info(user_id) ON UPDATE
CASCADE ON DELETE CASCADE,
                        FOREIGN KEY(product_id) REFERENCES product_info(product_id) ON
UPDATE CASCADE ON DELETE CASCADE);


CREATE TABLE destination_info(id int PRIMARY KEY NOT NULL,
                               user_id varchar(16) UNIQUE KEY NOT NULL,
                               family_name varchar(16) NOT NULL,
                               first_name varchar(16) NOT NULL,
                               family_name_kana varchar(16) NOT NULL,
                               first_name_kana varchar(16) NOT NULL,
                               email varchar(32) NOT NULL,
                               tel_number varchar(13) NOT NULL,
                               user_address varchar(50) NOT NULL,
                               register_date datetime NOT NULL,
                               update_date datetime,
                               FOREIGN KEY(user_id) REFERENCES user_info(user_id) ON
UPDATE CASCADE ON DELETE CASCADE);


CREATE TABLE purchase_history_info(id int PRIMARY KEY NOT NULL,
                                    user_id varchar(16) UNIQUE KEY NOT NULL,
                                    product_id int UNIQUE KEY NOT NULL,
                                    register_date datetime NOT NULL,
                                    update_date datetime,
                                    FOREIGN KEY(user_id) REFERENCES user_info(user_id) ON
UPDATE CASCADE ON DELETE CASCADE,
                                    FOREIGN KEY(product_id) REFERENCES product_info(product_id)
ON UPDATE CASCADE);