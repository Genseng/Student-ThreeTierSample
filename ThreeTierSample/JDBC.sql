drop database if EXISTS JDBC;
create database if NOT EXISTS JDBC
character set utf8 collate utf8_general_ci;

USE JDBC;

DROP TABLE IF EXISTS `paiming`;
CREATE TABLE `paiming` (
  `scale` varchar(11) NOT NULL,
  `srank` varchar(20) DEFAULT NULL,/*考生学校排名*/
  PRIMARY KEY (`scale`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
INSERT INTO `paiming` (`scale`,`srank`) VALUES 
 ('01','101'),
 ('03','25'),
 ('04','44'),
 ('08','57'),
 ('10','82'),
 ('09','95'),
 ('07','26'),
 ('05','75');
 
DROP TABLE IF EXISTS `success`;
CREATE TABLE `success` (
  `snum` varchar(30) NOT NULL,/*考生准考证号*/
  `sbnum` int,/*科目号*/
  `pnum` int,/*试卷号*/
  `subject` varchar(40),/*科目名称*/
  `scale` varchar(2),/*考生班级排名*/
  PRIMARY KEY (`snum`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


INSERT INTO `success` (`snum`,`sbnum`,`pnum`,`subject`,`scale`) VALUES 
 ('20154091001',1,10,'C语言','01'),
 ('20154091002',2,20,'jsp程序设计','01'),
 ('20154091003',3,20,'面向对象设计','01'),
 ('20154091004',4,20,'java程序设计','01'),
 ('20154091005',5,20,'高等数学','01'),
 ('20154091006',1,50,'C语言','01'),
 ('20154091007',2,20,'jsp程序设计','01'),
 ('20144091008',3,20,'面向对象设计','02'),
 ('20164091006',4,20,'java程序设计','01'),
 ('20164091007',5,20,'高等数学','01'),
 ('20164091001',1,40,'C语言','01'),
 ('20164091002',5,20,'高等数学','01'),
 ('20164091003',3,20,'面向对象设计','01'),
 ('20164091004',4,20,'java程序设计','01'),
 ('20164091005',5,30,'高等数学','01'),
 ('20164091010',1,20,'C语言','01'),
 ('20164091011',2,20,'jsp程序设计','01'),
 ('20164091012',3,20,'面向对象设计','01'),
 ('20164091013',4,20,'java程序设计','01'),
 ('20164091014',5,20,'高等数学','01'),
 ('20164091015',1,20,'C语言','01'),
 ('20164091016',2,20,'jsp程序设计','01');

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;


INSERT INTO `user` VALUES ('1', 'admin', '30', '123456');
INSERT INTO `user` VALUES ('3', 'cs', '25', '123456');
INSERT INTO `user` VALUES ('4', 'qw', '12', '123');
INSERT INTO `user` VALUES ('5', 'de', '34', '123456');
INSERT INTO `user` VALUES ('7', 'gd', '27', '123');
INSERT INTO `user` VALUES ('8', 'qwe', '25', '123');
INSERT INTO `user` VALUES ('9', '123', '12', '123');
INSERT INTO `user` VALUES ('10', 'csa', '22', '123');
INSERT INTO `user` VALUES ('11', 'asda', '11', '123');

DROP TABLE IF EXISTS loginfo;
CREATE TABLE loginfo (
  id int(11) NOT NULL AUTO_INCREMENT,
  userid varchar(20) DEFAULT NULL,
  loginIP varchar(30) default NUll,
  logintime datetime DEFAULT NULL,
  PRIMARY KEY (id)
)  DEFAULT CHARSET=utf8;

INSERT INTO loginfo (id,userid,loginIP,logintime) VALUES 
 (null,'admin',"192.168.0.1",'2019-10-11 18:11:06'),
 (null,'admin',"192.168.0.2",'2019-10-11 18:12:06'),
 (null,'admin',"192.168.0.3",'2019-10-11 18:13:06');

DROP TABLE IF EXISTS login;
CREATE TABLE login (
  id int(11),
  uname varchar(20),
  upwd varchar(20) 
) ;

INSERT INTO `login` (`id`,`uname`,`upwd`) VALUES 
 (1,'zs','abc');
 
 
 
DROP TABLE IF EXISTS mytxt;
CREATE TABLE mytxt (
  id int(11) primary key,
  txt text
) ;
set global max_allowed_packet = 2*1024*1024*10;
DROP TABLE IF EXISTS  mymusic;
CREATE TABLE  mymusic (
  id int(11) primary key,
  music Blob
) ;

DROP TABLE IF EXISTS student;
CREATE TABLE student (
  sno int(11) primary key,
  sname varchar(20),
  sage int,  
  saddress varchar(30) 
)CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO `student` (`sno`,`sname`,`sage`,`saddress`) VALUES 
 (1,'admin',1,'China');
INSERT INTO `student` VALUES ('2', '张三', '18', '中国');
INSERT INTO `student` VALUES ('3', '李四3', '3', '李四3的地址');
INSERT INTO `student` VALUES ('4', '李四4', '4', '李四4的地址');
INSERT INTO `student` VALUES ('5', '李四5', '5', '李四5的地址');
INSERT INTO `student` VALUES ('6', '李四6', '6', '李四6的地址');
INSERT INTO `student` VALUES ('7', '李四7', '7', '李四7的地址');
INSERT INTO `student` VALUES ('8', '李四8', '8', '李四8的地址');
INSERT INTO `student` VALUES ('9', '李四9', '9', '李四9的地址');
INSERT INTO `student` VALUES ('10', '李四10', '10', '李四10的地址');
INSERT INTO `student` VALUES ('11', '李四11', '11', '李四11的地址');
INSERT INTO `student` VALUES ('12', '李四12', '12', '李四12的地址');
INSERT INTO `student` VALUES ('13', '李四13', '13', '李四13的地址');
INSERT INTO `student` VALUES ('14', '李四14', '14', '李四14的地址');
INSERT INTO `student` VALUES ('15', '李四15', '15', '李四15的地址');
INSERT INTO `student` VALUES ('16', '李四16', '16', '李四16的地址');
INSERT INTO `student` VALUES ('17', '李四17', '17', '李四17的地址');
INSERT INTO `student` VALUES ('18', '李四18', '18', '李四18的地址');
INSERT INTO `student` VALUES ('19', '李四19', '19', '李四19的地址');
INSERT INTO `student` VALUES ('20', '李四20', '20', '李四20的地址');

INSERT INTO `student` VALUES (99,'admin',1,'China');
INSERT INTO `student` VALUES (98,'admin',1,'China');
INSERT INTO `student` VALUES (97,'admin',1,'China');
INSERT INTO `student` VALUES (96,'admin',1,'China');
INSERT INTO `student` VALUES (95,'admin',1,'China');
INSERT INTO `student` VALUES (94,'admin',1,'China');
INSERT INTO `student` VALUES (93,'admin',1,'China');
INSERT INTO `student` VALUES (92,'admin',1,'China');
INSERT INTO `student` VALUES (91,'admin',1,'China');
INSERT INTO `student` VALUES (90,'admin',1,'China');
INSERT INTO `student` VALUES (89,'admin',1,'China');
INSERT INTO `student` VALUES (88,'admin',1,'China');
INSERT INTO `student` VALUES (87,'admin',1,'China');
INSERT INTO `student` VALUES (86,'admin',1,'China');
INSERT INTO `student` VALUES (85,'admin',1,'China');
INSERT INTO `student` VALUES (84,'admin',1,'China');
INSERT INTO `student` VALUES (83,'admin',1,'China');
INSERT INTO `student` VALUES (82,'admin',1,'China');
INSERT INTO `student` VALUES (81,'admin',1,'China');
INSERT INTO `student` VALUES (80,'admin',1,'China');
INSERT INTO `student` VALUES (79,'admin',1,'China');
INSERT INTO `student` VALUES (78,'admin',1,'China');
INSERT INTO `student` VALUES (77,'admin',1,'China');
INSERT INTO `student` VALUES (76,'admin',1,'China');
INSERT INTO `student` VALUES (75,'admin',1,'China');
INSERT INTO `student` VALUES (74,'admin',1,'China');
INSERT INTO `student` VALUES (73,'admin',1,'China');
INSERT INTO `student` VALUES (72,'admin',1,'China');
INSERT INTO `student` VALUES (71,'admin',1,'China');
INSERT INTO `student` VALUES (70,'admin',1,'China');
INSERT INTO `student` VALUES (69,'admin',1,'China');
INSERT INTO `student` VALUES (68,'admin',1,'China');
INSERT INTO `student` VALUES (67,'admin',1,'China');
INSERT INTO `student` VALUES (66,'admin',1,'China');
INSERT INTO `student` VALUES (65,'admin',1,'China');
INSERT INTO `student` VALUES (64,'admin',1,'China');
INSERT INTO `student` VALUES (63,'admin',1,'China');
INSERT INTO `student` VALUES (62,'admin',1,'China');
INSERT INTO `student` VALUES (61,'admin',1,'China');
INSERT INTO `student` VALUES (60,'admin',1,'China');
INSERT INTO `student` VALUES (59,'admin',1,'China');
INSERT INTO `student` VALUES (58,'admin',1,'China');
INSERT INTO `student` VALUES (57,'admin',1,'China');
INSERT INTO `student` VALUES (56,'admin',1,'China');
INSERT INTO `student` VALUES (55,'admin',1,'China');
INSERT INTO `student` VALUES (54,'admin',1,'China');
INSERT INTO `student` VALUES (53,'admin',1,'China');
INSERT INTO `student` VALUES (52,'admin',1,'China');
INSERT INTO `student` VALUES (51,'admin',1,'China');
INSERT INTO `student` VALUES (50,'admin',1,'China');
INSERT INTO `student` VALUES (49,'admin',1,'China');
INSERT INTO `student` VALUES (48,'admin',1,'China');
INSERT INTO `student` VALUES (47,'admin',1,'China');
INSERT INTO `student` VALUES (46,'admin',1,'China');
INSERT INTO `student` VALUES (45,'admin',1,'China');
INSERT INTO `student` VALUES (44,'admin',1,'China');
INSERT INTO `student` VALUES (43,'admin',1,'China');
INSERT INTO `student` VALUES (42,'admin',1,'China');
INSERT INTO `student` VALUES (41,'admin',1,'China');
INSERT INTO `student` VALUES (40,'admin',1,'China');
INSERT INTO `student` VALUES (39,'admin',1,'China');
INSERT INTO `student` VALUES (38,'admin',1,'China');
INSERT INTO `student` VALUES (37,'admin',1,'China');
INSERT INTO `student` VALUES (36,'admin',1,'China');
INSERT INTO `student` VALUES (35,'admin',1,'China');
INSERT INTO `student` VALUES (34,'admin',1,'China');
INSERT INTO `student` VALUES (33,'admin',1,'China');
INSERT INTO `student` VALUES (32,'admin',1,'China');
INSERT INTO `student` VALUES (31,'aaaaa',1,'China');
INSERT INTO `student` VALUES (30,'aaaaa',1,'China');
INSERT INTO `student` VALUES (29,'aaaaa',1,'China');
INSERT INTO `student` VALUES (28,'aaaaa',1,'China');
INSERT INTO `student` VALUES (27,'aaaaa',1,'China');
INSERT INTO `student` VALUES (26,'aaaaa',1,'China');
INSERT INTO `student` VALUES (25,'aaaaa',1,'China');
INSERT INTO `student` VALUES (24,'aaaaa',1,'China');
INSERT INTO `student` VALUES (23,'aaaaa',1,'China');
INSERT INTO `student` VALUES (22,'aaaaa',1,'China');
INSERT INTO `student` VALUES (21,'aaaaa',1,'China');



