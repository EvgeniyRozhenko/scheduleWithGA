package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.TimePeriod;
import com.solvd.scheduleWithGA.dao.interfaces.ITimePeriodDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TimePeriodService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public TimePeriod getTimePeriodById (int id){
        TimePeriod timePeriod;
        try (SqlSession session = factory.openSession()) {
            ITimePeriodDAO timePeriodDAO = session.getMapper(ITimePeriodDAO.class);
            timePeriod = timePeriodDAO.getById(id);
        }
        return timePeriod;
    }
}
