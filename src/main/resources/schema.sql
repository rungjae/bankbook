CREATE TABLE bankbook(
                      seq bigint NOT NULL AUTO_INCREMENT, -- 시퀀스
                      use varchar(80) NOT NULL, -- 사용처
                      price int NOT NULL,  -- 금액
                      balance int NOT NULL, -- 잔액
                      payment_time datetime DEFAULT NULL, -- 결제시간
--                       create_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                      PRIMARY KEY (seq),
--                       CONSTRAINT unq_user_email UNIQUE(email)
);