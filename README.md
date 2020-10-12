# CodeFury_Contacts-Networking_Application

### Setup Required
> Package : com.training.utils --> File : CoonectionUtility.java --> line 15 --> Change DB location to your preffered location.
> Package : com.training.utils --> File : AdminParser.java --> line 27 --> Enter absolute location of Admins.xml to parse method.
> Package : com.training.services --> File : UserDaoImpl.java --> line 53 --> Enter absolute location of Profile.png to FileInputStream.
> Package : com.training.services --> File : VerificationService.java --> line 90 [Link to line](https://github.com/TagareRohan/CodeFury_Contacts-Networking_Application/blob/8a49dc9342d1c443106b6f216e24261d1874286b/Networking_Application/src/com/training/services/VerificationService.java#L90)  --> Enter absolute location of Profile.png to FileInputStream.

### Users table create query:
> create table users(id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,fullName varchar(100),email varchar(100),phonenumber bigint,gender varchar(10),dateofbirth date,address varchar(100),city varchar(40),state varchar(40),country varchar(40),company varchar(50),image blob(102400),username varchar(50),password varchar(50));

### Contacts table create query:
> create table contacts(userid int not null,fullName varchar(100) not null,email varchar(100) not null,phonenumber bigint,gender varchar(10),dateofbirth date,address varchar(100),city varchar(40),state varchar(40),country varchar(40),company varchar(50),image blob(102400),CONSTRAINT relationship PRIMARY KEY (userid,fullname),FOREIGN KEY (userid) REFERENCES users(id));

### Relationship table create query:
> create table Relationship(userid1 integer NOT NULL,userid2 integer NOT NULL,status integer,actionId integer,CONSTRAINT relation PRIMARY KEY (userid1,userid2),FOREIGN KEY (userid1) REFERENCES users(id),FOREIGN KEY (userid2) REFERENCES users(id));

### Disabled table create query:
> create table disabled (userid int not null, email varchar(100), CONSTRAINT disabled PRIMARY KEY (userid));
