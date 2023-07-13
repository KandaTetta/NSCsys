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

/* �����f�[�^ */

INSERT INTO member (member_id, login_id, password, user_name,birth_year) VALUES (NULL, 'nichi01', 'nichinichi', '���d���Y',1964);
INSERT INTO member (member_id, login_id, password, user_name,birth_year) VALUES (NULL, 'hana000', 'flower000', '���d�Ԏq',2000);

INSERT INTO article (article_id, content, writer_id) VALUES (NULL, 'NEC��1899�N�i����32�N�j�ɑn�����܂����B�n���L�O����7��17���ł��B', '1');
INSERT INTO article (article_id, content, writer_id) VALUES (NULL, '�����͑��z�������珸���ē��ɒ��݂܂��B', '1');
INSERT INTO article (article_id, content, writer_id) VALUES (NULL, '�R���s���[�^���o�ꂷ��O����A�@�B�̕s��́u�o�O�v�ƌĂ΂�Ă����炵���B', '2');

INSERT INTO products VALUES(NULL,'�t���e���r',300000);
INSERT INTO products VALUES(NULL,'Lavie L',190000);
INSERT INTO products VALUES(NULL,'ValueStarG',150000);

INSERT INTO course VALUES('PG001','Java�v���O���~���O������','3');
INSERT INTO course VALUES('PG002','Java�v���O���~���O������','4');
INSERT INTO course VALUES('PG003','Java�v���O���~���O�㋉��','5');
INSERT INTO course VALUES('PG101','�v���O���~���O�T�_','1');
INSERT INTO course VALUES('PG102','�I�u�W�F�N�g�w���T�v','2');
INSERT INTO course VALUES('PG103','��{�݌v��b','2');
INSERT INTO course VALUES('PG004','�ڍא݌v��b','3');