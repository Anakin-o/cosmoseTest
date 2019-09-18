DELETE FROM customer;
INSERT INTO customer(user_id,user_name,password) VALUES ('0001','test001','123456');
INSERT INTO customer(user_id,user_name,password) VALUES ('0002','test002','123456');

DELETE FROM ROOM;
INSERT INTO room(room_id,city,price) VALUES('1001','SHANGHAI',1000.0);
INSERT INTO room(room_id,city,price) VALUES('1002','SHANGHAI',2000.0);
INSERT INTO room(room_id,city,price) VALUES('1003','SHANGHAI',3000.0);
INSERT INTO room(room_id,city,price) VALUES('1004','BEIJING',1000.0);
INSERT INTO room(room_id,city,price) VALUES('1005','BEIJING',2000.0);
INSERT INTO room(room_id,city,price) VALUES('1006','BEIJING',3000.0);

DELETE FROM RESERVATION;
INSERT into RESERVATION(reservation_id,room_id,user_id,start_time,end_time,status) VALUES(1,'1001','0002',DATE('2019-10-01 13:12:41'),DATE('2019-10-03 13:12:41'),1);
INSERT into RESERVATION(reservation_id,room_id,user_id,start_time,end_time,status) VALUES(2,'1002','0001',DATE('2019-10-01 13:12:41'),DATE('2019-10-03 13:12:41'),1);

