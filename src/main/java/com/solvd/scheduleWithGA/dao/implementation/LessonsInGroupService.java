package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.LessonsInGroup;
import com.solvd.scheduleWithGA.dao.interfaces.ILessonsInGroupDAO;
import com.solvd.scheduleWithGA.dao.interfaces.ITeacherDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LessonsInGroupService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public LessonsInGroup getLessonInGroupId (int id){
        LessonsInGroup lessonsInGroup;
        try (SqlSession session = factory.openSession()) {
            ILessonsInGroupDAO lessonsInGroupDAO = session.getMapper(ILessonsInGroupDAO.class);
            lessonsInGroup = lessonsInGroupDAO.getById(id);
        }
        return lessonsInGroup;
    }

}
