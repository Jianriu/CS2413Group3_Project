/**Update this file whenever new tables are created*/

CREATE TABLE `CS2413`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fullName` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `CS2413`.`Users` 
ADD COLUMN `email` VARCHAR(45) NOT NULL AFTER `password`,
CHANGE COLUMN `fullName` `fullname` VARCHAR(45) NOT NULL ;
  