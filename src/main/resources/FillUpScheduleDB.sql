USE ScheduleDB;

insert into Speciality(specialityName)
VALUES ('Physics'),('Mathematics'),('English'),('History'),('Biology'),('Physical training');

insert into Teacher(fullName, specialityId)
values ("Irina Korniyenko",1),("Natalia Balamutova",2),("Maria Kobanchik",3),("Oleg Cepunko",4),("Elena Sergeeva",5),
("Oleg Boyko",6),("Ruben Shishkaridze",2),("Elvira Markova",2),("Sergey Sergeev",4),("Oksana Buskina",5);

insert into Lesson(lessonName, specialityId)
values ("Physics",1),("Algebra",2),("Geometry",2),("Mathematics",2),("English",3),
("History of Ukraine",4),("World history",4),("Biology",5),("Nature-study",5),("Physical training",6);

insert into ClassGroup(groupName, groupSize)
values ("5-A",26),("9-A",25),("10-A",30);

insert into LessonInGroup(lessonId, groupId, hoursPerWeek)
values (4,1,4),(5,1,3),(6,1,2),(7,1,2),(9,1,1),(10,1,2),
(1,2,3),(2,2,4),(3,2,4),(5,2,3),(6,2,2),(7,2,2),(8,2,3),(10,2,2),
(1,3,4),(2,3,4),(3,3,4),(5,3,4),(6,3,2),(7,3,1),(8,3,4),(10,3,2);

insert into Classroom(roomNumber, capacity)
values (101,32),(102,32),(103,40),(104,30),(105,30),(106,30),
(107,34),(108,36),(109,32),(110,40),(111,42),(112,28);

insert WeekDay(dayName)
values ("Monday"),("Tuesday"),("Wednesday"),("Thursday"),("Friday");

insert into TimePeriod(timeFrom, timeTo)
values ("8:00","8:45"),("9:00","9:45"),("10:00","10:45"),("11:00","11:45"),
("12:00","12:45"),("13:00","13:45"),("14:00","14:45"),("15:00","15:45");

insert into TimeSlot(timePeriodId, weekDayId)
values (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),
(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),
(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),
(1,4),(2,4),(3,4),(4,4),(5,4),(6,4),(7,4),(8,4),
(1,5),(2,5),(3,5),(4,5),(5,5),(6,5),(7,5),(8,5);