package com.solvd.scheduleWithGA.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisFactory {
    private static SqlSessionFactory factory;
    private final static MyBatisFactory myBatisFactory = new MyBatisFactory();

    private MyBatisFactory(){
        try{
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSessionFactory(){
        return factory;
    }
}
