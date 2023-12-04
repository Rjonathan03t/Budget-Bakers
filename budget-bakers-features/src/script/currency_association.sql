CREATE TABLE IF NOT EXISTS currency_association (
   id_association INT PRIMARY KEY,
   id_account INT,
   id_currency INT,
   FOREIGN KEY (id_account) REFERENCES account(id_account),
   FOREIGN KEY (id_currency) REFERENCES currency(id_currency)
);