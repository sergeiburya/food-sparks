CREATE TABLE `recipe_product_list` (
  `recipe_id` bigint NOT NULL,
  `amount` int DEFAULT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`recipe_id`,`product_id`),
  KEY `FK7w57i5jk1r9mgskp0xwkqtypd` (`product_id`),
  CONSTRAINT `FK7w57i5jk1r9mgskp0xwkqtypd` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FKpms2f5eejb9qg0nfi44y09vm` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
