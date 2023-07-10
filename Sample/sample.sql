set character set sjis;
DROP DATABASE if exists sample;
CREATE DATABASE sample;
GRANT ALL ON sample.* TO 'sample'@'localhost' IDENTIFIED BY 'sample';

use sample;

create table dept (
  no int primary key,
  name varchar(64) not null
);

create table emp (
  no int primary key,
  name varchar(64),
  hire_date DATE ,
  dept_no int,
  FOREIGN KEY (dept_no)
    REFERENCES dept (no)
);

create table numbering (
  table_name varchar(64) primary key,
  current_no int
);

INSERT INTO sample.numbering VALUES("dept",3);
INSERT INTO sample.numbering VALUES("emp",2);


INSERT INTO sample.dept  VALUES ('1','開発');
INSERT INTO sample.dept  VALUES ('2','人事');
INSERT INTO sample.dept  VALUES ('3','営業');

INSERT INTO sample.emp  VALUES (1,'田中','2023-07-01',1);
INSERT INTO sample.emp  VALUES (2,'山田','2023-07-15',2);

select * from dept;
select * from emp;
select * from numbering;

