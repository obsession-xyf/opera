/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : ca2

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2017-09-30 21:06:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(1000) DEFAULT NULL,
  `password` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for `t_bk`
-- ----------------------------
DROP TABLE IF EXISTS `t_bk`;
CREATE TABLE `t_bk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bkName` varchar(100) DEFAULT NULL COMMENT '版块名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='分类';

-- ----------------------------
-- Records of t_bk
-- ----------------------------
INSERT INTO `t_bk` VALUES ('1', '新房');
INSERT INTO `t_bk` VALUES ('2', '二手房');

-- ----------------------------
-- Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(1000) DEFAULT NULL COMMENT '账号',
  `password` varchar(1000) DEFAULT NULL COMMENT '密码',
  `name` varchar(1000) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(1000) DEFAULT NULL COMMENT '手机',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `age` varchar(100) DEFAULT NULL COMMENT '年龄',
  `address` varchar(100) DEFAULT NULL COMMENT '家庭住址',
  `idcard` varchar(100) DEFAULT NULL COMMENT '身份证',
  `insertDate` datetime DEFAULT NULL COMMENT '入库日期',
  `headPic` varchar(50) DEFAULT NULL COMMENT '头像',
  `level` varchar(50) DEFAULT NULL COMMENT '层级',
  `isft` varchar(50) DEFAULT NULL COMMENT '发帖权限',
  `ispl` varchar(50) DEFAULT NULL COMMENT '评论权限',
  `mb1` varchar(50) DEFAULT NULL COMMENT '密保1',
  `mb2` varchar(50) DEFAULT NULL COMMENT '密保2',
  `mb3` varchar(50) DEFAULT NULL COMMENT '密保3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('3', 'c1', '111', '小黑', '13811111111', '男', '16', '12312', '3123123', '2017-02-27 18:15:48', 'upload/20170928/150660333978381.jpg', '初级', '是', '是', '11', '22', '33');
INSERT INTO `t_customer` VALUES ('4', 'c3', '111', '小白', '13811111111', '男', '12', '123123', '123123123', '2017-02-27 18:19:43', 'upload/20170522/149543276385730.jpg', '初级', '是', '是', null, null, null);
INSERT INTO `t_customer` VALUES ('5', 'c2', '1111', '1231231', '13811111111', '男', '1231', '1231231', '1231231231231', '2017-02-27 18:35:38', 'upload/20170522/149543276385730.jpg', '初级', '是', '是', null, null, null);
INSERT INTO `t_customer` VALUES ('6', 'c4', '111', '小黄', '13911111111', '男', '21', '大大大师法第三方', '1212', '2017-03-01 10:44:52', 'upload/20170522/149543276385730.jpg', '初级', '是', '是', null, null, null);
INSERT INTO `t_customer` VALUES ('7', 'c5', '111', 'dsfsdfsdfsdf12', '13811111111', '男', '12', '12', '12', '2017-03-01 13:03:11', 'upload/20170522/149543276385730.jpg', '初级', '是', '是', null, null, null);
INSERT INTO `t_customer` VALUES ('8', 'a1', '111', '王小帅', '13811111111', '男', '33', '的发的说法是', '213123123123', '2017-04-12 00:09:10', 'upload/20170522/149543276385730.jpg', '初级', '是', '是', null, null, null);
INSERT INTO `t_customer` VALUES ('9', 'a6', '222', '小别', '1381111111', '男', '21', '打发第三方', '123123123123', '2017-04-12 15:23:55', 'upload/20170522/149543276385730.jpg', '初级', '否', '否', '11', '22', '33');

-- ----------------------------
-- Table structure for `t_hd`
-- ----------------------------
DROP TABLE IF EXISTS `t_hd`;
CREATE TABLE `t_hd` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `pic` varchar(100) DEFAULT NULL COMMENT '图片',
  `content` text COMMENT '内容',
  `showDate` varchar(100) DEFAULT NULL COMMENT '显示日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='活动';

-- ----------------------------
-- Records of t_hd
-- ----------------------------
INSERT INTO `t_hd` VALUES ('1', '说的发多少发', 'upload/20170928/150659785331877.jpg', '阿斯顿发斯蒂芬', '2017-09-28');
INSERT INTO `t_hd` VALUES ('2', 'asdfasdfa', 'upload/20170928/150660356722998.jpg', 'asdfasdf111', '2017-09-21');

-- ----------------------------
-- Table structure for `t_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wdxxId` int(11) DEFAULT NULL COMMENT '房产',
  `insertDate` datetime DEFAULT NULL COMMENT '日期',
  `customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='记录';

-- ----------------------------
-- Records of t_log
-- ----------------------------
INSERT INTO `t_log` VALUES ('1', '10', '2017-05-22 13:04:21', null);
INSERT INTO `t_log` VALUES ('2', '10', '2017-05-22 13:07:50', null);
INSERT INTO `t_log` VALUES ('3', '11', '2017-05-22 13:07:53', null);
INSERT INTO `t_log` VALUES ('4', '12', '2017-05-22 13:07:55', null);
INSERT INTO `t_log` VALUES ('5', '10', '2017-05-22 13:41:46', '3');
INSERT INTO `t_log` VALUES ('6', '10', '2017-05-22 13:42:27', '3');
INSERT INTO `t_log` VALUES ('7', '10', '2017-05-22 13:42:36', '3');
INSERT INTO `t_log` VALUES ('8', '10', '2017-05-22 13:42:49', '3');
INSERT INTO `t_log` VALUES ('9', '10', '2017-05-22 13:42:54', '3');
INSERT INTO `t_log` VALUES ('10', '10', '2017-05-22 13:43:08', '3');
INSERT INTO `t_log` VALUES ('11', '10', '2017-05-22 13:43:16', '3');
INSERT INTO `t_log` VALUES ('12', '10', '2017-05-22 13:43:45', '3');
INSERT INTO `t_log` VALUES ('13', '9', '2017-05-22 13:44:25', '3');
INSERT INTO `t_log` VALUES ('14', '10', '2017-05-22 13:51:13', '3');
INSERT INTO `t_log` VALUES ('15', '10', '2017-05-22 13:52:35', '3');
INSERT INTO `t_log` VALUES ('16', '10', '2017-05-22 13:52:49', '3');
INSERT INTO `t_log` VALUES ('17', '10', '2017-05-22 13:59:06', null);
INSERT INTO `t_log` VALUES ('18', '10', '2017-05-22 13:59:16', '3');
INSERT INTO `t_log` VALUES ('19', '10', '2017-05-22 14:01:34', '3');
INSERT INTO `t_log` VALUES ('20', '10', '2017-05-22 14:02:40', '3');
INSERT INTO `t_log` VALUES ('21', '12', '2017-05-22 14:07:02', '3');
INSERT INTO `t_log` VALUES ('22', '10', '2017-09-28 19:03:15', null);
INSERT INTO `t_log` VALUES ('23', '10', '2017-09-28 19:15:47', '3');
INSERT INTO `t_log` VALUES ('24', '10', '2017-09-28 19:16:06', '3');
INSERT INTO `t_log` VALUES ('25', '14', '2017-09-28 19:16:13', '3');
INSERT INTO `t_log` VALUES ('26', '14', '2017-09-28 19:16:30', '3');
INSERT INTO `t_log` VALUES ('27', '14', '2017-09-28 19:16:34', '3');
INSERT INTO `t_log` VALUES ('28', '14', '2017-09-28 19:16:36', '3');
INSERT INTO `t_log` VALUES ('29', '12', '2017-09-28 19:16:40', '3');
INSERT INTO `t_log` VALUES ('30', '14', '2017-09-28 19:17:10', '3');
INSERT INTO `t_log` VALUES ('31', '13', '2017-09-28 19:17:13', '3');
INSERT INTO `t_log` VALUES ('32', '13', '2017-09-28 19:17:52', '3');
INSERT INTO `t_log` VALUES ('33', '10', '2017-09-28 19:17:55', '3');
INSERT INTO `t_log` VALUES ('34', '10', '2017-09-28 19:19:13', '3');
INSERT INTO `t_log` VALUES ('35', '14', '2017-09-28 19:31:25', '3');
INSERT INTO `t_log` VALUES ('36', '10', '2017-09-28 19:31:53', '3');
INSERT INTO `t_log` VALUES ('37', '10', '2017-09-28 19:32:43', '3');
INSERT INTO `t_log` VALUES ('38', '14', '2017-09-28 21:00:19', null);
INSERT INTO `t_log` VALUES ('39', '14', '2017-09-28 21:00:37', null);
INSERT INTO `t_log` VALUES ('40', '13', '2017-09-28 21:01:40', '3');
INSERT INTO `t_log` VALUES ('41', '13', '2017-09-28 21:01:44', '3');
INSERT INTO `t_log` VALUES ('42', '13', '2017-09-28 21:01:49', '3');
INSERT INTO `t_log` VALUES ('43', '13', '2017-09-28 21:01:54', '3');
INSERT INTO `t_log` VALUES ('44', '14', '2017-09-28 21:03:58', '3');

-- ----------------------------
-- Table structure for `t_ltsm`
-- ----------------------------
DROP TABLE IF EXISTS `t_ltsm`;
CREATE TABLE `t_ltsm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text COMMENT '论坛说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='论坛说明';

-- ----------------------------
-- Records of t_ltsm
-- ----------------------------
INSERT INTO `t_ltsm` VALUES ('13', '<p>这个是网站公告s</p>\r\n\r\n<p>asdfasdfa</p>\r\n\r\n<p>asdfasdf</p>\r\n\r\n<p>asdfasdf<img alt=\"\" src=\"/ca2/upload/20170928/150660351811640.jpg\" style=\"height:315px; width:420px\" /></p>\r\n');

-- ----------------------------
-- Table structure for `t_mgc`
-- ----------------------------
DROP TABLE IF EXISTS `t_mgc`;
CREATE TABLE `t_mgc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mgc` varchar(100) DEFAULT NULL COMMENT '敏感词',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mgc
-- ----------------------------
INSERT INTO `t_mgc` VALUES ('1', '小泽玛利亚');
INSERT INTO `t_mgc` VALUES ('2', '丁义珍');
INSERT INTO `t_mgc` VALUES ('3', '李达康');
INSERT INTO `t_mgc` VALUES ('4', '貂蝉');
INSERT INTO `t_mgc` VALUES ('5', '特朗普');

-- ----------------------------
-- Table structure for `t_pinglun`
-- ----------------------------
DROP TABLE IF EXISTS `t_pinglun`;
CREATE TABLE `t_pinglun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wdxxId` int(11) DEFAULT NULL COMMENT '评论信息',
  `customerId` int(11) DEFAULT NULL COMMENT '评论人',
  `content` text COMMENT '评论内容',
  `insertDate` datetime DEFAULT NULL COMMENT '评论日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='评论';

-- ----------------------------
-- Records of t_pinglun
-- ----------------------------
INSERT INTO `t_pinglun` VALUES ('1', '1', '3', 'sadfasdfasdf', '2017-03-11 12:41:31');
INSERT INTO `t_pinglun` VALUES ('2', '1', '3', 'asdfasdf', '2017-03-11 12:41:35');
INSERT INTO `t_pinglun` VALUES ('4', '3', '3', '多少发到付', '2017-03-13 12:28:29');
INSERT INTO `t_pinglun` VALUES ('12', '10', '3', 'fasdfasdf', '2017-04-27 14:37:18');
INSERT INTO `t_pinglun` VALUES ('13', '10', '3', 'sdfasdfasdf', '2017-04-27 15:16:20');
INSERT INTO `t_pinglun` VALUES ('14', '14', '3', 'fsdafasdf', '2017-09-28 19:16:33');
INSERT INTO `t_pinglun` VALUES ('15', '13', '3', 'asdfasdfasdf', '2017-09-28 21:01:48');

-- ----------------------------
-- Table structure for `t_sc`
-- ----------------------------
DROP TABLE IF EXISTS `t_sc`;
CREATE TABLE `t_sc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wdxxId` int(11) DEFAULT NULL COMMENT '信息',
  `customerId` int(11) DEFAULT NULL COMMENT '用户',
  `insertDate` datetime DEFAULT NULL COMMENT '日期',
  `bkId` int(11) DEFAULT NULL COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='收藏';

-- ----------------------------
-- Records of t_sc
-- ----------------------------
INSERT INTO `t_sc` VALUES ('6', '5', '3', '2017-04-24 23:14:53', '1');
INSERT INTO `t_sc` VALUES ('7', '7', '3', '2017-04-24 23:15:08', '2');
INSERT INTO `t_sc` VALUES ('8', '8', '3', '2017-04-24 23:23:55', '1');
INSERT INTO `t_sc` VALUES ('10', '10', '3', '2017-04-27 15:16:28', '1');
INSERT INTO `t_sc` VALUES ('11', '14', '3', '2017-09-28 19:16:29', '1');
INSERT INTO `t_sc` VALUES ('12', '13', '3', '2017-09-28 21:01:52', '1');

-- ----------------------------
-- Table structure for `t_wdxx`
-- ----------------------------
DROP TABLE IF EXISTS `t_wdxx`;
CREATE TABLE `t_wdxx` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) DEFAULT NULL COMMENT '我',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `pic` varchar(100) DEFAULT NULL COMMENT '图片',
  `content` text COMMENT '内容',
  `zan` int(11) DEFAULT NULL COMMENT '赞',
  `insertDate` datetime DEFAULT NULL COMMENT '发布日期',
  `nologin` varchar(50) DEFAULT NULL COMMENT '游客是否可见',
  `bkId` int(11) DEFAULT NULL,
  `types` int(11) DEFAULT NULL COMMENT '类型',
  `bh` varchar(200) DEFAULT NULL,
  `hx` varchar(200) DEFAULT NULL,
  `czxs` varchar(200) DEFAULT NULL,
  `quyu` varchar(200) DEFAULT NULL,
  `jiage` varchar(200) DEFAULT NULL,
  `dth` varchar(200) DEFAULT NULL,
  `fwzt` varchar(200) DEFAULT NULL,
  `lxr` varchar(200) DEFAULT NULL,
  `lxdh` varchar(200) DEFAULT NULL,
  `jwd` varchar(200) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='我的消息';

-- ----------------------------
-- Records of t_wdxx
-- ----------------------------
INSERT INTO `t_wdxx` VALUES ('9', '3', '1111111111', 'upload/20170522/149543277802593.jpg', 'dfadsfasdf111111111', '3', '2017-04-27 14:25:57', '否', null, null, '1493274311277', '音频', '', '', '222', '22', '22', '22', '222', null, '发布');
INSERT INTO `t_wdxx` VALUES ('11', '3', '111', 'upload/20170522/149543277802593.jpg', '11', '0', '2017-05-15 16:07:52', '是', null, null, '1494835672435', '音频', '', '', '11', '11', '11', '11', '11', null, '发布');
INSERT INTO `t_wdxx` VALUES ('12', '3', 'aaaaaa11111', 'upload/20170522/149543277802593.jpg', '333ffff', '0', '2017-05-15 16:09:17', '是', null, null, '1494835757244', '音频', '', '', '33', '33', '33', '33', '33', '116.195,39.708977', '发布');
INSERT INTO `t_wdxx` VALUES ('13', '3', 'fasdfasdfasdf', 'upload/20170928/150659728436090.mp4', 'dfasdfasdfasdf', '1', '2017-09-28 19:14:47', '是', null, null, '1506597287417', '视频', null, null, null, null, null, null, null, null, '发布');
INSERT INTO `t_wdxx` VALUES ('14', '3', 'dsfdasfas', 'upload/20170928/150659729576338.mp3', 'asdfasdf', '1', '2017-09-28 19:14:57', '是', null, null, '1506597297484', '音频', null, null, null, null, null, null, null, null, '发布');
INSERT INTO `t_wdxx` VALUES ('15', '3', '啊啊啊啊啊啊', 'upload/20170928/150660380763691.mp4', '啊是的发送到发多少发', '0', '2017-09-28 21:03:51', '是', null, null, '1506603831854', '视频', null, null, null, null, null, null, null, null, '发布');

-- ----------------------------
-- Table structure for `t_zanlog`
-- ----------------------------
DROP TABLE IF EXISTS `t_zanlog`;
CREATE TABLE `t_zanlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wdxxId` int(11) DEFAULT NULL COMMENT '房产',
  `insertDate` datetime DEFAULT NULL COMMENT '日期',
  `customerId` int(11) DEFAULT NULL COMMENT '用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='赞记录';

-- ----------------------------
-- Records of t_zanlog
-- ----------------------------
INSERT INTO `t_zanlog` VALUES ('1', '10', '2017-05-22 13:43:44', '3');
INSERT INTO `t_zanlog` VALUES ('2', '9', '2017-05-22 14:01:26', '3');
INSERT INTO `t_zanlog` VALUES ('3', '9', '2017-05-22 14:02:36', '3');
INSERT INTO `t_zanlog` VALUES ('4', '14', '2017-09-28 19:16:35', '3');
INSERT INTO `t_zanlog` VALUES ('5', '13', '2017-09-28 21:01:43', '3');

-- ----------------------------
-- Table structure for `t_zhishi`
-- ----------------------------
DROP TABLE IF EXISTS `t_zhishi`;
CREATE TABLE `t_zhishi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `pic` varchar(100) DEFAULT NULL COMMENT '图片',
  `fileUrl` varchar(100) DEFAULT NULL COMMENT '文件',
  `content` text COMMENT '内容',
  `showDate` varchar(100) DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='戏曲常识';

-- ----------------------------
-- Records of t_zhishi
-- ----------------------------
INSERT INTO `t_zhishi` VALUES ('1', '奥德赛发送的', 'upload/20170928/150659786428371.jpg', 'upload/20170928/150659821095186.xls', '阿斯顿发斯蒂芬', '2017-09-28');

-- ----------------------------
-- Table structure for `t_zhishilist`
-- ----------------------------
DROP TABLE IF EXISTS `t_zhishilist`;
CREATE TABLE `t_zhishilist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zhishiId` int(11) DEFAULT NULL COMMENT '戏曲常识',
  `customerId` int(11) DEFAULT NULL COMMENT '用户',
  `content` text COMMENT '文字',
  `insertDate` datetime DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='戏曲常识交流';

-- ----------------------------
-- Records of t_zhishilist
-- ----------------------------
INSERT INTO `t_zhishilist` VALUES ('1', '1', '3', 'dfadsfsdfa', '2017-09-28 19:29:07');
INSERT INTO `t_zhishilist` VALUES ('2', '1', '3', 'asdfasdf', '2017-09-28 19:29:09');
INSERT INTO `t_zhishilist` VALUES ('3', '1', '3', 'sdsfasdf', '2017-09-28 21:02:37');
