CREATE SCHEMA IF NOT EXISTS BOOK_SERVICES;
SET SCHEMA BOOK_SERVICES;

drop table if exists book_services.AUTHOR cascade;
drop table if exists book_services.BOOK cascade;
drop sequence if exists book_services.authorid_seq;
drop sequence if exists book_services.bookid_seq;
create sequence book_services.authorid_seq start with 1 increment by 1;
create sequence book_services.bookid_seq start with 1 increment by 1;
commit;

create table book_services.AUTHOR
(AUTHOR_ID numeric(38,0) not null,
DATE_OF_BIRTH TIMESTAMP,
FIRST_NAME varchar(255),
LAST_NAME varchar(255),
NATIONALITY varchar(255),
primary key (AUTHOR_ID));
commit;

create table book_services.BOOK
(BOOK_ID numeric(38,0) not null,
PRICE float(53),
PUBLICATION_DATE TIMESTAMP,
AUTHOR_ID varchar(255),
GENRE varchar(255),
TITLE varchar(255),
primary key (BOOK_ID));
commit;

alter table if exists book_services.BOOK
add constraint fk_author_id foreign key (author_id) references book_services.AUTHOR;
commit;


INSERT INTO BOOK_SERVICES.AUTHOR (AUTHOR_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH,NATIONALITY)
VALUES(1101, 'Jane', 'Austen', '1970-01-01', 'USA');

INSERT INTO BOOK_SERVICES.AUTHOR (AUTHOR_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH,NATIONALITY)
VALUES(1102, 'Frank', 'Herbert', '1971-01-01', 'USA');

INSERT INTO BOOK_SERVICES.AUTHOR (AUTHOR_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH,NATIONALITY)
VALUES(1103, 'J.R.R.', 'Tolkien', '1972-01-01', 'USA');

INSERT INTO BOOK_SERVICES.AUTHOR (AUTHOR_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH,NATIONALITY)
VALUES(1104, 'Gillian', 'Flynn', '1973-01-01', 'USA');

INSERT INTO BOOK_SERVICES.AUTHOR (AUTHOR_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH,NATIONALITY)
VALUES(1105, 'Howard', 'Zinn', '1974-01-01', 'USA');

INSERT INTO BOOK_SERVICES.BOOK (BOOK_ID, TITLE, GENRE,PUBLICATION_DATE,PRICE, AUTHOR_ID)
VALUES(1101, 'Pride and Prejudice', 'Classics', '2000-01-15', 135.00, 1101 );

INSERT INTO BOOK_SERVICES.BOOK (BOOK_ID, TITLE, GENRE,PUBLICATION_DATE,PRICE, AUTHOR_ID)
VALUES(1102, 'Dune', 'Science Fiction', '2000-01-15', 210.00, 1102 );

INSERT INTO BOOK_SERVICES.BOOK (BOOK_ID, TITLE, GENRE,PUBLICATION_DATE,PRICE, AUTHOR_ID)
VALUES(1103, 'The Lord of the Rings', 'Fantasy', '2000-01-15', 310.00, 1103 );

INSERT INTO BOOK_SERVICES.BOOK (BOOK_ID, TITLE, GENRE,PUBLICATION_DATE,PRICE, AUTHOR_ID)
VALUES(1104, 'Gone Girl', 'Mistery/Thriller', '2000-01-15', 410.00, 1104 );

INSERT INTO BOOK_SERVICES.BOOK (BOOK_ID, TITLE, GENRE,PUBLICATION_DATE,PRICE, AUTHOR_ID)
VALUES(1105, 'A Peoples History of the United States', 'History', '2000-01-15', 410.00, 1105 );
commit;
