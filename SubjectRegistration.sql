drop database if exists SubjectRegistration;

create database if not exists SubjectRegistration;

use SubjectRegistration;

create table Subjects (
	SubjectID		tinyint unsigned auto_increment primary key,
    SubjectName		nvarchar(30) not null unique key
);

create table TimeSlot (
	TimeSlotID		tinyint unsigned auto_increment primary key,
    DayOfTheWeek	enum('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday') not null,
    NumberOfPeriod	tinyint unsigned not null,
    StartAtPeriod	tinyint unsigned not null,
    EndAtPeriod		tinyint unsigned not null
);

create table Class (
	ClassID			tinyint unsigned auto_increment primary key,
    SubjectID		tinyint unsigned not null,
    TimeSlotID		tinyint unsigned not null
);

alter table Class add constraint lk1 foreign key (SubjectID) references Subjects(SubjectID);
alter table Class add constraint lk2 foreign key (TimeSlotID) references TimeSlot(TimeSlotID);

alter table Class add constraint lk3 unique (SubjectID, TimeSlotID);

create table Student (
	StudentID		tinyint unsigned auto_increment primary key,
    StudentName		nvarchar(30) not null,
    StudentEmail	nvarchar(30) not null unique,
    StudentPassword	nvarchar(200) not null,
    StudentStatus	enum('0', '1') not null
);

create table StudentClass (
	StudentClassID	tinyint unsigned auto_increment primary key,
	StudentID		tinyint unsigned,
    ClassID			tinyint unsigned
);

alter table StudentClass add constraint lk4 foreign key (StudentID) references Student(StudentID);
alter table StudentClass add constraint lk5 foreign key (ClassID) references Class(ClassID);

alter table StudentClass add constraint lk6 unique (StudentID, ClassID);

create table RegistrationUserToken (
	RegistrationUserTokenID	tinyint unsigned auto_increment primary key,
    Token					nvarchar(36) not null unique,
    StudentID				tinyint unsigned not null,
    ExpiredDate				datetime not null
);

insert into Subjects (SubjectName) values ('Toán'), ('Lý'), ('Hóa'), ('Văn'), ('Anh'), ('Sinh'), ('Sử'), ('Địa');

insert into TimeSlot (DayOfTheWeek, NumberOfPeriod, StartAtPeriod, EndAtPeriod) values ('Monday', 4, 1, 4);
insert into TimeSlot (DayOfTheWeek, NumberOfPeriod, StartAtPeriod, EndAtPeriod) values ('Wednesday', 2, 2, 3);
insert into TimeSlot (DayOfTheWeek, NumberOfPeriod, StartAtPeriod, EndAtPeriod) values ('Thursday', 2, 1, 2);
insert into TimeSlot (DayOfTheWeek, NumberOfPeriod, StartAtPeriod, EndAtPeriod) values ('Tuesday', 3, 3, 5);
insert into TimeSlot (DayOfTheWeek, NumberOfPeriod, StartAtPeriod, EndAtPeriod) values ('Monday', 2, 3, 4);
insert into TimeSlot (DayOfTheWeek, NumberOfPeriod, StartAtPeriod, EndAtPeriod) values ('Friday', 1, 1, 1);
insert into TimeSlot (DayOfTheWeek, NumberOfPeriod, StartAtPeriod, EndAtPeriod) values ('Wednesday', 2, 2, 3);
insert into TimeSlot (DayOfTheWeek, NumberOfPeriod, StartAtPeriod, EndAtPeriod) values ('Friday', 2, 3, 4);

insert into Class (SubjectID, TimeSlotID) values (1, 1);
insert into Class (SubjectID, TimeSlotID) values (2, 2);
insert into Class (SubjectID, TimeSlotID) values (3, 3);
insert into Class (SubjectID, TimeSlotID) values (4, 4);
insert into Class (SubjectID, TimeSlotID) values (5, 5);
insert into Class (SubjectID, TimeSlotID) values (6, 6);
insert into Class (SubjectID, TimeSlotID) values (7, 7);
insert into Class (SubjectID, TimeSlotID) values (8, 8);

insert into Student (StudentName, StudentEmail, StudentPassword, StudentStatus) values	('Nguyễn Văn A', 's0m4li1@gmail.com', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 1),
																						('Trần Văn B', 's0m4li2@gmail.com', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 1),
																						('Dương Văn C', 's0m4li3@gmail.com', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 1);

insert into StudentClass (StudentID, ClassID) values (1, 1);
insert into StudentClass (StudentID, ClassID) values (1, 2);
insert into StudentClass (StudentID, ClassID) values (1, 3);

select * from StudentClass;

-- select * from StudentClass order by StudentClassID;

-- select SC.StudentID, SC.ClassName, TS.NumberOfPeriod from StudentClass as SC inner join Class as C on SC.ClassName = C.ClassName inner join TimeSlot as TS on C.TimeSlotID = TS.TimeSlotID;