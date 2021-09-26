package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.Classroom;
import com.solvd.scheduleWithGA.dao.interfaces.IClassroomDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;

public class ClassroomService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public HashMap<Integer, Classroom> getClassroomHashMap() {
        HashMap<Integer, Classroom> result = new HashMap<>();
        Classroom classroom;
        int id = 1;
        try (SqlSession session = factory.openSession()) {
            IClassroomDAO classroomDAO = session.getMapper(IClassroomDAO.class);
            while (true) {
                classroom = classroomDAO.getById(id);
                id++;
                if (classroom==null) break;
                result.put(classroom.getIdRoom(), classroom);
            }
        }
        return result;
    }

    public Classroom getClassroomById(int id){
        Classroom classroom;
        try (SqlSession session = factory.openSession()) {
            IClassroomDAO classroomDAO = session.getMapper(IClassroomDAO.class);
            classroom = classroomDAO.getById(id);
        }
        return classroom;
    }
}
