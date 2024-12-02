CREATE SCHEMA IF NOT EXISTS GAJULA_SERVICES;
SET SCHEMA GAJULA_SERVICES;

drop table if exists gajula_services.AUTHOR cascade;
drop table if exists gajula_services.BOOK cascade;
drop sequence if exists gajula_services.authorid_seq;
drop sequence if exists gajula_services.bookid_seq;
create sequence gajula_services.authorid_seq start with 1 increment by 1;
create sequence gajula_services.bookid_seq start with 1 increment by 1;
commit;

create table gajula_services.AUTHOR
(AUTHOR_ID numeric(38,0) not null,
DATE_OF_BIRTH TIMESTAMP,
FIRST_NAME varchar(255),
LAST_NAME varchar(255),
NATIONALITY varchar(255),
primary key (AUTHOR_ID));
commit;

create table gajula_services.BOOK
(BOOK_ID numeric(38,0) not null,
PRICE float(53),
PUBLICATION_DATE TIMESTAMP,
AUTHOR_ID varchar(255),
GENRE varchar(255),
TITLE varchar(255),
primary key (BOOK_ID));
commit;

alter table if exists gajula_services.BOOK
add constraint fk_author_id foreign key (author_id) references GAJULA_SERVICES.AUTHOR;
commit;


INSERT INTO GAJULA_SERVICES.AUTHOR (AUTHOR_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH,NATIONALITY)
VALUES(1101, 'Jane', 'Austen', '1970-01-01', 'USA');

INSERT INTO GAJULA_SERVICES.AUTHOR (AUTHOR_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH,NATIONALITY)
VALUES(1102, 'Frank', 'Herbert', '1971-01-01', 'USA');

INSERT INTO GAJULA_SERVICES.AUTHOR (AUTHOR_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH,NATIONALITY)
VALUES(1103, 'J.R.R.', 'Tolkien', '1972-01-01', 'USA');

INSERT INTO GAJULA_SERVICES.AUTHOR (AUTHOR_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH,NATIONALITY)
VALUES(1104, 'Gillian', 'Flynn', '1973-01-01', 'USA');

INSERT INTO GAJULA_SERVICES.AUTHOR (AUTHOR_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH,NATIONALITY)
VALUES(1105, 'Howard', 'Zinn', '1974-01-01', 'USA');

INSERT INTO GAJULA_SERVICES.BOOK (BOOK_ID, TITLE, GENRE,PUBLICATION_DATE,PRICE, AUTHOR_ID)
VALUES(1101, 'Pride and Prejudice', 'Classics', '2000-01-15', 135.00, 1101 );

INSERT INTO GAJULA_SERVICES.BOOK (BOOK_ID, TITLE, GENRE,PUBLICATION_DATE,PRICE, AUTHOR_ID)
VALUES(1102, 'Dune', 'Science Fiction', '2000-01-15', 210.00, 1102 );

INSERT INTO GAJULA_SERVICES.BOOK (BOOK_ID, TITLE, GENRE,PUBLICATION_DATE,PRICE, AUTHOR_ID)
VALUES(1103, 'The Lord of the Rings', 'Fantasy', '2000-01-15', 310.00, 1103 );

INSERT INTO GAJULA_SERVICES.BOOK (BOOK_ID, TITLE, GENRE,PUBLICATION_DATE,PRICE, AUTHOR_ID)
VALUES(1104, 'Gone Girl', 'Mistery/Thriller', '2000-01-15', 410.00, 1104 );

INSERT INTO GAJULA_SERVICES.BOOK (BOOK_ID, TITLE, GENRE,PUBLICATION_DATE,PRICE, AUTHOR_ID)
VALUES(1105, 'A Peoples History of the United States', 'History', '2000-01-15', 410.00, 1105 );
commit;

drop table if exists gajula_services.CUSTOMER cascade;
drop table if exists gajula_services.VEHICLE cascade;
drop sequence if exists gajula_services.custuid_seq;
drop sequence if exists gajula_services.vehuid_seq;
CREATE SEQUENCE GAJULA_SERVICES.custuid_seq start with 1 increment by 1;
CREATE SEQUENCE GAJULA_SERVICES.vehuid_seq start with 1 increment by 1;
commit;

CREATE TABLE IF NOT EXISTS GAJULA_SERVICES.customer
(
    cust_uid bigint PRIMARY KEY,
    custname VARCHAR(100),
    custnumber bigint,
    email_address VARCHAR(100),
    phone bigint,
    createddate timestamp without time zone,
    modifieddate timestamp without time zone
);
CREATE TABLE IF NOT EXISTS GAJULA_SERVICES.vehicle
(
    vehicle_uid bigint PRIMARY KEY,
    vin VARCHAR(100),
    vrn VARCHAR(100),
    cust_uid bigint,
    CONSTRAINT fk_customer FOREIGN KEY(cust_uid)
	REFERENCES GAJULA_SERVICES.customer(cust_uid)
);
COMMIT;

INSERT INTO GAJULA_SERVICES.customer(cust_uid,createddate, custname, custnumber, email_address, modifieddate, phone)
VALUES (11,CURRENT_DATE, 'test1', '1101','test1@GMAIL.COM', CURRENT_DATE, '1234567891');
INSERT INTO GAJULA_SERVICES.vehicle(vehicle_uid, vin, vrn, cust_uid)
VALUES (11, 'vin1101', 'vrn1001', 11);
COMMIT;

