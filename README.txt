-- Postgresql table:

CREATE TABLE t_products
(
  product_id integer NOT NULL DEFAULT nextval('db_products_product_id_seq'::regclass),
  product_name character(100),
  category character(100),
  description text,
  product_price numeric(12,2) NOT NULL DEFAULT 0.00,
  expiration_date date,
  CONSTRAINT db_products_pkey PRIMARY KEY (product_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE t_products
  OWNER TO postgres;
