DROP table if EXISTS purchase_history_info;
CREATE table purchase_history_info;
use purchase_history_info;


CREATE TABLE purchase_history_info(id int PRIMARY KEY NOT NULL,
                                    user_id varchar(16) UNIQUE KEY NOT NULL,
                                    product_id int UNIQUE KEY NOT NULL,
                                    insert_date datetime NOT NULL,
                                    update_date datetime,
                                    FOREIGN KEY(user_id) REFERENCES user_info(user_id) ON
UPDATE CASCADE ON DELETE CASCADE,
                                    FOREIGN KEY(product_id) REFERENCES product_info(product_id)
ON UPDATE CASCADE);