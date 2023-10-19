CREATE DATABASE IF NOT EXISTS number;
CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'password';
GRANT SELECT,UPDATE,INSERT ON number.* TO 'user'@'%';
USE number;
CREATE TABLE IF NOT EXISTS contact (id int primary key auto_increment, name varchar(255), number varchar(255) not null);