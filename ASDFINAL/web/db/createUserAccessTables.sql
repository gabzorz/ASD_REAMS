CREATE TABLE ROLE(
    ROLEID INT,
    "ROLENAME" VARCHAR(20),
    PRIMARY KEY (ROLEID)
);

CREATE TABLE USER_ACCOUNT(
    USERID INT NOT NULL PRIMARY KEY
    GENERATED ALWAYS AS IDENTITY
    (START WITH 1, INCREMENT BY 1),
    "FNAME" VARCHAR(50),
    "LNAME" VARCHAR(50),
    "ADDRESS" VARCHAR(100),
    "DATEOFBIRTH" VARCHAR(10),
    "EMAILADDRESS" VARCHAR(100),
    "CONTACTNUMBER" VARCHAR(10),
    "PASSWORD" VARCHAR(50),
    "ROLEID" INT
);

