
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema online_store
-- -----------------------------------------------------

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
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) )
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
  INDEX `user_status_id_idx` (`userStatusId` ASC) ,
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
  `description` VARCHAR(1024) NULL DEFAULT '-',
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
  `description` VARCHAR(1024) NULL DEFAULT '-',
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
  UNIQUE INDEX `orderStatusId_UNIQUE` (`orderStatusId` ASC) )
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
  `description` VARCHAR(1024) NULL DEFAULT '-',
  `imagePath` VARCHAR(90) NOT NULL,
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
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `product_id`
    FOREIGN KEY (`productId`)
    REFERENCES `online_store`.`products` (`productId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
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
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `category_product_id`
    FOREIGN KEY (`productId`)
    REFERENCES `online_store`.`products` (`productId`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


/*SET SQL_SAFE_UPDATES = 0;*/

--
INSERT INTO `online_store`.`orderstatus` (`orderStatusId`, `name`) VALUES ('2', 'close');
INSERT INTO `online_store`.`orderstatus` (`orderStatusId`, `name`) VALUES ('1', 'open');
--
INSERT INTO `online_store`.`userstatus` (`userStatusId`, `statusName`) VALUES ('1', 'admin');
INSERT INTO `online_store`.`userstatus` (`userStatusId`, `statusName`) VALUES ('2', 'customer');
--
INSERT INTO `online_store`.`contacts` (`contactsId`, `email`, `phoneNumber`, `country`, `city`, `street`, `houseNumber`, `apartmentNumber`) VALUES ('1', 'ilya_chekun@mail.ru', '375293136052', 'беларусь', 'минск', 'лобанка', '62', '191');
INSERT INTO `online_store`.`contacts` (`contactsId`, `email`, `phoneNumber`, `country`, `city`, `street`, `houseNumber`, `apartmentNumber`) VALUES ('2', 'user_1@mail.ru', '375256252575', 'беларусь', 'гомель', 'петренко', '41', '21');
INSERT INTO `online_store`.`contacts` (`contactsId`, `email`, `phoneNumber`, `country`, `city`, `street`, `houseNumber`, `apartmentNumber`) VALUES ('3', 'user_2@mail.ru', '375294216565', 'беларусь', 'витебск', 'скрипникова', '91', '182');

---
INSERT INTO `online_store`.`users` (`userId`, `contactsId`, `userStatusId`, `login`, `password`, `name`, `surname`, `birthDate`, `banned`) VALUES ('1', '1', '1', 'nykech', 'z7�Jj�R�X*', 'илья', 'чекун', '1999-09-17', '0');
INSERT INTO `online_store`.`users` (`userId`, `contactsId`, `userStatusId`, `login`, `password`, `name`, `surname`, `birthDate`, `banned`) VALUES ('2', '2', '2', 'user1', '���F���w�\'�y�', 'вася', 'петров', '1995-05-12', '0');
INSERT INTO `online_store`.`users` (`userId`, `contactsId`, `userStatusId`, `login`, `password`, `name`, `surname`, `birthDate`, `banned`) VALUES ('3', '3', '2', 'user2', '�}�\Z��@{�=���', 'никита', 'иванов', '1984-02-10', '0');


INSERT INTO `online_store`.`products` (`productId`, `name`, `description`, `imagePath`, `cost`) VALUES ('1', 'iphone 10', 'Диагональ (дюйм): 5.8; Разрешение (пикс): 2436x1125; Встроенная память (Гб): 64; Фотокамера (Мп): 12 + 12 (двойная)', 'pictures/product/iphone10.jpg', '1800');
INSERT INTO `online_store`.`products` (`productId`, `name`, `description`, `imagePath`, `cost`) VALUES ('2', 'iphone 9', ' iPhone получит неизменную диагональ экрана (5,8 дюйма), при этом объем его оперативной памяти будет увеличен до 4 ГБ. Емкость аккумулятора либо останется на таком же уровне, либо окажется чуть больше (на 10 %), а вот увеличенная модель, если все же будет представлена, сможет похвастаться более емким аккумулятором (3300-3400 мАч).', 'pictures/product/iphone9.png', '1600');
INSERT INTO `online_store`.`products` (`productId`, `name`, `description`, `imagePath`, `cost`) VALUES ('3', 'iphone 7', 'Стандартная модель iPhone 7 имеет дисплей диагональю 4,7 дюйма, разрешением 1334x750 пикселей; размеры телефона — 138,3×67,1×7,1 мм, вес — 138 грамм', 'pictures/product/iphone7.jpg', '1200');
INSERT INTO `online_store`.`products` (`productId`, `name`, `description`, `imagePath`, `cost`) VALUES ('4', 'a-90', 'Поддержка стандартов связи: 5G (Sub6); 4G/LTE; 3G; GSM; Платформа: Android 9.0 Pie', 'pictures/product/samsung_a90.jp', '850');
INSERT INTO `online_store`.`products` (`productId`, `name`, `description`, `imagePath`, `cost`) VALUES ('5', 'j 7', 'Android 7; Дисплей 5.5 дюйма, SuperAMOLED, FullHD, автоматическая регулировка яркости, AlwaysOn Display', 'pictures/product/samsung_j7.jpg', '500');
INSERT INTO `online_store`.`products` (`productId`, `name`, `description`, `imagePath`, `cost`) VALUES ('6', 'a-50', '158.5 x 74.7 x 7,7 мм, 166 грамм;	6.4 дюйма, 1080х2340 точек (19.5:9), SuperAMOLED, 403 ppi, автоматическая регулировка яркости, AlwaysOn Display, Corning Gorilla Glass 3', 'top	pictures/product/samsung_a50.jpeg', '500');
INSERT INTO `online_store`.`products` (`productId`, `name`, `description`, `imagePath`, `cost`) VALUES ('7', 'iphone 11', 'Apple — одна из немногих, кто в своём ассортименте флагманов имеет и OLED и IPS дисплеи. ... В iPhone 11 нас встречает ровно тот же дисплей, что и в XR. Называется Liquid Retina HD', 'pictures/product/iphone11.jpeg', '2100');

INSERT INTO `online_store`.`products` (`productId`, `name`, `description`, `imagePath`, `cost`) VALUES ('8', 'Xiaomi MI TV 4A Pro 43', 'LED; 43 \"; 1920x1080 (Full HD); IPS-матрица; Smart TV; Bluetooth, Wi-Fi Direct, Wi-Fi; цвет: черный.', 'pictures/product/television/xiaomi_mi_tv_4a_pro_43_1.jpg', '750');
INSERT INTO `online_store`.`products` (`productId`, `name`, `description`, `imagePath`, `cost`) VALUES ('9', 'Samsung UE32N5300AU', 'LED; 32 \"; 1920x1080 (Full HD); Smart TV; HDR; Wi-Fi Direct, Wi-Fi; Dolby Digital; цвет: черный', 'pictures/product/television/samsung_ue_32.jpg', '1075');
INSERT INTO `online_store`.`products` (`productId`, `name`, `description`, `imagePath`, `cost`) VALUES ('10', ' Sony KD-55XF9005', 'LED; 54.6 \"; 3840x2160 (4K UHD); Smart TV; HDR; Wi-Fi, Wi-Fi Direct, Bluetooth; Dolby Digital; цвет: черный', 'pictures/product/television/sony_kd.jpg', '2400');




--

INSERT INTO `online_store`.`brands` (`brandId`, `name`, `description`, `imagePath`) VALUES ('1', 'Huawei', 'Компания была основана в 1987 году в городе Шэньчжэнь, и на момент создания ее уставной капитал составлял всего 20 000 юаней. Основателем Huawei был бывший офицер, заместитель главы инженерного корпуса китайской Народно-освободительной армии Рэн Жэнфэй.', '-');
INSERT INTO `online_store`.`brands` (`brandId`, `name`, `description`, `imagePath`) VALUES ('2', 'HONOR', 'В 2014 году руководство Huawei принимает решение о создании отдельного бренда Honor. Название в переводе с английского означает “Честь”.  Основной аудиторией бренда является молодая и современная аудитория. ', '-');
INSERT INTO `online_store`.`brands` (`brandId`, `name`, `description`, `imagePath`) VALUES ('3', 'Nokia', 'Становление бренда началось в 1865 году, когда инженер Фредрик Идестам открыл бумажную фабрику в Финляндии.', '-');
INSERT INTO `online_store`.`brands` (`brandId`, `name`, `description`, `imagePath`) VALUES ('4', 'Sony', 'История Корпорация Sony была основана Акио Моритой и Масару Ибукой 7 мая 1946 года. В самом начале она называлась «Токё цусин когё кабусики-гайся» (Токийская телекоммуникационно-промышленная компания) или сокращённо Тоцуко или TTK, но, как выяснил Акио Морита, это название тяжело произносить американцам.', '-');
INSERT INTO `online_store`.`brands` (`brandId`, `name`, `description`, `imagePath`) VALUES ('5', 'Samsung', 'Samsung Group («Сáмсон Груп», кор. 삼성그룹, Samseong Gurub, Samsŏng Gurup) — южнокорейская группа компаний, один из крупнейших чеболей, основанный в 1938 году.', '-');
INSERT INTO `online_store`.`brands` (`brandId`, `name`, `description`, `imagePath`) VALUES ('6', 'Apple', 'Корпорация Apple (ранее называлась Apple Computer) — производитель персональных компьютеров «Mac», планшетов «iPad», аудиоплееров «iPod», телефонов «iPhone», программного обеспечения. Основали компанию Стив Джобс, Стив Возняк и Рональд Уэйн в 1976 году.', '-');


insert into productbrands(brandId,productId) values( 6 ,1  );
insert into productbrands(brandId,productId) values( 6 , 2 );
insert into productbrands(brandId,productId) values( 6 , 3);
insert into productbrands(brandId,productId) values(6 , 7 );

insert into productbrands(brandId,productId) values( 5 , 4);
insert into productbrands(brandId,productId) values(5 , 5 );
insert into productbrands(brandId,productId) values(5 , 6);
insert into productbrands(brandId,productId) values(4 ,10);
insert into productbrands(brandId,productId) values(2 ,8);
insert into productbrands(brandId,productId) values(5 ,9);
---

INSERT INTO `online_store`.`categories` (`categoryId`, `name`, `description`, `imagePath`) VALUES ('1', 'Телевизоры', 'У нас есть телевизоры с плоским экраном, способные удовлетворить Ваши потребности в развлечениях. Насладитесь своими любимыми телешоу, фильмами и музыкой в совершенно новом качестве с инновационными технологиями  4K UHD, OLED 4K и LED телевизорами. Вы найдете современные технологии, в которых Вы нуждаетесь вместе с надежностью, которую Вы ожидаете. Узнайте больше о нашей коллекции телевизоров с плоскими экранами, а также наших инновационных беспроводных динамиках и звуковых панелях .', '-');
INSERT INTO `online_store`.`categories` (`categoryId`, `name`, `description`, `imagePath`) VALUES ('2', 'Телефоны', 'У нас есть огромное количество смартфонов на любой вкус. В нашем каталоге вы надете все самые популярные бренды по приемлимой цене!', '-');

insert into  productсategories(productId,categoryId) values(1,2);
insert into  productсategories(productId,categoryId) values(2,2);
insert into  productсategories(productId,categoryId) values(3,2);
insert into  productсategories(productId,categoryId) values(4,2);
insert into  productсategories(productId,categoryId) values(5,2);
insert into  productсategories(productId,categoryId) values(6,2);
insert into  productсategories(productId,categoryId) values(7,2);
insert into productсategories(categoryId,productId) values(1,10);
insert into productсategories(categoryId,productId) values(1,9);
insert into productсategories(categoryId,productId) values(1,8);
--
