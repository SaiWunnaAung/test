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
    }

    @Test
    void testCountryReportTwo() throws SQLException {
        ArrayList<Country> countries = db.countryReportTwo("Asia");
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
    }

    @Test
    void testCityReportOne() throws SQLException {
        ArrayList<City> cities = db.cityReportOne();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
    }

    @Test
    void testCityReportTwo() throws SQLException {
        ArrayList<City> cities = db.cityReportTwo("Asia");
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
    }

    @Test
    void testCapitalCityReportOne() throws SQLException {
        ArrayList<CapitalCity> capitalCities = db.capitalCityReportOne();
        assertNotNull(capitalCities);
        assertEquals(capitalCities.size() > 0, true);
    }

    @Test
    void testPopulationReportOne() throws SQLException {
        ArrayList<Population> populations = db.populationReportOne();
        assertNotNull(populations);
        assertEquals(populations.size() > 0, true);
    }

    @Test
    void testPopulationReportTwo() throws SQLException {
        ArrayList<Population> populations = db.populationReportTwo("Europe");
        assertNotNull(populations);
        assertEquals(populations.size() > 0, true);
    }

    @Test
    void testPopulationReportThree() throws SQLException {
        ArrayList<Population> populations = db.populationReportThree("North America");
        assertNotNull(populations);
        assertEquals(populations.size() > 0, true);
    }

    @Test
    void testPopulationReportFour() throws SQLException {
        ArrayList<Population> populations = db.populationReportFour("United Kingdom");
        assertNotNull(populations);
        assertEquals(populations.size() > 0, true);
    }

    @Test
    void testPopulationReportSeven() throws SQLException {
        ArrayList<Population> populations = db.populationReportSeven();
        assertNotNull(populations);
        assertEquals(populations.size() > 0, true);
    }

    @AfterAll()
    static void end()
    {
        db.disconnect(); // Disconnect database connection after running all test
    }
}
