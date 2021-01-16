create database  office_hours_management;
use office_hours_management;
create table subject_staff(
RowID int not null AUTO_INCREMENT unique,
Member_1_ID  int,
Member_2_ID int,
Member_3_ID int ,
Member_4_ID int ,
Member_5_ID int,
primary key(RowID)
);
INSERT INTO subject_staff (Member_1_ID,Member_2_ID,Member_3_ID,Member_4_ID,Member_5_ID) VALUES (1,2,3,4,5);

CREATE TABLE student_subject (
    RowID INT NOT NULL AUTO_INCREMENT unique,
    subject_1_ID INT,
    subject_2_ID INT,
    subject_3_ID INT,
    subject_4_ID INT,
    subject_5_ID int,
    subject_6_ID int,
    PRIMARY KEY (RowID)
);
create table member_office_hours(
RowID int not null AUTO_INCREMENT unique,
office_hours_1_ID int ,
office_hours_2_ID int ,
office_hours_3_ID int ,
office_hours_4_ID int ,
primary key (RowID)
);
create table messages(
messageID int not null AUTO_INCREMENT unique,
messageSenderemail varchar(200),
messageReciveremail  varchar(200),
messageContent   varchar(400),
senddate             date,
primary key (messageID)
);
create table appointment(
AppointmentID int not null AUTO_INCREMENT unique,
AppointmentDate date,
AppointmentSlot int,
MemberID int,
StudentID int,
primary key (AppointmentID)
);

create  table subject(
SubjectID int not null AUTO_INCREMENT unique,
SubjectName varchar(200),
RowID int,
primary Key (SubjectID),
foreign key(RowID) REFERENCES subject_staff(RowID)
);
INSERT INTO subject (SubjectName) VALUES ('Math');

create table staff_member(
MemberID int not null AUTO_INCREMENT unique,
MemberRole varcharacter(100),
MemberfName varchar(200),
MemberlName varchar(200),
MemberUsername  varchar(200),
MemberEmail varchar(400),
Mmberpwd   varchar(200),  
StudentMessage varchar(1000),
SubjectName varchar(200),
SubjectID int,
clientsRowID int,
AppointmentID int,
RowID    int,
primary key(MemberID),
foreign key(SubjectID) REFERENCES subject(SubjectID),
foreign key(AppointmentID) REFERENCES appointment(AppointmentID)
);

create table office_hours(
OfficeHourID int not Null AUTO_INCREMENT unique,
AvailableDay date,
AvailableTime time,
fromslot int,
toslot int,
MemberID int,
primary Key(OfficeHourID),
foreign key(MemberID) REFERENCES staff_member(MemberID)
);

create table student(
StudentID int not null AUTO_INCREMENT unique,
StudentFName varchar(200),
StudentLName varchar(200),
StudentEmail varchar(400),
StudentUsername
Studentpwd   varchar (200),
RowID int,
AppointmentID int,
primary key(StudentID),
foreign key(RowID) REFERENCES student_subject(RowID),
foreign key(AppointmentID) REFERENCES appointment(AppointmentID)
);