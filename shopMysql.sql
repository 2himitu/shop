DROP DATABASE IF EXISTS  shop;
CREATE DATABASE shop;
USE shop;

CREATE TABLE cart(
num INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
userid VARCHAR(50) NOT NULL,
gCode VARCHAR(50) NOT NULL,
gName VARCHAR(50) NOT NULL,
gPrice VARCHAR(50) NOT NULL,
gSize VARCHAR(10) NOT NULL,
gColor VARCHAR(20) NOT NULL,
gAmount INT(10) NOT NULL,
gImage VARCHAR(20) NOT NULL
);

CREATE sequence cart_seq
increment BY 1  #1씩 증가 (기본값 : 1)
START WITH 1 #시작점 1 (기본값 : 1) 
MAXVALUE 100 #끝점 100 (기본값 : 10의 27승(무한)) 
nocache #시퀀스를 미리 만들어 놓고 메모리에서 가져다 쓰지않겠다 (기본값 : 20개)
nocycle; 




DESC cart;

CREATE TABLE goods(
gCode VARCHAR(50) NOT NULL PRIMARY KEY,
gCategory VARCHAR(50) NOT NULL,
gName VARCHAR(50) NOT NULL,
gContent VARCHAR(50) NOT NULL,
gPrice	INT(10) NOT NULL,
gImage VARCHAR(50) NOT NULL
);

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('bottom1','bottom','bottom1','bottom1',18000,'bottom1');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('bottom2','bottom','bottom2','bottom2',18000,'bottom2');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('bottom3','bottom','bottom3','bottom3',18000,'bottom3');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('bottom4','bottom','bottom4','bottom4',18000,'bottom4');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('bottom5','bottom','bottom5','bottom5',18000,'bottom5');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('bottom6','bottom','bottom6','bottom6',18000,'bottom6');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('bottom7','bottom','bottom7','bottom7',18000,'bottom7');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('bottom8','bottom','bottom8','bottom8',18000,'bottom8');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('bottom9','bottom','bottom9','bottom9',18000,'bottom9');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('bottom10','bottom','bottom10','bottom10',18000,'bottom10');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('bottom11','bottom','bottom11','bottom11',18000,'bottom11');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('bottom12','bottom','bottom12','bottom12',18000,'bottom12');


INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('dress1','dress','dress1','dress1',18000,'dress1');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('dress2','dress','dress2','dress2',18000,'dress2');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('dress3','dress','dress3','dress3',18000,'dress3');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('dress4','dress','dress4','dress4',18000,'dress4');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('dress5','dress','dress5','dress5',18000,'dress5');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('dress6','dress','dress6','dress6',18000,'dress6');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('dress7','dress','dress7','dress7',18000,'dress7');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('dress8','dress','dress8','dress8',18000,'dress8');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('dress9','dress','dress9','dress9',18000,'dress9');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('dress10','dress','dress10','dress10',18000,'dress10');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('dress11','dress','dress11','dress11',18000,'dress11');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('dress12','dress','dress12','dress12',18000,'dress12');


INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('outer1','outer','outer1','outer1',18000,'outer1');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('outer2','outer','outer2','outer2',18000,'outer2');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('outer3','outer','outer3','outer3',18000,'outer3');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('outer4','outer','outer4','outer4',18000,'outer4');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('outer5','outer','outer5','outer5',18000,'outer5');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('outer6','outer','outer6','outer6',18000,'outer6');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('outer7','outer','outer7','outer7',18000,'outer7');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('outer8','outer','outer8','outer8',18000,'outer8');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('outer9','outer','outer9','outer9',18000,'outer9');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('outer10','outer','outer10','outer10',18000,'outer10');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('outer11','outer','outer11','outer11',18000,'outer11');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('outer12','outer','outer12','outer12',18000,'outer12');


INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('top1','top','top1','top1',18000,'top1');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('top2','top','top2','top2',18000,'top2');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('top3','top','top3','top3',18000,'top3');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('top4','top','top4','top4',18000,'top4');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('top5','top','top5','top5',18000,'top5');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('top6','top','top6','top6',18000,'top6');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('top7','top','top7','top7',18000,'top7');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('top8','top','top8','top8',18000,'top8');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('top9','top','top9','top9',18000,'top9');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('top10','top','top10','top10',18000,'top10');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('top11','top','top11','top11',18000,'top11');

INSERT INTO goods (gCode,gCategory,gName,gContent,gPrice,gImage) 
VALUES ('top12','top','top12','top12',18000,'top12');


SELECT * FROM goods; 

CREATE TABLE `member`(
userid VARCHAR(50) NOT NULL PRIMARY KEY,
passwd VARCHAR(50) NOT NULL,
username VARCHAR(50) NOT NULL,
post VARCHAR(50) NOT NULL,
addr1 VARCHAR(50) NOT NULL,
addr2 VARCHAR(50) NOT NULL,
phone1 VARCHAR(50) NOT NULL,
phone2 VARCHAR(50) NOT NULL,
phone3 VARCHAR(50) NOT NULL,
email1 VARCHAR(50) NOT NULL,
email2 VARCHAR(50) NOT NULL
);

DESC goods;

CREATE TABLE `order`(
num INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
userid VARCHAR(50) NOT NULL,
gCode VARCHAR(50) NOT NULL,
gName VARCHAR(50) NOT NULL,
gPrice INT(10) UNSIGNED NOT NULL,
gSize VARCHAR(50) NOT NULL,
gColor VARCHAR(50) NOT NULL,
gAmount INT(10) UNSIGNED NOT NULL,
gImage VARCHAR(50) NOT NULL,
orderName VARCHAR(50) NOT NULL,
post VARCHAR(50) NOT NULL,
addr1 VARCHAR(50) NOT NULL,
addr2 VARCHAR(50) NOT NULL,
phone VARCHAR(50) NOT NULL,
payMethod VARCHAR(50) NOT NULL,
orderday VARCHAR(50) NOT NULL
);

DESC goods;