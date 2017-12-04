drop database if exists yataberyouhin;
create database yataberyouhin;
use yataberyouhin;

create table cart_info(
id int primary key not null,
user_id varchar(128) not null,
product_id int not null,
insert_date datetime not null,
update_date datetime
foreign key(user_id) references user_info(user_id) on update cascade
foreign key(product_id) references product_info(product_id) on update cascade
)

insert into cart_info values(,"",,,);