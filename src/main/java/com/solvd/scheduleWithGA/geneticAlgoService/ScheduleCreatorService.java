package com.solvd.scheduleWithGA.geneticAlgoService;

import com.solvd.scheduleWithGA.binary.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ScheduleCreatorService {
    private final HashMap<Integer, Classroom> rooms;
    private final HashMap<Integer, Teacher> teachers;
    private final HashMap<Integer, Lesson> lessons;
    private final HashMap<Integer, ClassGroup> groups;
    private final HashMap<Integer, TimeSlot> timeslots;

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

    public ClassGroup[] getGroupsAsArray() {
        return (ClassGroup[]) this.groups.values().toArray();
    }

    public TimeSlot getRandomTimeslot() {
        TimeSlot[] timeslotArray = (TimeSlot[]) this.timeslots.values().toArray();
        return timeslotArray[(int) (timeslotArray.length * Math.random())];
    }

    public Classroom getRandomClassroom() {
        Classroom[] roomsArray = (Classroom[]) this.rooms.values().toArray();
        return roomsArray[(int) (roomsArray.length * Math.random())];
    }

    public Lesson getLessonById(int lessonId) {
        return this.lessons.get(lessonId);
    }


    public int getAmountSchedules() {
        if (this.amountSchedules > 0) {
            return this.amountSchedules;
        }

        int numberOfSchedules = 0;
        ArrayList<ClassGroup> groups = (ArrayList<ClassGroup>) this.groups.values();
        for (ClassGroup group : groups) {
            numberOfSchedules += group.getLessonsIds().size();
        }
        this.amountSchedules = numberOfSchedules;

        return this.amountSchedules;
    }

//    public void createSchedules(Individual individual) {
//        Schedule[] schedules = new Schedule[this.getAmountSchedules()]; //тут не обзательно делать размерность,
//                                                                                    // раз я заменил массив на эррейЛист
//        int[] chromosome = individual.getChromosome();
//
//
//
//    }



}
