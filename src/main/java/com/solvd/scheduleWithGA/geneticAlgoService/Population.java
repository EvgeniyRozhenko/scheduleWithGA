package com.solvd.scheduleWithGA.geneticAlgoService;

import java.util.ArrayList;

public class Population {
    private ArrayList<Individual> population;
    private int averagePopulationFitness = 0;

    public Population(int populationSize) {
        this.population = new ArrayList<>(populationSize);
    }

    public Population(int populationSize, ScheduleCreatorService timetable) {
        this.population = new ArrayList<>(populationSize);

        for (int individualCount = 0; individualCount < populationSize; individualCount++) {
            // происходит заполнение массива Популяции индивидами со случайными хромосомами
            Individual individual = new Individual(timetable);
            this.population.add(individual);
        }
    }

    public Population(int populationSize, int chromosomeLength) {
        this.population = new ArrayList<>(populationSize);

        for (int individualCount = 0; individualCount < populationSize; individualCount++) {
            // происходит заполнение популяции индивидами с хромосомами-пустышками
            Individual individual = new Individual(chromosomeLength);
            this.population.set(individualCount, individual);
        }
    }

    public ArrayList<Individual> getPopulation() {
        return this.population;
    }

    //TODO сделать сортировку по популяции и выдать самого сильного (возможно двух для создания отпрыска)
//    public Individual getFittestIndividual(int expectedFitness) {
//        // прохождение по популяции и сортировка по соответсвию
//        Arrays.sort(this.population, (o1, o2) -> {
//            if (o1.getFitness() > o2.getFitness()) {
//                return -1;
//            } else if (o1.getFitness() < o2.getFitness()) {
//                return 1;
//            }
//            return 0;
//        });
//
//        return this.population.get(expectedFitness);
//    }

    public void countAndSetPopulationFitness(ScheduleCreatorService table) {
        // установка общ пригодности популяции
        int totalSumCollisions = 0;
        int sumOfCollisions;
        ArrayList<Individual> population = this.population;
        for (int i = 0; i < population.size(); i++) {
            Individual individual = population.get(i);
            table.createSchedules(individual);
            sumOfCollisions = table.calculateCollisions();
            population.get(i).setFitness(sumOfCollisions);
            totalSumCollisions += sumOfCollisions;
        }
        this.averagePopulationFitness = (population.size() * 100 - totalSumCollisions) / population.size();
    }

    public double getAveragePopulationFitness() {
        return this.averagePopulationFitness;
    }

    public Individual getIndividual(int index) {
        return population.get(index);
    }

    public void setIndividualByIndex(int index, Individual individual) {
        this.population.set(index, individual);
    }

    @Override
    public String toString() {
        return "MyPopulation {\n" +
                population.toString().replace("|", "\n") + '}';
    }
}
