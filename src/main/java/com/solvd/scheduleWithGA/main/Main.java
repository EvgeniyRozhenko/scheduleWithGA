package com.solvd.scheduleWithGA.main;

import com.solvd.scheduleWithGA.binary.ClassGroup;
import com.solvd.scheduleWithGA.binary.Schedule;
import com.solvd.scheduleWithGA.binary.Teacher;
import com.solvd.scheduleWithGA.dao.implementation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ClassGroupService classGroupService = new ClassGroupService();
        LOGGER.info(classGroupService.getClassGroupById(2));
        LessonService lessonService = new LessonService();
        LOGGER.info(lessonService.getLessonById(2));
        TeacherService teacherService = new TeacherService();
        LOGGER.info(teacherService.getTeacherById(1));
        TimeSlotService timeSlotService = new TimeSlotService();
        LOGGER.info(timeSlotService.getTimslotById(1));
        ClassroomService classroomService = new ClassroomService();
        LOGGER.info(classroomService.getClassroomById(1));

        Schedule schedule = new Schedule();
        schedule.setClassroomId(1);
        schedule.setTeacherId(1);
        schedule.setLessonInGroupId(1);
        schedule.setTimeSlotId(1);
        ScheduleService scheduleService = new ScheduleService();
        scheduleService.addScheduleToDb(schedule);
    }
}
