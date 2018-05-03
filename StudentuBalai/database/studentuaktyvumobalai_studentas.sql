DROP TABLE IF EXISTS `studentas`;

CREATE TABLE `studentas` (
  `studento_nr` int(8) NOT NULL,
  `vardas` varchar(45) NOT NULL,
  `pavarde` varchar(45) NOT NULL,
  `grupes_kodas` varchar(10) NOT NULL,
  PRIMARY KEY (`studento_nr`),
  KEY `grupes_kodas_idx` (`grupes_kodas`),
  CONSTRAINT `` FOREIGN KEY (`grupes_kodas`) REFERENCES `grupe` (`kodas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `studentas` WRITE;
/*!40000 ALTER TABLE `studentas` DISABLE KEYS */;
INSERT INTO `studentas` VALUES (20152658,'Adriana','Šabanaitė','PRIf-15/3'),(20153214,'Jonas','Jonaitis','PRIf-14/3'),(20153333,'Jonas','Jonaitis','PRIf-15/3'),(20153568,'Vaida','Juzenaite','PRIf-15/3'),(20158963,'Petras','Petraitis','PRIf-15/1');
/*!40000 ALTER TABLE `studentas` ENABLE KEYS */;
UNLOCK TABLES;

