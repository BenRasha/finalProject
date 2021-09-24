CREATE DATABASE gallery_db;

create user 'gallery_app'@localhost
        identified by 'gallery_password';

GRANT SELECT,INSERT,UPDATE,DELETE
    ON gallery_db.*
    TO gallery_app@localhost;