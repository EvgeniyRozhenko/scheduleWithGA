CREATE DATABASE ScheduleDB;
USE ScheduleDB;

CREATE TABLE Speciality(
idSpeciality int not null auto_increment,
specialityName varchar(45) not null,
PRIMARY KEY(idSpeciality)
);

CREATE TABLE Teacher(
idTeacher int not null auto_increment,
fullName varchar(60) not null,
specialityId int not null,
PRIMARY KEY(idTeacher),
foreign key (specialityId) references Speciality(idSpeciality)
);

SELECT * FROM Teacher;

CREATE TABLE Classroom(
idRoom int not null auto_increment,
roomNumber int(4) not null,
capacity int not null,
PRIMARY KEY(idRoom)
);

SELECT * FROM Classroom;

CREATE TABLE TimePeriod(
idTimePeriod int not null auto_increment,
timeFrom varchar(45) not null,
timeTo varchar(45) not null,
PRIMARY KEY(idTimePeriod)
);

SELECT * FROM TimePeriod;

CREATE TABLE WeekDay(
idWeekDay int not null auto_increment,
dayName varchar(15) not null,
PRIMARY KEY(idWeekDay)
);

SELECT * FROM WeekDay;

CREATE TABLE TimeSlot(
idTimeSlot int not null auto_increment,
timePeriodId int not null,
weekDayId int not null,
PRIMARY KEY(idTimeSlot),
FOREIGN KEY(timePeriodId) REFERENCES TimePeriod(idTimePeriod),
FOREIGN KEY(weekDayId) REFERENCES WeekDay(idWeekDay)
);

SELECT * FROM TimeSlot;

CREATE TABLE Lesson(
idLesson int not null auto_increment,
lessonName varchar(45) not null,
specialityId int not null,
PRIMARY KEY(idLesson),
foreign key (specialityId) references Speciality(idSpeciality)
);

SELECT * FROM Lesson;

CREATE TABLE ClassGroup(
idClassGroup int not null auto_increment,
groupName varchar(45) not null,
groupSize int(2) not null,
PRIMARY KEY(idClassGroup)
);

SELECT * FROM ClassGroup;

CREATE TABLE LessonInGroup(
idLessonInGroup int not null auto_increment,
lessonId int not null,
groupId int not null,
hoursPerWeek int,
PRIMARY KEY(idLessonInGroup),
FOREIGN KEY(lessonId) REFERENCES Lesson(idLesson),
FOREIGN KEY(groupId) REFERENCES ClassGroup(idClassGroup)
);

SELECT * FROM LessonInGroup;

CREATE TABLE Schedule(
idSchedule int not null auto_increment,
timeSlotId int not null,
teacherId int not null,
lessonInGroupId int not null,
classroomId int not null,
PRIMARY KEY(idSchedule),
FOREIGN KEY(timeSlotId) REFERENCES TimeSlot(idTimeSlot),
FOREIGN KEY(teacherId) REFERENCES Teacher(idTeacher),
FOREIGN KEY(lessonInGroupId) REFERENCES LessonInGroup(idLessonInGroup),
FOREIGN KEY(classroomId) REFERENCES Classroom(idRoom)
);

SELECT * FROM Schedule;