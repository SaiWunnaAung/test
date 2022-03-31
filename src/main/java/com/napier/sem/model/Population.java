package com.napier.sem.model;

/**
 *Represents a Population: Class for Population model which included getter setter methods.
 */
public class Population {

    /**
     * The name of the continent/region/country.
     */
    private String name;

    /**
     * The total population of the continent/region/country.
     */
    private long population;

    /**
     * The population not living in city
     */
    private long popNotInCity;

    /**
     * The population living in city
     */
    private long popInCity;

    /**
     * The total population of the continent/region/country living in cities (including a %).
     */
    private double percentagePopulationInCities;

    /**
     * The total population of the continent/region/country not living in cities (including a %).
     */
    private double percentagePopulationNotInCities;


    /**
     * method to get continent/region/country name
     * @return name of continent/region/country
     */
    public String getName() {
        return name;
    }

    /**
     * method to set continent/region/country name
     * @param name of continent/region/country
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to get population of the continent/region/country
     * @return population of the continent/region/country
     */
    public long getPopulation() {
        return population;
    }

    /**
     * method to set population of the continent/region/country
     * @param population of the continent/region/country
     */
    public void setPopulation(long population) {
        this.population = population;
    }

    /**
     * method to get population not in city
     * @return population not in city
     */
    public long getPopNotInCity() {
        return popNotInCity;
    }

    /**
     * method to set population not in city
     * @param popNotInCity population not in city
     */
    public void setPopNotInCity(long popNotInCity) {
        this.popNotInCity = popNotInCity;
    }

    /**
     * method to get population in city
     * @return population in city
     */
    public long getPopInCity() {
        return popInCity;
    }

    /**
     * method to set population in city
     * @param popInCity population in city
     */
    public void setPopInCity(long popInCity) {
        this.popInCity = popInCity;
    }

    /**
     * method to get population of the continent/region/country living in cities (including a %)
     * @return percentagePopulationInCities of the continent/region/country
     */
    public double getPercentagePopulationInCities() {
        return percentagePopulationInCities;
    }

    /**
     * method to set population of the continent/region/country living in cities (including a %)
     * @param percentagePopulationInCities  of the continent/region/country
     */
    public void setPercentagePopulationInCities(double percentagePopulationInCities) {
        this.percentagePopulationInCities = percentagePopulationInCities;
    }

    /**
     * method to get population of the continent/region/country not living in cities (including a %)
     * @return percentagePopulationNotInCities of the continent/region/country
     */
    public double getPercentagePopulationNotInCities() {
        return percentagePopulationNotInCities;
    }

    /**
     * method to set population of the continent/region/country not living in cities (including a %)
     * @param percentagePopulationNotInCities of the continent/region/country
     */
    public void setPercentagePopulationNotInCities(double percentagePopulationNotInCities) {
        this.percentagePopulationNotInCities = percentagePopulationNotInCities;
    }
}
