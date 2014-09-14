/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-09-13 19:22:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `album`
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `coverArtistEmbedded` bit(1) NOT NULL,
  `coverArtistPath` varchar(255) DEFAULT NULL,
  `coverArtsistURL` varchar(255) DEFAULT NULL,
  `extraLargeImageUrl` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `largeImageUrl` varchar(255) DEFAULT NULL,
  `lastScanned` datetime DEFAULT NULL,
  `listeners` int(11) NOT NULL,
  `mediumImageUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `playCount` int(11) NOT NULL,
  `smallImageUrl` varchar(255) DEFAULT NULL,
  `songCount` int(11) NOT NULL,
  `year` varchar(255) DEFAULT NULL,
  `artist_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3C68E4FDBBD663A` (`artist_id`),
  CONSTRAINT `FK3C68E4FDBBD663A` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------
INSERT INTO `album` VALUES ('402880eb47ee4d450147ee4de2230000', '2014-08-19 20:46:27', '2014-08-19 20:46:27', '', null, null, null, '流行', null, null, '0', null, '一样爱着你', null, '0', null, '0', '2012', '402880eb47bdab8b0147bdac8f240000');

-- ----------------------------
-- Table structure for `albumtype`
-- ----------------------------
DROP TABLE IF EXISTS `albumtype`;
CREATE TABLE `albumtype` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of albumtype
-- ----------------------------

-- ----------------------------
-- Table structure for `albumtype_album`
-- ----------------------------
DROP TABLE IF EXISTS `albumtype_album`;
CREATE TABLE `albumtype_album` (
  `AlbumType_id` varchar(32) NOT NULL,
  `ablumSet_id` varchar(32) NOT NULL,
  PRIMARY KEY (`AlbumType_id`,`ablumSet_id`),
  UNIQUE KEY `ablumSet_id` (`ablumSet_id`),
  KEY `FK85ADC0B9F8FB90AA` (`ablumSet_id`),
  KEY `FK85ADC0B950676F5A` (`AlbumType_id`),
  CONSTRAINT `FK85ADC0B950676F5A` FOREIGN KEY (`AlbumType_id`) REFERENCES `albumtype` (`id`),
  CONSTRAINT `FK85ADC0B9F8FB90AA` FOREIGN KEY (`ablumSet_id`) REFERENCES `album` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of albumtype_album
-- ----------------------------

-- ----------------------------
-- Table structure for `album_song`
-- ----------------------------
DROP TABLE IF EXISTS `album_song`;
CREATE TABLE `album_song` (
  `Album_id` varchar(32) NOT NULL,
  `songSet_id` varchar(32) NOT NULL,
  PRIMARY KEY (`Album_id`,`songSet_id`),
  UNIQUE KEY `songSet_id` (`songSet_id`),
  KEY `FK44532D25EB2BCE62` (`songSet_id`),
  KEY `FK44532D25EB5DD7A` (`Album_id`),
  CONSTRAINT `FK44532D25EB2BCE62` FOREIGN KEY (`songSet_id`) REFERENCES `song` (`id`),
  CONSTRAINT `FK44532D25EB5DD7A` FOREIGN KEY (`Album_id`) REFERENCES `album` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album_song
-- ----------------------------

-- ----------------------------
-- Table structure for `artist`
-- ----------------------------
DROP TABLE IF EXISTS `artist`;
CREATE TABLE `artist` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `albumCount` int(11) NOT NULL,
  `bioContent` varchar(255) DEFAULT NULL,
  `bioSummary` varchar(255) DEFAULT NULL,
  `extraLargeImageUrl` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `largeImageUrl` varchar(255) DEFAULT NULL,
  `listeners` int(11) DEFAULT NULL,
  `mediumImageUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `playCount` int(11) NOT NULL,
  `smallImageUrl` varchar(255) DEFAULT NULL,
  `sortName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of artist
-- ----------------------------
INSERT INTO `artist` VALUES ('402880eb47bdab8b0147bdac8f240000', '2014-08-10 10:08:28', '2014-08-10 10:08:28', '4', '输入歌手内容路绮欧民航局 民间歌手号', '路绮欧民航局', null, '女', '/upload/images/artist/0/default_large.jpg', '0', '/upload/images/artist/0/default_medium.jpg', '路绮欧', '0', '/upload/images/artist/0/default_thumbnail.jpg', '路绮欧');

-- ----------------------------
-- Table structure for `genre`
-- ----------------------------
DROP TABLE IF EXISTS `genre`;
CREATE TABLE `genre` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of genre
-- ----------------------------
INSERT INTO `genre` VALUES ('402880eb4758d7f5014758df10a70000', '2014-07-21 20:21:59', '2014-07-21 20:21:59', '流行', '流行');

-- ----------------------------
-- Table structure for `genre_song`
-- ----------------------------
DROP TABLE IF EXISTS `genre_song`;
CREATE TABLE `genre_song` (
  `Genre_id` varchar(32) NOT NULL,
  `songSet_id` varchar(32) NOT NULL,
  PRIMARY KEY (`Genre_id`,`songSet_id`),
  UNIQUE KEY `songSet_id` (`songSet_id`),
  KEY `FK22616E91EB2BCE62` (`songSet_id`),
  KEY `FK22616E91204F14FA` (`Genre_id`),
  CONSTRAINT `FK22616E91204F14FA` FOREIGN KEY (`Genre_id`) REFERENCES `genre` (`id`),
  CONSTRAINT `FK22616E91EB2BCE62` FOREIGN KEY (`songSet_id`) REFERENCES `song` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of genre_song
-- ----------------------------

-- ----------------------------
-- Table structure for `imageinfo`
-- ----------------------------
DROP TABLE IF EXISTS `imageinfo`;
CREATE TABLE `imageinfo` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `large` varchar(255) DEFAULT NULL,
  `medium` varchar(255) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imageinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `isAccountEnabled` bit(1) NOT NULL,
  `isAccountLocked` bit(1) NOT NULL,
  `lockedDate` datetime DEFAULT NULL,
  `loginDate` datetime DEFAULT NULL,
  `loginFailureCount` int(11) NOT NULL,
  `loginIp` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `passwordRecoverKey` varchar(255) DEFAULT NULL,
  `point` int(11) NOT NULL,
  `registerIp` varchar(255) DEFAULT NULL,
  `safeAnswer` varchar(255) DEFAULT NULL,
  `safeQuestion` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `memberRank_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `FK892776BA2CADA0BB` (`memberRank_id`),
  CONSTRAINT `FK892776BA2CADA0BB` FOREIGN KEY (`memberRank_id`) REFERENCES `memberrank` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------

-- ----------------------------
-- Table structure for `memberrank`
-- ----------------------------
DROP TABLE IF EXISTS `memberrank`;
CREATE TABLE `memberrank` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `isDefault` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `point` int(11) NOT NULL,
  `preferentialScale` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `point` (`point`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of memberrank
-- ----------------------------

-- ----------------------------
-- Table structure for `member_song`
-- ----------------------------
DROP TABLE IF EXISTS `member_song`;
CREATE TABLE `member_song` (
  `favoriteMemberSet_id` varchar(32) NOT NULL,
  `favoriteSongSet_id` varchar(32) NOT NULL,
  PRIMARY KEY (`favoriteMemberSet_id`,`favoriteSongSet_id`),
  KEY `FKB5D9CF9AF03B0C89` (`favoriteMemberSet_id`),
  KEY `FKB5D9CF9A604344FE` (`favoriteSongSet_id`),
  CONSTRAINT `FKB5D9CF9A604344FE` FOREIGN KEY (`favoriteSongSet_id`) REFERENCES `song` (`id`),
  CONSTRAINT `FKB5D9CF9AF03B0C89` FOREIGN KEY (`favoriteMemberSet_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member_song
-- ----------------------------

-- ----------------------------
-- Table structure for `song`
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `album` tinyblob,
  `album1` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `artist` tinyblob,
  `artist1` varchar(255) DEFAULT NULL,
  `composer` varchar(255) DEFAULT NULL,
  `encoder` varchar(255) DEFAULT NULL,
  `hasLyrics` bit(1) NOT NULL,
  `language` varchar(255) DEFAULT NULL,
  `lyricist` varchar(255) DEFAULT NULL,
  `lyrics` varchar(255) DEFAULT NULL,
  `mediaType` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `playCount` int(11) NOT NULL,
  `recordCompany` varchar(255) DEFAULT NULL,
  `size` int(11) NOT NULL,
  `status` bit(1) NOT NULL,
  `time` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `songMetaData_id` varchar(32) DEFAULT NULL,
  `songCategory_id` varchar(32) DEFAULT NULL,
  `genre_id` varchar(32) DEFAULT NULL,
  `extraLargeImageUrl` varchar(255) DEFAULT NULL,
  `largeImageUrl` varchar(255) DEFAULT NULL,
  `mediumImageUrl` varchar(255) DEFAULT NULL,
  `smallImageUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK276935102E795A` (`songMetaData_id`),
  KEY `FK276935E2077EDA` (`songCategory_id`),
  KEY `FK276935204F14FA` (`genre_id`),
  CONSTRAINT `FK276935102E795A` FOREIGN KEY (`songMetaData_id`) REFERENCES `songmetadata` (`id`),
  CONSTRAINT `FK276935204F14FA` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  CONSTRAINT `FK276935E2077EDA` FOREIGN KEY (`songCategory_id`) REFERENCES `songcategory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of song
-- ----------------------------
INSERT INTO `song` VALUES ('402880eb4776e260014776e8a48a0000', '2014-07-27 16:21:03', '2014-07-27 16:21:03', null, 'Promo Only Mainstream Radio November', null, null, 'Promo', null, '', '', null, null, '', 'mp3', 'Right Now (Na Na Na)', '/veight/upload/mp3201407/Akon - Right Now.mp3', '0', null, '0', '', '4:05', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776e8e86a0001', '2014-07-27 16:21:21', '2014-07-27 16:21:21', null, 'Live 1991(环球复黑王系列)', null, null, '', null, '', '', null, null, '', 'mp3', '真的爱你', '/veight/upload/mp3201407/BEYOND - 真的爱你.mp3', '0', null, '0', '', '5:24', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776ea992c0004', '2014-07-27 16:23:11', '2014-07-27 16:23:11', null, '卓依婷 - 鲁冰花', null, null, '卓依婷 ', null, '', '', null, null, '', 'mp3', '卓依婷 - 鲁冰花', '/veight/upload/mp3201407/卓依婷 - 鲁冰花.mp3', '0', null, '0', '', '4:17', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776ead66d0005', '2014-07-27 16:23:27', '2014-07-27 16:23:27', null, '欢喜就好', null, null, 'j舞曲 ', null, '', '', null, null, '', 'mp3', '欢喜就好', '/veight/upload/mp3201407/dj舞曲 - 欢喜就好.mp3', '0', null, '0', '', '5:01', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776eb04d70007', '2014-07-27 16:23:39', '2014-07-27 16:23:39', null, '欢喜就好', null, null, 'j舞曲 ', null, '', '', null, null, '', 'mp3', '欢喜就好', '/veight/upload/mp3201407/dj舞曲 - 欢喜就好.mp3', '0', null, '0', '', '5:01', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776eb0d2c0008', '2014-07-27 16:23:41', '2014-07-27 16:23:41', null, '欢喜就好', null, null, 'j舞曲 ', null, '', '', null, null, '', 'mp3', '欢喜就好', '/veight/upload/mp3201407/dj舞曲 - 欢喜就好.mp3', '0', null, '0', '', '5:01', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776eb14a20009', '2014-07-27 16:23:43', '2014-07-27 16:23:43', null, '欢喜就好', null, null, 'j舞曲 ', null, '', '', null, null, '', 'mp3', '欢喜就好', '/veight/upload/mp3201407/dj舞曲 - 欢喜就好.mp3', '0', null, '0', '', '5:01', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776eb1c21000a', '2014-07-27 16:23:45', '2014-07-27 16:23:45', null, '欢喜就好', null, null, 'j舞曲 ', null, '', '', null, null, '', 'mp3', '欢喜就好', '/veight/upload/mp3201407/dj舞曲 - 欢喜就好.mp3', '0', null, '0', '', '5:01', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776eb2309000b', '2014-07-27 16:23:47', '2014-07-27 16:23:47', null, '欢喜就好', null, null, 'j舞曲 ', null, '', '', null, null, '', 'mp3', '欢喜就好', '/veight/upload/mp3201407/dj舞曲 - 欢喜就好.mp3', '0', null, '0', '', '5:01', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776eb29f4000c', '2014-07-27 16:23:48', '2014-07-27 16:23:48', null, '欢喜就好', null, null, 'j舞曲 ', null, '', '', null, null, '', 'mp3', '欢喜就好', '/veight/upload/mp3201407/dj舞曲 - 欢喜就好.mp3', '0', null, '0', '', '5:01', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776eb3137000d', '2014-07-27 16:23:50', '2014-07-27 16:23:50', null, '欢喜就好', null, null, 'j舞曲 ', null, '', '', null, null, '', 'mp3', '欢喜就好', '/veight/upload/mp3201407/dj舞曲 - 欢喜就好.mp3', '0', null, '0', '', '5:01', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776ec94130010', '2014-07-27 16:25:21', '2014-07-27 16:25:21', null, '最熟悉的陌生人', null, null, '最熟悉的陌生人', null, '', '', null, null, '', 'mp3', '最熟悉的陌生人', '/veight/upload/mp3201407/最熟悉的陌生人.mp3', '0', null, '0', '', '4:24', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776eca39f0012', '2014-07-27 16:25:25', '2014-07-27 16:25:25', null, '最熟悉的陌生人', null, null, '最熟悉的陌生人', null, '', '', null, null, '', 'mp3', '最熟悉的陌生人', '/veight/upload/mp3201407/最熟悉的陌生人.mp3', '0', null, '0', '', '4:24', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4776e260014776ecf968001e', '2014-07-27 16:25:47', '2014-07-27 16:25:47', null, '最熟悉的陌生人', null, null, '最熟悉的陌生人', null, '', '', null, null, '', 'mp3', '最熟悉的陌生人', '/veight/upload/mp3201407/最熟悉的陌生人.mp3', '0', null, '0', '', '4:24', '0', null, null, null, null, null, null, null);
INSERT INTO `song` VALUES ('402880eb477790850147779236e30000', '2014-07-27 19:26:16', '2014-07-27 19:26:16', null, 'Rolling in the Deep', null, null, 'Rolling in the Deep', null, '', '', null, null, '', 'mp3', 'Rolling in the Deep', '/veight/upload/mp3201407/adele - rolling in the deep.mp3', '0', null, '0', '', '3:54', '2010', null, null, '402880eb4758d7f5014758df10a70000', null, null, null, null);
INSERT INTO `song` VALUES ('402880eb478ca27e01478ca2c6fd0000', '2014-07-31 21:36:23', '2014-07-31 21:36:23', null, 'Goodbye Lullaby', null, null, 'Goodbye', null, '', '', null, null, '', 'mp3', 'Goodbye（说再见）', '/upload/images/Avril Lavigne - Goodbye.mp3', '0', null, '0', '', '4:30', '0', null, null, '402880eb4758d7f5014758df10a70000', null, null, null, null);
INSERT INTO `song` VALUES ('402880eb478cb18e01478cb1dac80000', '2014-07-31 21:52:51', '2014-07-31 21:52:51', null, '90\'闹Now', null, null, '一样爱着你', null, '', '', null, null, '', 'mp3', '一样爱着你', '/upload/images/by2 - 一样爱着你.mp3', '0', null, '0', '', '4:22', '0', null, null, '402880eb4758d7f5014758df10a70000', null, null, null, null);
INSERT INTO `song` VALUES ('402880eb478cb18e01478cb28c210003', '2014-07-31 21:53:37', '2014-07-31 21:53:37', null, '最熟悉的陌生人', null, null, '最熟悉的陌生人', null, '', '', null, null, '', 'mp3', '最熟悉的陌生人', '/upload/images/最熟悉的陌生人.mp3', '0', null, '0', '', '4:24', '0', null, null, '402880eb4758d7f5014758df10a70000', null, null, null, null);
INSERT INTO `song` VALUES ('402880eb478cb18e01478cb2b98d0004', '2014-07-31 21:53:48', '2014-07-31 21:53:48', null, '星梦苦', null, null, '星梦苦', null, '', '', null, null, '', 'mp3', '星梦苦旅收藏汽车音响专用慢摇串', '/upload/images/dj 汽车音响专用慢摇串烧现场版.mp3', '0', null, '0', '', '13:27', '0', null, null, '402880eb4758d7f5014758df10a70000', null, null, null, null);
INSERT INTO `song` VALUES ('402880eb478cb18e01478cb31a130005', '2014-07-31 21:54:13', '2014-07-31 21:54:13', null, '不再犹豫', null, null, 'Beyond', null, '', '', null, null, '', 'mp3', '不再犹豫', '/upload/images/Beyond - 不再犹豫.mp3', '0', null, '0', '', '4:14', '0', null, null, '402880eb4758d7f5014758df10a70000', null, null, null, null);
INSERT INTO `song` VALUES ('402880eb47ba81930147ba82131b0000', '2014-08-09 19:23:12', '2014-08-09 19:23:12', null, '90\'闹Now', null, null, '样爱着', null, '', '', null, null, '', 'mp3', '一样爱着你', '/upload/images/by2 - 一样爱着你.mp3', '0', null, '0', '', '4:22', '0', null, null, '402880eb4758d7f5014758df10a70000', null, null, null, null);
INSERT INTO `song` VALUES ('402880eb4807f8fa014807f920cd0000', '2014-08-24 20:24:00', '2014-08-24 20:24:00', null, '', null, null, '', null, '', '', null, null, '', '', '', '', '0', null, '0', '', '', '', null, null, '402880eb4758d7f5014758df10a70000', '', null, null, null);

-- ----------------------------
-- Table structure for `songcategory`
-- ----------------------------
DROP TABLE IF EXISTS `songcategory`;
CREATE TABLE `songcategory` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `metaDescription` longtext,
  `metaKeywords` longtext,
  `name` varchar(255) NOT NULL,
  `orderList` int(11) NOT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB3B68553204407E3` (`parent_id`),
  CONSTRAINT `FKB3B68553204407E3` FOREIGN KEY (`parent_id`) REFERENCES `songcategory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of songcategory
-- ----------------------------

-- ----------------------------
-- Table structure for `songmetadata`
-- ----------------------------
DROP TABLE IF EXISTS `songmetadata`;
CREATE TABLE `songmetadata` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `album` varchar(255) DEFAULT NULL,
  `albumArtist` varchar(255) DEFAULT NULL,
  `albumArtistSort` varchar(255) DEFAULT NULL,
  `albumId` int(11) NOT NULL,
  `artist` varchar(255) DEFAULT NULL,
  `artistId` int(11) NOT NULL,
  `artistSort` varchar(255) DEFAULT NULL,
  `artworkPath` varchar(255) DEFAULT NULL,
  `bitRate` bigint(20) NOT NULL,
  `composer` varchar(255) DEFAULT NULL,
  `coverArtEmbedded` bit(1) NOT NULL,
  `discNr` smallint(6) DEFAULT NULL,
  `discNrs` smallint(6) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `format` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `hasLyrics` bit(1) NOT NULL,
  `lyrics` varchar(255) DEFAULT NULL,
  `mediaType` varchar(255) DEFAULT NULL,
  `modified` bigint(20) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `trackNr` smallint(6) DEFAULT NULL,
  `trackNrs` smallint(6) DEFAULT NULL,
  `variableBitRate` bit(1) NOT NULL,
  `year` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of songmetadata
-- ----------------------------

-- ----------------------------
-- Table structure for `v_admin`
-- ----------------------------
DROP TABLE IF EXISTS `v_admin`;
CREATE TABLE `v_admin` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `isAccountEnabled` bit(1) DEFAULT NULL,
  `isAccountExpired` bit(1) DEFAULT NULL,
  `isAccountLocked` bit(1) DEFAULT NULL,
  `isCredentialsExpired` bit(1) DEFAULT NULL,
  `lockedDate` datetime DEFAULT NULL,
  `loginDate` datetime DEFAULT NULL,
  `loginFailureCount` int(11) DEFAULT NULL,
  `loginIp` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_admin
-- ----------------------------
INSERT INTO `v_admin` VALUES ('402880eb47f363ab0147f3653c980001', '2014-08-20 20:30:03', '2014-08-20 20:30:03', '计算机', '845885222@qq.com', '', '', '', '', null, '2014-08-20 20:30:03', '0', '0:0:0:0:0:0:0:1', '王坤', 'e10adc3949ba59abbe56e057f20f883e', 'admin');

-- ----------------------------
-- Table structure for `v_admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `v_admin_role`;
CREATE TABLE `v_admin_role` (
  `admins_id` varchar(32) NOT NULL,
  `roles_id` varchar(32) NOT NULL,
  PRIMARY KEY (`admins_id`,`roles_id`),
  KEY `FKF5C37ECFB4BC35A5` (`admins_id`),
  KEY `FKF5C37ECF1F459433` (`roles_id`),
  CONSTRAINT `FKF5C37ECF1F459433` FOREIGN KEY (`roles_id`) REFERENCES `v_role` (`id`),
  CONSTRAINT `FKF5C37ECFB4BC35A5` FOREIGN KEY (`admins_id`) REFERENCES `v_admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_admin_role
-- ----------------------------
INSERT INTO `v_admin_role` VALUES ('402880eb47f363ab0147f3653c980001', '402880eb47f363ab0147f364cc680000');

-- ----------------------------
-- Table structure for `v_document`
-- ----------------------------
DROP TABLE IF EXISTS `v_document`;
CREATE TABLE `v_document` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `deleteflag` varchar(255) DEFAULT NULL,
  `isDirectory` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `size` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD29C26C4C84A5053` (`parent_id`),
  CONSTRAINT `FKD29C26C4C84A5053` FOREIGN KEY (`parent_id`) REFERENCES `v_document` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_document
-- ----------------------------

-- ----------------------------
-- Table structure for `v_log`
-- ----------------------------
DROP TABLE IF EXISTS `v_log`;
CREATE TABLE `v_log` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `content` longtext,
  `ip` varchar(255) NOT NULL,
  `operation` varchar(255) NOT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `parameter` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_log
-- ----------------------------
INSERT INTO `v_log` VALUES ('402880eb480d086b01480d08f22c0000', '2014-08-25 19:59:23', '2014-08-25 19:59:23', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', 'username = 1221\nemail = 312\ndepartment = 12\nname = 231\nroleIds = 402880eb47f363ab0147f364cc680000\nisEnabled = true\n');
INSERT INTO `v_log` VALUES ('402880eb480d09a301480d09e8120000', '2014-08-25 20:00:26', '2014-08-25 20:00:26', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', 'username = ee\nemail = eee\ndepartment = ee\nname = ee\nroleIds = 402880eb47f363ab0147f364cc680000\nisEnabled = true\n');
INSERT INTO `v_log` VALUES ('402880eb480d0a3b01480d0aebd30000', '2014-08-25 20:01:32', '2014-08-25 20:01:32', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', 'username = eee\nemail = eee\ndepartment = eee\nname = eee\nroleIds = 402880eb47f363ab0147f364cc680000\nisEnabled = true\n');
INSERT INTO `v_log` VALUES ('402880eb480d0a3b01480d0d239f0001', '2014-08-25 20:03:57', '2014-08-25 20:03:57', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', 'username = 11\nemail = 11\ndepartment = 11\nname = 11\nroleIds = 402880eb47f363ab0147f364cc680000\nisEnabled = true\n');
INSERT INTO `v_log` VALUES ('402880eb480d100001480d104f4a0000', '2014-08-25 20:07:25', '2014-08-25 20:07:25', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', 'username = 11\nemail = 11\ndepartment = 11\nname = 11\nroleIds = 402880eb47f363ab0147f364cc680000\nisEnabled = true\n');
INSERT INTO `v_log` VALUES ('402880eb480d115b01480d11d12c0000', '2014-08-25 20:09:04', '2014-08-25 20:09:04', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', 'username = 11\nemail = 11\ndepartment = 11\nname = 11\nroleIds = 402880eb47f363ab0147f364cc680000\nisEnabled = true\n');
INSERT INTO `v_log` VALUES ('402880eb480d157801480d15bcba0000', '2014-08-25 20:13:21', '2014-08-25 20:13:21', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', 'username = 11\nemail = 11\ndepartment = 11\nname = 11\nroleIds = 402880eb47f363ab0147f364cc680000\nisEnabled = true\n');
INSERT INTO `v_log` VALUES ('402880eb480d445901480d45836b0000', '2014-08-25 21:05:32', '2014-08-25 21:05:32', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', '');
INSERT INTO `v_log` VALUES ('402880eb480d468b01480d46a32d0000', '2014-08-25 21:06:46', '2014-08-25 21:06:46', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', '');
INSERT INTO `v_log` VALUES ('402880eb480d468b01480d479cbc0001', '2014-08-25 21:07:50', '2014-08-25 21:07:50', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', '');
INSERT INTO `v_log` VALUES ('402880eb480d468b01480d4859490002', '2014-08-25 21:08:38', '2014-08-25 21:08:38', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', '');
INSERT INTO `v_log` VALUES ('402880eb480d468b01480d493a000003', '2014-08-25 21:09:35', '2014-08-25 21:09:35', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', '');
INSERT INTO `v_log` VALUES ('402880eb480da72f01480da8d5290000', '2014-08-25 22:54:01', '2014-08-25 22:54:01', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', 'username = eee\nemail = eee\ndepartment = ee\nname = eee\nisAccountEnabled = true\n_isAccountEnabled = on\nroleIds = 402880eb47f363ab0147f364cc680000\n');
INSERT INTO `v_log` VALUES ('402880eb480daa3e01480daaf7610000', '2014-08-25 22:56:21', '2014-08-25 22:56:21', null, '0:0:0:0:0:0:0:1', '保存', 'jimi', 'username = eee\nemail = eee\ndepartment = eee\nname = eee\nisAccountEnabled = true\n_isAccountEnabled = on\nroleIds = 402880eb47f363ab0147f364cc680000\n');

-- ----------------------------
-- Table structure for `v_role`
-- ----------------------------
DROP TABLE IF EXISTS `v_role`;
CREATE TABLE `v_role` (
  `id` varchar(32) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `isSystem` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_role
-- ----------------------------
INSERT INTO `v_role` VALUES ('402880eb47f363ab0147f364cc680000', '2014-08-20 20:29:35', '2014-08-20 20:29:35', '拥有最高权限', '', '超级管理员');

-- ----------------------------
-- Table structure for `v_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `v_role_authority`;
CREATE TABLE `v_role_authority` (
  `Role_id` varchar(32) NOT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  KEY `FK4D9D99A3812D1BDA` (`Role_id`),
  CONSTRAINT `FK4D9D99A3812D1BDA` FOREIGN KEY (`Role_id`) REFERENCES `v_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_role_authority
-- ----------------------------
INSERT INTO `v_role_authority` VALUES ('402880eb47f363ab0147f364cc680000', 'ROLE_ADMIN_SONG');
INSERT INTO `v_role_authority` VALUES ('402880eb47f363ab0147f364cc680000', 'ROLE_ADMIN_ALBUM');
INSERT INTO `v_role_authority` VALUES ('402880eb47f363ab0147f364cc680000', 'ROLE_ADMIN_GENRE');
INSERT INTO `v_role_authority` VALUES ('402880eb47f363ab0147f364cc680000', 'ROLE_ADMIN_ARTIST');
