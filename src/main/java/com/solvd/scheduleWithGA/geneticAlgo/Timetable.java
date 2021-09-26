package com.solvd.scheduleWithGA.geneticAlgo;

import com.solvd.scheduleWithGA.binary.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Timetable {
    private final HashMap<Integer, Classroom> rooms;
    private final HashMap<Integer, Teacher> teachers;
    private final HashMap<Integer, Lesson> lessons;
    private final HashMap<Integer, ClassGroup> groups;
    private final HashMap<Integer, TimeSlot> timeslots;

    private ArrayList<Schedule> schedules = new ArrayList<>();

    private int amountSchedules = 0;


    public Timetable() {
        this.rooms = new HashMap<>();
        this.teachers = new HashMap<>();
        this.lessons = new HashMap<>();
        this.groups = new HashMap<>();
        this.timeslots = new HashMap<>();
    }

    public Timetable(Timetable cloneable) {
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

//    public void addRoom(int roomId, String roomName, int capacity) {
//        this.rooms.put(roomId, new Classroom(roomId, roomName, capacity));
//    }

//    public void addProfessor(int professorId, String professorName) {
//        this.teachers.put(professorId, new Teacher(professorId, professorName));
//    }

//    /**
//     * Add new module
//     *
//     * @param moduleId
//     * @param moduleCode
//     * @param module
//     * @param professorIds
//     */
//    public void addModule(int moduleId, String moduleCode, String module, int professorIds[]) {
//        this.lessons.put(moduleId, new Module(moduleId, moduleCode, module, professorIds));
//    }

//    /**
//     * Add new group
//     *
//     * @param groupId
//     * @param groupSize
//     * @param moduleIds
//     */
//    public void addGroup(int groupId, int groupSize, int moduleIds[]) {
//        this.groups.put(groupId, new Group(groupId, groupSize, moduleIds));
//        this.amountSchedules = 0;
//    }

//    /**
//     * Add new timeslot
//     *
//     * @param timeslotId
//     * @param timeslot
//     */
//    public void addTimeslot(int timeslotId, String timeslot) {
//        this.timeslots.put(timeslotId, new Timeslot(timeslotId, timeslot));
//    }

    /**
     * Get number of classes that need scheduling
     * @return numClasses
     */
    public int getAmountSchedules() {
        if (this.amountSchedules > 0) {
            return this.amountSchedules;
        }

        int numberOfSchedules = 0;
//        ClassGroup[] groups = this.groups.values().toArray(new ClassGroup[this.groups.size()]);
        ArrayList<ClassGroup> groups = (ArrayList<ClassGroup>) this.groups.values();
        for (ClassGroup group : groups) {
            numberOfSchedules += group.getModuleIds().length;
        }
        this.amountSchedules = numberOfSchedules;

        return this.amountSchedules;
    }

    public void createSchedules(Individual individual) {
        // Init schedules
        ArrayList<Schedule> schedules = new ArrayList<>(this.getAmountSchedules());

        // Get individual's chromosome
        int[] chromosome = individual.getChromosome();
        int chromosomePos = 0;
        int scheduleIndex = 0;

        for (ClassGroup group : this.getGroupsAsArray()) {
            int moduleIds[] = group.getModuleIds();
            for (int moduleId : moduleIds) {
                schedules[scheduleIndex] = new Class(scheduleIndex, group.getGroupId(), moduleId);

                // Add timeslot
                schedules[scheduleIndex].addTimeslot(chromosome[chromosomePos]);
                chromosomePos++;

                // Add room
                schedules[scheduleIndex].setRoomId(chromosome[chromosomePos]);
                chromosomePos++;

                // Add professor
                schedules[scheduleIndex].addProfessor(chromosome[chromosomePos]);
                chromosomePos++;

                scheduleIndex++;
            }
        }

        this.schedules = schedules;
    }

    /**
     * Get room from roomId
     *
     * @param roomId
     * @return room
     */
    public Classroom getRoom(int roomId) {
        if (!this.rooms.containsKey(roomId)) {
            System.out.println("Rooms doesn't contain key " + roomId);
        }
        return (Classroom) this.rooms.get(roomId);
    }

    public HashMap<Integer, Classroom> getRooms() {
        return this.rooms;
    }

    /**
     * Get random room
     *
     * @return room
     */
    public Classroom getRandomRoom() {
        Object[] roomsArray = this.rooms.values().toArray();
        Classroom classroom = (Classroom) roomsArray[(int) (roomsArray.length * Math.random())];
        return classroom;
    }

    /**
     * Get professor from professorId
     *
     * @param professorId
     * @return professor
     */
    public Professor getProfessor(int professorId) {
        return (Professor) this.teachers.get(professorId);
    }

    /**
     * Get module from moduleId
     *
     * @param moduleId
     * @return module
     */
    public Module getModule(int moduleId) {
        return (Module) this.lessons.get(moduleId);
    }

    /**
     * Get moduleIds of student group
     *
     * @param groupId
     * @return moduleId array
     */
    public int[] getGroupModules(int groupId) {
        Group group = (Group) this.groups.get(groupId);
        return group.getModuleIds();
    }

    /**
     * Get group from groupId
     *
     * @param groupId
     * @return group
     */
    public Group getGroup(int groupId) {
        return (Group) this.groups.get(groupId);
    }

    /**
     * Get all student groups
     *
     * @return array of groups
     */
    public Group[] getGroupsAsArray() {
        return (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
    }

    /**
     * Get timeslot by timeslotId
     *
     * @param timeslotId
     * @return timeslot
     */
    public TimeSlot getTimeslot(int timeslotId) {
        return (TimeSlot) this.timeslots.get(timeslotId);
    }

    /**
     * Get random timeslotId
     *
     * @return timeslot
     */
    public TimeSlot getRandomTimeslot() {
        Object[] timeslotArray = this.timeslots.values().toArray();
        TimeSlot timeslot = (TimeSlot) timeslotArray[(int) (timeslotArray.length * Math.random())];
        return timeslot;
    }

    /**
     * Get classes
     *
     * @return classes
     */
    public Schedule[] getSchedules() {
        return this.schedules;
    }

    /**
     * Calculate the number of clashes between Classes generated by a
     * chromosome.
     *
     * The most important method in this class; look at a candidate timetable
     * and figure out how many constraints are violated.
     *
     * Running this method requires that createClasses has been run first (in
     * order to populate this.classes). The return value of this method is
     * simply the number of constraint violations (conflicting professors,
     * timeslots, or rooms), and that return value is used by the
     * GeneticAlgorithm.calcFitness method.
     *
     * There's nothing too difficult here either -- loop through this.classes,
     * and check constraints against the rest of the this.classes.
     *
     * The two inner `for` loops can be combined here as an optimization, but
     * kept separate for clarity. For small values of this.classes.length it
     * doesn't make a difference, but for larger values it certainly does.
     *
     * @return numClashes
     */
    public int calcClashes() {
        int clashes = 0;

        for (Class classA : this.schedules) {
            // Check room capacity
            int roomCapacity = this.getRoom(classA.getRoomId()).getRoomCapacity();
            int groupSize = this.getGroup(classA.getGroupId()).getGroupSize();

            if (roomCapacity < groupSize) {
                clashes++;
            }

            // Check if room is taken
            for (Class classB : this.schedules) {
                if (classA.getRoomId() == classB.getRoomId() && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId()) {
                    clashes++;
                    break;
                }
            }

            // Check if professor is available
            for (Class classB : this.schedules) {
                if (classA.getProfessorId() == classB.getProfessorId() && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId()) {
                    clashes++;
                    break;
                }
            }
        }

        return clashes;
    }
}
