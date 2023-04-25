/*
 Navicat Premium Data Transfer

 Source Server         : 172.18.30.53
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : localhost:3306
 Source Schema         : zu

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 25/04/2023 08:38:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply`  (
  `apply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '申请看房',
  `house_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area` double(255, 0) NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `apply_date` datetime(6) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(255) NOT NULL,
  PRIMARY KEY (`apply_id`, `house_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of apply
-- ----------------------------

-- ----------------------------
-- Table structure for applyout
-- ----------------------------
DROP TABLE IF EXISTS `applyout`;
CREATE TABLE `applyout`  (
  `aoid` int(11) NOT NULL AUTO_INCREMENT COMMENT '退租申请',
  `house_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`aoid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of applyout
-- ----------------------------

-- ----------------------------
-- Table structure for checkout
-- ----------------------------
DROP TABLE IF EXISTS `checkout`;
CREATE TABLE `checkout`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '退租申请',
  `house_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of checkout
-- ----------------------------

-- ----------------------------
-- Table structure for hetong
-- ----------------------------
DROP TABLE IF EXISTS `hetong`;
CREATE TABLE `hetong`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chuzu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chuzu_idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zuke` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zuke_idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fromdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `todate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `payday` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of hetong
-- ----------------------------
INSERT INTO `hetong` VALUES (19, '房东1', '222', '用户1', '111', '2023-04-18', '2023-04-28', 4000.00, '广州市', '1017', 10);

-- ----------------------------
-- Table structure for houselist
-- ----------------------------
DROP TABLE IF EXISTS `houselist`;
CREATE TABLE `houselist`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `houseid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `area` double NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `houseid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 932 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of houselist
-- ----------------------------
INSERT INTO `houselist` VALUES (10, '1010', '上海市', 373, 438.00, '未租赁');
INSERT INTO `houselist` VALUES (11, '1011', '东莞', 89, 350.00, '未租赁');
INSERT INTO `houselist` VALUES (12, '1012', '成都市', 486, 438.00, '未租赁');
INSERT INTO `houselist` VALUES (13, '1013', '中山', 885, 704.00, '未租赁');
INSERT INTO `houselist` VALUES (14, '1014', '北京市', 435, 98.00, '未租赁');
INSERT INTO `houselist` VALUES (15, '1015', '上海市', 148, 536.00, '未租赁');
INSERT INTO `houselist` VALUES (16, '1016', '上海市', 857, 719.00, '未租赁');
INSERT INTO `houselist` VALUES (17, '1017', '广州市', 390, 400.00, '已租赁');
INSERT INTO `houselist` VALUES (18, '1018', '北京市', 9, 152.00, '未租赁');
INSERT INTO `houselist` VALUES (19, '1019', '上海市', 952, 911.00, '未租赁');
INSERT INTO `houselist` VALUES (21, '1021', '深圳', 478, 184.00, '未租赁');
INSERT INTO `houselist` VALUES (22, '1022', '广州市', 771, 953.00, '未租赁');
INSERT INTO `houselist` VALUES (23, '1023', '深圳', 260, 891.00, '未租赁');
INSERT INTO `houselist` VALUES (24, '1024', '上海市', 346, 731.00, '未租赁');
INSERT INTO `houselist` VALUES (37, '1037', '中国上海市闵行区宾川路298号8室', 520, 47.00, '未租赁');
INSERT INTO `houselist` VALUES (38, '1038', '中国上海市黄浦区淮海中路714号华润大厦15室', 452, 384.00, '未租赁');
INSERT INTO `houselist` VALUES (39, '1039', '中国北京市海淀区清河中街68号296号4楼', 705, 812.00, '未租赁');
INSERT INTO `houselist` VALUES (40, '1040', '中国广州市白云区机场路棠苑街五巷558号2号楼', 752, 287.00, '未租赁');
INSERT INTO `houselist` VALUES (41, '1041', '中国广州市天河区天河路507号34栋', 943, 749.00, '未租赁');
INSERT INTO `houselist` VALUES (42, '1042', '中国北京市東城区東直門內大街279号3号楼', 261, 294.00, '未租赁');
INSERT INTO `houselist` VALUES (43, '1043', '中国北京市房山区岳琉路393号华润大厦49室', 836, 501.00, '未租赁');
INSERT INTO `houselist` VALUES (44, '1044', '中国广州市海珠区江南西路314号31栋', 293, 113.00, '未租赁');
INSERT INTO `houselist` VALUES (45, '1045', '中国中山京华商圈华夏街556号18号楼', 781, 161.00, '未租赁');
INSERT INTO `houselist` VALUES (46, '1046', '中国成都市成华区双庆路81号41号楼', 190, 945.00, '未租赁');
INSERT INTO `houselist` VALUES (47, '1047', '中国成都市成华区二仙桥东三路123号36号楼', 977, 806.00, '未租赁');
INSERT INTO `houselist` VALUES (48, '1048', '中国深圳罗湖区田贝一路230号36号楼', 687, 332.00, '未租赁');
INSERT INTO `houselist` VALUES (49, '1049', '中国北京市海淀区清河中街68号399号32号楼', 227, 120.00, '未租赁');
INSERT INTO `houselist` VALUES (50, '1050', '中国上海市闵行区宾川路701号华润大厦42室', 81, 233.00, '未租赁');
INSERT INTO `houselist` VALUES (51, '1051', '中国广州市天河区天河路553号华润大厦36室', 483, 96.00, '未租赁');
INSERT INTO `houselist` VALUES (52, '1052', '中国东莞坑美十五巷469号29栋', 300, 48.00, '未租赁');
INSERT INTO `houselist` VALUES (53, '1053', '中国广州市天河区天河路758号27栋', 808, 63.00, '未租赁');
INSERT INTO `houselist` VALUES (54, '1054', '中国上海市浦东新区健祥路371号华润大厦42室', 134, 486.00, '未租赁');
INSERT INTO `houselist` VALUES (55, '1055', '中国深圳福田区景田东一街752号46栋', 100, 459.00, '未租赁');
INSERT INTO `houselist` VALUES (56, '1056', '中国成都市成华区玉双路6号487号30号楼', 791, 332.00, '未租赁');
INSERT INTO `houselist` VALUES (57, '1057', '中国上海市黄浦区淮海中路349号14楼', 578, 219.00, '未租赁');
INSERT INTO `houselist` VALUES (58, '1058', '中国深圳福田区深南大道921号46栋', 645, 900.00, '未租赁');
INSERT INTO `houselist` VALUES (59, '1059', '中国北京市朝阳区三里屯路690号24栋', 634, 78.00, '未租赁');
INSERT INTO `houselist` VALUES (60, '1060', '中国深圳福田区深南大道610号10室', 511, 514.00, '未租赁');
INSERT INTO `houselist` VALUES (61, '1061', '中国广州市白云区小坪东路94号14号楼', 104, 950.00, '未租赁');
INSERT INTO `houselist` VALUES (62, '1062', '中国广州市海珠区江南西路881号华润大厦28室', 494, 758.00, '未租赁');
INSERT INTO `houselist` VALUES (63, '1063', '中国北京市東城区東直門內大街491号华润大厦36室', 501, 39.00, '未租赁');
INSERT INTO `houselist` VALUES (64, '1064', '中国成都市成华区二仙桥东三路655号华润大厦24室', 857, 464.00, '未租赁');
INSERT INTO `houselist` VALUES (65, '1065', '中国成都市成华区二仙桥东三路9号50楼', 104, 548.00, '未租赁');
INSERT INTO `houselist` VALUES (66, '1066', '中国深圳福田区景田东一街803号29栋', 193, 350.00, '未租赁');
INSERT INTO `houselist` VALUES (67, '1067', '中国广州市海珠区江南西路741号华润大厦31室', 925, 680.00, '未租赁');
INSERT INTO `houselist` VALUES (68, '1068', '中国深圳福田区景田东一街1号46栋', 659, 673.00, '未租赁');
INSERT INTO `houselist` VALUES (69, '1069', '中国广州市越秀区中山二路44号32栋', 356, 845.00, '未租赁');
INSERT INTO `houselist` VALUES (70, '1070', '中国中山紫马岭商圈中山五路47号华润大厦19室', 649, 926.00, '未租赁');
INSERT INTO `houselist` VALUES (71, '1071', '中国东莞坑美十五巷115号29楼', 536, 301.00, '未租赁');
INSERT INTO `houselist` VALUES (72, '1072', '中国中山紫马岭商圈中山五路228号27号楼', 877, 80.00, '未租赁');
INSERT INTO `houselist` VALUES (73, '1073', '中国广州市天河区天河路141号25号楼', 958, 677.00, '未租赁');
INSERT INTO `houselist` VALUES (74, '1074', '中国北京市延庆区028县道273号11栋', 476, 552.00, '未租赁');
INSERT INTO `houselist` VALUES (75, '1075', '中国成都市成华区双庆路201号39号楼', 970, 416.00, '未租赁');
INSERT INTO `houselist` VALUES (76, '1076', '中国深圳福田区景田东一街861号29号楼', 556, 252.00, '未租赁');
INSERT INTO `houselist` VALUES (77, '1077', '中国中山紫马岭商圈中山五路648号22栋', 54, 152.00, '未租赁');
INSERT INTO `houselist` VALUES (78, '1078', '中国北京市房山区岳琉路128号49栋', 578, 804.00, '未租赁');
INSERT INTO `houselist` VALUES (79, '1079', '中国上海市徐汇区虹桥路585号34室', 283, 676.00, '未租赁');
INSERT INTO `houselist` VALUES (80, '1080', '中国东莞环区南街二巷737号19栋', 123, 137.00, '未租赁');
INSERT INTO `houselist` VALUES (81, '1081', '中国深圳龙岗区布吉镇西环路183号15栋', 692, 587.00, '未租赁');
INSERT INTO `houselist` VALUES (82, '1082', '中国深圳龙岗区布吉镇西环路219号24室', 314, 339.00, '未租赁');
INSERT INTO `houselist` VALUES (83, '1083', '中国中山天河区大信商圈大信南路979号华润大厦26室', 840, 590.00, '未租赁');
INSERT INTO `houselist` VALUES (84, '1084', '中国成都市锦江区人民南路四段95号31楼', 142, 499.00, '未租赁');
INSERT INTO `houselist` VALUES (85, '1085', '中国广州市天河区天河路927号29栋', 863, 488.00, '未租赁');
INSERT INTO `houselist` VALUES (86, '1086', '中国深圳福田区景田东一街276号华润大厦20室', 236, 943.00, '未租赁');

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `artist` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES ('错位时空', 'http://music.163.com/song/media/outer/url?id=1808492017.mp3', '艾辰', 'http://p2.music.126.net/8C0lwLE88j9ZwLyPQ9a4FA==/109951165595770076.jpg');
INSERT INTO `music` VALUES ('我走后', 'http://music.163.com/song/media/outer/url?id=2017812455.mp3', '董先森', 'http://p1.music.126.net/JafzaMpVNW74dDqmQOBKcw==/109951168265738796.jpg');
INSERT INTO `music` VALUES ('姑娘在远方', 'http://music.163.com/song/media/outer/url?id=2022196813.mp3', '柯柯柯啊', 'http://p1.music.126.net/69MfQfl-rA0IwEuRSCEyNw==/109951168307420773.jpg');
INSERT INTO `music` VALUES ('等你归来', 'http://music.163.com/song/media/outer/url?id=2000193232.mp3', '456', 'http://p1.music.126.net/bisOFZHy6WuBBfaHtr238Q==/109951165674729204.jpg');
INSERT INTO `music` VALUES ('布鲁克的心跳', 'http://music.163.com/song/media/outer/url?id=26127565.mp3', '优梦', 'http://p2.music.126.net/EanWH6wBIQ4fAGVEkefusQ==/109951166255073827.jpg');
INSERT INTO `music` VALUES ('予你', 'http://music.163.com/song/media/outer/url?id=573880157.mp3', '九百九十五号', 'https://tse2-mm.cn.bing.net/th/id/OIP-C.V3CoJ-Il68YEnTihtoAj8QHaHa');
INSERT INTO `music` VALUES ('雪', 'http://music.163.com/song/media/outer/url?id=2026224214.mp3', 'Capper', 'https://tse2-mm.cn.bing.net/th/id/OIP-C.V3CoJ-Il68YEnTihtoAj8QHaHa');
INSERT INTO `music` VALUES ('我记得', 'http://music.163.com/song/media/outer/url?id=1974443814.mp3', '赵雷', 'http://p2.music.126.net/FCWD6ibS2JK2B3QAnXuzwQ==/109951167805892385.jpg');
INSERT INTO `music` VALUES ('达尔文', 'http://music.163.com/song/media/outer/url?id=2019573476.mp3', '林俊杰', 'http://p1.music.126.net/4x-65bnidSKyEMDBmGtn8g==/109951168466764238.jpg');
INSERT INTO `music` VALUES ('只要你愿意', 'http://music.163.com/song/media/outer/url?id=1494835439.mp3', '李佳思', 'http://p2.music.126.net/xxTOIDuG_zgIulJ2vaFzTA==/109951165463786624.jpg');
INSERT INTO `music` VALUES ('和宇宙的温柔关联', 'http://music.163.com/song/media/outer/url?id=1959667347.mp3', '房东的猫', 'http://p2.music.126.net/fISwJ705Y1c81EqWxKjNqg==/109951167603798520.jpg');
INSERT INTO `music` VALUES ('我等不到', 'D:\\桌面\\黎林添娇 - 我等不到.mp3', NULL, NULL);

-- ----------------------------
-- Table structure for paid
-- ----------------------------
DROP TABLE IF EXISTS `paid`;
CREATE TABLE `paid`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '已缴租金',
  `house_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `paydate` date NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of paid
-- ----------------------------

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES (5, '2023-04-24', '干活111');
INSERT INTO `schedule` VALUES (6, '2023-04-19', '666');

-- ----------------------------
-- Table structure for solve
-- ----------------------------
DROP TABLE IF EXISTS `solve`;
CREATE TABLE `solve`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `house_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of solve
-- ----------------------------
INSERT INTO `solve` VALUES (12, '1017', '广州市', '2023-04-11 00:00:00', '666', '用户1', 2, '已处理');

-- ----------------------------
-- Table structure for topaid
-- ----------------------------
DROP TABLE IF EXISTS `topaid`;
CREATE TABLE `topaid`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `house_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of topaid
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123123', '房东', '望月');
INSERT INTO `user` VALUES (2, 'qwe', '123123', '用户', '用户1');
INSERT INTO `user` VALUES (3, 'qqq', '123123', '用户', '用户2');

-- ----------------------------
-- Table structure for userlist
-- ----------------------------
DROP TABLE IF EXISTS `userlist`;
CREATE TABLE `userlist`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`, `idcard`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of userlist
-- ----------------------------
INSERT INTO `userlist` VALUES (1, 'qwe', '111', '15188888888', 2, '用户1');
INSERT INTO `userlist` VALUES (2, 'qqq', '333', '234234234', 3, '用户2');
INSERT INTO `userlist` VALUES (3, 'admin', '222', '345675676', 1, '房东1');

-- ----------------------------
-- Table structure for wrong
-- ----------------------------
DROP TABLE IF EXISTS `wrong`;
CREATE TABLE `wrong`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `house_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of wrong
-- ----------------------------
INSERT INTO `wrong` VALUES (16, '1017', '广州市', '2023-04-24 10:52:51', '报着玩\n', '用户1', 2, '待处理');

-- ----------------------------
-- Table structure for zulist
-- ----------------------------
DROP TABLE IF EXISTS `zulist`;
CREATE TABLE `zulist`  (
  `zid` int(11) NOT NULL AUTO_INCREMENT,
  `house_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `contract_id` int(11) NOT NULL,
  PRIMARY KEY (`zid`, `house_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of zulist
-- ----------------------------
INSERT INTO `zulist` VALUES (9, '1017', 4000.00, '广州市', 2, 19);

SET FOREIGN_KEY_CHECKS = 1;
