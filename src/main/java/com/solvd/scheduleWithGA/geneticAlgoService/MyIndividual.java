package com.solvd.scheduleWithGA.geneticAlgoService;

import com.solvd.scheduleWithGA.binary.ClassGroup;
import com.solvd.scheduleWithGA.binary.Lesson;

import java.util.Arrays;

public class MyIndividual {
    private int[] chromosome;
    private double fitness = -1;

    /**
     Инициализирует случайный индивид на основе расписания, как фиксированной информации.
     Учитывая фикс инфу создаём хромосому, которая случайным образом назначает TimeSlots,
     Classrooms и Teachers для каждой ClassGroup и Lesson.
     */
    public MyIndividual(ScheduleCreatorService timetable) {
        //сохраняем количество расписаний из [] айдишек Уроков в Группах
        int amountSchedules = timetable.getAmountSchedules();

        // 1 ген для classroom, 1 для timeslot, 1 для teacher
        // к примеру кол-во 3. "123". 3*3=9. теперь "123_123_123" где 123 для classroom, timeslot и teacher
        int chromosomeLength = amountSchedules * 3;
        // создаём случайного индивида
        int[] newChromosome = new int[chromosomeLength];
        int chromosomeIndex = 0;
        //проходим по Группам
        for (ClassGroup group : timetable.getGroupsAsArray()) {
            //проходим по элементам [] Уроков в каждой Группе
            for (int lessonId : group.getLessonsIds()) {
                //добавляем случайный id timeslot в текущий индекс хромосомы
                int timeSlotId = timetable.getRandomTimeslot().getIdTimeSlot();
                newChromosome[chromosomeIndex] = timeSlotId;
                ++chromosomeIndex;

                //добавляем случайный id classroom в следующий индекс хромосомы
                int classroomId = timetable.getRandomClassroom().getIdRoom();
                newChromosome[chromosomeIndex] = classroomId;
                ++chromosomeIndex;

                //добаляем случайный id teacher из [] поля lesson-а в след индекс хромосомы
                Lesson lesson = timetable.getLessonById(lessonId);
                newChromosome[chromosomeIndex] = lesson.getRandomTeacherId();
                ++chromosomeIndex;
            }
        }
        //сохраняем новосозданный хромосом в поле
        this.chromosome = newChromosome;
    }

    /**
     * Второй конструктор инициализирует индивида с заданной длиной хромосомы.
     * Конструктор не создаёт случайную хромосому - пустышка. Нужен этот конструктор
     * только для конструктора Population? как заполнение [] популяции индивидами
     * или для метода crossoverPopulation(), алгоритм которого переписывает всю эту хромосому.
     */
    public MyIndividual(int chromosomeLength) {
        int[] newChromosome;
        newChromosome = new int[chromosomeLength];
        for (int i = 0; i < chromosomeLength; i++) {
            newChromosome[i] = i;
        }
        this.chromosome = newChromosome;
    }


    public int[] getChromosome() {
        return this.chromosome;
    }

    public void setGene(int index, int gene) { //???
        this.chromosome[index] = gene;
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

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public String toString() {
        return "MyIndividual {" +
                "chromosome " + Arrays.toString(chromosome) +
                '}';
    }
}
