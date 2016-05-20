create database test;
use test;
CREATE TABLE `deal` (`id` int(11) NOT NULL AUTO_INCREMENT,
 `business` text NOT NULL,
 `done` int(11) NOT NULL DEFAULT '0',
 `add_date` date NOT NULL,
 PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET='utf8';
INSERT INTO `test1`.`deal` (`business`, `done`, `add_date`) VALUES ('Проснуться', '1', '2016-05-20');
INSERT INTO `test1`.`deal` (`business`, `done`, `add_date`) VALUES ('Покушать', '1', '2016-05-20');
INSERT INTO `test1`.`deal` (`business`, `done`, `add_date`) VALUES ('Сходить на работу', '1', '2016-05-20');
INSERT INTO `test1`.`deal` (`business`, `done`, `add_date`) VALUES ('Получить зарплату', '1', '2016-05-20');
INSERT INTO `test1`.`deal` (`business`, `done`, `add_date`) VALUES ('Прогулять зарплату', '0', '2016-05-20');
INSERT INTO `test1`.`deal` (`business`, `done`, `add_date`) VALUES ('Заснуть', '0', '2016-05-20');
INSERT INTO `test1`.`deal` (`business`, `done`, `add_date`) VALUES ('Проснуться', '0', '2016-05-21');
INSERT INTO `test1`.`deal` (`business`, `done`, `add_date`) VALUES ('Покушать', '0', '2016-05-21');
INSERT INTO `test1`.`deal` (`business`, `done`, `add_date`) VALUES ('Отдохнуть', '0', '2016-05-21');
INSERT INTO `test1`.`deal` (`business`, `done`, `add_date`) VALUES ('Еще Отдохнуть', '0', '2016-05-21');
INSERT INTO `test1`.`deal` (`business`, `done`, `add_date`) VALUES ('И еще отдохнуть :)', '0', '2016-05-21');
