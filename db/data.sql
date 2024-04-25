create schema if not exists ds0;

use ds0;

drop table if exists t_order_0;
drop table if exists t_order_1;

create table t_order_0
(
    id       bigint primary key auto_increment,
    order_id int not null,
    user_id  int not null
);

create table t_order_1
(
    id       bigint primary key auto_increment,
    order_id int not null,
    user_id  int not null
);

create schema if not exists ds1;

use ds1;

drop table if exists t_order_0;
drop table if exists t_order_1;

create table t_order_0
(
    id       bigint primary key auto_increment,
    order_id int not null,
    user_id  int not null
);

create table t_order_1
(
    id       bigint primary key auto_increment,
    order_id int not null,
    user_id  int not null
);


create schema if not exists ds2;

use ds2;

CREATE TABLE if not exists `t_order`
(
    `id`       bigint NOT NULL AUTO_INCREMENT,
    `order_id` int    NOT NULL,
    `user_id`  int    NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;



create schema if not exists ds3;

use ds3;

CREATE TABLE if not exists `t_order`
(
    `id`       bigint NOT NULL AUTO_INCREMENT,
    `order_id` int    NOT NULL,
    `user_id`  int    NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;




