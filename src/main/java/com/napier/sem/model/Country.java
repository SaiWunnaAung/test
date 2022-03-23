package com.napier.sem.model;

/**
 * Represents a Country: Class for country model which included getter setter methods.
 */
public class Country {

    /**
     * country code
     */
    private String code;

    /**
     * country name
     */
    private String name;

    /**
     * continent name
     */
    private String continent;

    /**
     * region name
     */
    private String region;

    /**
     * number of population
     */
    private long population;

    /**
     * capital name
     */
    private String capital;


    /**
     * method to get country code
     * @return code of country
     */
    public String getCode() {
        return code;
    }

    /**
     * method to set country code
     * @param code of country
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * method to get country name
     * @return name of country
     */
    public String getName() {
        return name;
    }

    /**
     * method to set country name
     * @param name of country
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to get continent name
     * @return continent name
     */
    public String getContinent() {
        return continent;
    }

    /**
     * method to set continent name
     * @param continent name
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * method to get region name
     * @return region name
     */
    public String getRegion() {
        return region;
    }

    /**
     * method to set region name
     * @param region name
     */
    public void setRegion(String region) {
        this.region = region;
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

    /**
     * method to get capital name
     * @return capital name
     */
    public String getCapital() {
        return capital;
    }

    /**
     * method to set capital name
     * @param capital name
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }
}