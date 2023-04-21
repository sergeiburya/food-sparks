CREATE TABLE `recipes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cooking_time` int DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `portions` int DEFAULT NULL,
  `spiced` BIT(1) DEFAULT NULL ,
  `subtitle` varchar(500) DEFAULT NULL,
  `dish_name` varchar(255) DEFAULT NULL,
  `complexity_id` bigint DEFAULT NULL,
  `cuisine_region_id` bigint DEFAULT NULL,
  `dish_type_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh9fpwfgxhxpifc1i2ffn01eyg` (`complexity_id`),
  KEY `FKi99h2dyxhaug8ux8rru6rvav2` (`cuisine_region_id`),
  KEY `FKat2a4sldcy6b8jios0n2fx27a` (`dish_type_id`),
  CONSTRAINT `FKat2a4sldcy6b8jios0n2fx27a` FOREIGN KEY (`dish_type_id`) REFERENCES `dish_type` (`id`),
  CONSTRAINT `FKh9fpwfgxhxpifc1i2ffn01eyg` FOREIGN KEY (`complexity_id`) REFERENCES `complexity` (`id`),
  CONSTRAINT `FKi99h2dyxhaug8ux8rru6rvav2` FOREIGN KEY (`cuisine_region_id`) REFERENCES `cuisine_region` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;
