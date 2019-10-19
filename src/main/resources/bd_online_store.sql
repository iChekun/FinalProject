
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';



-- -----------------------------------------------------
-- Schema online_store
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `online_store` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci ;
USE `online_store` ;

-- -----------------------------------------------------
-- Table `online_store`.`contacts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`contacts` (
  `contactsId` VARCHAR(36) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phoneNumber` BIGINT(20) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `houseNumber` INT(11) NOT NULL,
  `apartmentNumber` INT(11) NOT NULL,
  PRIMARY KEY (`contactsId`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`userstatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`userstatus` (
  `userStatusId` VARCHAR(36) NOT NULL,
  `statusName` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`userStatusId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`users` (
  `userId` VARCHAR(36) NOT NULL,
  `contactsId` VARCHAR(36) NOT NULL,
  `userStatusId` VARCHAR(36) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `birthDate` DATE NOT NULL,
  `banned` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) ,
  INDEX `contactsID_idx` (`contactsId` ASC) ,
  INDEX `user_status_id_idx` (`userStatusId` ASC) VISIBLE,
  CONSTRAINT `contactsId`
    FOREIGN KEY (`contactsId`)
    REFERENCES `online_store`.`contacts` (`contactsId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `userStatusId`
    FOREIGN KEY (`userStatusId`)
    REFERENCES `online_store`.`userstatus` (`userStatusId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`baskets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`baskets` (
  `basketId` VARCHAR(36) NOT NULL,
  `userId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`basketId`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC) ,
  UNIQUE INDEX `basketId_UNIQUE` (`basketId` ASC) ,
  INDEX `user_id_basket_idx` (`userId` ASC) ,
  CONSTRAINT `userIdBasket`
    FOREIGN KEY (`userId`)
    REFERENCES `online_store`.`users` (`userId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`brands`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`brands` (
  `brandId` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(256) NULL DEFAULT '-',
  `imagePath` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`brandId`),
  UNIQUE INDEX `brand_name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`categories` (
  `categoryId` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(256) NULL DEFAULT '-',
  `imagePath` VARCHAR(40) NULL DEFAULT 'no image',
  PRIMARY KEY (`categoryId`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`orderstatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`orderstatus` (
  `orderStatusId` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`orderStatusId`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) ,
  UNIQUE INDEX `orderStatusId_UNIQUE` (`orderStatusId` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`paymentmethods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`paymentmethods` (
  `paymentMethodId` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL DEFAULT 'cash' COMMENT ' (WebMoney, VISA, MasterCard, PayPal или наличные',
  PRIMARY KEY (`paymentMethodId`),
  UNIQUE INDEX `payment_method_id_UNIQUE` (`paymentMethodId` ASC) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`orders` (
  `orderId` VARCHAR(36) NOT NULL,
  `userId` VARCHAR(36) NOT NULL,
  `paymentMethodId` VARCHAR(36) NOT NULL,
  `orderStatusId` VARCHAR(36) NULL DEFAULT '1',
  `cost` DOUBLE NOT NULL,
  `orderDate` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`orderId`),
  INDEX `user_id_order_idx` (`userId` ASC) ,
  INDEX `payment_method_id_idx` (`paymentMethodId` ASC) ,
  INDEX `orderStatusId_idx` (`orderStatusId` ASC) ,
  CONSTRAINT `orderStatusId`
    FOREIGN KEY (`orderStatusId`)
    REFERENCES `online_store`.`orderstatus` (`orderStatusId`),
  CONSTRAINT `paymentMethodId`
    FOREIGN KEY (`paymentMethodId`)
    REFERENCES `online_store`.`paymentmethods` (`paymentMethodId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `userIdOrder`
    FOREIGN KEY (`userId`)
    REFERENCES `online_store`.`users` (`userId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`products` (
  `productId` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(256) NULL DEFAULT '-',
  `imagePath` VARCHAR(45) NOT NULL,
  `cost` DOUBLE NOT NULL,
  PRIMARY KEY (`productId`),
  UNIQUE INDEX `product_id_UNIQUE` (`productId` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`orderproducts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`orderproducts` (
  `orderId` VARCHAR(36) NOT NULL,
  `productId` VARCHAR(36) NOT NULL,
  INDEX `order_id_idx` (`orderId` ASC) ,
  INDEX `product_id_order_idx` (`productId` ASC) ,
  CONSTRAINT `order_id`
    FOREIGN KEY (`orderId`)
    REFERENCES `online_store`.`orders` (`orderId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `product_id_order`
    FOREIGN KEY (`productId`)
    REFERENCES `online_store`.`products` (`productId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`productbrands`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`productbrands` (
  `productId` VARCHAR(36) NOT NULL,
  `brandId` VARCHAR(36) NULL DEFAULT NULL,
  INDEX `brand_id_idx` (`brandId` ASC) ,
  INDEX `product_id_idx` (`productId` ASC) ,
  CONSTRAINT `brand_id`
    FOREIGN KEY (`brandId`)
    REFERENCES `online_store`.`brands` (`brandId`)
    ON DELETE CASCADE,
  CONSTRAINT `product_id`
    FOREIGN KEY (`productId`)
    REFERENCES `online_store`.`products` (`productId`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`productsbasket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`productsbasket` (
  `basketId` VARCHAR(36) NOT NULL,
  `productId` VARCHAR(36) NOT NULL,
  INDEX `product_id_idx` (`productId` ASC) ,
  INDEX `productsInBasket_idx` (`basketId` ASC) ,
  CONSTRAINT `prodctIdBasket_`
    FOREIGN KEY (`productId`)
    REFERENCES `online_store`.`products` (`productId`)
    ON DELETE CASCADE,
  CONSTRAINT `productsInBasket`
    FOREIGN KEY (`basketId`)
    REFERENCES `online_store`.`baskets` (`basketId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `online_store`.`productсategories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`productсategories` (
  `productId` VARCHAR(36) NOT NULL,
  `categoryId` VARCHAR(36) NULL DEFAULT NULL,
  INDEX `product_id_idx` (`productId` ASC) ,
  INDEX `category_id_idx` (`categoryId` ASC) ,
  CONSTRAINT `category_id`
    FOREIGN KEY (`categoryId`)
    REFERENCES `online_store`.`categories` (`categoryId`)
    ON DELETE CASCADE,
  CONSTRAINT `category_product_id`
    FOREIGN KEY (`productId`)
    REFERENCES `online_store`.`products` (`productId`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
