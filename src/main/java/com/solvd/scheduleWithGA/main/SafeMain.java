package com.solvd.scheduleWithGA.main;

import com.solvd.scheduleWithGA.binary.Teacher;
import com.solvd.scheduleWithGA.dao.implementation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class SafeMain {
        private static final Logger LOGGER = LogManager.getLogger(SafeMain.class);

        public static void main(String[] args) {
            ClassGroupService classGroupService = new ClassGroupService();
            LOGGER.info(classGroupService.getClassGroupById(2));
            LessonService lessonService = new LessonService();
            LOGGER.info(lessonService.getLessonById(2));
            TeacherService teacherService = new TeacherService();
            LOGGER.info(teacherService.getTeacherById(1));
            TimeSlotService timeSlotService = new TimeSlotService();


            TeacherService teacherService1 = new TeacherService();
            HashMap<Integer, Teacher> x = teacherService.getTeachersHashMap();

            LOGGER.info(timeSlotService.getTimslotById(1));
            ClassroomService classroomService = new ClassroomService();
            LOGGER.info(classroomService.getClassroomById(1));
        }
    }


