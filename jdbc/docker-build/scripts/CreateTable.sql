CREATE TABLE EMPLOYEES (
    ID INT NOT NULL AUTO_INCREMENT,
    LAST_NAME VARCHAR(60) NOT NULL,
    FIRST_NAME VARCHAR(60) NOT NULL,
    EMAIL VARCHAR(60) NOT NULL,
    DEPARTMENT VARCHAR(60) NOT NULL,
    SALARY DECIMAL(10,2),
    PRIMARY KEY (ID)
);
