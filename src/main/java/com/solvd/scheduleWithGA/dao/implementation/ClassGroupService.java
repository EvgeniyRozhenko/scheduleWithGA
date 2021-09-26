package com.solvd.scheduleWithGA.dao.implementation;

import com.solvd.scheduleWithGA.binary.ClassGroup;
import com.solvd.scheduleWithGA.binary.Classroom;
import com.solvd.scheduleWithGA.dao.interfaces.IClassGroupDAO;
import com.solvd.scheduleWithGA.dao.interfaces.IClassroomDAO;
import com.solvd.scheduleWithGA.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;

public class ClassGroupService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public HashMap<Integer, ClassGroup> getClassGroupHashMap(){
        HashMap<Integer, ClassGroup> result = new HashMap<>();
        ClassGroup classGroup;
        int id =1;
        try(SqlSession session = factory.openSession()){
            IClassGroupDAO classGroupDAO = session.getMapper(IClassGroupDAO.class);
            while (true){
                classGroup = classGroupDAO.getById(id);
                id++;
                if (classGroup == null) break;
                result.put(classGroup.getIdClassGroup(), classGroup);
            }
        }
        return result;
    }

    public ClassGroup getClassGroupById(int id){
        ClassGroup classGroup;
        try(SqlSession session = factory.openSession()){
            IClassGroupDAO classGroupDAO = session.getMapper(IClassGroupDAO.class);
            classGroup = classGroupDAO.getById(id);
        }
        return classGroup;
    }
}
