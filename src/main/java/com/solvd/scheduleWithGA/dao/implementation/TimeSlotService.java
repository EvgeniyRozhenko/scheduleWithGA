package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.Classroom;
import com.solvd.scheduleWithGA.binary.TimeSlot;
import com.solvd.scheduleWithGA.dao.interfaces.IClassroomDAO;
import com.solvd.scheduleWithGA.dao.interfaces.ITimeSlotDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;

public class TimeSlotService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public HashMap<Integer, TimeSlot> getTimeSlotHashMap(){
        HashMap<Integer, TimeSlot> result = new HashMap<>();
        TimeSlot timeSlot;
        int id =1;
        try(SqlSession session = factory.openSession()){
            ITimeSlotDAO classroomDAO = session.getMapper(ITimeSlotDAO.class);
            while (true){
                timeSlot = classroomDAO.getById(id);
                id++;
                if(timeSlot==null) break;
                result.put(timeSlot.getIdTimeSlot(), timeSlot);
            }
        }
        return result;
    }
}
