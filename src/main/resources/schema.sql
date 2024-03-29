CREATE TABLE TABLE_ATTRIBUTE_TYPE(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(30) NOT NULL
);

CREATE TABLE TABLE_ATTRIBUTE(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    ATTR_TYPE_ID BIGINT NOT NULL,
    VALUE VARCHAR(30) NOT NULL
);

CREATE TABLE TABLE_GROUP(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(20) NOT NULL
);

CREATE TABLE TABLE_CATEGORY(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(20) NOT NULL
);

CREATE TABLE TABLE_PRODUCT(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(30) NOT NULL,
    DESCRIPTION VARCHAR(100),
    MODEL VARCHAR(20) NOT NULL,
    PRICE DOUBLE NOT NULL,
    ACTIVE INT NOT NULL,
    CATEGORY_ID BIGINT NOT NULL,
    GROUP_ID BIGINT NOT NULL
);

CREATE TABLE PRODUCT_ATTR(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    PRODUCT_ID BIGINT NOT NULL,
    ATTR_ID BIGINT NOT NULL
);

CREATE TABLE TABLE_STOCK(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    PRODUCT_ID BIGINT NOT NULL,
    AMOUNT BIGINT NOT NULL
);