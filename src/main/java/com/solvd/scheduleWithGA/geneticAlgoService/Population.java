package com.solvd.scheduleWithGA.geneticAlgoService;

import java.util.ArrayList;
import java.util.Objects;

public class Population {
    private ArrayList<Individual> individuals;
    private int averagePopulationFitness = 0;

    public Population(int populationSize, ScheduleCreatorService timetable) {
        this.individuals = new ArrayList<>(populationSize);

        for (int individualCount = 0; individualCount < populationSize; individualCount++) {

            Individual individual = new Individual(timetable);
            this.individuals.add(individual);
        }
    }

    public Population(ArrayList<Individual> individuals, ScheduleCreatorService timetable) {
        this.individuals = individuals;
        countAndSetPopulationFitness(timetable);
    }

    public ArrayList<Individual> getIndividuals() {
        return this.individuals;
    }

    public double getAveragePopulationFitness() {
        return this.averagePopulationFitness;
    }

    //TODO сделать сортировку по популяции и выдать самого сильного (возможно двух для создания отпрыска)
//    public Individual sortByFitness(int expectedFitness) {
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
        int totalSumCollisions = 0;
        int sumOfCollisions;
        ArrayList<Individual> population = this.individuals;

        for (int i = 0; i < population.size(); i++) {

            Individual individual = population.get(i);
            table.createSchedules(individual);
            sumOfCollisions = table.calculateCollisions();
            population.get(i).setFitness(sumOfCollisions);
            totalSumCollisions += sumOfCollisions;
        }
        this.averagePopulationFitness = (population.size() * 100 - totalSumCollisions) / population.size();
    }

    public Population selectionFittest(ScheduleCreatorService timetable) {
        ArrayList<Individual> selectedIndividuals = new ArrayList<>();

        for (Individual individual : this.individuals) {
            if (individual.getFitness() == 100) {
                selectedIndividuals.add(individual);
            }
        }

        return new Population(selectedIndividuals, timetable);
    }

    public Individual getIndividual(int index) {
        return individuals.get(index);
    }

    public void setIndividualByIndex(int index, Individual individual) {
        this.individuals.set(index, individual);
    }

    @Override
    public String toString() {
        return "MyPopulation {\n" +
                individuals.toString().replace("|", "\n") + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Population)) return false;
        Population that = (Population) o;
        return averagePopulationFitness == that.averagePopulationFitness && individuals.equals(that.individuals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(individuals, averagePopulationFitness);
    }
}
