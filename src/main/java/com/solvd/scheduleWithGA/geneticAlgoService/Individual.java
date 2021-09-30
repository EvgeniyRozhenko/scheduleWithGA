package com.solvd.scheduleWithGA.geneticAlgoService;

import com.solvd.scheduleWithGA.binary.ClassGroup;
import com.solvd.scheduleWithGA.binary.Classroom;
import com.solvd.scheduleWithGA.binary.Lesson;
import com.solvd.scheduleWithGA.binary.TimeSlot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Individual {
    private ArrayList<Integer> chromosome;
    private int fitness = 0;

    private static final Logger LOGGER = LogManager.getLogger(Individual.class);

    /**
     Инициализирует случайный индивид на основе расписания, как фиксированной информации.
     Учитывая фикс инфу создаём хромосому, которая случайным образом назначает TimeSlots,
     Classrooms и Teachers для каждой ClassGroup и Lesson.
     */
    public Individual(ScheduleCreatorService timetable) {
        //сохраняем количество расписаний из [] айдишек Уроков в Группах
        int amountSchedules = timetable.getAmountSchedules();
        // создаём случайного индивида
        ArrayList<Integer> newChromosome = new ArrayList<>();
        //проходим по Группам
        for (ClassGroup group : timetable.getGroupsAsArray()) {
            //проходим по элементам [] Уроков в каждой Группе
            for (int lessonId : group.getLessonsIds()) {
                //добавляем случайный id timeslot в текущий индекс хромосомы
                TimeSlot timeSlot = timetable.getRandomTimeslot();
                int timeSlotId = timeSlot.getIdTimeSlot();
                newChromosome.add(timeSlotId);

                //добавляем случайный id classroom в следующий индекс хромосомы
                Classroom classroom = timetable.getRandomClassroom();
                int classroomId = classroom.getIdRoom();
                newChromosome.add(classroomId);

                //добаляем случайный id teacher из [] поля lesson-а в след индекс хромосомы
                Lesson lesson = timetable.getLessonById(lessonId);
                newChromosome.add(lesson.getRandomTeacherId());
            }
        }
        this.chromosome = newChromosome;
    }

    /**
     * Второй конструктор инициализирует индивида с заданной длиной хромосомы.
     * Конструктор не создаёт случайную хромосому - пустышка. Нужен этот конструктор
     * только для конструктора Population? как заполнение [] популяции индивидами
     * или для метода crossoverPopulation(), алгоритм которого переписывает всю эту хромосому.
     */
    public Individual(int chromosomeLength) {
        ArrayList<Integer> newChromosome = new ArrayList<>(chromosomeLength);

        for (int i = 0; i < chromosomeLength; i++) {
            newChromosome.set(i, i);
        }
        this.chromosome = newChromosome;
    }


    public ArrayList<Integer> getChromosome() {
        return this.chromosome;
    }

    public boolean containsGene(int gene) {
        for (int j : this.chromosome) {
            if (j == gene) {
                return true;
            }
        }
        return false;
    }

    public double getFitness() {
        return this.fitness;
    }

    public void setFitness(int collisions) {
        this.fitness = 100 - collisions;
    }

    public String toString() {
        return "Individual {" +
                "\n chromosome -> " + chromosome +
                "\n fitness -> " + fitness +
                "}|";
    }

//    public Individual(ScheduleCreatorService timetable) {
//        int chromosomeSize = timetable.getTimeslots().size();
//        LOGGER.debug("ChromosomeSize -> " + chromosomeSize);
//        HashMap<Integer, HashMap<Integer, BunchHelper>> newChromosome = new HashMap<>(chromosomeSize);
//        HashMap<Integer, BunchHelper> groupPossibleLecture = new HashMap<>();
//        LOGGER.debug("New chromosome size is -> " + newChromosome.size());
//
//        for (TimeSlot timeSlot : timetable.getTimeslots().values()) {
//            int timeSlotId = timeSlot.getIdTimeSlot();
//
//            for (ClassGroup group : timetable.getGroupsAsArray()) {
//                int groupId = group.getIdClassGroup();
//                int randomLessonId = group.getRandomLessonId();
//
//                Lesson currentLesson = timetable.getLessonById(randomLessonId);
//                int randomTeacherId = currentLesson.getRandomTeacherId();
//
//                Classroom classroom = timetable.getRandomClassroom();
//                int randomClassroomId = classroom.getIdRoom();
//
//                BunchHelper bunch = new BunchHelper(randomLessonId, randomTeacherId, randomClassroomId);
//
//                groupPossibleLecture.put(groupId, bunch);
//            }
//            newChromosome.put(timeSlotId, groupPossibleLecture);
//        }
//        this.chromosome = newChromosome;
//    }
}
