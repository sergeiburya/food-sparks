CREATE TABLE `warehouse` (
  `product_id` bigint NOT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `FKow13o6v2o8btmca0nw5pblpss` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
