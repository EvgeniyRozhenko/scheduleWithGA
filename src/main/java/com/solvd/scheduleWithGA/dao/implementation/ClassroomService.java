package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.Classroom;
import com.solvd.scheduleWithGA.dao.interfaces.IClassroomDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ClassroomService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public Classroom getClassroombyId(int id){
        Classroom classroom;
        try(SqlSession session = factory.openSession()){
            IClassroomDAO classroomDAO = session.getMapper(IClassroomDAO.class);
            classroom = classroomDAO.getById(id);
        }
        return classroom;
    }
}
