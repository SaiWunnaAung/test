package com.napier.sem.model;

/**
 * Represents a Capital City: Class for capital city model which included getter setter methods.
 */
public class CapitalCity {
    /**
     * capital city name
     */
    private String name;

    /**
     * country name
     */
    private String country;

    /**
     * number of population
     */
    private long population;

    /**
     * method to get capital city name
     * @return name of capital city
     */
    public String getName() {
        return name;
    }

    /**
     * method to set capital city name
     * @param name of capital city
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to get country name
     * @return name of country
     */
    public String getCountry() {
        return country;
    }

    /**
     * method to set country name
     * @param country name
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * method to get number of population
     * @return population number
     */
    public long getPopulation() {
        return population;
    }

    /**
     * method to set number of population
     * @param population number
     */
    public void setPopulation(long population) {
        this.population = population;
    }
}
