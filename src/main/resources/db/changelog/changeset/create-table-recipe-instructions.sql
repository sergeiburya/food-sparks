CREATE TABLE `recipe_instructions` (
  `recipe_id` bigint NOT NULL,
  `instructions` varchar(2000) DEFAULT NULL,
  KEY `FK7v3emx3mfvngvbwd10x0hx9vg` (`recipe_id`),
  CONSTRAINT `FK7v3emx3mfvngvbwd10x0hx9vg` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
