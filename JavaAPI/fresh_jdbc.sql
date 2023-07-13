DROP DATABASE IF EXISTS book_store;
CREATE DATABASE book_store;
GRANT ALL ON book_store.* TO 'jdbc'@'localhost' IDENTIFIED BY 'jdbc';

USE book_store;

/* 顧客テーブル */
CREATE TABLE customers(
  cust_no INT AUTO_INCREMENT PRIMARY KEY,
  login_id VARCHAR(32),
  password VARCHAR(32),
  name VARCHAR(32),
  address VARCHAR(32)
);

/* 書籍テーブル */
CREATE TABLE books(
  book_no INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(32),
  author VARCHAR(32),
  publisher VARCHAR(32),
  price INT,
  stock INT
);

/* 注文テーブル */
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

/* 仕入テーブル */
CREATE TABLE buyings(
  buy_no INT AUTO_INCREMENT PRIMARY KEY,
  book_no INT,
  buy_qty INT,
  buy_date DATE,
  FOREIGN KEY(book_no) REFERENCES books(book_no)
);

INSERT INTO customers
  VALUES(null,'kakeya','takejiro','掛谷二郎','神奈川県平塚市');
INSERT INTO customers
  VALUES(null,'kawai','ky1984','河合富泰','東京都世田谷区');
INSERT INTO customers
  VALUES(null,'shinoda','shinojun88','篠田英明','宮城県仙台市青葉区');
INSERT INTO customers
  VALUES(null,'nakamoto','nakamotox','仲本淳治','東京都北区');
INSERT INTO customers
  VALUES(null,'shibaki','shibaki0309','芝木真琴','宮城県石巻市');
INSERT INTO customers
  VALUES(null,'ueno','ueno222','上野幸恵','大阪府大阪市北区');

INSERT INTO books VALUES(null,
  'Ｃプログラミング大辞典','宮崎満','テクニカルブックス',2200,20);
INSERT INTO books VALUES(null,
  'Javaプログラミングサンプル１００','岡本雅文','技術出版社',1560,20);
INSERT INTO books VALUES(null,
  'windowsOS全機能徹底解説','渋谷博善','瀬戸メディアワークス',2200,20);
INSERT INTO books VALUES(null,
  'よくわかるデータベースの本','立原正巳','MD出版',900,20);
INSERT INTO books VALUES(null,
  'Word入門講座','小島基彦','テクニカルブックス',1100,20);
INSERT INTO books VALUES(null,
  'WEBデザインの大原則','里見陽子','瀬戸メディアワークス',1520,20);
