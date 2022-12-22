create table users
(
    id       bigserial primary key,
    name     text not null,
    surname  text not null,
    email    text not null,
    password text not null
);
