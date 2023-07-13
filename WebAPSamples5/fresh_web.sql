set character set sjis;
DROP DATABASE IF EXISTS javaweb_db;
CREATE DATABASE javaweb_db;
GRANT ALL ON javaweb_db.* TO 'duke'@'localhost' IDENTIFIED BY 'system5';

use javaweb_db;


/*Tables */

CREATE TABLE member
(
    member_id int NOT NULL AUTO_INCREMENT,
    login_id varchar(60) NOT NULL,
    password varchar(60) NOT NULL,
    user_name varchar(60) NOT NULL,
    birth_year int ,
    PRIMARY KEY (member_id),
    UNIQUE (login_id)
);

CREATE TABLE article
(
    article_id int NOT NULL AUTO_INCREMENT,
    content varchar(255) NOT NULL,
    writer_id int NOT NULL,
    PRIMARY KEY (article_id),
    FOREIGN KEY (writer_id)
    REFERENCES member (member_id)
);


CREATE TABLE products (
  no    INT         AUTO_INCREMENT PRIMARY KEY,
  name  VARCHAR(64) NOT NULL,
  price INT         NOT NULL
);

CREATE TABLE course(
  course_no CHAR(5) PRIMARY KEY,
  course_name VARCHAR(60) NOT NULL,
  term int NOT NULL
);

CREATE TABLE entry(
  no    INT         AUTO_INCREMENT PRIMARY KEY,
  sei  VARCHAR(10) NOT NULL,
  mei  VARCHAR(10) NOT NULL,
  gender CHAR(2) NOT NULL,
  zipcode CHAR(8) NOT NULL,
  address VARCHAR(60) NOT NULL,
  course_no CHAR(5) NOT NULL,
  FOREIGN KEY (course_no)
    REFERENCES course (course_no)
);

/* 初期データ */

INSERT INTO member (member_id, login_id, password, user_name,birth_year) VALUES (NULL, 'nichi01', 'nichinichi', '日電太郎',1964);
INSERT INTO member (member_id, login_id, password, user_name,birth_year) VALUES (NULL, 'hana000', 'flower000', '日電花子',2000);

INSERT INTO article (article_id, content, writer_id) VALUES (NULL, 'NECは1899年（明治32年）に創立しました。創立記念日は7月17日です。', '1');
INSERT INTO article (article_id, content, writer_id) VALUES (NULL, '金星は太陽が西から昇って東に沈みます。', '1');
INSERT INTO article (article_id, content, writer_id) VALUES (NULL, 'コンピュータが登場する前から、機械の不具合は「バグ」と呼ばれていたらしい。', '2');

INSERT INTO products VALUES(NULL,'液晶テレビ',300000);
INSERT INTO products VALUES(NULL,'Lavie L',190000);
INSERT INTO products VALUES(NULL,'ValueStarG',150000);

INSERT INTO course VALUES('PG001','Javaプログラミング初級編','3');
INSERT INTO course VALUES('PG002','Javaプログラミング中級編','4');
INSERT INTO course VALUES('PG003','Javaプログラミング上級編','5');
INSERT INTO course VALUES('PG101','プログラミング概論','1');
INSERT INTO course VALUES('PG102','オブジェクト指向概要','2');
INSERT INTO course VALUES('PG103','基本設計基礎','2');
INSERT INTO course VALUES('PG004','詳細設計基礎','3');