-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: world
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `countrylanguage`
--

DROP TABLE IF EXISTS `countrylanguage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countrylanguage` (
  `CountryCode` char(3) NOT NULL DEFAULT '',
  `Language` char(30) NOT NULL DEFAULT '',
  `IsOfficial` enum('T','F') NOT NULL DEFAULT 'F',
  `Percentage` decimal(4,1) NOT NULL DEFAULT '0.0',
  PRIMARY KEY (`CountryCode`,`Language`),
  KEY `CountryCode` (`CountryCode`),
  CONSTRAINT `countryLanguage_ibfk_1` FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countrylanguage`
--

LOCK TABLES `countrylanguage` WRITE;
/*!40000 ALTER TABLE `countrylanguage` DISABLE KEYS */;
INSERT INTO `countrylanguage` VALUES ('ABW','Dutch','T',5.3),('ABW','English','F',9.5),('ABW','Papiamento','F',76.7),('ABW','Spanish','F',7.4),('AFG','Balochi','F',0.9),('AFG','Dari','T',32.1),('AFG','Pashto','T',52.4),('AFG','Turkmenian','F',1.9),('AFG','Uzbek','F',8.8),('AGO','Ambo','F',2.4),('AGO','Chokwe','F',4.2),('AGO','Kongo','F',13.2),('AGO','Luchazi','F',2.4),('AGO','Luimbe-nganguela','F',5.4),('AGO','Luvale','F',3.6),('AGO','Mbundu','F',21.6),('AGO','Nyaneka-nkhumbi','F',5.4),('AGO','Ovimbundu','F',37.2),('AIA','English','T',0.0),('ALB','Albaniana','T',97.9),('ALB','Greek','F',1.8),('ALB','Macedonian','F',0.1),('AND','Catalan','T',32.3),('AND','French','F',6.2),('AND','Portuguese','F',10.8),('AND','Spanish','F',44.6),('ANT','Dutch','T',0.0),('ANT','English','F',7.8),('ANT','Papiamento','T',86.2),('ARE','Arabic','T',42.0),('ARE','Hindi','F',0.0),('ARG','Indian Languages','F',0.3),('ARG','Italian','F',1.7),('ARG','Spanish','T',96.8),('ARM','Armenian','T',93.4),('ARM','Azerbaijani','F',2.6),('ASM','English','T',3.1),('ASM','Samoan','T',90.6),('ASM','Tongan','F',3.1),('ATG','Creole English','F',95.7),('ATG','English','T',0.0),('AUS','Arabic','F',1.0),('AUS','Canton Chinese','F',1.1),('AUS','English','T',81.2),('AUS','German','F',0.6),('AUS','Greek','F',1.6),('AUS','Italian','F',2.2),('AUS','Serbo-Croatian','F',0.6),('AUS','Vietnamese','F',0.8),('AUT','Czech','F',0.2),('AUT','German','T',92.0),('AUT','Hungarian','F',0.4),('AUT','Polish','F',0.2),('AUT','Romanian','F',0.2),('AUT','Serbo-Croatian','F',2.2),('AUT','Slovene','F',0.4),('AUT','Turkish','F',1.5),('AZE','Armenian','F',2.0),('AZE','Azerbaijani','T',89.0),('AZE','Lezgian','F',2.3),('AZE','Russian','F',3.0),('BDI','French','T',0.0),('BDI','Kirundi','T',98.1),('BDI','Swahili','F',0.0),('BEL','Arabic','F',1.6),('BEL','Dutch','T',59.2),('BEL','French','T',32.6),('BEL','German','T',1.0),('BEL','Italian','F',2.4),('BEL','Turkish','F',0.9),('BEN','Adja','F',11.1),('BEN','Aizo','F',8.7),('BEN','Bariba','F',8.7),('BEN','Fon','F',39.8),('BEN','Ful','F',5.6),('BEN','Joruba','F',12.2),('BEN','Somba','F',6.7),('BFA','Busansi','F',3.5),('BFA','Dagara','F',3.1),('BFA','Dyula','F',2.6),('BFA','Ful','F',9.7),('BFA','Gurma','F',5.7),('BFA','Mossi','F',50.2),('BGD','Bengali','T',97.7),('BGD','Chakma','F',0.4),('BGD','Garo','F',0.1),('BGD','Khasi','F',0.1),('BGD','Marma','F',0.2),('BGD','Santhali','F',0.1),('BGD','Tripuri','F',0.1),('BGR','Bulgariana','T',83.2),('BGR','Macedonian','F',2.6),('BGR','Romani','F',3.7),('BGR','Turkish','F',9.4),('BHR','Arabic','T',67.7),('BHR','English','F',0.0),('BHS','Creole English','F',89.7),('BHS','Creole French','F',10.3),('BIH','Serbo-Croatian','T',99.2),('BLR','Belorussian','T',65.6),('BLR','Polish','F',0.6),('BLR','Russian','T',32.0),('BLR','Ukrainian','F',1.3),('BLZ','English','T',50.8),('BLZ','Garifuna','F',6.8),('BLZ','Maya Languages','F',9.6),('BLZ','Spanish','F',31.6),('BMU','English','T',100.0),('BOL','Aimará','T',3.2),('BOL','Guaraní','F',0.1),('BOL','Ketšua','T',8.1),('BOL','Spanish','T',87.7),('BRA','German','F',0.5),('BRA','Indian Languages','F',0.2),('BRA','Italian','F',0.4),('BRA','Japanese','F',0.4),('BRA','Portuguese','T',97.5),('BRB','Bajan','F',95.1),('BRB','English','T',0.0),('BRN','Chinese','F',9.3),('BRN','English','F',3.1),('BRN','Malay','T',45.5),('BRN','Malay-English','F',28.8),('BTN','Asami','F',15.2),('BTN','Dzongkha','T',50.0),('BTN','Nepali','F',34.8),('BWA','Khoekhoe','F',2.5),('BWA','Ndebele','F',1.3),('BWA','San','F',3.5),('BWA','Shona','F',12.3),('BWA','Tswana','F',75.5),('CAF','Banda','F',23.5),('CAF','Gbaya','F',23.8),('CAF','Mandjia','F',14.8),('CAF','Mbum','F',6.4),('CAF','Ngbaka','F',7.5),('CAF','Sara','F',6.4),('CAN','Chinese','F',2.5),('CAN','Dutch','F',0.5),('CAN','English','T',60.4),('CAN','Eskimo Languages','F',0.1),('CAN','French','T',23.4),('CAN','German','F',1.6),('CAN','Italian','F',1.7),('CAN','Polish','F',0.7),('CAN','Portuguese','F',0.7),('CAN','Punjabi','F',0.7),('CAN','Spanish','F',0.7),('CAN','Ukrainian','F',0.6),('CCK','English','T',0.0),('CCK','Malay','F',0.0),('CHE','French','T',19.2),('CHE','German','T',63.6),('CHE','Italian','T',7.7),('CHE','Romansh','T',0.6),('CHL','Aimará','F',0.5),('CHL','Araucan','F',9.6),('CHL','Rapa nui','F',0.2),('CHL','Spanish','T',89.7),('CHN','Chinese','T',92.0),('CHN','Dong','F',0.2),('CHN','Hui','F',0.8),('CHN','Mantšu','F',0.9),('CHN','Miao','F',0.7),('CHN','Mongolian','F',0.4),('CHN','Puyi','F',0.2),('CHN','Tibetan','F',0.4),('CHN','Tujia','F',0.5),('CHN','Uighur','F',0.6),('CHN','Yi','F',0.6),('CHN','Zhuang','F',1.4),('CIV','[South]Mande','F',7.7),('CIV','Akan','F',30.0),('CIV','Gur','F',11.7),('CIV','Kru','F',10.5),('CIV','Malinke','F',11.4),('CMR','Bamileke-bamum','F',18.6),('CMR','Duala','F',10.9),('CMR','Fang','F',19.7),('CMR','Ful','F',9.6),('CMR','Maka','F',4.9),('CMR','Mandara','F',5.7),('CMR','Masana','F',3.9),('CMR','Tikar','F',7.4),('COD','Boa','F',2.3),('COD','Chokwe','F',1.8),('COD','Kongo','F',16.0),('COD','Luba','F',18.0),('COD','Mongo','F',13.5),('COD','Ngala and Bangi','F',5.8),('COD','Rundi','F',3.8),('COD','Rwanda','F',10.3),('COD','Teke','F',2.7),('COD','Zande','F',6.1),('COG','Kongo','F',51.5),('COG','Mbete','F',4.8),('COG','Mboshi','F',11.4),('COG','Punu','F',2.9),('COG','Sango','F',2.6),('COG','Teke','F',17.3),('COK','English','F',0.0),('COK','Maori','T',0.0),('COL','Arawakan','F',0.1),('COL','Caribbean','F',0.1),('COL','Chibcha','F',0.4),('COL','Creole English','F',0.1),('COL','Spanish','T',99.0),('COM','Comorian','T',75.0),('COM','Comorian-Arabic','F',1.6),('COM','Comorian-French','F',12.9),('COM','Comorian-madagassi','F',5.5),('COM','Comorian-Swahili','F',0.5),('CPV','Crioulo','F',100.0),('CPV','Portuguese','T',0.0),('CRI','Chibcha','F',0.3),('CRI','Chinese','F',0.2),('CRI','Creole English','F',2.0),('CRI','Spanish','T',97.5),('CUB','Spanish','T',100.0),('CXR','Chinese','F',0.0),('CXR','English','T',0.0),('CYM','English','T',0.0),('CYP','Greek','T',74.1),('CYP','Turkish','T',22.4),('CZE','Czech','T',81.2),('CZE','German','F',0.5),('CZE','Hungarian','F',0.2),('CZE','Moravian','F',12.9),('CZE','Polish','F',0.6),('CZE','Romani','F',0.3),('CZE','Silesiana','F',0.4),('CZE','Slovak','F',3.1),('DEU','German','T',91.3),('DEU','Greek','F',0.4),('DEU','Italian','F',0.7),('DEU','Polish','F',0.3),('DEU','Southern Slavic Languages','F',1.4),('DEU','Turkish','F',2.6),('DJI','Afar','F',34.8),('DJI','Arabic','T',10.6),('DJI','Somali','F',43.9),('DMA','Creole English','F',100.0),('DMA','Creole French','F',0.0),('DNK','Arabic','F',0.7),('DNK','Danish','T',93.5),('DNK','English','F',0.3),('DNK','German','F',0.5),('DNK','Norwegian','F',0.3),('DNK','Swedish','F',0.3),('DNK','Turkish','F',0.8),('DOM','Creole French','F',2.0),('DOM','Spanish','T',98.0),('DZA','Arabic','T',86.0),('DZA','Berberi','F',14.0),('ECU','Ketšua','F',7.0),('ECU','Spanish','T',93.0),('EGY','Arabic','T',98.8),('EGY','Sinaberberi','F',0.0),('ERI','Afar','F',4.3),('ERI','Bilin','F',3.0),('ERI','Hadareb','F',3.8),('ERI','Saho','F',3.0),('ERI','Tigre','F',31.7),('ERI','Tigrinja','T',49.1),('ESH','Arabic','T',100.0),('ESP','Basque','F',1.6),('ESP','Catalan','F',16.9),('ESP','Galecian','F',6.4),('ESP','Spanish','T',74.4),('EST','Belorussian','F',1.4),('EST','Estonian','T',65.3),('EST','Finnish','F',0.7),('EST','Russian','F',27.8),('EST','Ukrainian','F',2.8),('ETH','Amhara','F',30.0),('ETH','Gurage','F',4.7),('ETH','Oromo','F',31.0),('ETH','Sidamo','F',3.2),('ETH','Somali','F',4.1),('ETH','Tigrinja','F',7.2),('ETH','Walaita','F',2.8),('FIN','Estonian','F',0.2),('FIN','Finnish','T',92.7),('FIN','Russian','F',0.4),('FIN','Saame','F',0.0),('FIN','Swedish','T',5.7),('FJI','Fijian','T',50.8),('FJI','Hindi','F',43.7),('FLK','English','T',0.0),('FRA','Arabic','F',2.5),('FRA','French','T',93.6),('FRA','Italian','F',0.4),('FRA','Portuguese','F',1.2),('FRA','Spanish','F',0.4),('FRA','Turkish','F',0.4),('FRO','Danish','T',0.0),('FRO','Faroese','T',100.0),('FSM','Kosrean','F',7.3),('FSM','Mortlock','F',7.6),('FSM','Pohnpei','F',23.8),('FSM','Trukese','F',41.6),('FSM','Wolea','F',3.7),('FSM','Yap','F',5.8),('GAB','Fang','F',35.8),('GAB','Mbete','F',13.8),('GAB','Mpongwe','F',14.6),('GAB','Punu-sira-nzebi','F',17.1),('GBR','English','T',97.3),('GBR','Gaeli','F',0.1),('GBR','Kymri','F',0.9),('GEO','Abhyasi','F',1.7),('GEO','Armenian','F',6.8),('GEO','Azerbaijani','F',5.5),('GEO','Georgiana','T',71.7),('GEO','Osseetti','F',2.4),('GEO','Russian','F',8.8),('GHA','Akan','F',52.4),('GHA','Ewe','F',11.9),('GHA','Ga-adangme','F',7.8),('GHA','Gurma','F',3.3),('GHA','Joruba','F',1.3),('GHA','Mossi','F',15.8),('GIB','Arabic','F',7.4),('GIB','English','T',88.9),('GIN','Ful','F',38.6),('GIN','Kissi','F',6.0),('GIN','Kpelle','F',4.6),('GIN','Loma','F',2.3),('GIN','Malinke','F',23.2),('GIN','Susu','F',11.0),('GIN','Yalunka','F',2.9),('GLP','Creole French','F',95.0),('GLP','French','T',0.0),('GMB','Diola','F',9.2),('GMB','Ful','F',16.2),('GMB','Malinke','F',34.1),('GMB','Soninke','F',7.6),('GMB','Wolof','F',12.6),('GNB','Balante','F',14.6),('GNB','Crioulo','F',36.4),('GNB','Ful','F',16.6),('GNB','Malinke','F',6.9),('GNB','Mandyako','F',4.9),('GNB','Portuguese','T',8.1),('GNQ','Bubi','F',8.7),('GNQ','Fang','F',84.8),('GRC','Greek','T',98.5),('GRC','Turkish','F',0.9),('GRD','Creole English','F',100.0),('GRL','Danish','T',12.5),('GRL','Greenlandic','T',87.5),('GTM','Cakchiquel','F',8.9),('GTM','Kekchí','F',4.9),('GTM','Mam','F',2.7),('GTM','Quiché','F',10.1),('GTM','Spanish','T',64.7),('GUF','Creole French','F',94.3),('GUF','Indian Languages','F',1.9),('GUM','Chamorro','T',29.6),('GUM','English','T',37.5),('GUM','Japanese','F',2.0),('GUM','Korean','F',3.3),('GUM','Philippene Languages','F',19.7),('GUY','Arawakan','F',1.4),('GUY','Caribbean','F',2.2),('GUY','Creole English','F',96.4),('HKG','Canton Chinese','F',88.7),('HKG','Chiu chau','F',1.4),('HKG','English','T',2.2),('HKG','Fukien','F',1.9),('HKG','Hakka','F',1.6),('HND','Creole English','F',0.2),('HND','Garifuna','F',1.3),('HND','Miskito','F',0.2),('HND','Spanish','T',97.2),('HRV','Serbo-Croatian','T',95.9),('HRV','Slovene','F',0.0),('HTI','French','T',0.0),('HTI','Haiti Creole','F',100.0),('HUN','German','F',0.4),('HUN','Hungarian','T',98.5),('HUN','Romani','F',0.5),('HUN','Romanian','F',0.1),('HUN','Serbo-Croatian','F',0.2),('HUN','Slovak','F',0.1),('IDN','Bali','F',1.7),('IDN','Banja','F',1.8),('IDN','Batakki','F',2.2),('IDN','Bugi','F',2.2),('IDN','Javanese','F',39.4),('IDN','Madura','F',4.3),('IDN','Malay','T',12.1),('IDN','Minangkabau','F',2.4),('IDN','Sunda','F',15.8),('IND','Asami','F',1.5),('IND','Bengali','F',8.2),('IND','Gujarati','F',4.8),('IND','Hindi','T',39.9),('IND','Kannada','F',3.9),('IND','Malajalam','F',3.6),('IND','Marathi','F',7.4),('IND','Orija','F',3.3),('IND','Punjabi','F',2.8),('IND','Tamil','F',6.3),('IND','Telugu','F',7.8),('IND','Urdu','F',5.1),('IRL','English','T',98.4),('IRL','Irish','T',1.6),('IRN','Arabic','F',2.2),('IRN','Azerbaijani','F',16.8),('IRN','Bakhtyari','F',1.7),('IRN','Balochi','F',2.3),('IRN','Gilaki','F',5.3),('IRN','Kurdish','F',9.1),('IRN','Luri','F',4.3),('IRN','Mazandarani','F',3.6),('IRN','Persian','T',45.7),('IRN','Turkmenian','F',1.6),('IRQ','Arabic','T',77.2),('IRQ','Assyrian','F',0.8),('IRQ','Azerbaijani','F',1.7),('IRQ','Kurdish','F',19.0),('IRQ','Persian','F',0.8),('ISL','English','F',0.0),('ISL','Icelandic','T',95.7),('ISR','Arabic','T',18.0),('ISR','Hebrew','T',63.1),('ISR','Russian','F',8.9),('ITA','Albaniana','F',0.2),('ITA','French','F',0.5),('ITA','Friuli','F',1.2),('ITA','German','F',0.5),('ITA','Italian','T',94.1),('ITA','Romani','F',0.2),('ITA','Sardinian','F',2.7),('ITA','Slovene','F',0.2),('JAM','Creole English','F',94.2),('JAM','Hindi','F',1.9),('JOR','Arabic','T',97.9),('JOR','Armenian','F',1.0),('JOR','Circassian','F',1.0),('JPN','Ainu','F',0.0),('JPN','Chinese','F',0.2),('JPN','English','F',0.1),('JPN','Japanese','T',99.1),('JPN','Korean','F',0.5),('JPN','Philippene Languages','F',0.1),('KAZ','German','F',3.1),('KAZ','Kazakh','T',46.0),('KAZ','Russian','F',34.7),('KAZ','Tatar','F',2.0),('KAZ','Ukrainian','F',5.0),('KAZ','Uzbek','F',2.3),('KEN','Gusii','F',6.1),('KEN','Kalenjin','F',10.8),('KEN','Kamba','F',11.2),('KEN','Kikuyu','F',20.9),('KEN','Luhya','F',13.8),('KEN','Luo','F',12.8),('KEN','Masai','F',1.6),('KEN','Meru','F',5.5),('KEN','Nyika','F',4.8),('KEN','Turkana','F',1.4),('KGZ','Kazakh','F',0.8),('KGZ','Kirgiz','T',59.7),('KGZ','Russian','T',16.2),('KGZ','Tadzhik','F',0.8),('KGZ','Tatar','F',1.3),('KGZ','Ukrainian','F',1.7),('KGZ','Uzbek','F',14.1),('KHM','Chinese','F',3.1),('KHM','Khmer','T',88.6),('KHM','Tšam','F',2.4),('KHM','Vietnamese','F',5.5),('KIR','Kiribati','T',98.9),('KIR','Tuvalu','F',0.5),('KNA','Creole English','F',100.0),('KNA','English','T',0.0),('KOR','Chinese','F',0.1),('KOR','Korean','T',99.9),('KWT','Arabic','T',78.1),('KWT','English','F',0.0),('LAO','Lao','T',67.2),('LAO','Lao-Soung','F',5.2),('LAO','Mon-khmer','F',16.5),('LAO','Thai','F',7.8),('LBN','Arabic','T',93.0),('LBN','Armenian','F',5.9),('LBN','French','F',0.0),('LBR','Bassa','F',13.7),('LBR','Gio','F',7.9),('LBR','Grebo','F',8.9),('LBR','Kpelle','F',19.5),('LBR','Kru','F',7.2),('LBR','Loma','F',5.8),('LBR','Malinke','F',5.1),('LBR','Mano','F',7.2),('LBY','Arabic','T',96.0),('LBY','Berberi','F',1.0),('LCA','Creole French','F',80.0),('LCA','English','T',20.0),('LIE','German','T',89.0),('LIE','Italian','F',2.5),('LIE','Turkish','F',2.5),('LKA','Mixed Languages','F',19.6),('LKA','Singali','T',60.3),('LKA','Tamil','T',19.6),('LSO','English','T',0.0),('LSO','Sotho','T',85.0),('LSO','Zulu','F',15.0),('LTU','Belorussian','F',1.4),('LTU','Lithuanian','T',81.6),('LTU','Polish','F',7.0),('LTU','Russian','F',8.1),('LTU','Ukrainian','F',1.1),('LUX','French','T',4.2),('LUX','German','T',2.3),('LUX','Italian','F',4.6),('LUX','Luxembourgish','T',64.4),('LUX','Portuguese','F',13.0),('LVA','Belorussian','F',4.1),('LVA','Latvian','T',55.1),('LVA','Lithuanian','F',1.2),('LVA','Polish','F',2.1),('LVA','Russian','F',32.5),('LVA','Ukrainian','F',2.9),('MAC','Canton Chinese','F',85.6),('MAC','English','F',0.5),('MAC','Mandarin Chinese','F',1.2),('MAC','Portuguese','T',2.3),('MAR','Arabic','T',65.0),('MAR','Berberi','F',33.0),('MCO','English','F',6.5),('MCO','French','T',41.9),('MCO','Italian','F',16.1),('MCO','Monegasque','F',16.1),('MDA','Bulgariana','F',1.6),('MDA','Gagauzi','F',3.2),('MDA','Romanian','T',61.9),('MDA','Russian','F',23.2),('MDA','Ukrainian','F',8.6),('MDG','French','T',0.0),('MDG','Malagasy','T',98.9),('MDV','Dhivehi','T',100.0),('MDV','English','F',0.0),('MEX','Mixtec','F',0.6),('MEX','Náhuatl','F',1.8),('MEX','Otomí','F',0.4),('MEX','Spanish','T',92.1),('MEX','Yucatec','F',1.1),('MEX','Zapotec','F',0.6),('MHL','English','T',0.0),('MHL','Marshallese','T',96.8),('MKD','Albaniana','F',22.9),('MKD','Macedonian','T',66.5),('MKD','Romani','F',2.3),('MKD','Serbo-Croatian','F',2.0),('MKD','Turkish','F',4.0),('MLI','Bambara','F',31.8),('MLI','Ful','F',13.9),('MLI','Senufo and Minianka','F',12.0),('MLI','Songhai','F',6.9),('MLI','Soninke','F',8.7),('MLI','Tamashek','F',7.3),('MLT','English','T',2.1),('MLT','Maltese','T',95.8),('MMR','Burmese','T',69.0),('MMR','Chin','F',2.2),('MMR','Kachin','F',1.4),('MMR','Karen','F',6.2),('MMR','Kayah','F',0.4),('MMR','Mon','F',2.4),('MMR','Rakhine','F',4.5),('MMR','Shan','F',8.5),('MNG','Bajad','F',1.9),('MNG','Buryat','F',1.7),('MNG','Dariganga','F',1.4),('MNG','Dorbet','F',2.7),('MNG','Kazakh','F',5.9),('MNG','Mongolian','T',78.8),('MNP','Carolinian','F',4.8),('MNP','Chamorro','F',30.0),('MNP','Chinese','F',7.1),('MNP','English','T',4.8),('MNP','Korean','F',6.5),('MNP','Philippene Languages','F',34.1),('MOZ','Chuabo','F',5.7),('MOZ','Lomwe','F',7.8),('MOZ','Makua','F',27.8),('MOZ','Marendje','F',3.5),('MOZ','Nyanja','F',3.3),('MOZ','Ronga','F',3.7),('MOZ','Sena','F',9.4),('MOZ','Shona','F',6.5),('MOZ','Tsonga','F',12.4),('MOZ','Tswa','F',6.0),('MRT','Ful','F',1.2),('MRT','Hassaniya','F',81.7),('MRT','Soninke','F',2.7),('MRT','Tukulor','F',5.4),('MRT','Wolof','F',6.6),('MRT','Zenaga','F',1.2),('MSR','English','T',0.0),('MTQ','Creole French','F',96.6),('MTQ','French','T',0.0),('MUS','Bhojpuri','F',21.1),('MUS','Creole French','F',70.6),('MUS','French','F',3.4),('MUS','Hindi','F',1.2),('MUS','Marathi','F',0.7),('MUS','Tamil','F',0.8),('MWI','Chichewa','T',58.3),('MWI','Lomwe','F',18.4),('MWI','Ngoni','F',6.7),('MWI','Yao','F',13.2),('MYS','Chinese','F',9.0),('MYS','Dusun','F',1.1),('MYS','English','F',1.6),('MYS','Iban','F',2.8),('MYS','Malay','T',58.4),('MYS','Tamil','F',3.9),('MYT','French','T',20.3),('MYT','Mahoré','F',41.9),('MYT','Malagasy','F',16.1),('NAM','Afrikaans','F',9.5),('NAM','Caprivi','F',4.7),('NAM','German','F',0.9),('NAM','Herero','F',8.0),('NAM','Kavango','F',9.7),('NAM','Nama','F',12.4),('NAM','Ovambo','F',50.7),('NAM','San','F',1.9),('NCL','French','T',34.3),('NCL','Malenasian Languages','F',45.4),('NCL','Polynesian Languages','F',11.6),('NER','Ful','F',9.7),('NER','Hausa','F',53.1),('NER','Kanuri','F',4.4),('NER','Songhai-zerma','F',21.2),('NER','Tamashek','F',10.4),('NFK','English','T',0.0),('NGA','Bura','F',1.6),('NGA','Edo','F',3.3),('NGA','Ful','F',11.3),('NGA','Hausa','F',21.1),('NGA','Ibibio','F',5.6),('NGA','Ibo','F',18.1),('NGA','Ijo','F',1.8),('NGA','Joruba','F',21.4),('NGA','Kanuri','F',4.1),('NGA','Tiv','F',2.3),('NIC','Creole English','F',0.5),('NIC','Miskito','F',1.6),('NIC','Spanish','T',97.6),('NIC','Sumo','F',0.2),('NIU','English','T',0.0),('NIU','Niue','F',0.0),('NLD','Arabic','F',0.9),('NLD','Dutch','T',95.6),('NLD','Fries','F',3.7),('NLD','Turkish','F',0.8),('NOR','Danish','F',0.4),('NOR','English','F',0.5),('NOR','Norwegian','T',96.6),('NOR','Saame','F',0.0),('NOR','Swedish','F',0.3),('NPL','Bhojpuri','F',7.5),('NPL','Hindi','F',3.0),('NPL','Maithili','F',11.9),('NPL','Nepali','T',50.4),('NPL','Newari','F',3.7),('NPL','Tamang','F',4.9),('NPL','Tharu','F',5.4),('NRU','Chinese','F',8.5),('NRU','English','T',7.5),('NRU','Kiribati','F',17.9),('NRU','Nauru','T',57.5),('NRU','Tuvalu','F',8.5),('NZL','English','T',87.0),('NZL','Maori','F',4.3),('OMN','Arabic','T',76.7),('OMN','Balochi','F',0.0),('PAK','Balochi','F',3.0),('PAK','Brahui','F',1.2),('PAK','Hindko','F',2.4),('PAK','Pashto','F',13.1),('PAK','Punjabi','F',48.2),('PAK','Saraiki','F',9.8),('PAK','Sindhi','F',11.8),('PAK','Urdu','T',7.6),('PAN','Arabic','F',0.6),('PAN','Creole English','F',14.0),('PAN','Cuna','F',2.0),('PAN','Embera','F',0.6),('PAN','Guaymí','F',5.3),('PAN','Spanish','T',76.8),('PCN','Pitcairnese','F',0.0),('PER','Aimará','T',2.3),('PER','Ketšua','T',16.4),('PER','Spanish','T',79.8),('PHL','Bicol','F',5.7),('PHL','Cebuano','F',23.3),('PHL','Hiligaynon','F',9.1),('PHL','Ilocano','F',9.3),('PHL','Maguindanao','F',1.4),('PHL','Maranao','F',1.3),('PHL','Pampango','F',3.0),('PHL','Pangasinan','F',1.8),('PHL','Pilipino','T',29.3),('PHL','Waray-waray','F',3.8),('PLW','Chinese','F',1.6),('PLW','English','T',3.2),('PLW','Palau','T',82.2),('PLW','Philippene Languages','F',9.2),('PNG','Malenasian Languages','F',20.0),('PNG','Papuan Languages','F',78.1),('POL','Belorussian','F',0.5),('POL','German','F',1.3),('POL','Polish','T',97.6),('POL','Ukrainian','F',0.6),('PRI','English','F',47.4),('PRI','Spanish','T',51.3),('PRK','Chinese','F',0.1),('PRK','Korean','T',99.9),('PRT','Portuguese','T',99.0),('PRY','German','F',0.9),('PRY','Guaraní','T',40.1),('PRY','Portuguese','F',3.2),('PRY','Spanish','T',55.1),('PSE','Arabic','F',95.9),('PSE','Hebrew','F',4.1),('PYF','Chinese','F',2.9),('PYF','French','T',40.8),('PYF','Tahitian','F',46.4),('QAT','Arabic','T',40.7),('QAT','Urdu','F',0.0),('REU','Chinese','F',2.8),('REU','Comorian','F',2.8),('REU','Creole French','F',91.5),('REU','Malagasy','F',1.4),('REU','Tamil','F',0.0),('ROM','German','F',0.4),('ROM','Hungarian','F',7.2),('ROM','Romani','T',0.7),('ROM','Romanian','T',90.7),('ROM','Serbo-Croatian','F',0.1),('ROM','Ukrainian','F',0.3),('RUS','Avarian','F',0.4),('RUS','Bashkir','F',0.7),('RUS','Belorussian','F',0.3),('RUS','Chechen','F',0.6),('RUS','Chuvash','F',0.9),('RUS','Kazakh','F',0.4),('RUS','Mari','F',0.4),('RUS','Mordva','F',0.5),('RUS','Russian','T',86.6),('RUS','Tatar','F',3.2),('RUS','Udmur','F',0.3),('RUS','Ukrainian','F',1.3),('RWA','French','T',0.0),('RWA','Rwanda','T',100.0),('SAU','Arabic','T',95.0),('SDN','Arabic','T',49.4),('SDN','Bari','F',2.5),('SDN','Beja','F',6.4),('SDN','Chilluk','F',1.7),('SDN','Dinka','F',11.5),('SDN','Fur','F',2.1),('SDN','Lotuko','F',1.5),('SDN','Nubian Languages','F',8.1),('SDN','Nuer','F',4.9),('SDN','Zande','F',2.7),('SEN','Diola','F',5.0),('SEN','Ful','F',21.7),('SEN','Malinke','F',3.8),('SEN','Serer','F',12.5),('SEN','Soninke','F',1.3),('SEN','Wolof','T',48.1),('SGP','Chinese','T',77.1),('SGP','Malay','T',14.1),('SGP','Tamil','T',7.4),('SHN','English','T',0.0),('SJM','Norwegian','T',0.0),('SJM','Russian','F',0.0),('SLB','Malenasian Languages','F',85.6),('SLB','Papuan Languages','F',8.6),('SLB','Polynesian Languages','F',3.8),('SLE','Bullom-sherbro','F',3.8),('SLE','Ful','F',3.8),('SLE','Kono-vai','F',5.1),('SLE','Kuranko','F',3.4),('SLE','Limba','F',8.3),('SLE','Mende','F',34.8),('SLE','Temne','F',31.8),('SLE','Yalunka','F',3.4),('SLV','Nahua','F',0.0),('SLV','Spanish','T',100.0),('SMR','Italian','T',100.0),('SOM','Arabic','T',0.0),('SOM','Somali','T',98.3),('SPM','French','T',0.0),('STP','Crioulo','F',86.3),('STP','French','F',0.7),('SUR','Hindi','F',0.0),('SUR','Sranantonga','F',81.0),('SVK','Czech and Moravian','F',1.1),('SVK','Hungarian','F',10.5),('SVK','Romani','F',1.7),('SVK','Slovak','T',85.6),('SVK','Ukrainian and Russian','F',0.6),('SVN','Hungarian','F',0.5),('SVN','Serbo-Croatian','F',7.9),('SVN','Slovene','T',87.9),('SWE','Arabic','F',0.8),('SWE','Finnish','F',2.4),('SWE','Norwegian','F',0.5),('SWE','Southern Slavic Languages','F',1.3),('SWE','Spanish','F',0.6),('SWE','Swedish','T',89.5),('SWZ','Swazi','T',89.9),('SWZ','Zulu','F',2.0),('SYC','English','T',3.8),('SYC','French','T',1.3),('SYC','Seselwa','F',91.3),('SYR','Arabic','T',90.0),('SYR','Kurdish','F',9.0),('TCA','English','T',0.0),('TCD','Arabic','T',12.3),('TCD','Gorane','F',6.2),('TCD','Hadjarai','F',6.7),('TCD','Kanem-bornu','F',9.0),('TCD','Mayo-kebbi','F',11.5),('TCD','Ouaddai','F',8.7),('TCD','Sara','F',27.7),('TCD','Tandjile','F',6.5),('TGO','Ane','F',5.7),('TGO','Ewe','T',23.2),('TGO','Gurma','F',3.4),('TGO','Kabyé','T',13.8),('TGO','Kotokoli','F',5.7),('TGO','Moba','F',5.4),('TGO','Naudemba','F',4.1),('TGO','Watyi','F',10.3),('THA','Chinese','F',12.1),('THA','Khmer','F',1.3),('THA','Kuy','F',1.1),('THA','Lao','F',26.9),('THA','Malay','F',3.6),('THA','Thai','T',52.6),('TJK','Russian','F',9.7),('TJK','Tadzhik','T',62.2),('TJK','Uzbek','F',23.2),('TKL','English','T',0.0),('TKL','Tokelau','F',0.0),('TKM','Kazakh','F',2.0),('TKM','Russian','F',6.7),('TKM','Turkmenian','T',76.7),('TKM','Uzbek','F',9.2),('TMP','Portuguese','T',0.0),('TMP','Sunda','F',0.0),('TON','English','T',0.0),('TON','Tongan','T',98.3),('TTO','Creole English','F',2.9),('TTO','English','F',93.5),('TTO','Hindi','F',3.4),('TUN','Arabic','T',69.9),('TUN','Arabic-French','F',26.3),('TUN','Arabic-French-English','F',3.2),('TUR','Arabic','F',1.4),('TUR','Kurdish','F',10.6),('TUR','Turkish','T',87.6),('TUV','English','T',0.0),('TUV','Kiribati','F',7.5),('TUV','Tuvalu','T',92.5),('TWN','Ami','F',0.6),('TWN','Atayal','F',0.4),('TWN','Hakka','F',11.0),('TWN','Mandarin Chinese','T',20.1),('TWN','Min','F',66.7),('TWN','Paiwan','F',0.3),('TZA','Chaga and Pare','F',4.9),('TZA','Gogo','F',3.9),('TZA','Ha','F',3.5),('TZA','Haya','F',5.9),('TZA','Hehet','F',6.9),('TZA','Luguru','F',4.9),('TZA','Makonde','F',5.9),('TZA','Nyakusa','F',5.4),('TZA','Nyamwesi','F',21.1),('TZA','Shambala','F',4.3),('TZA','Swahili','T',8.8),('UGA','Acholi','F',4.4),('UGA','Ganda','F',18.1),('UGA','Gisu','F',4.5),('UGA','Kiga','F',8.3),('UGA','Lango','F',5.9),('UGA','Lugbara','F',4.7),('UGA','Nkole','F',10.7),('UGA','Rwanda','F',3.2),('UGA','Soga','F',8.2),('UGA','Teso','F',6.0),('UKR','Belorussian','F',0.3),('UKR','Bulgariana','F',0.3),('UKR','Hungarian','F',0.3),('UKR','Polish','F',0.1),('UKR','Romanian','F',0.7),('UKR','Russian','F',32.9),('UKR','Ukrainian','T',64.7),('UMI','English','T',0.0),('URY','Spanish','T',95.7),('USA','Chinese','F',0.6),('USA','English','T',86.2),('USA','French','F',0.7),('USA','German','F',0.7),('USA','Italian','F',0.6),('USA','Japanese','F',0.2),('USA','Korean','F',0.3),('USA','Polish','F',0.3),('USA','Portuguese','F',0.2),('USA','Spanish','F',7.5),('USA','Tagalog','F',0.4),('USA','Vietnamese','F',0.2),('UZB','Karakalpak','F',2.0),('UZB','Kazakh','F',3.8),('UZB','Russian','F',10.9),('UZB','Tadzhik','F',4.4),('UZB','Tatar','F',1.8),('UZB','Uzbek','T',72.6),('VAT','Italian','T',0.0),('VCT','Creole English','F',99.1),('VCT','English','T',0.0),('VEN','Goajiro','F',0.4),('VEN','Spanish','T',96.9),('VEN','Warrau','F',0.1),('VGB','English','T',0.0),('VIR','English','T',81.7),('VIR','French','F',2.5),('VIR','Spanish','F',13.3),('VNM','Chinese','F',1.4),('VNM','Khmer','F',1.4),('VNM','Man','F',0.7),('VNM','Miao','F',0.9),('VNM','Muong','F',1.5),('VNM','Nung','F',1.1),('VNM','Thai','F',1.6),('VNM','Tho','F',1.8),('VNM','Vietnamese','T',86.8),('VUT','Bislama','T',56.6),('VUT','English','T',28.3),('VUT','French','T',14.2),('WLF','Futuna','F',0.0),('WLF','Wallis','F',0.0),('WSM','English','T',0.6),('WSM','Samoan','T',47.5),('WSM','Samoan-English','F',52.0),('YEM','Arabic','T',99.6),('YEM','Soqutri','F',0.0),('YUG','Albaniana','F',16.5),('YUG','Hungarian','F',3.4),('YUG','Macedonian','F',0.5),('YUG','Romani','F',1.4),('YUG','Serbo-Croatian','T',75.2),('YUG','Slovak','F',0.7),('ZAF','Afrikaans','T',14.3),('ZAF','English','T',8.5),('ZAF','Ndebele','F',1.5),('ZAF','Northsotho','F',9.1),('ZAF','Southsotho','F',7.6),('ZAF','Swazi','F',2.5),('ZAF','Tsonga','F',4.3),('ZAF','Tswana','F',8.1),('ZAF','Venda','F',2.2),('ZAF','Xhosa','T',17.7),('ZAF','Zulu','T',22.7),('ZMB','Bemba','F',29.7),('ZMB','Chewa','F',5.7),('ZMB','Lozi','F',6.4),('ZMB','Nsenga','F',4.3),('ZMB','Nyanja','F',7.8),('ZMB','Tongan','F',11.0),('ZWE','English','T',2.2),('ZWE','Ndebele','F',16.2),('ZWE','Nyanja','F',2.2),('ZWE','Shona','F',72.1);
/*!40000 ALTER TABLE `countrylanguage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-14 17:30:58
