package com.solvd.scheduleWithGA.geneticAlgoService;

import java.util.Arrays;

public class MyPopulation implements {
    private MyIndividual[] population;
    private double populationFitness = -1;

    public MyPopulation(int populationSize) {
        this.population = new MyIndividual[populationSize];
    }

    public MyPopulation(int populationSize, ScheduleCreatorService timetable) {
        this.population = new MyIndividual[populationSize];

        for (int individualCount = 0; individualCount < populationSize; individualCount++) {
            // происходит заполнение массива Популяции индивидами со случайными хромосомами
            MyIndividual individual = new MyIndividual(timetable);
            this.population[individualCount] = individual;
        }
    }

    public MyPopulation(int populationSize, int chromosomeLength) {
        this.population = new MyIndividual[populationSize];

        for (int individualCount = 0; individualCount < populationSize; individualCount++) {
            // происходит заполнение популяции индивидами с хромосомами-пустышками
            MyIndividual individual = new MyIndividual(chromosomeLength);
            this.population[individualCount] = individual;
        }
    }

    public MyIndividual[] getPopulation() {
        return this.population;
    }

    //TODO сделать сортировку по популяции и выдать самого сильного (возможно двух для создания отпрыска)
    public MyIndividual getFittestIndividual(int expectedFitness) {
        // прохождение по популяции и сортировка по соответсвию
        Arrays.sort(this.population, (o1, o2) -> {
            if (o1.getFitness() > o2.getFitness()) {
                return -1;
            } else if (o1.getFitness() < o2.getFitness()) {
                return 1;
            }
            return 0;
        });

        return this.population[expectedFitness];
    }

    public void countAndSetPopulationFitness() {
        // установка общ пригодности популяции
        double generalFitness = 0;
        for (MyIndividual individual : this.population) {
            generalFitness += individual.getFitness();
        }
        this.populationFitness = generalFitness;
    }

    public double getPopulationFitness() {
        return this.populationFitness;
    }

    public MyIndividual getIndividual(int index) {
        return population[index];
    }

    public void setIndividualByIndex(int index, MyIndividual individual) {
        this.population[index] = individual;
    }
}
