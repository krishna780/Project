 

Step 1 : Create tables in Mysql :
SQL Querries :
CREATE TABLE `dependent` (
 `id` int NOT NULL AUTO_INCREMENT,
 `name` varchar(45) NOT NULL,
 `dob` date NOT NULL,
 `enroleeId` int DEFAULT NULL,
 `enrolee_id` int DEFAULT NULL,
 PRIMARY KEY (`id`),
 KEY `FKnokaah6bprnbnqu8du9iymn2i` (`enrolee_id`),
 CONSTRAINT `FKnokaah6bprnbnqu8du9iymn2i` FOREIGN KEY (`enrolee_id`) REFERENCES `enrolee` (`id`)
);
