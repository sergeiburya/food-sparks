CREATE TABLE `cart_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqkqmvkmbtiaqn2nfqf25ymfs2` (`product_id`),
  CONSTRAINT `FKqkqmvkmbtiaqn2nfqf25ymfs2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

