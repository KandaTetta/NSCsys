DROP DATABASE IF EXISTS book_store;
CREATE DATABASE book_store;
GRANT ALL ON book_store.* TO 'jdbc'@'localhost' IDENTIFIED BY 'jdbc';

USE book_store;

/* Ϊqe[u */
CREATE TABLE customers(
  cust_no INT AUTO_INCREMENT PRIMARY KEY,
  login_id VARCHAR(32),
  password VARCHAR(32),
  name VARCHAR(32),
  address VARCHAR(32)
);

/* Πe[u */
CREATE TABLE books(
  book_no INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(32),
  author VARCHAR(32),
  publisher VARCHAR(32),
  price INT,
  stock INT
);

/* Άe[u */
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

/* dόe[u */
CREATE TABLE buyings(
  buy_no INT AUTO_INCREMENT PRIMARY KEY,
  book_no INT,
  buy_qty INT,
  buy_date DATE,
  FOREIGN KEY(book_no) REFERENCES books(book_no)
);

INSERT INTO customers
  VALUES(null,'kakeya','takejiro','|JρY','_ήμ§½Λs');
INSERT INTO customers
  VALUES(null,'kawai','ky1984','ΝxΧ','s’cJζ');
INSERT INTO customers
  VALUES(null,'shinoda','shinojun88','ΒcpΎ','{ι§εδsΒtζ');
INSERT INTO customers
  VALUES(null,'nakamoto','nakamotox','{~‘','skζ');
INSERT INTO customers
  VALUES(null,'shibaki','shibaki0309','ΕΨ^Υ','{ι§Ξͺs');
INSERT INTO customers
  VALUES(null,'ueno','ueno222','γμKb','εγ{εγskζ');

INSERT INTO books VALUES(null,
  'bvO~Oε«T','{θ','eNjJubNX',2200,20);
INSERT INTO books VALUES(null,
  'JavavO~OTvPOO','ͺ{λΆ','ZpoΕΠ',1560,20);
INSERT INTO books VALUES(null,
  'windowsOSS@\Oκπΰ','aJP','£ΛfBA[NX',2200,20);
INSERT INTO books VALUES(null,
  'ζ­ν©ιf[^x[XΜ{','§΄³€','MDoΕ',900,20);
INSERT INTO books VALUES(null,
  'Wordόεuΐ','¬ξF','eNjJubNX',1100,20);
INSERT INTO books VALUES(null,
  'WEBfUCΜε΄₯','’©zq','£ΛfBA[NX',1520,20);
