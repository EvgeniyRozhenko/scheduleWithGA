package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.Classroom;
import com.solvd.scheduleWithGA.binary.Lesson;
import com.solvd.scheduleWithGA.dao.interfaces.IClassroomDAO;
import com.solvd.scheduleWithGA.dao.interfaces.ILessonDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;

public class LessonService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public HashMap<Integer, Lesson> getLessonHashMap(){
        HashMap<Integer, Lesson> result = new HashMap<>();
        Lesson lesson;
        int id = 1;
        try(SqlSession session = factory.openSession()){
            ILessonDAO lessonDAO = session.getMapper(ILessonDAO.class);
            while(true){
                lesson = lessonDAO.getById(id);
                id++;
                if(lesson==null) break;
                result.put(lesson.getIdLesson(), lesson);
            }
        }
        return result;
    }

    public Lesson getLessonById(int id)
    {
        Lesson lesson;
        try(SqlSession session = factory.openSession()) {
            ILessonDAO lessonDAO = session.getMapper(ILessonDAO.class);
            lesson = lessonDAO.getById(id);
        }
        return lesson;
    }
}
