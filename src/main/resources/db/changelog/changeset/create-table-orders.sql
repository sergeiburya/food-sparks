CREATE TABLE `orders` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `order_time` datetime(6) DEFAULT NULL,
                        `sum` decimal(19,2) DEFAULT NULL,
                        `delivery_information_id` bigint DEFAULT NULL,
                        `user_id` bigint DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `FK90ywmc7qjic663h4n662gdgqo` (`delivery_information_id`),
                        KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`),
                        CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
                        CONSTRAINT `FK90ywmc7qjic663h4n662gdgqo` FOREIGN KEY (`delivery_information_id`) REFERENCES `delivery_information` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

