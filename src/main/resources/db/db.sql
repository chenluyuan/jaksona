create table users(id bigint not null primary key, username varchar(50) not null, password varchar(500) not null,enabled boolean not null);
create table authorities (id bigint not null primary key, username varchar(50) not null,authority varchar(50) not null);
create table groups (id bigint not null primary key, group_name varchar(50) not null);
create table group_authorities (id bigint not null primary key, group_id bigint not null, authority varchar(50) not null);
create table group_members (id bigint not null primary key, group_id bigint not null,username varchar(50) not null);
create unique index ix_auth_username on authorities (username,authority);