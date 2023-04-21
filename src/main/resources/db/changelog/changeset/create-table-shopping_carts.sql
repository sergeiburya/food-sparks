CREATE TABLE `shopping_carts` (
  `id` bigint NOT NULL,
  `coupon_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKocitl05e1ppd9l92osr2r63gc` (`coupon_id`),
  CONSTRAINT `FKc1fbrvff059ke4p8ce3hu38oa` FOREIGN KEY (`id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKocitl05e1ppd9l92osr2r63gc` FOREIGN KEY (`coupon_id`) REFERENCES `coupons` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

