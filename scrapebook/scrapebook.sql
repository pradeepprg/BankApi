CREATE TABLE USERS_BANKING(
sid varchar2(20) PRIMARY KEY,
name varchar2(255) not null,
gender varchar2(1) CHECK (gender IN ('M','F','O')) not null,
address varchar2(255) not null,
address2 varchar2(255) not null,
city varchar2(255) not null,
state varchar2(255) not null,
country varchar2(255) not null,
zip varchar2(255) not null,
phone varchar2(10) not null,
email varchar2(255) not null,
password varchar2(255) not null,
dob date not null,
sid_doc_id number not null,
doc1_id number not null,
doc2_id number not null
);

DROP TABLE USERS_BANKING;


SELECT * FROM USERS_BANKING;

--------------------------------------------ACCOUNTS----------------------------------------------------

CREATE TABLE ACCOUNTS_BANKING(
accno varchar2(255) primary key,
sid REFERENCES USERS_BANKING(sid) not null,
acctype varchar2(1) CHECK (acctype IN ('S','C')),
balance decimal(15,2) not null,
cashcid varchar2(16) REFERENCES CASH_CARD_BANKING(ccid) not null
);

drop table ACCOUNTS_BANKING

SELECT * FROM ACCOUNTS_BANKING

--------------------------------------------CASH CARD-----------------------------------------------------

CREATE TABLE CASH_CARD_BANKING(
ccid varchar2(20) primary key,
ccno varchar2(16) not null,
cid varchar2(16) REFERENCES CREDIT_CARD_BANKING(cid) not null
);

drop table CASH_CARD_BANKING

SELECT * FROM CASH_CARD_BANKING
----------------------------------------CREDIT CARD-------------------------------------------------------


CREATE TABLE CREDIT_CARD_BANKING(
cid varchar2(20) primary key,
cno varchar2(16) not null,
caddress varchar2(255) not null,
caddress2 varchar2(255) not null,
ccity varchar2(255) not null,
cstate varchar2(255) not null,
ccountry varchar2(255) not null,
czip varchar2(255) not null,
month varchar2(255) not null,
year varchar2(255) not null,
cvv number(4) not null
);


drop table CREDIT_CARD_BANKING
SELECT * FROM CREDIT_CARD_BANKING;


-----------------------------------------------BLACK LIST-------------------------------------------------

CREATE TABLE BLACK_LIST_BANKING(
id varchar2(20) primary key,
sid varchar2(20) not null,
bltype number CHECK (bltype IN(1,2))
);

SELECT * FROM BLACK_LIST_BANKING

--------------------------------------FILES TABLE-------------------------------------------------------------

CREATE TABLE FILES_BANKING(
fid number primary key,
doc_name varchar2(255) not null
);