CREATE TABLE bankbook(
                      seq bigint NOT NULL AUTO_INCREMENT, -- 시퀀스
                      use varchar(80) NOT NULL, -- 사용처
                      daw varchar(80) NOT NULL, -- 입/출금 여부
                      price int NOT NULL,  -- 금액
                      balance int, -- 잔액
                      payment_time datetime DEFAULT NULL, -- 결제시간
--                       create_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                      PRIMARY KEY (seq)
--                       CONSTRAINT unq_user_email UNIQUE(email)
);

INSERT INTO bankbook(use, daw, price, balance, payment_time) VALUES ('스타벅스','출금',50000,250000,now());
INSERT INTO bankbook(use, daw, price, balance, payment_time) VALUES ('마포갈매기','출금',100000,150000,now());
