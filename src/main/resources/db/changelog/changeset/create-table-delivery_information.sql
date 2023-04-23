CREATE TABLE `delivery_information` (
                                        `id` bigint NOT NULL AUTO_INCREMENT,
                                        `apartment` int NOT NULL,
                                        `build` varchar(255) DEFAULT NULL,
                                        `comment` varchar(255) DEFAULT NULL,
                                        `day_of_delivery` varchar(255) DEFAULT NULL,
                                        `first_name` varchar(255) DEFAULT NULL,
                                        `last_name` varchar(255) DEFAULT NULL,
                                        `phone` varchar(255) DEFAULT NULL,
                                        `street` varchar(255) DEFAULT NULL,
                                        `time_of_delivery` varchar(255) DEFAULT NULL,
                                        `town` varchar(255) DEFAULT NULL,
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
