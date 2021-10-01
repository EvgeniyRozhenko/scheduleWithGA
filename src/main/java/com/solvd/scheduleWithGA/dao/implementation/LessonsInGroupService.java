package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.LessonInGroup;
import com.solvd.scheduleWithGA.dao.interfaces.ILessonsInGroupDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LessonsInGroupService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public LessonInGroup getLessonInGroupId (int id){
        LessonInGroup lessonInGroup;
        try (SqlSession session = factory.openSession()) {
            ILessonsInGroupDAO lessonsInGroupDAO = session.getMapper(ILessonsInGroupDAO.class);
            lessonInGroup = lessonsInGroupDAO.getById(id);
        }
        return lessonInGroup;
    }

}
