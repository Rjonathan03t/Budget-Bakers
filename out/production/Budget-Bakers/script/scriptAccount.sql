CREATE TABLE IF NOT EXISTS account (
   id_account INT PRIMARY KEY,
   username VARCHAR (150),
   number INT CHECK,
   balance INT,
   status VARCHAR (50) CHECK (status = 'active' or status = 'inactive')
);

INSERT INTO account VALUES (1,'Rakoto',0001,10000,'active');
INSERT INTO account VALUES (2,'Rabe',0002,20000,'active');
INSERT INTO account VALUES (3,'Rasolo',0003,50000,'active');
INSERT INTO account VALUES (4,'Andria',0004,7000,'active');
INSERT INTO account VALUES (5,'Zaka',0005,30000,'active');