drop table ACCOUNTDETAILS;
drop table BOOKMARK;
DROP TABLE REVIEW;
DROP TABLE RESERVATION;
drop TABLE PRODUCT;
drop table CUSTOMER;

CREATE TABLE Customer
(
	name                 VARCHAR2(5)  NULL ,
	userPw               VARCHAR2(12)  NULL ,
	phoneNumber          VARCHAR2(12)  NULL ,
	emailAddress         VARCHAR2(30)  NULL ,
	birthDate            DATE  NULL ,
	userId               VARCHAR2(12)  NOT NULL 
);

CREATE UNIQUE INDEX XPKCustomer ON Customer
(userId   ASC);

ALTER TABLE Customer
	ADD CONSTRAINT  XPKCustomer PRIMARY KEY (userId);

CREATE TABLE AccountDetails
(
	bankName             VARCHAR2(10)  NULL ,
	nameOnAccount        VARCHAR2(5)  NULL ,
	accountNumber        VARCHAR2(20)  NULL ,
	userId               VARCHAR2(12)  NOT NULL 
);

CREATE UNIQUE INDEX XPKAccountDetails ON AccountDetails
(userId   ASC);

ALTER TABLE AccountDetails
	ADD CONSTRAINT  XPKAccountDetails PRIMARY KEY (userId);

CREATE TABLE Product
(
	productId            NUMBER(6,0)  NOT NULL ,
	location             VARCHAR2(40)  NULL ,
	price                NUMBER(7,0)  NULL ,
	description          VARCHAR2(200)  NULL ,
	status               NUMBER(1,0)  NULL ,
	image                VARCHAR2(50)  NULL ,
	name                 VARCHAR2(5)  NULL ,
<<<<<<< HEAD
=======
	type                 NUMBER(1,0)  NULL
>>>>>>> 37048a29f3c92cb50797a2700fa126831a93f1f3
);

CREATE UNIQUE INDEX XPKProduct ON Product
(productId   ASC);

ALTER TABLE Product
	ADD CONSTRAINT  XPKProduct PRIMARY KEY (productId);

CREATE TABLE BookMark
(
	productId            NUMBER(6,0)  NOT NULL ,
	userId               VARCHAR2(12)  NOT NULL 
);

CREATE UNIQUE INDEX XPKBookMark ON BookMark
(productId   ASC,userId   ASC);

ALTER TABLE BookMark
	ADD CONSTRAINT  XPKBookMark PRIMARY KEY (productId,userId);

CREATE TABLE Reservation
(
	reservationId        NUMBER(6,0)  NOT NULL ,
	startDate            DATE  NULL ,
	endDate              DATE  NULL ,
	headCount            NUMBER(2,0)  NULL ,
	price                NUMBER(7,0)  NULL ,
	reservationList      NUMBER(2,0)  NULL ,
	productId            NUMBER(6,0)  NOT NULL ,
	userId               VARCHAR2(12)  NOT NULL 
);

CREATE UNIQUE INDEX XPKReservation ON Reservation
(reservationId   ASC);

ALTER TABLE Reservation
	ADD CONSTRAINT  XPKReservation PRIMARY KEY (reservationId);

CREATE TABLE Review
(
	title                VARCHAR2(20)  NULL ,
	writeDate            DATE  NULL ,
	rating               NUMBER(2,1)  NULL  CONSTRAINT  Validation_Rule_Rating CHECK (rating BETWEEN 0 AND 5),
	content              VARCHAR2(500)  NULL ,
	image                VARCHAR2(50)  NULL ,
	reservationId        	NUMBER(6,0)  NOT NULL
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
	
ALTER TABLE Prodcut DROP COLUMN type;