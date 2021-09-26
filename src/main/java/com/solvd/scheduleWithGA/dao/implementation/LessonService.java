package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.Classroom;
import com.solvd.scheduleWithGA.binary.Lesson;
import com.solvd.scheduleWithGA.dao.interfaces.IClassroomDAO;
import com.solvd.scheduleWithGA.dao.interfaces.ILessonDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LessonService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public Lesson getLessonById(int id){
        Lesson lesson;
        try(SqlSession session = factory.openSession()){
            ILessonDAO lessonDAO = session.getMapper(ILessonDAO.class);
            lesson = lessonDAO.getById(id);
        }
        return lesson;
    }
}
