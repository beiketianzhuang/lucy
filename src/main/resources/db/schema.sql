create table if not exists company_data
(
    id            int(11)     not null primary key auto_increment,
    `data_order`  int         not null,
    desc          varchar(2048),
    business_type varchar(20) not null,
    active        tinyint(1)       default 1,
    update_at     timestamp   null default current_timestamp on update current_timestamp,
    create_at     timestamp   null default current_timestamp
);

create table if not exists company_step
(
    id        int(11)   not null primary key auto_increment,
    step      int       not null,
    desc      varchar(2048),
    active    tinyint(1)     default 1,
    update_at timestamp null default current_timestamp on update current_timestamp,
    create_at timestamp null default current_timestamp
);

create table if not exists company_question
(
    id        int(11)   not null primary key auto_increment,
    step      int       not null,
    question  varchar(200),
    answer    varchar(2048),
    active    tinyint(1)     default 1,
    update_at timestamp null default current_timestamp on update current_timestamp,
    create_at timestamp null default current_timestamp
);

create table if not exists business_type
(
    id        int(11)     not null primary key auto_increment,
    name      varchar(20) not null,
    value     varchar(20) not null,
    price     float(11),
    active    tinyint(1)       default 1,
    update_at timestamp   null default current_timestamp on update current_timestamp,
    create_at timestamp   null default current_timestamp
);

create table if not exists industry
(
    id        int(11)     not null primary key auto_increment,
    name      varchar(20) not null,
    value     varchar(20) not null,
    parent_id int(11)     null default 0,
    active    tinyint(1)       default 1,
    update_at timestamp   null default current_timestamp on update current_timestamp,
    create_at timestamp   null default current_timestamp
);