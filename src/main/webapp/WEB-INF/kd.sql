-- --------------------------------------------------------
-- 호스트:                          172.31.58.238
-- 서버 버전:                        11.0.2-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- game 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `game` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `game`;

-- 테이블 game.board_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_info` (
  `BI_NUM` int(11) NOT NULL AUTO_INCREMENT,
  `BI_TITLE` varchar(1000) NOT NULL,
  `BI_CONTENT` text NOT NULL,
  `UI_NUM` int(11) NOT NULL,
  `CREDAT` char(8) NOT NULL,
  `CRETIM` char(6) NOT NULL,
  `LMODAT` char(8) NOT NULL,
  `LMOTIM` char(6) NOT NULL,
  `ACTIVE` char(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`BI_NUM`),
  KEY `UI_NUM` (`UI_NUM`),
  CONSTRAINT `board_info_ibfk_1` FOREIGN KEY (`UI_NUM`) REFERENCES `user_info` (`UI_NUM`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 game.board_info:~3 rows (대략적) 내보내기
INSERT INTO `board_info` (`BI_NUM`, `BI_TITLE`, `BI_CONTENT`, `UI_NUM`, `CREDAT`, `CRETIM`, `LMODAT`, `LMOTIM`, `ACTIVE`) VALUES
	(4, '길동씨 게시물', '나는 길동이', 6, '20230727', '140455', '20230727', '170959', '1'),
	(5, '푸바오 게시물', '나는 푸바오', 1, '20230727', '140727', '20230727', '140727', '1');

-- 테이블 game.user_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_info` (
  `UI_NUM` int(11) NOT NULL AUTO_INCREMENT,
  `UI_NAME` varchar(30) NOT NULL,
  `UI_ID` varchar(30) NOT NULL,
  `UI_PWD` varchar(30) NOT NULL,
  `UI_IMG_PATH` varchar(50) DEFAULT NULL,
  `UI_DESC` varchar(4000) DEFAULT NULL,
  `UI_BIRTH` char(8) NOT NULL,
  `CREDAT` char(8) NOT NULL,
  `CRETIM` char(6) NOT NULL,
  `LMODAT` char(8) NOT NULL,
  `LMOTIM` char(6) NOT NULL,
  `ACTIVE` char(1) DEFAULT '1',
  PRIMARY KEY (`UI_NUM`),
  UNIQUE KEY `UI_ID` (`UI_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 game.user_info:~2 rows (대략적) 내보내기
INSERT INTO `user_info` (`UI_NUM`, `UI_NAME`, `UI_ID`, `UI_PWD`, `UI_IMG_PATH`, `UI_DESC`, `UI_BIRTH`, `CREDAT`, `CRETIM`, `LMODAT`, `LMOTIM`, `ACTIVE`) VALUES
	(1, '푸바오', 'pubao', 'pubao', NULL, '천방지축 어리둥절 빙글빙글 돌아가는 말괄량이 푸바오의 하루', '20200713', '20230725', '150808', '20230726', '151622', '1'),
	(6, '홍길동', 'hong', 'hong', NULL, '동번서번', '20000511', '20230726', '152034', '20230726', '152118', '1');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
