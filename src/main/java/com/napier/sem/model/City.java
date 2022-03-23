package com.napier.sem.model;

/**
 * Represents a City: Class for city model which included getter setter methods.
 */
public class City {
    /**
     * city name
     */
    private String name;

    /**
     * country name
     */
    private String country;

    /**
     * district name
     */
    private String district;

    /**
     * number of population
     */
    private long population;

    /**
     * method to get city name
     * @return name of city
     */
    public String getName() {
        return name;
    }

    /**
     * method to set city name
     * @param name of city
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
     * method to get district name
     * @return name of district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * method to set district name
     * @param district name
     */
    public void setDistrict(String district) {
        this.district = district;
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
