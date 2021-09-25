package com.solvd.scheduleWithGA.dao;

public interface IEntityDAO <T>{
    void save (T t);
    void delete (T t);
    T getById(int id);
}
