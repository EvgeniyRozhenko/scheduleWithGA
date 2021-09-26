package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.Teacher;
import com.solvd.scheduleWithGA.dao.interfaces.ITeacherDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;

public class TeacherService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public HashMap<Integer, Teacher> getTeachersHashMap() {
        HashMap<Integer, Teacher> result = new HashMap<>();
        Teacher teacher;
        int id = 1;
        try (SqlSession session = factory.openSession()) {
            ITeacherDAO teacherDAO = session.getMapper(ITeacherDAO.class);
            teacher = teacherDAO.getById(1);
            while (true) {
                teacher = teacherDAO.getById(id);
                id++;
                if (teacher!=null) result.put(teacher.getIdTeacher(), teacher);
                else break;
            }
        }
        return result;
    }
}
