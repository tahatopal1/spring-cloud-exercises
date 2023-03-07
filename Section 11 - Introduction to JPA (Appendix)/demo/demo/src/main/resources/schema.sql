create table course
(
    id     bigint       not null auto_increment primary key,
    name   VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL
) engine = InnoDB;

