-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: localhost    Database: projeto
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `advogados`
--

DROP TABLE IF EXISTS `advogados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `advogados` (
  `id` int NOT NULL,
  `nome` varchar(50) NOT NULL,
  `OAB` varchar(50) NOT NULL,
  `UF` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advogados`
--

LOCK TABLES `advogados` WRITE;
/*!40000 ALTER TABLE `advogados` DISABLE KEYS */;
INSERT INTO `advogados` VALUES (1,'Victor Sousa','27292','PB'),(2,'Maria Silva','82745','	SP'),(3,'João Pereira','18392','RJ'),(4,'Ana Costa','27384','MG'),(5,'Paulo Santos','73845','RS'),(6,'Carla Oliveira','	56472','BA'),(7,'Lucas Almeida','93827','PR'),(8,'Fernanda Lima','38291','	SC'),(9,'Rodrigo Azevedo','74921','DF'),(10,'Juliana Ribeiro','	19283','ES'),(11,'	Bruno Fernandes','82934','PE'),(12,'Larissa Barbosa','18374','GO'),(13,'Marcelo Andrade','49382','CE'),(14,'Tatiana Marques','28493','AM'),(15,'Eduardo Mendes','83947','AC');
/*!40000 ALTER TABLE `advogados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `CPF` varchar(50) NOT NULL,
  `Telefone` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `id_endereco` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_endereco` (`id_endereco`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Camila Moura','11701945678','83999141578','camilamoura@gmai.com',3),(2,'Maria Santana','31001987456','21998456723','mariasantos@gmail.com',4),(3,'João Silvio','21401568790','10120198545','joaosilva@gmail.com',2),(4,'Pedro Costa','41201698547','31999845236','pedrocosta@gmail.com',5),(5,'Ana Oliveira','51001987456','41998653247','anaoliveira@gmail.com',1),(6,'Lucas Pereira','61801478523','51999365214','lucaspereira@gmail.com',6),(7,'Beatriz Rocha','71401698745','61999541236','beatrizrocha@gmail.com',7),(8,'Carlos Lima','81001587436','71998856237','carloslima@gmail.com',8),(9,'Fernanda Alves','91201874523','81999785214','fernandaalves@gmail.com',10),(10,'Rafael Souza','10120198545','91999652147','rafaelsouza@gmail.com',9),(11,'aaaaa','10000','1000000000','asdasdasdasd',11),(12,'asdasd','11','111','11',12),(13,'aaa adsasdasdas','aaa asasdasd','aaa asdasdasdasdasd','aaa asdasdas',13);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `id` int NOT NULL,
  `CEP` varchar(50) NOT NULL,
  `Estado` varchar(50) NOT NULL,
  `Cidade` varchar(50) NOT NULL,
  `Bairro` varchar(50) NOT NULL,
  `Rua` varchar(50) NOT NULL,
  `Numero` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'58115001','Paraíba','Campina Grande','Centro','Arruda Câmara','104'),(2,'870000000','Paraná','Campo Mourão','Centro','Rua B','201'),(3,'870000001','São Paulo','São Paulo','Morumbi','Rua C','15'),(4,'870000002','Rio de Janeiro','Rio de Janeiro','Lapa','Rua D','305'),(5,'870000003','Minas Gerais','Belo Horizonte','Cruzes','	Rua E','123'),(6,'870000004','Rio Grande do Sul','Porto Alegre','Sul','Rua F','408'),(7,'870000005','Santa Catarina','Florianópolis','Ilha','Rua G','714'),(8,'870000006','Bahia','Salvador','Almeida','Rua H','	509'),(9,'870000007','Pernambuco','Recife','Pina','Rua I','820'),(10,'870000008','Ceará','Fortaleza','Enseada','	Rua J','213213'),(11,'7878787887','PR','asdasd','asdasda','asdasdasd','10'),(12,'7878787887','11','11','11','11','11'),(13,'87000000','PR','CM','asdasd','aaaasdasda asdasdasdasd','111');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `processo`
--

DROP TABLE IF EXISTS `processo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `processo` (
  `id` int NOT NULL,
  `id_cliente` int DEFAULT NULL,
  `id_Advogados` int DEFAULT NULL,
  `Numero_do_Processo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Vara` varchar(50) NOT NULL,
  `Comarca` varchar(50) NOT NULL,
  `Data_Protocolo` date NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Reu` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_Advogados` (`id_Advogados`),
  CONSTRAINT `processo_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `processo_ibfk_2` FOREIGN KEY (`id_Advogados`) REFERENCES `advogados` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processo`
--

LOCK TABLES `processo` WRITE;
/*!40000 ALTER TABLE `processo` DISABLE KEYS */;
INSERT INTO `processo` VALUES (1,1,1,'0060326-87.2018.8.26.0100','Segunda Cível','Campina Grande','2022-03-03','Arquivado','Carlos'),(2,2,5,'0070326-87.2019.8.26.0100','Primeira Criminal','João Pessoa','2019-05-04','Em andamento','Ana'),(3,3,6,'	0080326-87.2020.8.26.0100','Terceira Cível','Recife','2020-01-15','Sentenciado','João'),(4,10,9,'	0090326-87.2021.8.26.0100','Quarta Cível','Natal','2021-07-19','Em recurso','	Maria'),(5,9,11,'0100326-87.2022.8.26.0100','Primeiro JECRIM','Salvador','2022-09-25','Arquivado','José'),(6,8,12,'0110326-87.2023.8.26.0100','Quarta Federal','Fortaleza','2023-03-11','Em andamento','Pedro'),(7,7,15,'0110326-87.2023.8.26.0100','Quarta Criminal','Maceió','2023-05-07','Em análise','Laura'),(8,6,3,'0110326-87.2023.8.26.0100','Quarta Cível','Teresina','2023-11-22','Sentenciado','Marcos'),(9,5,7,'0140326-87.2016.8.26.0100','Primeira do Consumidor','São Luís','2016-12-10','Em recurso','Paula'),(10,1,2,'1111 asdasdad','asdsd asasdadsadsasd','asdasdasd asdasdas','2024-07-10','asdasdasd adsasdasda','asdasd asdasdasda');
/*!40000 ALTER TABLE `processo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'projeto'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-25 14:15:49
