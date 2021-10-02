CREATE DATABASE `healthcareDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT ENCRYPTION='N';
USE healthcareDB;
CREATE TABLE account (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `firstname` VARCHAR(255) DEFAULT NULL,
    `lastname` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX uq_username (username ASC)
);

ALTER TABLE account
ADD COLUMN (
		`gender` VARCHAR(255) DEFAULT NULL,
    `birthday` VARCHAR(255) DEFAULT NULL,
    `citizenid` VARCHAR(255) DEFAULT NULL,
    `avatar` VARCHAR(255) DEFAULT NULL,
    `phone` VARCHAR(255) DEFAULT NULL,
    `email` VARCHAR(255) DEFAULT NULL,
    `address` VARCHAR(255) DEFAULT NULL
);

CREATE TABLE role (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `permission` VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX uq_permission (permission ASC)
);

CREATE TABLE account_role (
    `account_id` BIGINT NOT NULL,
    `role_id` BIGINT NOT NULL,
    PRIMARY KEY (account_id, role_id)
);
