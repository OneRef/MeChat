/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : mechat

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 14/03/2024 17:50:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat_channel
-- ----------------------------
DROP TABLE IF EXISTS `chat_channel`;
CREATE TABLE `chat_channel`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `type` int NULL DEFAULT NULL COMMENT '类型 1：“个人” 2：“群组”',
  `channel_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '频道名称',
  `channel_num` int NULL DEFAULT NULL COMMENT '频道人数',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '群聊头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat_channel
-- ----------------------------
INSERT INTO `chat_channel` VALUES (1, '2023-08-24 11:45:03', '2023-09-01 09:41:30', 67, '义并便目领用快', 72, NULL);
INSERT INTO `chat_channel` VALUES (28, '2011-09-18 09:57:43', '1996-07-03 14:39:00', 6, '值手金民', 3, NULL);

-- ----------------------------
-- Table structure for chat_user_channel
-- ----------------------------
DROP TABLE IF EXISTS `chat_user_channel`;
CREATE TABLE `chat_user_channel`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `channel_id` int NULL DEFAULT NULL COMMENT '频道id',
  `channel_type` int NULL DEFAULT NULL COMMENT '频道类型1:\"好友\",2:\"群聊\"',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat_user_channel
-- ----------------------------
INSERT INTO `chat_user_channel` VALUES (1, '2023-09-06 14:22:49', '2023-09-06 14:22:52', 1, 1, 1);
INSERT INTO `chat_user_channel` VALUES (2, '2023-08-30 14:24:13', '2023-09-06 14:24:16', 1, 2, 2);
INSERT INTO `chat_user_channel` VALUES (3, '2023-09-27 14:24:18', '2023-09-05 14:24:20', 2, 1, 1);
INSERT INTO `chat_user_channel` VALUES (4, '2023-09-07 14:24:22', '2023-09-06 14:24:25', 2, 2, 2);
INSERT INTO `chat_user_channel` VALUES (6, '2023-09-06 15:38:05', '2023-09-13 15:38:07', 2, 3, 2);
INSERT INTO `chat_user_channel` VALUES (7, '2023-09-06 15:39:34', '2023-09-06 15:39:34', 1, 3, 2);
INSERT INTO `chat_user_channel` VALUES (96, '2003-07-18 00:21:02', '2015-09-26 00:44:49', 30, 29, 94);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程名称',
  `course_teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '任课老师',
  `subject_id` int NULL DEFAULT NULL COMMENT '课程相关学科id\r\n',
  `create_time` datetime NULL DEFAULT NULL COMMENT '课程开始日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '面向对象程序设计2024-1', '韦雨庭', 1, '2024-02-26 18:21:41');
INSERT INTO `course` VALUES (2, '面向对象程序设计2023-2', '韦雨庭', 1, '2023-09-26 18:22:08');
INSERT INTO `course` VALUES (3, '前端开发2024-1', 'REF', 2, '2024-03-04 20:45:19');

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '试卷标题',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '试卷描述',
  `duration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '考试时长',
  `total_marks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '考试总分',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam
-- ----------------------------

-- ----------------------------
-- Table structure for exam_question
-- ----------------------------
DROP TABLE IF EXISTS `exam_question`;
CREATE TABLE `exam_question`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `exam_id` int NULL DEFAULT NULL COMMENT '关联试卷',
  `question_id` int NULL DEFAULT NULL COMMENT '关联题库',
  `score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '在该题库中的分值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_question
-- ----------------------------

-- ----------------------------
-- Table structure for exam_question_student
-- ----------------------------
DROP TABLE IF EXISTS `exam_question_student`;
CREATE TABLE `exam_question_student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `exam_id` int NULL DEFAULT NULL COMMENT '队对应考试id',
  `question_id` int NULL DEFAULT NULL COMMENT '试题id',
  `student_id` int NULL DEFAULT NULL COMMENT '用户学生的id',
  `answe_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学生的答案',
  `score` int NULL DEFAULT NULL COMMENT '该题分数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_question_student
-- ----------------------------

-- ----------------------------
-- Table structure for learning_condition
-- ----------------------------
DROP TABLE IF EXISTS `learning_condition`;
CREATE TABLE `learning_condition`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NULL DEFAULT NULL COMMENT '对应学生',
  `ability` int NOT NULL COMMENT '学习能力数值',
  `usual_performance` int NULL DEFAULT NULL COMMENT '平时表现得分（上课作答情况）',
  `homework` int NULL DEFAULT NULL COMMENT '平时作业平均得分',
  `entrance_examination` int NULL DEFAULT NULL COMMENT '高考成绩',
  `questionnaire` int NULL DEFAULT NULL COMMENT '问卷分析',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of learning_condition
-- ----------------------------

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `question_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '题目内容',
  `difficulty` int NULL DEFAULT NULL COMMENT '题目难度（0-100）',
  `subject_id` int NULL DEFAULT NULL COMMENT '关联学科id',
  `chapter` int NULL DEFAULT NULL COMMENT '章节',
  `type` int NULL DEFAULT NULL COMMENT '题目类型（1单选2多选3填空4主观）',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `score` int NULL DEFAULT NULL COMMENT '分数',
  `answer_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '参考答案',
  `user_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, '请问在已下选项中主要采用面向对象开发的语言是： A.C++ B.Java C.Python D.Go', 11, 1, 1, 1, NULL, NULL, 5, 'B', 1);
INSERT INTO `question` VALUES (2, '在下列选项中，哪些是质数？A. 8,B.11,C. 15,D. 23,E. 27', 20, 2, 1, 2, '2021-01-28 07:17:47', '2009-10-07 07:26:48', 5, 'BD', 1);
INSERT INTO `question` VALUES (3, '请问JAVA的图标是什么', 30, 1, 1, 3, '2010-03-28 16:19:16', '2015-08-17 01:32:39', 5, '咖啡', 1);
INSERT INTO `question` VALUES (4, '在本堂课中你学到了些什么？', 40, 1, 1, 4, '2024-03-01 17:07:24', '2024-03-12 17:07:26', NULL, '参考答案：无', 1);
INSERT INTO `question` VALUES (7, '请问 ABCD', 20, 1, 2, 1, NULL, NULL, 5, 'A.XX', 108);
INSERT INTO `question` VALUES (8, '啊啊啊', 20, 1, 1, 1, NULL, NULL, 5, '啊啊啊啊啊啊啊啊', 108);
INSERT INTO `question` VALUES (9, '啊啊啊', 20, 1, 1, 1, NULL, NULL, 5, '啊啊啊啊啊啊啊啊', 108);
INSERT INTO `question` VALUES (10, NULL, 20, NULL, 1, 1, NULL, NULL, 5, 'A.哦', 1);
INSERT INTO `question` VALUES (11, '啊啊啊啊啊啊啊啊啊啊', 20, 1, 1, 1, NULL, NULL, 5, 'A.噢噢', 108);
INSERT INTO `question` VALUES (12, '啊啊啊啊啊啊啊啊啊啊', 20, 1, 1, 1, NULL, NULL, 5, 'A.噢噢', 108);
INSERT INTO `question` VALUES (13, '我的是', 1, 1, 1, 1, NULL, NULL, 1, '1', 1);
INSERT INTO `question` VALUES (14, '下面答案是A #OPTION A. a, B. b, C. c, D. d', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `question` VALUES (15, '我的问题是问题描述 #OPTION A. 张萌, B. 李佳萱, C. 韦雨庭, D. 罗宾利', 10, 1, 1, 1, NULL, NULL, 10, 'C', NULL);
INSERT INTO `question` VALUES (16, '你是什么身份 #OPTION A. 学生, B. 老师, C. 牛马, D. 管理员', 1, 1, 1, 1, NULL, NULL, 1, 'A', NULL);
INSERT INTO `question` VALUES (17, '你是什么 #OPTION A. 牛, B. 鼠鼠, C. 糊糊, D. 兔兔', 20, 1, 50, 1, NULL, NULL, 10, 'A', 107);
INSERT INTO `question` VALUES (18, '试试拖动条 #OPTION A. 哦, B. 啊, C. 一一一, D. 呜呜', 72, 1, 1, 10, NULL, NULL, 10, 'C', 107);
INSERT INTO `question` VALUES (19, '请问以下问题中 #OPTION A. 嗦嘎, B. 洗哈, C. 嚯嚯, D. 芜湖', 11, 1, 1, 1, NULL, NULL, 5, 'A', 106);
INSERT INTO `question` VALUES (20, '啊啊 #OPTION A. 啊啊啊q, B. 啊啊, C. 啊啊, D. 啊啊', 45, 1, 1, 1, NULL, NULL, 1, 'A', 106);
INSERT INTO `question` VALUES (21, '111 #OPTION A. 111, B. 111111111, C. 1111111, D. 11111111111', 50, 1, 1, 1, NULL, NULL, 1, 'B', 106);
INSERT INTO `question` VALUES (23, '我的 #OPTION A. 啊啊, B. 啊啊啊, C. 噢噢噢, D. 哈哈哈', 48, 1, 1, 1, NULL, NULL, 1, 'A, B, C', 106);
INSERT INTO `question` VALUES (24, '这是一道填空题', 49, 1, 1, 3, NULL, NULL, 1, '这是答案', 106);

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NULL DEFAULT NULL,
  `course_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES (1, 2, 1);
INSERT INTO `student_course` VALUES (2, 1, 1);
INSERT INTO `student_course` VALUES (3, 1, 3);
INSERT INTO `student_course` VALUES (4, 1, 77);
INSERT INTO `student_course` VALUES (5, 108, 1);
INSERT INTO `student_course` VALUES (6, 108, 2);

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学科名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学科描述\r\n',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES (1, '面向对象程序设计', '使用JAVA进行教学');
INSERT INTO `subject` VALUES (2, '前端', '使用xxxx');

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件名',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件类型',
  `size` bigint NULL DEFAULT NULL COMMENT '文件大小',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '下载链接',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  `enable` tinyint(1) NULL DEFAULT 1 COMMENT '是否禁用链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES (36, '图层 1.png', 'png', 3031, 'http://10.36.16.52:8001/file/12b6bfdcbe1e40148fcebdd47e327623.png', 0, 1);
INSERT INTO `sys_file` VALUES (37, '图层 1.png', 'png', 3031, 'http://10.36.16.52:8001/file/dc1bcb8512b543ea8fa4e152cf0fc7c5.png', 0, 1);
INSERT INTO `sys_file` VALUES (38, '图层 1.png', 'png', 3031, 'http://10.36.16.52:8080/file/e403e6aaaf5748aba58f7270fdd98a44.png', 0, 1);
INSERT INTO `sys_file` VALUES (39, 'IJ)NZ7W2JA_~`ZJ@C[D%T@T.jpg', 'jpg', 59743, 'http://192.168.176.1:8080/file/3210405921a7470b963dd1c62f7eb973.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (40, 'IJ)NZ7W2JA_~`ZJ@C[D%T@T.jpg', 'jpg', 59743, 'http://192.168.176.1:8080/file/1e5f8fc80b7b488889b4f63d096a7436.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (41, 'F_K)P1W26XH{@}ED1}}GVHL.gif', 'gif', 17417, 'http://192.168.176.1:8080/file/ca9c3feaaf6f4cd3ba7a5734d311ece6.gif', 0, 1);
INSERT INTO `sys_file` VALUES (42, 'XGLZF1A2U4O9EU7_33P579A.gif', 'gif', 1077407, 'http://192.168.176.1:8080/file/4096cd8772944ba8a6c35dbe3c551e52.gif', 0, 1);
INSERT INTO `sys_file` VALUES (43, 'XGLZF1A2U4O9EU7_33P579A.gif', 'gif', 1077407, 'http://192.168.249.1:8080/file/51e0ab3acd964845a09d9b2e0a569606.gif', 0, 1);
INSERT INTO `sys_file` VALUES (44, 'F_K)P1W26XH{@}ED1}}GVHL.gif', 'gif', 17417, 'http://192.168.1.10:8080/file/6c0bfd97a4cc4c8eaaf0ba3c7bc90723.gif', 0, 1);
INSERT INTO `sys_file` VALUES (45, 'IJ)NZ7W2JA_~`ZJ@C[D%T@T.jpg', 'jpg', 59743, 'http://172.20.112.1:8080/file/17579dff5a804e70aa928b9d02d8803f.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (46, 'QQ图片20230904142603.jpg', 'jpg', 249221, 'http://172.20.112.1:8080/file/a11b9ddec305474b993e24b24c1f35b7.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (47, '4B9BD1D0C42D8401C099D17001B24BDC.png', 'png', 46264, 'http://172.20.112.1:8080/file/0849eb778d014648aa009c08de8a98bc.png', 0, 1);
INSERT INTO `sys_file` VALUES (48, '4B9BD1D0C42D8401C099D17001B24BDC.png', 'png', 46264, 'http://172.20.112.1:8080/file/312a490f657645c4be046af2b12b6e31.png', 0, 1);
INSERT INTO `sys_file` VALUES (49, 'IJ)NZ7W2JA_~`ZJ@C[D%T@T.jpg', 'jpg', 59743, 'http://172.20.112.1:8080/file/1650ab77769649b4b95a7af6daf00443.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (50, 'F_K)P1W26XH{@}ED1}}GVHL.gif', 'gif', 17417, 'http://172.20.112.1:8080/file/d13293e1b9be4a44b6aaa04043e08adf.gif', 0, 1);
INSERT INTO `sys_file` VALUES (51, 'IJ)NZ7W2JA_~`ZJ@C[D%T@T.jpg', 'jpg', 59743, 'http://172.20.112.1:8080/file/5208f3b5589546ff836b66fae975fbff.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (52, 'IJ)NZ7W2JA_~`ZJ@C[D%T@T.jpg', 'jpg', 59743, 'http://172.20.112.1:8080/file/a1df0c8718fc4043b2f2840364f13275.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (53, 'IJ)NZ7W2JA_~`ZJ@C[D%T@T.jpg', 'jpg', 59743, 'http://172.20.112.1:8080/file/64ae6bf94f3649f59b4108dc9a53dd3b.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (54, '4B9BD1D0C42D8401C099D17001B24BDC.png', 'png', 46264, 'http://172.20.112.1:8080/file/c8ec523aa3884f4882d2cf5e259cdf85.png', 0, 1);
INSERT INTO `sys_file` VALUES (55, '报名照片.jpg', 'jpg', 7365, 'http://172.20.112.1:8080/file/c53f0eb59e854c58b9253a5a3129fdbd.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (56, 'IJ)NZ7W2JA_~`ZJ@C[D%T@T.jpg', 'jpg', 59743, 'http://172.20.112.1:8080/file/d49292e368e84cd49cb1f2c1acb43d23.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (57, 'F_K)P1W26XH{@}ED1}}GVHL.gif', 'gif', 17417, 'http://172.20.112.1:8080/file/1967ca373296498ab4a2d13999056057.gif', 0, 1);
INSERT INTO `sys_file` VALUES (58, 'IJ)NZ7W2JA_~`ZJ@C[D%T@T.jpg', 'jpg', 59743, 'http://172.20.112.1:8080/file/ab2695e15f8a4d53aa56f0fa901f5670.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (59, 'IJ)NZ7W2JA_~`ZJ@C[D%T@T.jpg', 'jpg', 59743, 'http://172.20.112.1:8080/file/eb0060c7c73c48f8bf05ca9c8b3eeee8.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (60, 'XGLZF1A2U4O9EU7_33P579A.gif', 'gif', 1077407, 'http://172.20.112.1:8080/file/f6089f59ce5447479520893bc635ca0f.gif', 0, 1);
INSERT INTO `sys_file` VALUES (61, '4B9BD1D0C42D8401C099D17001B24BDC.png', 'png', 46264, 'http://172.20.112.1:8080/file/22b1764c6c134ab2ab385f66edf8f4e1.png', 0, 1);
INSERT INTO `sys_file` VALUES (62, '报名照片.jpg', 'jpg', 7365, 'http://127.0.0.1:8080/file/2bebf6766d10460587e2332cb92e346a.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (63, 'IJ)NZ7W2JA_~`ZJ@C[D%T@T.jpg', 'jpg', 59743, 'http://127.0.0.1:8080/file/1d658334421e4a51b437d6342cd1c4f3.jpg', 0, 1);
INSERT INTO `sys_file` VALUES (64, 'XGLZF1A2U4O9EU7_33P579A.gif', 'gif', 1077407, 'http://localhost:8080/file/445754ce4f2b45f39dd0816713c98213.gif', 0, 1);
INSERT INTO `sys_file` VALUES (65, 'XGLZF1A2U4O9EU7_33P579A.gif', 'gif', 1077407, 'http://localhost:8080/file/b8f2782346a9406f825eb58f301e77ac.gif', 0, 1);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户类型 仅含\"学生\"：“老师” ：“管理员”',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '个人头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2023-08-24 10:33:01', '2024-02-25 14:05:38', 'v247233', '学生', '$2a$10$83VyrI2X5BBL.xifBwAfxuW.eZgPqnzwFgKGz9Xzy3N/PPaVYAo4y', 'fufu', NULL, '');
INSERT INTO `user` VALUES (2, '1999-06-01 06:26:54', '2024-02-25 14:05:39', '吕秀兰', '学生', 'commodo exercitation', '朱秀英', 't.zgewokb@qq.com', '');
INSERT INTO `user` VALUES (3, '2023-08-24 10:33:01', '2024-02-25 14:05:40', 'v134525', '学生', '$10$83VyrI2X5BBL.xifBwAfxuW.eZgPqnzwFgKGz9Xzy3N/PPaVYAo4y', '小来福', NULL, '');
INSERT INTO `user` VALUES (15, '1984-12-02 00:49:03', '2024-02-25 14:05:41', '汤明', '学生', 'enim', '范丽', 'a.ckqcz@qq.com', '');
INSERT INTO `user` VALUES (32, '2015-02-26 21:41:09', '2024-02-25 14:05:41', 'v123456', '学生', '$2a$10$ESwjSlFjcbMP3YIbQYCbmeuW.Q2W/DMeKFcQg7zP13ybY5SPNFlIS', '马刚', 'y.ejpl@qq.com', 'http://dummyimage.com/100x100');
INSERT INTO `user` VALUES (90, '1984-03-14 22:54:17', '2024-02-25 14:05:42', '孔秀兰', '学生', 'sint incididunt sit', '宋刚', 'h.lohdyst@qq.com', '');
INSERT INTO `user` VALUES (91, '2001-01-27 08:49:22', '2024-02-25 14:05:43', '陈娟', '学生', '$2a$10$QP0rF1xCyER7SsyOMuR3SOteqvVwvJQRx1Uj77rk7j8Y4qpUf1m4m', '林艳', 'f.zflmal@qq.com', 'http://dummyimage.com/100x100');
INSERT INTO `user` VALUES (92, '2015-07-04 00:17:24', '2024-02-25 14:05:44', '蒋勇', '学生', '$2a$10$FmaAVLu7CIgCL0LzqGzNwelfZh5RDEneADM6zXSk87s3tL4gmRc6K', '钱秀英', 'l.jgigmgqmcz@qq.com', 'http://dummyimage.com/100x100');
INSERT INTO `user` VALUES (93, '1971-06-09 11:19:06', '2024-02-25 14:05:44', '尹秀兰', '学生', '$2a$10$rdsqG4MFTqf1DUc4hnI.gebJWFCuOxNdJLVUJ1c2cYK9Hn9AlR.sO', '薛敏', 'q.ichae@qq.com', 'http://dummyimage.com/100x100');
INSERT INTO `user` VALUES (94, '2011-06-02 02:56:52', '2024-02-25 14:05:45', '龚秀英', '学生', '$2a$10$DJOkTgdXfN5zE4cRitJvmupr3M2X4U7sFub7cTBDL7gL5HApCvRQa', '杜强', 'w.pmsdqhkrsf@qq.com', 'http://dummyimage.com/100x100');
INSERT INTO `user` VALUES (95, '2013-07-12 05:34:06', '2024-02-25 14:05:46', '常平', '学生', '$2a$10$ai1wzG9UhIAbPhh8RAoYY.fq7QWxuvP4oDmZwXNq/.TFVwR2THo3O', '许丽', 'g.xrbusc@qq.com', 'http://dummyimage.com/100x100');
INSERT INTO `user` VALUES (96, '1975-09-18 07:49:15', '2024-02-25 14:05:46', '熊军', '学生', '$2a$10$gU4QU3B.xYDB.ktOvPIGveTd7OK3AEQZWupQWs1zSB6z2fGKSDViC', '唐秀英', 'w.cnkwmpu@qq.com', 'http://dummyimage.com/100x100');
INSERT INTO `user` VALUES (97, '2022-04-02 21:05:27', '2024-02-25 14:05:47', '方伟', '学生', '$2a$10$M9S7HKLDuztHyMNGL2lNO.vqACCa0TUE8BE0wtbtmplhGwbM8YPBK', '唐艳', 's.caphpsnro@qq.com', 'http://dummyimage.com/100x100');
INSERT INTO `user` VALUES (98, NULL, '2024-02-25 14:05:48', '雨庭', '学生', '$2a$10$zLOaH1.Aza6uoFQH408AIeftaSJ8lBJG.jOMC4LhWoyN71nkATqFG', '一只小来福', 'v2472331253@163.com', 'http://dummyimage.com/100x100');
INSERT INTO `user` VALUES (99, '2023-11-03 09:51:31', '2024-02-25 14:05:49', '雨啊啊庭', '学生', '$2a$10$E1jecMsqYlB3qOSsOlMJN.9zkQr2VESIc8TezjKjEs7NdgiFdkELG', '一福', 'v247233@163.com', 'http://dummyimage.com/100x100');
INSERT INTO `user` VALUES (100, '2024-02-25 13:42:51', '2024-02-25 14:06:48', 'dd123', '学生', '$2a$10$XAru68DxTidRxoxo2uiuke6mLMU2K.rHnVj8sgFjNL9cIh20XqlqG', '134525', '2558689930@qq.com', 'null');
INSERT INTO `user` VALUES (101, '2024-02-25 14:08:11', NULL, 'zxdsb', '管理员', '$2a$10$TzvPRNuH9iXiiADnzBz71eSX5n6IVrTAg0eJ2m/B2Ff36uHpROxBm', '张询', '123456aa0@qq.com', 'null');
INSERT INTO `user` VALUES (105, '2024-02-25 16:59:48', NULL, '@vv134525', '老师', '$2a$10$NLbCrNN.9j.R5WVcbQZEv.5lXh578kE/2Ks1czqM9WBpu3lwO82r2', '@vv134525', '@vv134525', 'http://172.20.112.1:8080/file/2bebf6766d10460587e2332cb92e346a.jpg');
INSERT INTO `user` VALUES (106, '2024-02-25 19:21:47', '2024-02-29 11:58:02', 'ls111', '老师', '$2a$10$1qZ9.jCvXlR4p4NY6hpiheX5JeSyU4mPg7E3Bp08B.egiLfqyIbrm', '老师111', 'dd123@qq.com', 'http://127.0.0.1:8080/file/1d658334421e4a51b437d6342cd1c4f3.jpg');
INSERT INTO `user` VALUES (107, '2024-02-29 12:04:17', NULL, 'ls222', '老师', '$2a$10$SNEAmXDGqkR9HSvg8F3V0OPAxtPCrnK1cCTuDSFlxxaZ91Mhs5oJ6', '小付付', 'aaaadd123@qq.com', 'http://localhost:8080/file/445754ce4f2b45f39dd0816713c98213.gif');
INSERT INTO `user` VALUES (108, '2024-03-04 15:32:09', NULL, 'xs111', '学生', '$2a$10$zBtswTuqgh.A50l8utWA7uH2Vr2cYskRH/L6kI8sM0FOac7Zt6BoS', '福来小', 'aaaaddas123@qq.com', 'http://localhost:8080/file/b8f2782346a9406f825eb58f301e77ac.gif');

SET FOREIGN_KEY_CHECKS = 1;
