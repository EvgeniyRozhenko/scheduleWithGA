package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.Schedule;
import com.solvd.scheduleWithGA.dao.interfaces.ILessonDAO;
import com.solvd.scheduleWithGA.dao.interfaces.IScheduleDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class ScheduleService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public void addScheduleToDb(Schedule schedule){
        try(SqlSession session = factory.openSession()) {
            IScheduleDAO scheduleDAO = session.getMapper(IScheduleDAO.class);
            try {
                scheduleDAO.save(schedule);
                session.commit();
            }
            catch (Exception e){
                session.rollback();
            }
        }
    }

    public ArrayList<Schedule> getScheduleByDayId(int dayId){
        ArrayList<Schedule> schedules = new ArrayList<>();
        try(SqlSession session = factory.openSession()) {
            IScheduleDAO scheduleDAO = session.getMapper(IScheduleDAO.class);
            schedules = scheduleDAO.getScheduleForDay(dayId);
        }
        return schedules;
    }
}
