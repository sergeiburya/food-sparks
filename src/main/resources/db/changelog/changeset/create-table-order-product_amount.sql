CREATE TABLE `order_product_amount` (
  `order_id` bigint NOT NULL,
  `amount` int DEFAULT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `FKeh76e34svqjvb7m2n31slb15y` (`product_id`),
  CONSTRAINT `FKeh76e34svqjvb7m2n31slb15y` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FKs3uh6chlomuoi7t93a25f10ci` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

