package com.solvd.scheduleWithGA.geneticAlgoService;

import com.solvd.scheduleWithGA.binary.*;

import java.util.*;

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


    public HashMap<Integer, ClassGroup> getGroups() {
        return this.groups;
    }

    public HashMap<Integer, TimeSlot> getTimeslots() {
        return this.timeslots;
    }

    public HashMap<Integer, Lesson> getLessons() {
        return this.lessons;
    }

    public HashMap<Integer, Teacher> getTeachers() {
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

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public ArrayList<ClassGroup> getGroupsAsArray() {
        return new ArrayList<>(this.groups.values());
    }

    public TimeSlot getRandomTimeslot() {
        return this.timeslots.get((int) (Math.random() * timeslots.size() + 1));
    }

    public Classroom getRandomClassroom() {
        return this.rooms.get((int) (Math.random() * rooms.size() + 1));
    }

    public Lesson getLessonById(int lessonId) {
        return this.lessons.get(lessonId);
    }


    public int getAmountSchedules() {

        int numberOfSchedules = 0;

        for (ClassGroup group : this.groups.values()) {
            numberOfSchedules += group.getLessonsIds().size();
        }

        return this.amountSchedules = numberOfSchedules;
    }

    public void createSchedules(Individual individual) {
        ArrayList<Schedule> schedules = new ArrayList<>(this.getAmountSchedules());
        ArrayList<Integer> chromosome = individual.getChromosome();
        int chromosomeIndex = 0;
        int scheduleIndex = 0;

        for (ClassGroup group : this.getGroupsAsArray()) {
            for (int lessonId : group.getLessonsIds()) {

                schedules.add(scheduleIndex, new Schedule(scheduleIndex, group.getIdClassGroup(), lessonId));
                schedules.get(scheduleIndex).setTimeSlotId(chromosome.get(chromosomeIndex));
                ++chromosomeIndex;

                schedules.get(scheduleIndex).setClassroomId(chromosome.get(chromosomeIndex));
                ++chromosomeIndex;

                schedules.get(scheduleIndex).setTeacherId(chromosome.get(chromosomeIndex));
                ++chromosomeIndex;
                ++scheduleIndex;
            }
        }
        this.schedules = schedules;
    }

    public int calculateCollisions() {
        int collisions = 0;

        for (Schedule scheduleFirst : this.schedules) {
            Classroom room = this.rooms.get(scheduleFirst.getClassroomId());
            int classroomCapacity = room.getCapacity();
            ClassGroup group = this.groups.get(scheduleFirst.getGroupId());
            int groupSize = group.getGroupSize();

            if (classroomCapacity < groupSize) {
                ++collisions;
            }
            for (Schedule scheduleSecond : this.schedules) {
                if (scheduleFirst.getIdSchedule() != scheduleSecond.getIdSchedule()
                        && scheduleFirst.getTimeSlotId() == scheduleSecond.getTimeSlotId()
                        && scheduleFirst.getTeacherId() == scheduleSecond.getTeacherId()
                        && scheduleFirst.getGroupId() == scheduleSecond.getGroupId()
                        && scheduleFirst.getLessonId() == scheduleSecond.getLessonId()
                        && scheduleFirst.getClassroomId() == scheduleSecond.getClassroomId()) {
                    ++collisions;
                }
                if ((scheduleFirst.getIdSchedule() != scheduleSecond.getIdSchedule()
                    && scheduleFirst.getClassroomId() == scheduleSecond.getClassroomId()
                    && scheduleFirst.getTimeSlotId() == scheduleSecond.getTimeSlotId())) {
                    ++collisions;
                }
                if (scheduleFirst.getIdSchedule() != scheduleSecond.getIdSchedule()
                        && scheduleFirst.getTeacherId() == scheduleSecond.getTeacherId()
                        && scheduleFirst.getTimeSlotId() == scheduleSecond.getTimeSlotId()) {
                    ++collisions;
                }
                if (scheduleFirst.getIdSchedule() != scheduleSecond.getIdSchedule()
                        && scheduleFirst.getGroupId() == scheduleSecond.getGroupId()
                        && scheduleFirst.getTimeSlotId() == scheduleSecond.getTimeSlotId()) {
                    ++collisions;
                }
            }
        }
        return collisions;
    }

    @Override
    public String toString() {
        return "ScheduleCreatorService{" +
                "rooms=" + rooms +
                ", teachers=" + teachers +
                ", lessons=" + lessons +
                ", groups=" + groups +
                ", timeslots=" + timeslots +
                ", schedules=" + schedules +
                ", amountSchedules=" + amountSchedules +
                '}';
    }
}
