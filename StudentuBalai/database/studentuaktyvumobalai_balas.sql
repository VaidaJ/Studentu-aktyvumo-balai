DROP TABLE IF EXISTS `balas`;

CREATE TABLE `balas` (
  `balo_id` int(11) NOT NULL AUTO_INCREMENT,
  `irasymo_data` date NOT NULL,
  `balai` int(11) NOT NULL,
  `paaiskinimas` varchar(100) NOT NULL,
  `studentas` int(11) NOT NULL,
  PRIMARY KEY (`balo_id`),
  KEY `studentas_idx` (`studentas`),
  CONSTRAINT `studentas` FOREIGN KEY (`studentas`) REFERENCES `studentas` (`studento_nr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


LOCK TABLES `balas` WRITE;
INSERT INTO `balas` VALUES (1,'2015-10-22',10,'Šnekėjo',20153568),(2,'2015-11-10',2,'Atsiskaitė',20153568),(3,'2017-11-25',20,'Atsiskaitė ankščiau',20153333),(7,'2017-11-24',5,'dgsdgsdg',20153333),(8,'2017-11-26',5,'Šnekėjo',20152658),(10,'2017-12-10',2,'',20152658);
UNLOCK TABLES;

