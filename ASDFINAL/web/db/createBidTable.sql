CREATE TABLE BID (
    "ITEMID" INT NOT NULL,
    "USERID" INT NOT NULL,
    "DATE" DATE DEFAULT CURRENT_DATE,
    "TIME" TIME DEFAULT CURRENT_TIME,
    "AMOUNT" INT NOT NULL,
    FOREIGN KEY (ITEMID) REFERENCES AUCTION_ITEM,
    FOREIGN KEY (USERID) REFERENCES USER_ACCOUNT
);