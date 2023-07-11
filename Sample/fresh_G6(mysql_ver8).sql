DROP DATABASE if exists nscdb;
CREATE DATABASE nscdb;
GRANT ALL ON nscdb.* TO 'duke'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

use nscdb;

-- memberテーブル
CREATE TABLE member (
 member_no   CHAR(10) PRIMARY KEY NOT NULL,
 name_sei    VARCHAR(30) NOT NULL,
 name_mei    VARCHAR(30) NOT NULL,
 kana_sei    VARCHAR(30) NOT NULL,
 kana_mei    VARCHAR(30) NOT NULL,
 email       VARCHAR(60) NOT NULL,
 nickname    VARCHAR(30) NOT NULL,
 password    VARCHAR(20) NOT NULL
);

-- lesson_categoryテーブル
CREATE TABLE lesson_category (
 lesson_category_code   INT AUTO_INCREMENT PRIMARY KEY,
 lesson_category_name   VARCHAR(30)  NOT NULL
);

-- time_frameテーブル
CREATE TABLE time_frame (
 time_frame_code   INT AUTO_INCREMENT PRIMARY KEY,
 start_time        VARCHAR(10) NOT NULL,
 end_time          VARCHAR(10) NOT NULL
);

-- facilityテーブル
CREATE TABLE facility (
 facility_code   INT AUTO_INCREMENT PRIMARY KEY ,
 facility_name   VARCHAR(10)  NOT NULL
);

-- lessonテーブル
CREATE TABLE lesson (
 lesson_code            INT AUTO_INCREMENT PRIMARY KEY,
 lesson_name            VARCHAR(30)  NOT NULL,
 description            VARCHAR(200) NOT NULL,
 lesson_category_code   INT,
 FOREIGN KEY(lesson_category_code) REFERENCES lesson_category(lesson_category_code)
);

-- instructor テーブル
CREATE TABLE instructor (
 instructor_code   INT AUTO_INCREMENT PRIMARY KEY,
 instructor_name   VARCHAR(20)  NOT NULL,
 facility_code     INT       NOT NULL,
 image_file        VARCHAR(20) ,
 FOREIGN KEY(facility_code) REFERENCES facility(facility_code)
);

-- scheduleテーブル
CREATE TABLE schedule(
 schedule_code    INT AUTO_INCREMENT PRIMARY KEY,
 lesson_code      INT   NOT NULL,
 event_date       DATE,
 time_frame_code  INT   NOT NULL,
 instructor_code  INT   NOT NULL,
 streaming_id     VARCHAR(30)  NOT NULL,
 streaming_pass   VARCHAR(30)  NOT NULL,
 cancel_flag      INT   NOT NULL,
 FOREIGN KEY(lesson_code) REFERENCES lesson(lesson_code),
 FOREIGN KEY(time_frame_code) REFERENCES time_frame(time_frame_code),
 FOREIGN KEY(instructor_code) REFERENCES instructor(instructor_code)
);

-- reserve テーブル
CREATE TABLE reserve (
 reserve_code      INT AUTO_INCREMENT PRIMARY KEY,
 member_no         CHAR(10)    NOT NULL,
 schedule_code     INT  NOT NULL,
 attendance_flag   INT  NOT NULL,
 cancel_flag       INT  NOT NULL,
 attendance_register_flag   INT   NOT  NULL,
 FOREIGN KEY(member_no) REFERENCES member(member_no),
 FOREIGN KEY(schedule_code) REFERENCES schedule(schedule_code)
);




INSERT INTO member
VALUES ('2018100010','鈴木','博','スズキ','ヒロシ','hiroshi@xxxxxx.co.jp','ヒロ','InuZuki55');
INSERT INTO member
VALUES ('2015230042','久保田','久美子','クボタ','クミコ','kubokumi@xxxx.ne.jp','くーさん','UU5MMss93');
INSERT INTO member
VALUES ('2002400883','伊藤','義信','イトウ','ヨシノブ','y-ito@xxxx.ne.jp','あきぱぱ','Bhu!49eju');
INSERT INTO member
VALUES ('2020442403','柳田','美紀','ヤナギダ','ミキ','mikimiki3@xxxx.ne.jp','ミッキー','Birth1118');
INSERT INTO member
VALUES ('2019455595','山本','真美','ヤマモト','マミ','ma-chan@xxxxxx.ne.jp','まーちゃん','m@6abc9@m');


INSERT INTO lesson_category VALUES (null,'ヨガ');
INSERT INTO lesson_category VALUES (null,'エクササイズ');
INSERT INTO lesson_category VALUES (null,'ボクササイズ');
INSERT INTO lesson_category VALUES (null,'ピラティス');
INSERT INTO lesson_category VALUES (null,'ダンス');
INSERT INTO lesson_category VALUES (null,'ストレッチ');
INSERT INTO lesson_category VALUES (null,'その他');


INSERT INTO time_frame VALUES (null,'10:00','10:50');
INSERT INTO time_frame VALUES (null,'13:00','13:50');
INSERT INTO time_frame VALUES (null,'14:00','14:50');
INSERT INTO time_frame VALUES (null,'15:00','15:50');
INSERT INTO time_frame VALUES (null,'16:00','16:50');
INSERT INTO time_frame VALUES (null,'17:00','17:50');
INSERT INTO time_frame VALUES (null,'18:00','18:50');
INSERT INTO time_frame VALUES (null,'19:00','19:50');
INSERT INTO time_frame VALUES (null,'20:00','20:50');


INSERT INTO facility VALUES (null,'田町');
INSERT INTO facility VALUES (null,'品川');
INSERT INTO facility VALUES (null,'渋谷');
INSERT INTO facility VALUES (null,'新宿');
INSERT INTO facility VALUES (null,'武蔵小杉');
INSERT INTO facility VALUES (null,'池袋');
INSERT INTO facility VALUES (null,'川口');
INSERT INTO facility VALUES (null,'町田');


INSERT INTO lesson
VALUES (null,'誰でも始められる簡単エクササイズ'
,'運動生理学に基づくストレッチング、ヨガを組み合わせ、音楽にのせて行う簡単なエクササイズです。初心者から始められます。',2);
INSERT INTO lesson
VALUES (null,'目指せ、部分痩せ！ヨガでシェイプアップ'
,'シェイプアップ効果を目指して、おなか周りや二の腕の筋力向上を行うヨガプログラムです。',1);
INSERT INTO lesson
VALUES (null,'楽しい！　リズムdeボクササイズ'
,'元東洋太平洋チャンピオンのタイガー佐藤が教える、エンタテイメントと融合したリズムボクササイズ。楽しんで強くなろう！',3);
INSERT INTO lesson
VALUES (null,'ピラティスで、強くしなやかな筋肉を！'
,'リハビリ用トレーニングでもあるピラティス。体に無理をさせずに筋肉を増やします。',4);
INSERT INTO lesson
VALUES (null,'ヨガでデトックス！'
,'日々の仕事や家事で溜まりがちな「あれやこれや」をデトックス。心身の疲労が飛んでいきます。',1);


INSERT INTO instructor VALUES (null,'田口　元',1,'image01.jpg');
INSERT INTO instructor VALUES (null,'斉藤　和美',2,'image02.jpg');
INSERT INTO instructor VALUES (null,'佐藤　洋一',3,'image03.jpg');
INSERT INTO instructor VALUES (null,'佐々木　さゆり',1,'image04.jpg');
INSERT INTO instructor VALUES (null,'桑田　ジュリア',7,'image05.jpg');


INSERT INTO schedule
VALUES (null,1,'2021-05-10',1,2,'xxx-xxx-xxxx','xxxxx',0);
INSERT INTO schedule
VALUES (null,2,'2021-05-10',5,1,'xxx-xxx-xxxx','xxxxx',0);
INSERT INTO schedule
VALUES (null,3,'2021-05-10',7,3,'xxx-xxx-xxxx','xxxxx',0);
INSERT INTO schedule
VALUES (null,4,'2021-05-10',7,4,'xxx-xxx-xxxx','xxxxx',0);
INSERT INTO schedule
VALUES (null,5,'2021-05-11',1,5,'xxx-xxx-xxxx','xxxxx',0);


INSERT INTO reserve VALUES (null,'2018100010',1,0,0,0);
INSERT INTO reserve VALUES (null,'2015230042',3,0,0,0);
INSERT INTO reserve VALUES (null,'2020442403',1,0,0,0);
INSERT INTO reserve VALUES (null,'2020442403',2,0,0,0);
INSERT INTO reserve VALUES (null,'2019455595',4,0,0,0);


select * from member;
select * from lesson_category;
select * from time_frame;
select * from facility;
select * from lesson;
select * from instructor;
select * from schedule;
select * from reserve;
