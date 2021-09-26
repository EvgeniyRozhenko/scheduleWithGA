package com.solvd.scheduleWithGA.main;

import com.solvd.scheduleWithGA.dao.implementation.ClassroomService;
import com.solvd.scheduleWithGA.dao.implementation.LessonService;
import com.solvd.scheduleWithGA.dao.implementation.TeacherService;
import com.solvd.scheduleWithGA.dao.implementation.TimeSlotService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        TeacherService teacherService = new TeacherService();
        LOGGER.info(teacherService.getTeachersHashMap());
        ClassroomService classroomService = new ClassroomService();
        LOGGER.info(classroomService.getClassroombyId(1));
        TimeSlotService timeSlotService = new TimeSlotService();
        LOGGER.info(timeSlotService.getTimeSlotById(1));
        LessonService lessonService = new LessonService();
        LOGGER.info(lessonService.getLessonById(1));
    }
}
