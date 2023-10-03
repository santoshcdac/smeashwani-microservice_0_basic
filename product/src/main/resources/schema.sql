Drop table IF EXISTS product;
create table product (id int not null AUTO_INCREMENT, name varchar(100) not null, description varchar(500), PRIMARY KEY ( id ));