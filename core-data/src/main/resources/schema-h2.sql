CREATE TABLE bank_account
(
  id             INTEGER AUTO_INCREMENT NOT NULL,
  account_number VARCHAR(50)            NOT NULL,
  iban           VARCHAR(50)            NOT NULL,
  bank_name      VARCHAR(50)            NOT NULL,
  bic            INTEGER(20)            NOT NULL,
  PRIMARY KEY (id)
);