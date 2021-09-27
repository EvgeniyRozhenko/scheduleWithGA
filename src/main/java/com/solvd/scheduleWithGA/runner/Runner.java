package com.solvd.scheduleWithGA.runner;

import com.solvd.scheduleWithGA.binary.ClassGroup;
import com.solvd.scheduleWithGA.binary.Classroom;
import com.solvd.scheduleWithGA.dao.implementation.*;
import com.solvd.scheduleWithGA.geneticAlgoService.MyIndividual;
import com.solvd.scheduleWithGA.geneticAlgoService.MyPopulation;
import com.solvd.scheduleWithGA.geneticAlgoService.ScheduleCreatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);
    public static void main(String[] args) {



        ClassroomService classroomService = new ClassroomService();
        LessonService lessonService = new LessonService();
        TeacherService teacherService = new TeacherService();
        ClassGroupService classGroupService = new ClassGroupService();
        TimeSlotService timeSlotService = new TimeSlotService();
        ScheduleCreatorService scheduleCreatorService = new ScheduleCreatorService();
        scheduleCreatorService.setGroups(classGroupService.getClassGroupHashMap());
        scheduleCreatorService.setLessons(lessonService.getLessonHashMap());
        scheduleCreatorService.setTeachers(teacherService.getTeachersHashMap());
        scheduleCreatorService.setRooms(classroomService.getClassroomHashMap());
        scheduleCreatorService.setTimeslots(timeSlotService.getTimeSlotHashMap());

        MyIndividual individual = new MyIndividual(scheduleCreatorService);

        MyPopulation population = new MyPopulation(5, scheduleCreatorService);

        LOGGER.info(individual.toString());
        population.countAndSetPopulationFitness();
        LOGGER.info("Population Fitness:"+population.getPopulationFitness());
    }
}
