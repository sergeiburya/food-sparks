CREATE TABLE `shopping_carts_cart_item_list`(
  `shopping_cart_id`  bigint NOT NULL,
  `cart_item_list_id` bigint NOT NULL,
  UNIQUE KEY `UK_t1c0x3s97jn88teiol1ccgsg9` (`cart_item_list_id`),
  KEY `FK208orejjt7q9evprg4tkhpvkr` (`shopping_cart_id`),
  CONSTRAINT `FK208orejjt7q9evprg4tkhpvkr` FOREIGN KEY (`shopping_cart_id`) REFERENCES `shopping_carts` (`id`),
  CONSTRAINT `FK5mi85exm2860rbh8qqtc52ge3` FOREIGN KEY (`cart_item_list_id`) REFERENCES `cart_item` (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci

