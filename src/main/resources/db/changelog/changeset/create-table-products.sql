CREATE TABLE `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount_in_package` int DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `image_Url` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKf55t6sm19p5lrihq24a6knota` (`product_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;
