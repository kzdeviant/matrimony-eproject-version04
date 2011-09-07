USE master
go
IF EXISTS(SELECT * FROM sys.databases WHERE name='Matrimony') DROP DATABASE Matrimony
go
CREATE DATABASE Matrimony
go
USE Matrimony

go
/********************************  Users ****************************************/
CREATE TABLE Users (
	UserID			int primary key identity, 
	[Role]			int NOT NULL default(0),	
	Username		nvarchar(50) NOT NULL,
	Password		nvarchar(500) NOT NULL,
	Email			nvarchar(50)  NOT NULL,
	LastLogin		datetime,
	Status			int default 1, 
	CreatedDate		datetime default getDate()
)
-----------------Role------------------------
--0. administrator
--1. user free
--2. user paid
--....
----------------RserStatus-------------------
--1. Enable
--2. Disabled
go
/******************************** User Profile ****************************************/
CREATE TABLE UserProfile (
	UserID			int primary key references Users(userID),
	Firstname		nvarchar(50),
	MiddleName		nvarchar(50),
	LastName		nvarchar(50),
	Gender			int,
	DateOfBirth		datetime,
	MaritalStatus	nvarchar(50) NOT NULL default 'unknown',
	Height			varchar(50),
	Weight			varchar(50),
	MotherTongue	nvarchar(250),
	ContactNumber	varchar(50),
	Work			nvarchar(250),
	Religion		nvarchar(255),
	Caste			nvarchar(255),
	countryLiving	nvarchar(255),
	City			nvarchar(200),
)
------- gender----------------------------------
-- 0: Fermale
-- 1: Male
----------------maritalStatus-------------------
-- Never Married
-- Divorced
-- Widowed
go
/******************************** User Personal ****************************************/	
CREATE TABLE UserPersonal (
	UserID				int primary key references Users(UserID),
	SelfFeatures		nvarchar(250) NULL,
	FamilyDetails		nvarchar(250) NULL,
	QualificationStatus	nvarchar(250) NULL,
	Designation			nvarchar(250) NULL,
	Location			nvarchar(250) NULL,
	FavoriteHobbies		nvarchar(250) NULL,
	FavoriteMusics		nvarchar(250) NULL,
	FavoriteMovies		nvarchar(250) NULL,
	FavoriteBooks		nvarchar(250) NULL,
	favoriteCuisines	nvarchar(250) NULL,
	FavoritePlace		nvarchar(250) NULL
)
go
/******************************** User Photo Album ****************************************/
CREATE TABLE UserAlbum (
	AlbumID        	int primary key identity,
	UserID			int references Users(UserID),
	AlbumTitle		nvarchar(250) NOT NULL default 'untitled', 	
	AlbumProfile	nvarchar(250) NOT NULL default 'untitled',
	LastUpdated		datetime,
	CreatedDate		datetime default getDate(),
	Status			int default 1, 
)
go
/******************************** User Photo ****************************************/
CREATE TABLE userPhoto(
	PhotoID        	int primary key identity, 
	AlbumID			int references userAlbum(albumID),
	PhotoLabel		nvarchar(250) NOT NULL default 'untitled',
	PhotoProfile	nvarchar(525) NOT NULL default 'unknown',
	IsMainAvatar    int,
	FilePath		nvarchar(250) NOT NULL default 'default.jpg',	
	UploadDate		datetime default getDate()
)
go
/******************************** User Service Package ****************************************/
CREATE TABLE UserServicePackage(
	ServiceID		int primary key identity, 
	ServiceName		nvarchar(50) NOT NULL,
	[Description]	nvarchar(60) null default 'unknown',
	Price			float  NOT NULL,
	Status			int default 1, 
)
go
/******************************** User Service Charge****************************************/
CREATE TABLE UserServiceCharge(
	ChargeID		 int primary key identity,
	ServiceID		 int references userServicePackage(serviceID),
	UserID			 int references users(userID),
	StartedDate		 datetime NOT NULL,
	ExpiredDate		 datetime NOT NULL,
	Status			 int
)
go
/******************************** User Payment****************************************/
CREATE TABLE UserPayment(
	PaymentID		int primary key identity,
	UserID			int references users(userID),
	PayGate			nvarchar(50) NOT NULL,
	AccountID		nvarchar(50) NOT NULL,
	TotalMoney		float NOT NULL,
	CreatedDate		datetime default getdate(),
	Status			int
)
go
/******************************** Site Contact ****************************************/
CREATE TABLE SiteContact(
	ContactID			int primary key identity,
	ContactName			nvarchar(250) NOT NULL,
	ContactNumber		nvarchar(250) NOT NULL,
	Email				nvarchar(50) NOT NULL,
	Comment				ntext NULL default 'unknown',
	CreatedDate			datetime default getDate(),
	Status				int, 
)


/********************************userRelationship******************************************/
CREATE TABLE UserRelationship(
	RelationID		int primary key identity,
	ReqUserID		int references users(userID),
	ResUserID		int references users(userID),
	Relationship	nvarchar(250) NOT NULL,
	CreatedDate		datetime default getdate(),
	Status			int, 
)
go
/********************************advCustomer******************************************/
CREATE TABLE AdvCustomer(
	CustomerID		int primary key identity,
	FullName		nvarchar(250) NOT NULL,
	Email			nvarchar(50) NOT NULL,
	Gender			bit default '1',
	Company			nvarchar(50) NULL default 'unknown',
	Phone			nvarchar(125) NULL,
	ContactAddress	nvarchar(525) NULL default 'unknown',
	Note			nvarchar(525) NULL default 'unknown',
	Edition			nvarchar(250) NULL default 'unknown',
	PostContent		nvarchar(525) NULL default 'unknown',
	CreatedDate		datetime default getdate(),
	Status			int
)
go
/********************************advCustomerPayment******************************************/
CREATE TABLE AdvCustomerPayment(
	PaymentID	Int primary key identity,
	CustomerID	int references advCustomer(customerID),
	PayGate		nvarchar(50) NOT NULL,
	AccountID	nvarchar(50) NOT NULL,
	TotalMoney	float NOT NULL,
	CreatedDate	datetime default getdate(),
	Status		int
)
go

/********************************NewThread******************************************/
CREATE TABLE NewThread(
	NewThreadID		Int primary key identity,
	UserID			int references users(userID),
	Title			nvarchar(255) NOT NULL,
	MessageThread		nvarchar(525) NOT NULL,
	CreatedDate		datetime default getdate(),
	Status			int
)
go

/********************************Reply******************************************/
CREATE TABLE Reply(
	ReplyID			Int primary key identity,
	NewThreadID		int references NewThread(NewThreadID),
	UserID			int references users(userID),
	Title			nvarchar(255) NOT NULL,
	MessageReply	nvarchar(525) NOT NULL,
	CreatedDate		datetime default getdate(),
)
go
/********************************Insert to Users******************************************/
INSERT INTO Users ([Role], Username, Password, Email, Status) VALUES(1,'tuyendn','e10adc3949ba59abbe56e057f20f883e','dangngoctuyen@gmail.com',1)
INSERT INTO Users ([Role], Username, Password, Email, Status) VALUES(1,'cuongnh','e10adc3949ba59abbe56e057f20f883e','nguyenhungcuongbn@gmail.com',1)
INSERT INTO Users ([Role], Username, Password, Email, Status) VALUES(1,'admin','e10adc3949ba59abbe56e057f20f883e','abcxyz@gmail.com',1)
INSERT INTO Users ([Role], Username, Password, Email, Status) VALUES(1,'admin123','e10adc3949ba59abbe56e057f20f883e','dangngoctuyen@gmail.com',1)
go
/********************************Insert to UserProfile******************************************/
INSERT INTO UserProfile(UserID) VALUES(1)
INSERT INTO UserProfile(UserID) VALUES(2)
INSERT INTO UserProfile(UserID) VALUES(3)
INSERT INTO UserProfile(UserID) VALUES(4)
go
/********************************Insert to UserPersonal******************************************/
INSERT INTO UserPersonal(UserID) VALUES(1)
INSERT INTO UserPersonal(UserID) VALUES(2)
INSERT INTO UserPersonal(UserID) VALUES(3)
INSERT INTO UserPersonal(UserID) VALUES(4)
go
/********************************Insert to thread******************************************/
INSERT INTO NewThread(UserID,Title,MessageThread,[Status]) VALUES(1,'What your name ?','What your name ?',1)
INSERT INTO Reply(UserID,NewThreadID,Title,MessageReply) VALUES(2,1,'Title','What your name ?')
INSERT INTO Reply(UserID,NewThreadID,Title,MessageReply) VALUES(3,1,'Title','What your name ?')
