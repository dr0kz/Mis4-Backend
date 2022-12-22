create table events
(
    id   bigserial primary key,
    name text      not null,
    time timestamp not null
);

create table users_events
(
    id       bigserial primary key,
    user_id  bigint references users (id)  not null,
    event_id bigint references events (id) not null
);
