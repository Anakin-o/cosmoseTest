create schema hotel;

create table if not exists customer (
USER_ID varchar(32) not null primary key auto_increment,
USER_NAME varchar(32),
PASSWORD varchar(100),
);

create table if not exists reservation (
RESERVATION_ID integer not null primary key,
END_TIME TIMESTAMP(23, 10),
ROOM_ID varchar(10),
START_TIME TIMESTAMP(23, 10),
STATUS bit,
USER_ID varchar(32)
);

create table if not exists room (
ROOM_ID varchar(32) not null primary key,
CITY varchar(32),
price decimal(10,2)
);