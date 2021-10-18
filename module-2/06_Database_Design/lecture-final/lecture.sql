BEGIN TRANSACTION;

DROP TABLE IF EXISTS artist, art, customer, transaction CASCADE;

CREATE TABLE artist (
  id SERIAL,
  --art_id INT NOT NULL,
  name VARCHAR(100),
  CONSTRAINT PK_artist_id PRIMARY KEY(id)
);

CREATE TABLE art (
  id SERIAL,
  artist_id INT NOT NULL,
  title VARCHAR(100),
  CONSTRAINT PK_art_id PRIMARY KEY(id)
);

-- Must create customer table here <--
CREATE TABLE customer (
  id SERIAL,
  name VARCHAR(100) NOT NULL,
  address VARCHAR(200) NOT NULL,
  CONSTRAINT PK_customer_id PRIMARY KEY(id)
);

CREATE TABLE transaction (
  id SERIAL,
  art_id INT NOT NULL,
  customer_id INT NOT NULL,
  purchase_date DATE,
  sale_price MONEY,
  CONSTRAINT PK_transaction_id PRIMARY KEY(id),
  CONSTRAINT FK_art_id FOREIGN KEY(art_id) REFERENCES art(id),
  CONSTRAINT FK_customer_id FOREIGN KEY(customer_id) REFERENCES customer(id)
);

-- Foreign keys
ALTER TABLE art ADD CONSTRAINT FK_art_artist FOREIGN KEY(artist_id) REFERENCES artist(id);

COMMIT;

--ROLLBACK;