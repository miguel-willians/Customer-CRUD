CREATE table if not exists customer(
    cd_customer serial primary key,
    nm_customer varchar(20) not null unique,
    ds_email varchar(35) not null unique,
    password varchar(255) not null
);
