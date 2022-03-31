package com.napier.sem;

import com.napier.sem.model.CapitalCity;
import com.napier.sem.model.City;
import com.napier.sem.model.Country;
import com.napier.sem.model.Population;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppIntegrationTest {
    static Report report;
    static DatabaseConnection db;
    @BeforeAll
    static void init() throws ClassNotFoundException, InterruptedException, SQLException
    {
        report = new Report();
        db = DatabaseConnection.Instance();
        db.connect("localhost:33060", 30000);
    }

    @Test
    void testCountryReportOne() throws SQLException {
        ArrayList<Country> countries = db.countryReportOne();
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        report.countryReportTemplate(countries);
    }

    @Test
    void testCountryReportTwo() throws SQLException {
        ArrayList<Country> countries = db.countryReportTwo("Asia");
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        report.countryReportTemplate(countries);
    }

    @Test
    void testCountryReportThree() throws SQLException {
        ArrayList<Country> countries = db.countryReportThree("Eastern Asia");
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        report.countryReportTemplate(countries);
    }

    @Test
    void testCountryReportFour() throws SQLException {
        ArrayList<Country> countries = db.countryReportFour(5);
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        report.countryReportTemplate(countries);
    }

    @Test
    void testCityReportOne() throws SQLException {
        ArrayList<City> cities = db.cityReportOne();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        report.cityReportTemplate(cities);
    }

    @Test
    void testCityReportTwo() throws SQLException {
        ArrayList<City> cities = db.cityReportTwo("Asia");
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        report.cityReportTemplate(cities);
    }

    @Test
    void testCityReportThree() throws SQLException {
        ArrayList<City> cities = db.cityReportThree("Eastern Asia");
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        report.cityReportTemplate(cities);
    }

    @Test
    void testCityReportFour() throws SQLException {
        ArrayList<City> cities = db.cityReportFour("Thailand");
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        report.cityReportTemplate(cities);
    }

    @Test
    void testCityReportSeven() throws SQLException {
        ArrayList<City> cities = db.cityReportSeven(7,"Asia");
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        report.cityReportTemplate(cities);
    }

    @Test
    void testCapitalCityReportOne() throws SQLException {
        ArrayList<CapitalCity> capitalCities = db.capitalCityReportOne();
        assertNotNull(capitalCities);
        assertEquals(capitalCities.size() > 0, true);
        report.capitalCityReportTemplate(capitalCities);
    }

    @Test
    void testPopulationReportOne() throws SQLException {
        ArrayList<Population> populations = db.populationReportOne();
        assertNotNull(populations);
        assertEquals(populations.size() > 0, true);
        report.populationReportTemplate(populations);
    }

    @Test
    void testPopulationReportTwo() throws SQLException {
        ArrayList<Population> populations = db.populationReportTwo();
        assertNotNull(populations);
        assertEquals(populations.size() > 0, true);
        report.populationReportTemplate(populations);
    }

    @Test
    void testAdditionalReportOne() throws SQLException {
        ArrayList<Population> populations = db.additionalReportOne();
        assertNotNull(populations);
        assertEquals(populations.size() > 0, true);
        report.simplePopulationReportTemplate(populations);
    }

    @Test
    void testAdditionalReportTwo() throws SQLException {
        ArrayList<Population> populations = db.additionalReportTwo("Europe");
        assertNotNull(populations);
        assertEquals(populations.size() > 0, true);
        report.simplePopulationReportTemplate(populations);
    }

    @Test
    void testAdditionalReportThree() throws SQLException {
        ArrayList<Population> populations = db.additionalReportThree("North America");
        assertNotNull(populations);
        assertEquals(populations.size() > 0, true);
        report.simplePopulationReportTemplate(populations);
    }

    @Test
    void testAdditionalReportFour() throws SQLException {
        ArrayList<Population> populations = db.additionalReportFour("United Kingdom");
        assertNotNull(populations);
        assertEquals(populations.size() > 0, true);
        report.simplePopulationReportTemplate(populations);
    }

    @Test
    void testAdditionalReportSeven() throws SQLException {
        ArrayList<Population> populations = db.additionalReportSeven();
        assertNotNull(populations);
        assertEquals(populations.size() > 0, true);
        report.advancePopulationReportTemplate(populations);
    }

    @AfterAll()
    static void end() throws SQLException {
        db.disconnect(); // Disconnect database connection after running all test
    }
}
