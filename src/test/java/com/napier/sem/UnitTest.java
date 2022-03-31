package com.napier.sem;

import com.napier.sem.model.Country;
import org.junit.jupiter.api.*;

import java.util.ArrayList;



class UnitTest
{
    static Report report;

    @BeforeAll
    static void init()
    {
        report = new Report();
    }

    @Test
    void uniTestCityReportOne()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.setCode("code");
        country.setName("Name");
        country.setContinent("continent");
        country.setRegion("region");
        country.setPopulation(2000);
        country.setCapital("capital");
        countries.add(country);
        report.countryReportTemplate(countries);
    }
}