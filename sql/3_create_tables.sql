USE `gallery_db`;

CREATE TABLE `users` (
            `user_id` INTEGER NOT NULL AUTO_INCREMENT,
            `login` VARCHAR(255) NOT NULL UNIQUE,
            `password` NCHAR(32) NOT NULL,
            /*
            * 0 - администратор (Role.ADMINISTRATOR)
            * 1 - пользователь (Role.USER)
            * 2 - гость (Role.GUEST)
            */
            `role` TINYINT NOT NULL CHECK (`role` IN (0, 1, 2)),
            CONSTRAINT PK_users PRIMARY KEY (`user_id`)
) ;

CREATE TABLE `users_info` (
            `user_id` INTEGER NOT NULL,
            `email` VARCHAR(100) NOT NULL,
            `name` VARCHAR(40) NOT NULL,
            `surname` VARCHAR(60) NOT NULL,
            `address` VARCHAR(255) NOT NULL,
            `phone` VARCHAR(20) NOT NULL,
            CONSTRAINT UN_email UNIQUE (`email`),
            CONSTRAINT PK_user_info PRIMARY KEY (`user_id`),
            CONSTRAINT FK_user_info FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
            ON UPDATE CASCADE
            ON DELETE RESTRICT
) ;

CREATE TABLE `paintings` (
            `paining_id` INTEGER NOT NULL AUTO_INCREMENT,
            `title` VARCHAR(20) NOT NULL,
            `description` VARCHAR(255) NOT NULL,
            `style` VARCHAR(15) NOT NULL Check ( `style` IN ('graphic', 'abstract', 'contemporary', 'realism')),
            CONSTRAINT PK_paintings PRIMARY KEY (`paining_id`)
) ;

CREATE TABLE `graphic_paintings` (
            `painting_id` INTEGER NOT NULL,
            `gr_size` VARCHAR(10) NOT NULL,
            `gr_image` VARCHAR(255) NOT NULL,
            `gr_material` VARCHAR(100) NOT NULL,
            `gr_date` DATE NOT NULL,
            CONSTRAINT UN_grimage UNIQUE (`gr_image`),
            CONSTRAINT PK_grpaintings PRIMARY KEY (`painting_id`),
            CONSTRAINT FK_grpaintings FOREIGN KEY (`painting_id`) REFERENCES `paintings` (`paining_id`)
) ;

CREATE TABLE `abstract_paintings` (
            `painting_id` INTEGER NOT NULL,
            `ab_size` VARCHAR(10) NOT NULL,
            `ab_image` VARCHAR(255) NOT NULL,
            `ab_material` VARCHAR(100) NOT NULL,
            `ab_date` DATE NOT NULL,
            CONSTRAINT UN_abimage UNIQUE (`ab_image`),
            CONSTRAINT PK_abpaintings PRIMARY KEY (`painting_id`),
            CONSTRAINT FK_abpaintings FOREIGN KEY (`painting_id`) REFERENCES `paintings` (`paining_id`)
) ;

CREATE TABLE `contemporary_paintings` (
            `painting_id` INTEGER NOT NULL,
            `con_size` VARCHAR(10) NOT NULL,
            `con_image` VARCHAR(255) NOT NULL,
            `con_material` VARCHAR(100) NOT NULL,
            `ab_date` DATE NOT NULL,
            CONSTRAINT UN_conimage UNIQUE (`con_image`),
            CONSTRAINT PK_conpaintings PRIMARY KEY (`painting_id`),
            CONSTRAINT Fk_conpaintings FOREIGN KEY (`painting_id`) REFERENCES `paintings` (`paining_id`)
) ;

CREATE TABLE `realism_paintings` (
            `painting_id` INTEGER NOT NULL,
            `rls_size` VARCHAR(10) NOT NULL,
            `rls_image` VARCHAR(255) NOT NULL,
            `rls_material` VARCHAR(100) NOT NULL,
            `rls_date` DATE NOT NULL,
            CONSTRAINT UN_rlsimage UNIQUE (`rls_image`),
            CONSTRAINT PK_rlspaintings PRIMARY KEY (`painting_id`),
            CONSTRAINT FK_rlspaintings FOREIGN KEY (`painting_id`) REFERENCES `paintings` (`paining_id`)
 ) ;

CREATE TABLE `sketches` (
            `sketch_id` INTEGER NOT NULL AUTO_INCREMENT,
            `sketch_title` VARCHAR(20) NOT NULL,
            `sketch_description` VARCHAR(255) NOT NULL,
            `sketch_size` VARCHAR(10) NOT NULL,
            `sketch_image` VARCHAR(255) NOT NULL,
            `sketch_date` DATE NOT NULL,
            CONSTRAINT UN_skimage UNIQUE (`sketch_image`),
            CONSTRAINT PK_sketches PRIMARY KEY (`sketch_id`)
) ;

CREATE TABLE `liked_paintings` (
            `liked_id` INTEGER NOT NULL AUTO_INCREMENT,
            `user_id` INTEGER NOT NULL,
            `painting_id` INTEGER NOT NULL,
            CONSTRAINT UN_paintid UNIQUE (`painting_id`),
            CONSTRAINT PK_liked PRIMARY KEY (`liked_id`),
            CONSTRAINT FK_likedUsers FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
            CONSTRAINT FK_likedPaintings FOREIGN KEY (`painting_id`) REFERENCES `paintings` (`paining_id`)

)