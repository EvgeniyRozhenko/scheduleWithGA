package com.solvd.scheduleWithGA.runner;

import com.solvd.scheduleWithGA.dao.implementation.*;

import com.solvd.scheduleWithGA.geneticAlgoService.Individual;
import com.solvd.scheduleWithGA.geneticAlgoService.Population;
import com.solvd.scheduleWithGA.geneticAlgoService.ScheduleCreatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

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

        Individual individual = new Individual(scheduleCreatorService);
        LOGGER.info(individual);
        LOGGER.info("Chromosome size -> " + individual.getChromosome().size());

        scheduleCreatorService.createSchedules(individual);
        LOGGER.info(scheduleCreatorService.getSchedules());

        int sumOfCollisions = scheduleCreatorService.calculateCollisions();
        LOGGER.info("Sum of collisions -> " + sumOfCollisions);
        individual.setFitness(sumOfCollisions);
        LOGGER.info("Fitness -> " + individual.getFitness());

        Population population = new Population(20, scheduleCreatorService);
        population.countAndSetPopulationFitness(scheduleCreatorService);
        LOGGER.info(population);
        LOGGER.info("Average population fitness -> " + population.getAveragePopulationFitness());

        Population newPopulation = population.selectionFittest(scheduleCreatorService);
        LOGGER.info(newPopulation);
        LOGGER.info("New average population fitness -> " + newPopulation.getAveragePopulationFitness());
    }
}