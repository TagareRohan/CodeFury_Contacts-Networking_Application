# CodeFury_Contacts-Networking_Application

* Contacts table create query:
> create table contacts(userid int not null,fullName varchar(100) not null,email varchar(100) not null,phonenumber bigint,gender varchar(10),dateofbirth date,address varchar(100),city varchar(40),state varchar(40),country varchar(40),company varchar(50),image blob(102400),CONSTRAINT relationship PRIMARY KEY (userid,fullname),FOREIGN KEY (userid) REFERENCES users(id));
