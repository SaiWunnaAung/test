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

/**
 * This class is for Integration Testing
 */
public class AppIntegrationTest {
    // Define Report object
    static Report report;
    // Define DatabaseConnection object
    static DatabaseConnection db;

    /**
     * This method is to run before all integration tests
     * @throws ClassNotFoundException
     * @throws InterruptedException
     * @throws SQLException
     */
    @BeforeAll
    static void init() throws ClassNotFoundException, InterruptedException, SQLException
    {
        // Create report object
        report = new Report();
        // Create database connection Instance
        db = DatabaseConnection.Instance();
        // Connect to the database
        db.connect("localhost:33060", 30000);
    }

    /**
     * This method is integration test for Country Report One
     * @throws SQLException
     */
    @Test
    void testCountryReportOne() throws SQLException {
        // create array list
        ArrayList<Country> countries = db.countryReportOne();
        // check array list is null
        assertNotNull(countries);
        // check array list has data
        assertEquals(countries.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(countries.get(0).getCode());
        assertNotNull(countries.get(0).getName());
        assertNotNull(countries.get(0).getContinent());
        assertNotNull(countries.get(0).getRegion());
        assertNotNull(countries.get(0).getPopulation());
        assertNotNull(countries.get(0).getCapital());
        /*Check expected data are correct or not*/
        assertEquals(countries.get(0).getCode(),"CHN");
        assertEquals(countries.get(0).getName(),"China");
        assertEquals(countries.get(0).getContinent(),"Asia");
        assertEquals(countries.get(0).getRegion(),"Eastern Asia");
        assertEquals(countries.get(0).getPopulation(),1277558000);
        assertEquals(countries.get(0).getCapital(),"Peking");
        // print report
        report.countryReportTemplate(countries);
    }

    /**
     * This method is integration test for Country Report Two
     * @throws SQLException
     */
    @Test
    void testCountryReportTwo() throws SQLException {
        // create array list
        ArrayList<Country> countries = db.countryReportTwo("Asia");
        // check array list is null
        assertNotNull(countries);
        // check array list has data
        assertEquals(countries.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(countries.get(0).getCode());
        assertNotNull(countries.get(0).getName());
        assertNotNull(countries.get(0).getContinent());
        assertNotNull(countries.get(0).getRegion());
        assertNotNull(countries.get(0).getPopulation());
        assertNotNull(countries.get(0).getCapital());
        /*Check expected data are correct or not*/
        assertEquals(countries.get(0).getCode(),"CHN");
        assertEquals(countries.get(0).getName(),"China");
        assertEquals(countries.get(0).getContinent(),"Asia");
        assertEquals(countries.get(0).getRegion(),"Eastern Asia");
        assertEquals(countries.get(0).getPopulation(),1277558000);
        assertEquals(countries.get(0).getCapital(),"Peking");
        // print report
        report.countryReportTemplate(countries);
    }

    /**
     * This method is integration test for Country Report Three
     * @throws SQLException
     */
    @Test
    void testCountryReportThree() throws SQLException {
        // create array list
        ArrayList<Country> countries = db.countryReportThree("Eastern Asia");// create array list
        // check array list is null
        assertNotNull(countries);
        // check array list has data
        assertEquals(countries.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(countries.get(0).getCode());
        assertNotNull(countries.get(0).getName());
        assertNotNull(countries.get(0).getContinent());
        assertNotNull(countries.get(0).getRegion());
        assertNotNull(countries.get(0).getPopulation());
        assertNotNull(countries.get(0).getCapital());
        /*Check expected data are correct or not*/
        assertEquals(countries.get(0).getCode(),"CHN");
        assertEquals(countries.get(0).getName(),"China");
        assertEquals(countries.get(0).getContinent(),"Asia");
        assertEquals(countries.get(0).getRegion(),"Eastern Asia");
        assertEquals(countries.get(0).getPopulation(),1277558000);
        assertEquals(countries.get(0).getCapital(),"Peking");
        // print report
        report.countryReportTemplate(countries);
    }

    /**
     * This method is integration test for Country Report Four
     * @throws SQLException
     */
    @Test
    void testCountryReportFour() throws SQLException {
        // create array list
        ArrayList<Country> countries = db.countryReportFour(5);
        // check array list is null
        assertNotNull(countries);
        // check array list has data
        assertEquals(countries.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(countries.get(0).getCode());
        assertNotNull(countries.get(0).getName());
        assertNotNull(countries.get(0).getContinent());
        assertNotNull(countries.get(0).getRegion());
        assertNotNull(countries.get(0).getPopulation());
        assertNotNull(countries.get(0).getCapital());
        /*Check expected data are correct or not*/
        assertEquals(countries.get(0).getCode(),"CHN");
        assertEquals(countries.get(0).getName(),"China");
        assertEquals(countries.get(0).getContinent(),"Asia");
        assertEquals(countries.get(0).getRegion(),"Eastern Asia");
        assertEquals(countries.get(0).getPopulation(),1277558000);
        assertEquals(countries.get(0).getCapital(),"Peking");
        // print report
        report.countryReportTemplate(countries);
    }

    /**
     * This method is integration test for City Report One
     * @throws SQLException
     */
    @Test
    void testCityReportOne() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportOne();
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Mumbai (Bombay)");
        assertEquals(cities.get(0).getCountry(),"India");
        assertEquals(cities.get(0).getDistrict(),"Maharashtra");
        assertEquals(cities.get(0).getPopulation(),10500000);
        // print report
        report.cityReportTemplate(cities);
    }

    /**
     * This method is integration test for City Report Two
     * @throws SQLException
     */
    @Test
    void testCityReportTwo() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportTwo("Asia");
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Mumbai (Bombay)");
        assertEquals(cities.get(0).getCountry(),"India");
        assertEquals(cities.get(0).getDistrict(),"Maharashtra");
        assertEquals(cities.get(0).getPopulation(),10500000);
        // print report
        report.cityReportTemplate(cities);
    }

    /**
     * This method is integration test for City Report Three
     * @throws SQLException
     */
    @Test
    void testCityReportThree() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportThree("Eastern Asia");
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Seoul");
        assertEquals(cities.get(0).getCountry(),"South Korea");
        assertEquals(cities.get(0).getDistrict(),"Seoul");
        assertEquals(cities.get(0).getPopulation(),9981619);
        // print report
        report.cityReportTemplate(cities);
    }

    /**
     * This method is integration test for City Report Four
     * @throws SQLException
     */
    @Test
    void testCityReportFour() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportFour("Thailand");
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Bangkok");
        assertEquals(cities.get(0).getCountry(),"Thailand");
        assertEquals(cities.get(0).getDistrict(),"Bangkok");
        assertEquals(cities.get(0).getPopulation(),6320174);
        // print report
        report.cityReportTemplate(cities);
    }

    /**
     * This method is integration test for City Report Seven
     * @throws SQLException
     */
    @Test
    void testCityReportSeven() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportSeven(7,"Asia");
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Mumbai (Bombay)");
        assertEquals(cities.get(0).getCountry(),"India");
        assertEquals(cities.get(0).getDistrict(),"Maharashtra");
        assertEquals(cities.get(0).getPopulation(),10500000);
        // print report
        report.cityReportTemplate(cities);
    }

    /**
     * This method is integration test for Capital City Report One
     * @throws SQLException
     */
    @Test
    void testCapitalCityReportOne() throws SQLException {
        // create array list
        ArrayList<CapitalCity> capitalCities = db.capitalCityReportOne();
        // check array list is null
        assertNotNull(capitalCities);
        // check array list has data
        assertEquals(capitalCities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(capitalCities.get(0).getName());
        assertNotNull(capitalCities.get(0).getCountry());
        assertNotNull(capitalCities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(capitalCities.get(0).getName(),"Seoul");
        assertEquals(capitalCities.get(0).getCountry(),"South Korea");
        assertEquals(capitalCities.get(0).getPopulation(),9981619);
        // print report
        report.capitalCityReportTemplate(capitalCities);
    }

    /**
     * This method is integration test for Population Report one
     * @throws SQLException
     */
    @Test
    void testPopulationReportOne() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.populationReportOne();
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        assertNotNull(populations.get(0).getPopInCity());
        assertNotNull(populations.get(0).getPopNotInCity());
        assertNotNull(populations.get(0).getPercentagePopulationInCities());
        assertNotNull(populations.get(0).getPercentagePopulationNotInCities());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"North America");
        assertEquals(populations.get(0).getPopulation(),482993000);
        assertEquals(populations.get(0).getPopInCity(),168250381);
        assertEquals(populations.get(0).getPopNotInCity(),314742619);
        assertEquals(populations.get(0).getPercentagePopulationInCities(),34.834999084472656);
        assertEquals(populations.get(0).getPercentagePopulationNotInCities(),65.16500091552734);
        // print report
        report.populationReportTemplate(populations);
    }

    /**
     * This method is integration test for Population Report Two
     * @throws SQLException
     */
    @Test
    void testPopulationReportTwo() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.populationReportTwo();
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        assertNotNull(populations.get(0).getPopInCity());
        assertNotNull(populations.get(0).getPopNotInCity());
        assertNotNull(populations.get(0).getPercentagePopulationInCities());
        assertNotNull(populations.get(0).getPercentagePopulationNotInCities());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"Caribbean");
        assertEquals(populations.get(0).getPopulation(),38140000);
        assertEquals(populations.get(0).getPopInCity(),11067550);
        assertEquals(populations.get(0).getPopNotInCity(),27072450);
        assertEquals(populations.get(0).getPercentagePopulationInCities(),29.018199920654297);
        assertEquals(populations.get(0).getPercentagePopulationNotInCities(),70.98179626464844);
        // print report
        report.populationReportTemplate(populations);
    }

    /**
     * This method is integration test for Additional Report One
     * @throws SQLException
     */
    @Test
    void testAdditionalReportOne() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.additionalReportOne();
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"World Population");
        assertEquals(populations.get(0).getPopulation(),6078749450L);
        // print report
        report.simplePopulationReportTemplate(populations);
    }

    /**
     * This method is integration test for Additional Report Two
     * @throws SQLException
     */
    @Test
    void testAdditionalReportTwo() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.additionalReportTwo("Europe");
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"Europe");
        assertEquals(populations.get(0).getPopulation(),730074600L);
        // print report
        report.simplePopulationReportTemplate(populations);
    }
    /**
     * This method is integration test for Additional Report Three
     * @throws SQLException
     */
    @Test
    void testAdditionalReportThree() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.additionalReportThree("North America");
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"North America");
        assertEquals(populations.get(0).getPopulation(),309632000L);
        // print report
        report.simplePopulationReportTemplate(populations);
    }

    /**
     * This method is integration test for Additional Report Four
     * @throws SQLException
     */
    @Test
    void testAdditionalReportFour() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.additionalReportFour("United Kingdom");
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"United Kingdom");
        assertEquals(populations.get(0).getPopulation(),59623400L);
        // print report
        report.simplePopulationReportTemplate(populations);
    }

    /**
     * This method is integration test for Additional Report Seven
     * @throws SQLException
     */
    @Test
    void testAdditionalReportSeven() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.additionalReportSeven();
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        assertNotNull(populations.get(0).getPercentagePopulationInCities());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"Chinese");
        assertEquals(populations.get(0).getPopulation(),119184353900L);
        assertEquals(populations.get(0).getPercentagePopulationInCities(),19.606719970703125);
        // print report
        report.advancePopulationReportTemplate(populations);
    }

    /**
     * This method will run after all integration test
     * @throws SQLException
     */
    @AfterAll()
    static void end() throws SQLException {
        db.disconnect(); // Disconnect database connection after running all test
    }
}
