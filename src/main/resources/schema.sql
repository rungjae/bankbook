CREATE TABLE bankbook(
                      seq bigint NOT NULL AUTO_INCREMENT, -- 시퀀스
                      use varchar(80) NOT NULL, -- 사용처
                      daw varchar(80) NOT NULL, -- 입/출금 여부
                      price int NOT NULL,  -- 금액
                      balance int, -- 잔액
                      paymentTime datetime DEFAULT NULL, -- 결제시간
                      PRIMARY KEY (seq)
);

INSERT INTO bankbook(use, daw, price, balance, paymentTime) VALUES ('스타벅스','출금',50000,250000,now());
INSERT INTO bankbook(use, daw, price, balance, paymentTime) VALUES ('마포갈매기','출금',100000,150000,now());
INSERT INTO bankbook(use, daw, price, balance, paymentTime) VALUES ('편의점','출금',50000,100000,now());
INSERT INTO bankbook(use, daw, price, balance, paymentTime) VALUES ('홍길동','입금',30000,130000,now());
INSERT INTO bankbook(use, daw, price, balance, paymentTime) VALUES ('아무개','입금',30000,160000,now());
INSERT INTO bankbook(use, daw, price, balance, paymentTime) VALUES ('이재성','입금',30000,190000,now());
INSERT INTO bankbook(use, daw, price, balance, paymentTime) VALUES ('조한영','입금',30000,220000,now());
INSERT INTO bankbook(use, daw, price, balance, paymentTime) VALUES ('보너스','입금',200000,420000,now());
