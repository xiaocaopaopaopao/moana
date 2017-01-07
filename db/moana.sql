-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.0.17-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 moana 的数据库结构
DROP DATABASE IF EXISTS `moana`;
CREATE DATABASE IF NOT EXISTS `moana` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `moana`;


-- 导出  表 moana.purchase_record 结构
DROP TABLE IF EXISTS `purchase_record`;
CREATE TABLE IF NOT EXISTS `purchase_record` (
  `id` varchar(32) NOT NULL,
  `uid` varchar(32) NOT NULL,
  `tid` varchar(32) NOT NULL,
  `num` int(10) NOT NULL,
  `purchaseTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_deal_record_user` (`uid`),
  KEY `FK_deal_record_ticket` (`tid`),
  CONSTRAINT `FK_deal_record_ticket` FOREIGN KEY (`tid`) REFERENCES `ticket` (`tid`),
  CONSTRAINT `FK_deal_record_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  moana.purchase_record 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `purchase_record` DISABLE KEYS */;
REPLACE INTO `purchase_record` (`id`, `uid`, `tid`, `num`, `purchaseTime`) VALUES
	('4028821f5977f0e7015977f0e7cc0001', '4028821f5977f0e7015977f0e7cc0000', '4028821f5962c187015962c1bb0d0000', 1, '2017-01-07 16:00:06'),
	('4028821f5977f0e7015977f0e7cc0002', '4028821f5977e82b015977e82b980000', '4028821f5962c187015962c1bb0d0000', 2, '2017-01-07 16:00:51');
/*!40000 ALTER TABLE `purchase_record` ENABLE KEYS */;


-- 导出  表 moana.sequence_table 结构
DROP TABLE IF EXISTS `sequence_table`;
CREATE TABLE IF NOT EXISTS `sequence_table` (
  `SEQUENCE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `NEXT_VAL` bigint(20) NOT NULL,
  PRIMARY KEY (`SEQUENCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  moana.sequence_table 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `sequence_table` DISABLE KEYS */;
REPLACE INTO `sequence_table` (`SEQUENCE_NAME`, `NEXT_VAL`) VALUES
	('lab.io.rush.model.User', 21);
/*!40000 ALTER TABLE `sequence_table` ENABLE KEYS */;


-- 导出  表 moana.ticket 结构
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `tid` varchar(32) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `num` int(10) unsigned DEFAULT NULL,
  `onlineDate` date DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  moana.ticket 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
REPLACE INTO `ticket` (`tid`, `name`, `num`, `onlineDate`) VALUES
	('4028821f5962c187015432c1cb0d0320', '冰雪女皇之冬日魔咒', 100, '2016-12-31'),
	('4028821f5962c187015962c1bb0d0000', '阿凡达2', 299, '2016-12-30');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;


-- 导出  表 moana.user 结构
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `uid` varchar(32) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(32) DEFAULT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  moana.user 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`uid`, `username`, `password`, `email`, `registerTime`) VALUES
	('4028821f5977e82b015977e82b980000', 'haoren@163.com', '123456', 'haoren@163.com', '2017-01-07 15:50:21'),
	('4028821f5977f0e7015977f0e7cc0000', '778711049@qq.com', '123456', '778711049@qq.com', '2017-01-07 15:59:53');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
