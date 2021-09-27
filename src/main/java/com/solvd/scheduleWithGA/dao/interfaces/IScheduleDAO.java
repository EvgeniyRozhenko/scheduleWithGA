package com.solvd.scheduleWithGA.dao.interfaces;

import com.solvd.scheduleWithGA.binary.Schedule;
import com.solvd.scheduleWithGA.dao.IEntityDAO;

import java.util.ArrayList;

public interface IScheduleDAO extends IEntityDAO<Schedule> {
    ArrayList<Schedule> getScheduleForDay(int dayId);
}
