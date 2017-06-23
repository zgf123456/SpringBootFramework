/*
 Navicat Premium Data Transfer

 Source Server         : localhost_my_test
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : localhost
 Source Database       : zgf

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 06/22/2017 15:14:26 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `quartz_job_config`
-- ----------------------------
DROP TABLE IF EXISTS `quartz_job_config`;
CREATE TABLE `quartz_job_config` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `JOB_NAME` varchar(255) NOT NULL COMMENT '定时任务名称',
  `ENABLE` char(1) NOT NULL COMMENT '是否启用，0-启用，1-停用',
  `CLASS_NAME` varchar(255) NOT NULL COMMENT '定时任务类全名',
  `CRON` varchar(60) NOT NULL COMMENT '定时CRON表达式',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
