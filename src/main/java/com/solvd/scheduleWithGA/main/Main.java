package com.solvd.scheduleWithGA.main;

import com.solvd.scheduleWithGA.binary.ClassGroup;
import com.solvd.scheduleWithGA.binary.Schedule;
import com.solvd.scheduleWithGA.binary.Teacher;
import com.solvd.scheduleWithGA.dao.implementation.*;
import org.apache.ibatis.type.ByteArrayTypeHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        ScheduleService scheduleService = new ScheduleService();
        LOGGER.info(scheduleService.getScheduleByDayId(1));
        LessonsInGroupService lessonsInGroupService = new LessonsInGroupService();
        LOGGER.info(lessonsInGroupService.getLessonInGroupId(1));
        TimePeriodService timePeriodService = new TimePeriodService();
        LOGGER.info(timePeriodService.getTimePeriodById(1));
        WeekDayService weekDayService = new WeekDayService();
        LOGGER.info(weekDayService.getWeekDayById(1));
    }
}
