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