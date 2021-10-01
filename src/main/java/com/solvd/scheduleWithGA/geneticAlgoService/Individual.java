package com.solvd.scheduleWithGA.geneticAlgoService;

import com.solvd.scheduleWithGA.binary.ClassGroup;
import com.solvd.scheduleWithGA.binary.Classroom;
import com.solvd.scheduleWithGA.binary.Lesson;
import com.solvd.scheduleWithGA.binary.TimeSlot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class Individual {
    private ArrayList<Integer> chromosome;
    private int fitness = 0;

    private static final Logger LOGGER = LogManager.getLogger(Individual.class);


    public Individual(ScheduleCreatorService timetable) {
        int chromosomeLength = timetable.getAmountSchedules();
        ArrayList<Integer> newChromosome = new ArrayList<>(chromosomeLength * 3);

        for (ClassGroup group : timetable.getGroupsAsArray()) {

            for (int lessonId : group.getLessonsIds()) {

                TimeSlot timeSlot = timetable.getRandomTimeslot();
                int timeSlotId = timeSlot.getIdTimeSlot();
                newChromosome.add(timeSlotId);

                Classroom classroom = timetable.getRandomClassroom();
                int classroomId = classroom.getIdRoom();
                newChromosome.add(classroomId);

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Individual)) return false;
        Individual that = (Individual) o;
        return fitness == that.fitness && chromosome.equals(that.chromosome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chromosome, fitness);
    }
}
