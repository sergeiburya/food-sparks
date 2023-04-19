CREATE TABLE `shopping_cart_product_amount` (
  `shopping_cart_id` bigint NOT NULL,
  `product_amount` int DEFAULT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`shopping_cart_id`,`product_id`),
  KEY `FK5e8dshesq2mfxk8dbp7ir3nq9` (`product_id`),
  CONSTRAINT `FK5e8dshesq2mfxk8dbp7ir3nq9` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FKb67s9te8u11hvbjxcjm8q4wal` FOREIGN KEY (`shopping_cart_id`) REFERENCES `shopping_carts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
