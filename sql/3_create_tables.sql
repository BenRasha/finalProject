USE gallery_db;

CREATE TABLE users (
            id INTEGER NOT NULL AUTO_INCREMENT,
            login VARCHAR(255) NOT NULL UNIQUE,
            password NCHAR(160) NOT NULL,
            /*
            * 0 - администратор Role.Administrator
            * 1 - пользователь Role.User
            * 2 - гость Role.Guest
            */
            role TINYINT NOT NULL CHECK (role IN (0, 1, 2)),
            CONSTRAINT PK_users PRIMARY KEY (id)
) ;

CREATE TABLE users_info (
            user_id INTEGER NOT NULL,
            email VARCHAR(320) NOT NULL,
            name VARCHAR(40) NOT NULL,
            surname VARCHAR(60) NOT NULL,
            city VARCHAR(255) NOT NULL,
            street VARCHAR(255) NOT NULL,
            phone VARCHAR(20) NOT NULL,
            CONSTRAINT UN_email UNIQUE (email),
            CONSTRAINT PK_user_info PRIMARY KEY (user_id),
            CONSTRAINT FK_usersInfoUsers FOREIGN KEY (user_id) REFERENCES users (id)
            ON UPDATE CASCADE
            ON DELETE RESTRICT
) ;

CREATE TABLE paintings (
            id INTEGER NOT NULL AUTO_INCREMENT,
            title VARCHAR(20) NOT NULL,
            style VARCHAR(15) NOT NULL CHECK ( style IN ('abstract', 'contemporary', 'realism')),
            size VARCHAR(10) NOT NULL,
            material VARCHAR(30) NOT NULL,
            date DATE NOT NULL,
            CONSTRAINT PK_paintings PRIMARY KEY (id)
) ;

CREATE TABLE sketches (
            id INTEGER NOT NULL AUTO_INCREMENT,
            title VARCHAR(20) NOT NULL,
            date DATE NOT NULL,
            CONSTRAINT PK_sketches PRIMARY KEY (id)
) ;

CREATE TABLE painting_photos (
            painting_id INTEGER NOT NULL,
            photo_path VARCHAR(260) NOT NULL,
            CONSTRAINT UN_photo_path UNIQUE (photo_path),
            CONSTRAINT FK_paintingPhotosPaintings FOREIGN KEY (painting_id) REFERENCES paintings(id)
            ON UPDATE CASCADE
            ON DELETE CASCADE
) ;

CREATE TABLE sketches_photos (
            sketch_id INTEGER NOT NULL,
            photo_path VARCHAR(260) NOT NULL,
            CONSTRAINT UN_photo_path UNIQUE (photo_path),
            CONSTRAINT FK_paintingPhotosSketches FOREIGN KEY (sketch_id) REFERENCES sketches(id)
            ON UPDATE CASCADE
            ON DELETE CASCADE
) ;

CREATE TABLE liked_paintings (
            user_id INTEGER NOT NULL,
            painting_id INTEGER NOT NULL,
            CONSTRAINT UN_paintingId UNIQUE (painting_id, user_id),
            CONSTRAINT FK_likedPaintingsUsers FOREIGN KEY (user_id) REFERENCES users (id),
            CONSTRAINT FK_likedPaintingsPaintings FOREIGN KEY (painting_id) REFERENCES paintings (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE
) ;