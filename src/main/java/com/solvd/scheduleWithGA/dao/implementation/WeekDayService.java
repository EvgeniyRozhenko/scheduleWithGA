package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.LessonsInGroup;
import com.solvd.scheduleWithGA.binary.WeekDay;
import com.solvd.scheduleWithGA.dao.interfaces.ILessonsInGroupDAO;
import com.solvd.scheduleWithGA.dao.interfaces.IWeekDayDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class WeekDayService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public WeekDay getWeekDayById (int id){
        WeekDay weekDay;
        try (SqlSession session = factory.openSession()) {
            IWeekDayDAO weekDayDAO = session.getMapper(IWeekDayDAO.class);
            weekDay = weekDayDAO.getById(id);
        }
        return weekDay;
    }
}
