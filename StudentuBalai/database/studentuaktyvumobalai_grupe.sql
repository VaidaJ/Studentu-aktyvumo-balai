DROP TABLE IF EXISTS `grupe`;

CREATE TABLE `grupe` (
  `kodas` varchar(10) NOT NULL,
  `studiju_programa` varchar(45) NOT NULL,
  `stojimo_metai` year(4) NOT NULL,
  PRIMARY KEY (`kodas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `grupe` WRITE;
INSERT INTO `grupe` VALUES ('IIf-16/2','dgfdghdfgdf',2016),('PRIf-14/1','zdgagasgas',2014),('PRIf-14/3','Programų inžinerija',2014),('PRIf-15/1','faga',2015),('PRIf-15/3','Programų inžinerija',2015),('PRIf-16/2','Programų inžinerija',2016),('PRIf-16/4','Programų inžinerija',2016),('PRIf-17/1','Programų inžinerija',2017),('PRIf-17/2','Programų inžinerija',2017),('PRIf-17/3','Programų inžinerija',2017);
UNLOCK TABLES;
