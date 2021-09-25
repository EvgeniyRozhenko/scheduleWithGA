USE ScheduleDB;

insert Speciality (specialityName)
values ("Физика"),("Математика"),("Английский язык"),("История"),("Биология"),("Физ подготовка");

insert Teacher(fullName, specialityId)
values ("Физик",1), ("Математик",2),("Англичанин",3),("Историк",4),("Биолог",5),
("Физкультурник",6),("Математик2",2),("Математик3",2),("Историк2",4),("Биолог2",5);

insert Classroom(roomNumber, capacity)
values (101, 32),(102, 32),(103, 40),(104, 30),(105, 30),(106, 30),
(107, 34),(108, 36),(109, 32),(110, 40),(111, 42),(112, 28);

insert TimePeriod(timeFrom, timeTo)
values ("8:00","8:45"),("9:00","9:45"),("10:00","10:45"),("11:00","11:45"),
("12:00","12:45"),("13:00","13:45"),("14:00","14:45"),("15:00","15:45");

insert WeekDay(dayName)
values ("Monday"),("Tuesday"),("Wednesday"),("Thursday"),("Friday");

insert TimeSlot(weekDayId, timePeriodId)
values (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8),
(2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (2, 7), (2, 8),
(3, 1), (3, 2), (3, 3), (3, 4), (3, 5), (3, 6), (3, 7), (3, 8),
(4, 1), (4, 2), (4, 3), (4, 4), (4, 5), (4, 6), (4, 7), (4, 8),
(5, 1), (5, 2), (5, 3), (5, 4), (5, 5), (5, 6), (5, 7), (5, 8);

insert Lesson(lessonName, specialityId)
values ("Физика", 1), ("Алгебра", 2), ("Геометрия", 2), ("Математика", 2), ("Английский язык", 3),
 ("История Украины", 4), ("История мира", 4), ("Биология", 5), ("Природоведение", 5), ("Физкультура", 6);
 
 insert ClassGroup(groupName, groupSize, lessonsPerWeek)
 values ("5-A", 26, 14), ("9-A", 25, 23), ("10-A", 30, 25);
 
 insert LessonInGroup(lessonId, groupId, hoursPerWeek)
 values (4, 1, 4), (5, 1, 3),(6, 1, 2), (7, 1, 2), (9, 1, 1), (10, 1, 2),
 (1, 2, 3), (2, 2, 4), (3, 2, 4), (5, 2, 3), (6, 2, 2), (7, 2, 2), (8, 2, 3), (10, 2, 2),
 (1, 2, 4), (2, 3, 4), (3, 3, 4), (5, 3, 4), (6, 3, 2), (7, 3, 1), (8, 3, 4), (10, 3, 2);
 