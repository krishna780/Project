CREATE TABLE `enrolee` (
 `id` int NOT NULL AUTO_INCREMENT,
 `name` varchar(45) NOT NULL,
 `dob` date NOT NULL,
 `phoneNo` varchar(45) DEFAULT NULL,
 `activation_status` bit(1) DEFAULT NULL,
 PRIMARY KEY (`id`)
);
