DROP TABLE IF EXISTS CURRENCY;

CREATE TABLE CURRENCY(
    CODE VARCHAR(255) PRIMARY KEY,
    CODE_CH VARCHAR(50),
    RATE VARCHAR(50),
    UPDATE_TIME VARCHAR(50)
                 );