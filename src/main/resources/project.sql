drop table ACCOUNTDETAILS;
drop table BOOKMARK;
DROP TABLE REVIEW;
DROP TABLE RESERVATION;
drop TABLE PRODUCT;
drop table CUSTOMER;



CREATE TABLE Customer
(
   name                 VARCHAR2(100)  NULL ,
   userPw               VARCHAR2(100)  NULL ,
   phoneNumber          VARCHAR2(100)  NULL ,
   emailAddress         VARCHAR2(100)  NULL ,
   birthDate            DATE  NULL ,
   userId               VARCHAR2(100)  NOT NULL 
   bankName             VARCHAR2(100)  NULL ,
   nameOnAccount        VARCHAR2(100)  NULL ,
   accountNumber        VARCHAR2(100)  NULL
);

CREATE UNIQUE INDEX XPKCustomer ON Customer
(userId   ASC);

ALTER TABLE Customer
   ADD CONSTRAINT  XPKCustomer PRIMARY KEY (userId);


CREATE TABLE Product
(
   productId            NUMBER(100,0)  NOT NULL ,
   location             VARCHAR2(100)  NULL ,
   price                NUMBER(10,0)  NULL ,
   description          VARCHAR2(1000)  NULL ,
   status               NUMBER(2,0)  NULL ,
   image                VARCHAR2(4000)  NULL ,
   name                 VARCHAR2(100)  NULL
);

CREATE UNIQUE INDEX XPKProduct ON Product
(productId   ASC);

ALTER TABLE Product
   ADD CONSTRAINT  XPKProduct PRIMARY KEY (productId);

CREATE TABLE BookMark
(
   productId            NUMBER(2,0)  NOT NULL ,
   userId               VARCHAR2(100)  NOT NULL 
);

CREATE UNIQUE INDEX XPKBookMark ON BookMark
(productId   ASC,userId   ASC);

ALTER TABLE BookMark
   ADD CONSTRAINT  XPKBookMark PRIMARY KEY (productId,userId);

CREATE TABLE Reservation
(
   reservationId        NUMBER(2,0)  NOT NULL ,
   name                 VARCHAR2(10)  NULL,
   startDate            DATE  NULL ,
   endDate              DATE  NULL ,
   headCount            NUMBER(100,0)  NULL ,
   price                NUMBER(10,0)  NULL ,
   reservationList      NUMBER(100,0)  NULL ,
   productId            NUMBER(100,0)  NOT NULL ,
   userId               VARCHAR2(100)  NOT NULL 
);

CREATE UNIQUE INDEX XPKReservation ON Reservation
(reservationId   ASC);

ALTER TABLE Reservation
   ADD CONSTRAINT  XPKReservation PRIMARY KEY (reservationId);

CREATE TABLE Review
(
   title                VARCHAR2(100)  NULL ,
   writeDate            DATE  NULL ,
   rating               NUMBER(2,1)  NULL  CONSTRAINT  Validation_Rule_Rating CHECK (rating BETWEEN 0 AND 5),
   content              VARCHAR2(100)  NULL ,
   image                VARCHAR2(4000)  NULL ,
   reservationId           NUMBER(100,0)  NOT NULL
);

CREATE UNIQUE INDEX XPKReview ON Review
(reservationId   ASC,userId   ASC);

ALTER TABLE Review
   ADD CONSTRAINT  XPKReview PRIMARY KEY (reservationId);

ALTER TABLE AccountDetails
   ADD (
CONSTRAINT Have FOREIGN KEY (userId) REFERENCES Customer (userId));

ALTER TABLE BookMark
   ADD (
CONSTRAINT bookMark1 FOREIGN KEY (productId) REFERENCES Product (productId));

ALTER TABLE BookMark
   ADD (
CONSTRAINT bookMark2 FOREIGN KEY (userId) REFERENCES Customer (userId));

ALTER TABLE Reservation
   ADD (
CONSTRAINT include FOREIGN KEY (productId) REFERENCES Product (productId));

ALTER TABLE Reservation
   ADD (
CONSTRAINT include FOREIGN KEY (name) REFERENCES Product (name));

ALTER TABLE Reservation
   ADD (
CONSTRAINT Reserve FOREIGN KEY (userId) REFERENCES Customer (userId));

ALTER TABLE Review
   ADD (
CONSTRAINT Review FOREIGN KEY (reservationId) REFERENCES Reservation (reservationId));

ALTER TABLE Product
   ADD type1 number(1) NOT NULL;
   
ALTER TABLE Product
   ADD type2 number(1) NOT NULL;

ALTER TABLE Product
   ADD type3 number(1) NOT NULL;   
   
ALTER TABLE Product DROP COLUMN type;

ALTER TABLE Customer
   ADD Bankname VARCHAR2(10);

ALTER TABLE Customer
   ADD NameOnAccount VARCHAR2(5);
   
ALTER TABLE Customer
   ADD AccountNumber VARCHAR2(20);
   
ALTER TABLE BookMark
   ADD name VARCHAR2(100);
   
ALTER TABLE BookMark
   ADD (
CONSTRAINT bookMark3 FOREIGN KEY (name) REFERENCES Product (name));

DROP TABLE AccountDetails;