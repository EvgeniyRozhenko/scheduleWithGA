package com.solvd.scheduleWithGA.geneticAlgoService;

import com.solvd.scheduleWithGA.binary.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ScheduleCreatorService {
    private HashMap<Integer, Classroom> rooms;
    private HashMap<Integer, Teacher> teachers;
    private HashMap<Integer, Lesson> lessons;
    private HashMap<Integer, ClassGroup> groups;

    private HashMap<Integer, TimeSlot> timeslots;

    private ArrayList<Schedule> schedules;

    private int amountSchedules = 0;

    public ScheduleCreatorService() {
        this.rooms = new HashMap<>();
        this.teachers = new HashMap<>();
        this.lessons = new HashMap<>();
        this.groups = new HashMap<>();
        this.timeslots = new HashMap<>();
    }

    public ScheduleCreatorService(ScheduleCreatorService cloneable) {
        this.rooms = cloneable.getRooms();
        this.teachers = cloneable.getTeachers();
        this.lessons = cloneable.getLessons();
        this.groups = cloneable.getGroups();
        this.timeslots = cloneable.getTimeslots();
    }

    private Random random = new Random();

    private HashMap<Integer, ClassGroup> getGroups() {
        return this.groups;
    }

    private HashMap<Integer, TimeSlot> getTimeslots() {
        return this.timeslots;
    }

    private HashMap<Integer, Lesson> getLessons() {
        return this.lessons;
    }

    private HashMap<Integer, Teacher> getTeachers() {
        return this.teachers;
    }

    public HashMap<Integer, Classroom> getRooms() {
        return this.rooms;
    }

    public void setRooms(HashMap<Integer, Classroom> rooms) {
        this.rooms = rooms;
    }

    public void setTeachers(HashMap<Integer, Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setLessons(HashMap<Integer, Lesson> lessons) {
        this.lessons = lessons;
    }

    public void setGroups(HashMap<Integer, ClassGroup> groups) {
        this.groups = groups;
    }

    public void setTimeslots(HashMap<Integer, TimeSlot> timeslots) {
        this.timeslots = timeslots;
    }

    public HashMap<Integer, ClassGroup> getGroupsAsArray() {
        return this.groups;
    }

    public TimeSlot getRandomTimeslot() {
        return this.timeslots.get((int)(Math.random() * timeslots.size() + 1));
    }

    public Classroom getRandomClassroom() {
        return this.rooms.get((int)(Math.random() * timeslots.size() + 1));

    public Lesson getLessonById(int lessonId) {
        return this.lessons.get(lessonId);
    }


    public int getAmountSchedules() {
        if (this.amountSchedules > 0) {
            return this.amountSchedules;
        }

        int numberOfSchedules = 0;

        for (ClassGroup group : this.groups.values()) {
            numberOfSchedules += group.getLessonsIds().size();
        }
        this.amountSchedules = numberOfSchedules;

        return this.amountSchedules;
    }

}
