package com.solvd.scheduleWithGA.runner;

<<<<<<< HEAD
import com.solvd.scheduleWithGA.dao.implementation.ClassGroupService;
import com.solvd.scheduleWithGA.dao.implementation.ClassroomService;
import com.solvd.scheduleWithGA.dao.implementation.LessonService;
import com.solvd.scheduleWithGA.dao.implementation.TeacherService;
=======
import com.solvd.scheduleWithGA.binary.ClassGroup;
import com.solvd.scheduleWithGA.binary.Classroom;
import com.solvd.scheduleWithGA.dao.implementation.*;
>>>>>>> 1539b3c4dafdf34b5a4f7dff5255fe44bac96193
import com.solvd.scheduleWithGA.geneticAlgoService.MyIndividual;
import com.solvd.scheduleWithGA.geneticAlgoService.MyPopulation;
import com.solvd.scheduleWithGA.geneticAlgoService.ScheduleCreatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

<<<<<<< HEAD
=======

>>>>>>> 1539b3c4dafdf34b5a4f7dff5255fe44bac96193
public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);
    public static void main(String[] args) {



        ClassroomService classroomService = new ClassroomService();
        LessonService lessonService = new LessonService();
        TeacherService teacherService = new TeacherService();
        ClassGroupService classGroupService = new ClassGroupService();
<<<<<<< HEAD
=======
        TimeSlotService timeSlotService = new TimeSlotService();
>>>>>>> 1539b3c4dafdf34b5a4f7dff5255fe44bac96193
        ScheduleCreatorService scheduleCreatorService = new ScheduleCreatorService();
        scheduleCreatorService.setGroups(classGroupService.getClassGroupHashMap());
        scheduleCreatorService.setLessons(lessonService.getLessonHashMap());
        scheduleCreatorService.setTeachers(teacherService.getTeachersHashMap());
        scheduleCreatorService.setRooms(classroomService.getClassroomHashMap());
<<<<<<< HEAD
=======
        scheduleCreatorService.setTimeslots(timeSlotService.getTimeSlotHashMap());
>>>>>>> 1539b3c4dafdf34b5a4f7dff5255fe44bac96193

        MyIndividual individual = new MyIndividual(scheduleCreatorService);

        MyPopulation population = new MyPopulation(5, scheduleCreatorService);

<<<<<<< HEAD
        LOGGER.info(individual);
=======
        LOGGER.info(individual.toString());
>>>>>>> 1539b3c4dafdf34b5a4f7dff5255fe44bac96193
        population.countAndSetPopulationFitness();
        LOGGER.info("Population Fitness:"+population.getPopulationFitness());
    }
}