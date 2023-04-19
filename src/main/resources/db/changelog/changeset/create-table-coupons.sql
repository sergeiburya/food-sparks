CREATE TABLE `coupons` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `coupon_value` varchar(255) DEFAULT NULL,
  `discount_size` int DEFAULT NULL,
  `expired` bit(1) NOT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
