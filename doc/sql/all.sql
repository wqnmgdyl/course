--大章
CREATE TABLE chapter  (
  id char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  course_id char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '课程ID',
  name varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (id) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '大章' ROW_FORMAT = Dynamic;

insert into chapter (id, course_id, name) values ('00000000','00000000','测试大章一');
insert into chapter (id, course_id, name) values ('00000001','00000000','测试大章二');
insert into chapter (id, course_id, name) values ('00000002','00000000','测试大章三');
insert into chapter (id, course_id, name) values ('00000003','00000000','测试大章四');
insert into chapter (id, course_id, name) values ('00000004','00000000','测试大章五');
insert into chapter (id, course_id, name) values ('00000005','00000000','测试大章六');
insert into chapter (id, course_id, name) values ('00000006','00000000','测试大章七');
insert into chapter (id, course_id, name) values ('00000007','00000000','测试大章八');
insert into chapter (id, course_id, name) values ('00000008','00000000','测试大章九');
insert into chapter (id, course_id, name) values ('00000009','00000000','测试大章十');
insert into chapter (id, course_id, name) values ('00000010','00000000','测试大章十一');
insert into chapter (id, course_id, name) values ('00000011','00000000','测试大章十二');
insert into chapter (id, course_id, name) values ('00000012','00000000','测试大章十三');
insert into chapter (id, course_id, name) values ('00000013','00000000','测试大章十四');
insert into chapter (id, course_id, name) values ('00000014','00000000','测试大章十五');

--小节
CREATE TABLE section (
id CHAR(8) NOT NULL DEFAULT '' COMMENT 'ID',
title VARCHAR(50) NOT NULL COMMENT '标题',
course_id CHAR(8) COMMENT '课程|course.id',
chapter_id CHAR(8) COMMENT '大章|chapter.id',
video VARCHAR(200) COMMENT '视频',
time INT COMMENT '时长|单位秒',
charge CHAR(1) COMMENT '收费|C 收费; F 免费',
sort INT COMMENT '顺序',
created_at DATETIME(3) COMMENT '创建时间',
updated_at DATETIME(3) COMMENT '修改时间',
PRIMARY KEY (id)
) engine=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='小节';

INSERT INTO section (id, title, course_id, chapter_id, video, time, charge, sort, created_at, updated_at)
VALUES('00000001', '测试小节01', '00000001', '00000000', '', 500, 'F', 1, now(), now());

--课程
create table course (
id char(8) not null default '' comment 'id',
name varchar(50) not null comment '名称',
summary varchar(2000) comment '概述',
time int default 0 comment '时长|单位秒',
price decimal(8,2) default 0.00 comment '价格(元)',
image varchar(100) comment '封面',
level char(1) comment '级别|枚举[CourseLevelEnum]: ONE("1", "初级"),TWO("2", "中级"),THREE("3", "高级")',
charge char(1) comment '收费|枚举[CourseChargeEnum]: CHARGE("C", 收费),FREE("F", "免费")',
status char(1) comment '状态|枚举[CourseStatusEnum]: PUBLISH("P", "发布"),DRAFT("D", "草稿")',
enroll integer default 0 comment '报名数',
sort int comment '顺序',
created_at datetime(3) comment '创建时间',
updated_at datetime(3) comment '修改时间',
primary key(id)
) engine=innodb default charset = utf8mb4 comment = '课程';

INSERT INTO course (id,name,summary,time,price,image,level,charge,status,enroll,sort,created_at,updated_at)
values ('00000001','测试课程01','这是一门测试课程',7200,19.9,'',0,'C','D',100,0,now(),now());