create table score(
    student_id char(10),
    cource_id char(10),
    score int
);
load data local infile "E:\\bigdata\\java\\data\\score.txt" into table score fields terminated by ',';


create table cource(
    id char(10),
    name char(10),
    score int
);

load data local infile "E:\\bigdata\\java\\data\\Cource.txt" into table cource fields terminated by ',';


#创建学生信息表
create table student
 (
     id char(10),
     name char(5),
     age int,
     gender char(2),
     clazz char(4)
 );


#导入数据，文件列的顺序要和表定义顺序一样
 load data local infile "E:\\bigdata\\java\\data\\students.txt" into table student fields terminated by ',';