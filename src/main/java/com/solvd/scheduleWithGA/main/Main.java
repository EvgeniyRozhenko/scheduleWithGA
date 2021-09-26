package com.solvd.scheduleWithGA.main;

import com.solvd.scheduleWithGA.binary.Teacher;
import com.solvd.scheduleWithGA.dao.implementation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        TeacherService teacherService = new TeacherService();
        LOGGER.info(teacherService.getTeachersHashMap());
        ClassroomService classroomService = new ClassroomService();
        LOGGER.info(classroomService.getClassroomHashMap());
        TimeSlotService timeSlotService = new TimeSlotService();
        LOGGER.info(timeSlotService.getTimeSlotHashMap());
        LessonService lessonService = new LessonService();
        LOGGER.info(lessonService.getLessonHashMap());
        ClassGroupService classGroupService = new ClassGroupService();
        LOGGER.info(classGroupService.getClassGroupHashMap());

        TeacherService teacherService1 = new TeacherService();
        HashMap<Integer, Teacher> x = teacherService.getTeachersHashMap();
    }
}
