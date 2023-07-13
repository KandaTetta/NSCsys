DROP DATABASE IF EXISTS book_store;
CREATE DATABASE book_store;
GRANT ALL ON book_store.* TO 'jdbc'@'localhost' IDENTIFIED BY 'jdbc';

USE book_store;

/* �ڋq�e�[�u�� */
CREATE TABLE customers(
  cust_no INT AUTO_INCREMENT PRIMARY KEY,
  login_id VARCHAR(32),
  password VARCHAR(32),
  name VARCHAR(32),
  address VARCHAR(32)
);

/* ���Ѓe�[�u�� */
CREATE TABLE books(
  book_no INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(32),
  author VARCHAR(32),
  publisher VARCHAR(32),
  price INT,
  stock INT
);

/* �����e�[�u�� */
CREATE TABLE orders(
  ord_no INT AUTO_INCREMENT PRIMARY KEY,
  cust_no INT,
  book_no INT,
  ord_qty INT,
  ord_total INT,
  ord_date DATE,
  FOREIGN KEY(cust_no) REFERENCES customers(cust_no),
  FOREIGN KEY(book_no) REFERENCES books(book_no)
);

/* �d���e�[�u�� */
CREATE TABLE buyings(
  buy_no INT AUTO_INCREMENT PRIMARY KEY,
  book_no INT,
  buy_qty INT,
  buy_date DATE,
  FOREIGN KEY(book_no) REFERENCES books(book_no)
);

INSERT INTO customers
  VALUES(null,'kakeya','takejiro','�|�J��Y','�_�ސ쌧���ˎs');
INSERT INTO customers
  VALUES(null,'kawai','ky1984','�͍��x��','�����s���c�J��');
INSERT INTO customers
  VALUES(null,'shinoda','shinojun88','�c�p��','�{�錧���s�t��');
INSERT INTO customers
  VALUES(null,'nakamoto','nakamotox','���{�~��','�����s�k��');
INSERT INTO customers
  VALUES(null,'shibaki','shibaki0309','�Ŗؐ^��','�{�錧�Ί��s');
INSERT INTO customers
  VALUES(null,'ueno','ueno222','���K�b','���{���s�k��');

INSERT INTO books VALUES(null,
  '�b�v���O���~���O�厫�T','�{�薞','�e�N�j�J���u�b�N�X',2200,20);
INSERT INTO books VALUES(null,
  'Java�v���O���~���O�T���v���P�O�O','���{�땶','�Z�p�o�Ŏ�',1560,20);
INSERT INTO books VALUES(null,
  'windowsOS�S�@�\�O����','�a�J���P','���˃��f�B�A���[�N�X',2200,20);
INSERT INTO books VALUES(null,
  '�悭�킩��f�[�^�x�[�X�̖{','��������','MD�o��',900,20);
INSERT INTO books VALUES(null,
  'Word����u��','������F','�e�N�j�J���u�b�N�X',1100,20);
INSERT INTO books VALUES(null,
  'WEB�f�U�C���̑匴��','�����z�q','���˃��f�B�A���[�N�X',1520,20);
