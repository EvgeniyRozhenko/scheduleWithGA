package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.Teacher;
import com.solvd.scheduleWithGA.dao.interfaces.ITeacherDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TeacherService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();
    public Teacher getTeacherById(int id){
        Teacher teacher;
        try (SqlSession session = factory.openSession()){
            ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);
            teacher = teacherDAO.getById(id);
        }
        return teacher;
    }
}
