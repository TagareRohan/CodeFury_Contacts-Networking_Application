# CodeFury_Contacts-Networking_Application

* Users table create query:
> create table users(id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,fullName varchar(100),email varchar(100),phonenumber bigint,gender varchar(10),dateofbirth date,address varchar(100),city varchar(40),state varchar(40),country varchar(40),company varchar(50),image blob(102400),username varchar(50),password varchar(50));

* Contacts table create query:
> create table contacts(userid int not null,fullName varchar(100) not null,email varchar(100) not null,phonenumber bigint,gender varchar(10),dateofbirth date,address varchar(100),city varchar(40),state varchar(40),country varchar(40),company varchar(50),image blob(102400),CONSTRAINT relationship PRIMARY KEY (userid,fullname),FOREIGN KEY (userid) REFERENCES users(id));

* Relationship table create query:
> create table Relationship(userid1 integer NOT NULL,userid2 integer NOT NULL,status integer,actionId integer,CONSTRAINT relation PRIMARY KEY (userid1,userid2),FOREIGN KEY (userid1) REFERENCES users(id),FOREIGN KEY (userid2) REFERENCES users(id));

* Disabled table create query:
> create table disabled (userid int not null, email varchar(100), CONSTRAINT disabled PRIMARY KEY (userid));
