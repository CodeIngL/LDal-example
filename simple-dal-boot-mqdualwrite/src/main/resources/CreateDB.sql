drop table ${appName}_FENCED if exists;

create table ${appName}_FENCED (
    id          bigint auto_increment primary key,
    ukey        varchar(100) null,
    create_time bigint       null,
    constraint ${appName}_FENCED_key_uindex unique (ukey)
);


