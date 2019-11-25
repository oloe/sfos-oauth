/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : oauth

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 23/11/2019 13:03:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login_history_entity
-- ----------------------------
DROP TABLE IF EXISTS `login_history_entity`;
CREATE TABLE `login_history_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `record_status` int(11) DEFAULT '0',
  `remarks` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `sort_priority` int(11) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  `client_id` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `device` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `ip` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `username` varchar(40) COLLATE utf8mb4_cs_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `index_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci;

-- ----------------------------
-- Table structure for oauth_client_entity
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_entity`;
CREATE TABLE `oauth_client_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `record_status` int(11) DEFAULT '0',
  `remarks` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `sort_priority` int(11) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  `access_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `application_name` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `authorities` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci NOT NULL,
  `authorized_grant_types` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci NOT NULL,
  `auto_approve` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `client_id` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci NOT NULL,
  `client_secret` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci NOT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `resource_ids` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `scope` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr2l8pjrmtn8e57w4qqoqnu7is` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci;

-- ----------------------------
-- Records of oauth_client_entity
-- ----------------------------
BEGIN;
INSERT INTO `oauth_client_entity` VALUES (1, '2019-11-23 04:47:41', '2019-11-23 04:47:41', 0, '测试明文:tgb.258', 0, 0, 7200, NULL, 'SampleClientId 测试应用', 'ROLE_TRUSTED_CLIENT', 'authorization_code,refresh_token,password', NULL, 'SampleClientId', '$2a$10$gcrWom7ubcRaVD1.6ZIrIeJP0mtPLH5J9V/.8Qth59lZ4B/5HMq96', NULL, 2592000, NULL, 'user_info', 'http://client.sso.com/login/oauth2/code/sso-login');
COMMIT;

-- ----------------------------
-- Table structure for role_entity
-- ----------------------------
DROP TABLE IF EXISTS `role_entity`;
CREATE TABLE `role_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `record_status` int(11) DEFAULT '0',
  `remarks` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `sort_priority` int(11) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  `role_name` varchar(15) COLLATE utf8mb4_cs_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6tqlgmw16egvfr70ndgd9nqyf` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci;

-- ----------------------------
-- Records of role_entity
-- ----------------------------
BEGIN;
INSERT INTO `role_entity` VALUES (1, '2019-11-23 04:47:41', '2019-11-23 04:47:41', 0, NULL, 0, 0, 'ROLE_SUPER');
INSERT INTO `role_entity` VALUES (2, '2019-11-23 04:47:41', '2019-11-23 04:47:41', 0, NULL, 0, 0, 'ROLE_ADMIN');
INSERT INTO `role_entity` VALUES (3, '2019-11-23 04:47:41', '2019-11-23 04:47:41', 0, NULL, 0, 0, 'ROLE_USER');
COMMIT;

-- ----------------------------
-- Table structure for scope_definition_entity
-- ----------------------------
DROP TABLE IF EXISTS `scope_definition_entity`;
CREATE TABLE `scope_definition_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `record_status` int(11) DEFAULT '0',
  `remarks` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `sort_priority` int(11) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  `definition` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `scope` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKn908i6w2068oq5vs137q55ud6` (`scope`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci;

-- ----------------------------
-- Records of scope_definition_entity
-- ----------------------------
BEGIN;
INSERT INTO `scope_definition_entity` VALUES (1, '2019-11-23 04:47:41', '2019-11-23 04:47:41', 0, NULL, 0, 0, '昵称、头像、性别信息', 'user_info');
COMMIT;

-- ----------------------------
-- Table structure for third_party_account_entity
-- ----------------------------
DROP TABLE IF EXISTS `third_party_account_entity`;
CREATE TABLE `third_party_account_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `record_status` int(11) DEFAULT '0',
  `remarks` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `sort_priority` int(11) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  `account_open_code` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `avatar_url` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `third_party` varchar(20) COLLATE utf8mb4_cs_0900_ai_ci NOT NULL,
  `third_party_account_id` varchar(100) COLLATE utf8mb4_cs_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKteg9nl8ovi8h8b69i4li6m2nx` (`third_party`,`third_party_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci;

-- ----------------------------
-- Table structure for third_party_account_entity_roles
-- ----------------------------
DROP TABLE IF EXISTS `third_party_account_entity_roles`;
CREATE TABLE `third_party_account_entity_roles` (
  `third_party_account_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci;

-- ----------------------------
-- Table structure for user_account_entity
-- ----------------------------
DROP TABLE IF EXISTS `user_account_entity`;
CREATE TABLE `user_account_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `record_status` int(11) DEFAULT '0',
  `remarks` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `sort_priority` int(11) DEFAULT '0',
  `version` int(11) DEFAULT '0',
  `account_open_code` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `avatar_url` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `city` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `failure_count` int(11) DEFAULT '0',
  `failure_time` datetime DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci NOT NULL,
  `province` varchar(255) COLLATE utf8mb4_cs_0900_ai_ci DEFAULT NULL,
  `username` varchar(50) COLLATE utf8mb4_cs_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK2jc14awfu2adi6x4w35q6jife` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci;

-- ----------------------------
-- Records of user_account_entity
-- ----------------------------
BEGIN;
INSERT INTO `user_account_entity` VALUES (1, '2019-11-23 04:56:26', '2019-11-23 04:56:26', 0, '测试明文：1qaz2wsx.', 0, 0, '1', NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '燕超', '$2a$10$IIFbXOuAiJEc4yBx4m9dxO6f87QScxsREGFAHNqSuh.cesuVsOnRC', NULL, 'yan.chao');
INSERT INTO `user_account_entity` VALUES (3, '2019-11-23 04:56:26', '2019-11-23 04:56:26', 0, '测试明文:tgb.258', 0, 0, '3', NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '李四', '$2a$10$gcrWom7ubcRaVD1.6ZIrIeJP0mtPLH5J9V/.8Qth59lZ4B/5HMq96', NULL, 'lisi');
COMMIT;

-- ----------------------------
-- Table structure for user_account_entity_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_account_entity_roles`;
CREATE TABLE `user_account_entity_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci;

-- ----------------------------
-- Records of user_account_entity_roles
-- ----------------------------
BEGIN;
INSERT INTO `user_account_entity_roles` VALUES (1, 1);
INSERT INTO `user_account_entity_roles` VALUES (3, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
