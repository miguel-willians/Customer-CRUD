DROP TABLE IF EXISTS customer CASCADE;

CREATE TABLE IF NOT EXISTS customer (
    cd_customer SERIAL PRIMARY KEY,
    nm_customer VARCHAR(20) NOT NULL,
    ds_email VARCHAR(35) NOT NULL,
    password VARCHAR(255) NOT NULL
);
