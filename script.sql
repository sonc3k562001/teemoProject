CREATE DATABASE `healthcareDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT ENCRYPTION='N';
USE healthcareDB;
CREATE TABLE account (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(120) NOT NULL,
    `password` VARCHAR(220) NOT NULL,
    `firstname` VARCHAR(120) DEFAULT NULL,
    `lastname` VARCHAR(120) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX uq_username (username ASC)
);

CREATE TABLE role (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `permission` VARCHAR(120) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX uq_permission (permission ASC)
);

CREATE TABLE account_role (
    `account_id` BIGINT NOT NULL,
    `role_id` BIGINT NOT NULL,
    PRIMARY KEY (account_id, role_id)
);
