CREATE TABLE IF NOT EXISTS clients
(
id bigserial NOT NULL,
name text NOT NULL,
place_of_birth text NOT NULL,
date_of_birth date NOT NULL,
address text COLLATE pg_catalog."default",
passport text NOT NULL,
CONSTRAINT clients_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS products
(
id bigserial NOT NULL,
product_type_id bigint NOT NULL,
name text NOT NULL,
client_ref bigint,
open_date date NOT NULL,
close_date date,
CONSTRAINT products_pk PRIMARY KEY (id),
CONSTRAINT prod_cl_fk FOREIGN KEY (client_ref)
REFERENCES clients (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS product_type
(
id bigserial NOT NULL,
name text NOT NULL,
begin_date date,
end_date date,
tarif_ref bigint,
CONSTRAINT product_type_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS accounts
(
id bigserial NOT NULL,
name text NOT NULL,
saldo bigint,
client_ref bigint NOT NULL,
open_date date NOT NULL,
close_date date,
product_ref bigint NOT NULL,
acc_num text NOT NULL,
CONSTRAINT accounts_pk PRIMARY KEY (id),
CONSTRAINT acc_cl_fk FOREIGN KEY (client_ref)
REFERENCES clients (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION,
CONSTRAINT acc_prod_fk FOREIGN KEY (product_ref)
REFERENCES products (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
);

CREATE TABLE records
(
id bigserial NOT NULL,
dt integer NOT NULL,
sum bigint NOT NULL,
acc_ref bigint NOT NULL,
oper_date date NOT NULL,
CONSTRAINT records_pk PRIMARY KEY (id),
CONSTRAINT rec_acc_fk FOREIGN KEY (acc_ref)
REFERENCES accounts (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION
);

CREATE TABLE tarifs
(
id bigserial NOT NULL,
name text NOT NULL,
cost bigint,
PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS products
ADD CONSTRAINT prod_prodtype_fk FOREIGN KEY (product_type_id)
REFERENCES product_type (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION;
ALTER TABLE IF EXISTS product_type
ADD CONSTRAINT prod_type_tar_fk FOREIGN KEY (tarif_ref)
REFERENCES tarifs (id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE NO ACTION;