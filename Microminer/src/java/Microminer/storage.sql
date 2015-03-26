create table LINE_STORAGE(
    ID integer not null generated always
        as identity (start with 1, increment by 1),
    URL varchar(255) not null,
    DESCRIPTION varchar(255) not null,
    primary key(ID)
);
    
