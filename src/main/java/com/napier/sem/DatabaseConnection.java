package com.napier.sem;
import com.napier.sem.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

/**
 * Declaring public class for DatabaseConnection
 */
@RestController
public class DatabaseConnection {
    /**
     * Create Database Connection object
     */
    private static Connection con = null;

    /**
     * Create Instance of database
     */
    private static DatabaseConnection instance = null;

    /**
     * Method for database singleton
     *
     * @return Instance of DatabaseConnection
     */
    public static DatabaseConnection Instance() {
        // Check instance is null
        if (instance == null){
            // If null assign new connection to instance variable
            instance = new DatabaseConnection();
        }
        // Return instance of DatabaseConnection
        return instance;
    }

    /**
     * Default constructor for DatabaseConnection
     */
    public DatabaseConnection() {
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, long delay) throws ClassNotFoundException, InterruptedException, SQLException {
        // Define class name for jdb driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Define retries variable and assign 20
        int retries = 20;
        // 20 times loop and connect database
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://worlddb.mysql.database.azure.com:3306/world?serverTimezone=UTC&useLegacyDatetimeCode=false&allowPublicKeyRetrieval=true&useSSL=false", "root_group4@worlddb", "*w&Dv5BMV");
                System.out.println("Successfully connected");
                break;
        }

    }


    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() throws SQLException {
        //Check con is not null and close connection
        if (con != null) {
                // Close connection
                con.close();
                System.out.println("--------------------------------------");
                System.out.println("Connection to database closed");
        }
    }

    private long counter = 0;
    private static final String template = "Hello, %s!";

    @RequestMapping("/greeting2")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name)
    {
        return new Greeting(counter++, String.format(template, name));
    }

    /**
     * Methods for retrieve data for CountryReportOne
     * @return countries ArrayList
     * @throws SQLException
     */
    public ArrayList<Country> countryReportOne() throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select con.code, con.name, con.continent, con.region, con.population, cit.name as capital from country con join city cit on capital=id order by population DESC";
        //Create countries arraylist to store country data
        ArrayList<Country> countries = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
            while (resultSet.next()) {
                /* Create country object and set data in setter method */
                Country country = new Country();
                country.setName(resultSet.getString("name"));
                country.setContinent(resultSet.getString("continent"));
                country.setRegion(resultSet.getString("region"));
                country.setPopulation(resultSet.getLong("population"));
                country.setCapital(resultSet.getString("capital"));
                country.setCode(resultSet.getString("code"));
                // Add country object in countries array list
                countries.add(country);
            }
        // Return countries array list
        return countries;
    }

    /**
     * Methods for retrieve data for CountryReportTwo
     * @param continent name
     * @return countries ArrayList
     * @throws SQLException
     */
    public ArrayList<Country> countryReportTwo(String continent) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select con.code, con.name, con.continent, con.region , con.population, cit.name as capital from country con join city cit on capital=id where continent ='"+continent+"' order by population DESC";
        //Create countries arraylist to store country data
        ArrayList<Country> countries = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
            while (resultSet.next()) {
                /* Create country object and set data in setter method */
                Country country = new Country();
                country.setName(resultSet.getString("name"));
                country.setContinent(resultSet.getString("continent"));
                country.setRegion(resultSet.getString("region"));
                country.setPopulation(resultSet.getLong("population"));
                country.setCapital(resultSet.getString("capital"));
                country.setCode(resultSet.getString("code"));
                // Add country object in countries array list
                countries.add(country);
            }
        // Return countries array list
        return countries;
    }

    /**
     * Methods for retrieve data for CountryReportThree
     * @param region name
     * @return countries ArrayList
     * @throws SQLException
     */
    public ArrayList<Country> countryReportThree(String region) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select con.code, con.name, con.continent, con.region , con.population, cit.name as capital from country con join city cit on capital=id where region = '"+region+"' order by population DESC";
        //Create countries arraylist to store country data
        ArrayList<Country> countries = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create country object and set data in setter method */
            Country country = new Country();
            country.setName(resultSet.getString("name"));
            country.setContinent(resultSet.getString("continent"));
            country.setRegion(resultSet.getString("region"));
            country.setPopulation(resultSet.getLong("population"));
            country.setCapital(resultSet.getString("capital"));
            country.setCode(resultSet.getString("code"));
            // Add country object in countries array list
            countries.add(country);
        }
        // Return countries array list
        return countries;
    }

    /**
     * Methods for retrieve data for CountryReportFour
     * @param topNum of top
     * @return countries ArrayList
     * @throws SQLException
     */
    public ArrayList<Country> countryReportFour(int topNum) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select con.code, con.name, con.continent, con.region, con.population, cit.name as capital from country con join city cit on capital=id order by population DESC LIMIT "+topNum+" ";
        //Create countries arraylist to store country data
        ArrayList<Country> countries = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create country object and set data in setter method */
            Country country = new Country();
            country.setName(resultSet.getString("name"));
            country.setContinent(resultSet.getString("continent"));
            country.setRegion(resultSet.getString("region"));
            country.setPopulation(resultSet.getLong("population"));
            country.setCapital(resultSet.getString("capital"));
            country.setCode(resultSet.getString("code"));
            // Add country object in countries array list
            countries.add(country);
        }
        // Return countries array list
        return countries;
    }

    /**
     * Methods for retrieve data for CountryReportFour
     * @param continent
     * @param num
     * @return countries ArrayList
     * @throws SQLException
     */
    public ArrayList<Country> countryReportFive(String continent, int num) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select con.code, con.name, con.continent, con.region, con.population, cit.name as " +
                "capital from country con join city cit on capital=id " +
                "where continent = '"+continent+"' order by population DESC LIMIT "+num+" ";
        //Create countries arraylist to store country data
        ArrayList<Country> countries = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create country object and set data in setter method */
            Country country = new Country();
            country.setName(resultSet.getString("name"));
            country.setContinent(resultSet.getString("continent"));
            country.setRegion(resultSet.getString("region"));
            country.setPopulation(resultSet.getLong("population"));
            country.setCapital(resultSet.getString("capital"));
            country.setCode(resultSet.getString("code"));
            // Add country object in countries array list
            countries.add(country);
        }
        // Return countries array list
        return countries;
    }

    /**
     * Methods for retrieve data for CityReportOne
     * @return cities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportOne() throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.district, city.population from city city join country country on CountryCode=code order by city.population DESC";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
            while (resultSet.next()) {
                /* Create city object and set data in setter method */
                City city = new City();
                city.setName(resultSet.getString("name"));
                city.setCountry(resultSet.getString("country"));
                city.setDistrict(resultSet.getString("district"));
                city.setPopulation(resultSet.getLong("population"));
                // Add city object in countries array list
                cities.add(city);
            }
        // Return cities array list
        return cities;
    }

    /**
     * Methods for retrieve data for CityReportTwo
     * @param continent name
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportTwo(String continent) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name As country, city.district, city.population from city city join country country on CountryCode=code where country.continent = '"+continent+"' order by city.population DESC";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
            while (resultSet.next()) {
                /* Create city object and set data in setter method */
                City city = new City();
                city.setName(resultSet.getString("name"));
                city.setCountry(resultSet.getString("country"));
                city.setDistrict(resultSet.getString("district"));
                city.setPopulation(resultSet.getLong("population"));
                // Add city object in countries array list
                cities.add(city);
            }
        // Return cities array list
        return cities;
    }

    /**
     * Methods for retrieve data for CityReportThree
     * @param region name
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportThree(String region) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.district, city.population from city city join country country on CountryCode=code where country.region = '"+region+"' order by city.population DESC";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
            while (resultSet.next()) {
                /* Create city object and set data in setter method */
                City city = new City();
                city.setName(resultSet.getString("name"));
                city.setCountry(resultSet.getString("country"));
                city.setDistrict(resultSet.getString("district"));
                city.setPopulation(resultSet.getLong("population"));
                // Add city object in countries array list
                cities.add(city);
            }
        // Return cities array list
        return cities;
    }

  /**
     * Methods for retrieve data for CityReportFour
     * @param country name
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportFour(String country) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.district, city.population from city city join country country on CountryCode=code where country.name = '"+country+"' order by city.population DESC";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
            while (resultSet.next()) {
                /* Create city object and set data in setter method */
                City city = new City();
                city.setName(resultSet.getString("name"));
                city.setCountry(resultSet.getString("country"));
                city.setDistrict(resultSet.getString("district"));
                city.setPopulation(resultSet.getLong("population"));
                // Add city object in countries array list
                cities.add(city);
            }
        // Return cities array list
        return cities;
    }

  /**
     * Methods for retrieve data for CityReportSeven
     * @param topNum
     * @param continent
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportSeven(int topNum, String continent) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name As country, city.district, city.population from city city join country country on CountryCode=code where continent = '"+continent+"' order by city.population DESC LIMIT "+topNum+" ";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
            while (resultSet.next()) {
                /* Create city object and set data in setter method */
                City city = new City();
                city.setName(resultSet.getString("name"));
                city.setCountry(resultSet.getString("country"));
                city.setDistrict(resultSet.getString("district"));
                city.setPopulation(resultSet.getLong("population"));
                // Add city object in countries array list
                cities.add(city);
            }
        // Return cities array list
        return cities;
    }

    /**
     * Methods for retrieve data for CapitalCityReportOne
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<CapitalCity> capitalCityReportOne() throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name As country, city.population from city city join country country on id=capital order by city.population DESC";
        //Create capitalCities arraylist to store capital city data
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
            while (resultSet.next()) {
                /* Create capitalCity object and set data in setter method */
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.setName(resultSet.getString("name"));
                capitalCity.setCountry(resultSet.getString("country"));
                capitalCity.setPopulation(resultSet.getLong("population"));
                // Add capitalCity object in capitalCities array list
                capitalCities.add(capitalCity);
            }
        // Return capitalCities array list
        return capitalCities;
    }

    /**
     * Methods for retrieve data for PopulationReportOne
     * @return populations ArrayList
     * @throws SQLException
     */
    public ArrayList<Population> populationReportOne() throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "Select country.continent, SUM(country.population) as TotalPopulation, SUM((select SUM(population) from city where countrycode = country.code)) AS popInCity, (SUM((select SUM(population) from city where countrycode = country.code)) / SUM(country.population))*100 as percentInCities , (sum(country.population)-SUM((select SUM(population) from city where countrycode = country.code))) as popNotInCity, ((sum(country.population)-SUM((select SUM(population) from city where countrycode = country.code))) / SUM(country.population))*100 as percentNotInCities from country GROUP BY country.continent";
        //Create populations arraylist to store population data
        ArrayList<Population> populations = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create population object and set data in setter method */
            Population population = new Population();
            population.setName(resultSet.getString("continent"));
            population.setPopulation(resultSet.getLong("TotalPopulation"));
            population.setPopInCity(resultSet.getLong("popInCity"));
            population.setPopNotInCity(resultSet.getLong("popNotInCity"));
            population.setPercentagePopulationInCities(resultSet.getFloat("percentInCities"));
            population.setPercentagePopulationNotInCities(resultSet.getFloat("percentNotInCities"));
            // Add population object in populations array list
            populations.add(population);
        }
        // Return populations array list
        return populations;
    }

    /**
     * Methods for retrieve data for PopulationReportTwo
     * @return populations ArrayList
     * @throws SQLException
     */
    public ArrayList<Population> populationReportTwo() throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "Select country.region, SUM(country.population) as TotalPopulation, SUM((select SUM(population) from city where countrycode = country.code)) AS popInCity, (SUM((select SUM(population) from city where countrycode = country.code)) / SUM(country.population))*100 as percentInCities , (sum(country.population)-SUM((select SUM(population) from city where countrycode = country.code))) as popNotInCity, ((sum(country.population)-SUM((select SUM(population) from city where countrycode = country.code))) / SUM(country.population))*100 as percentNotInCities from country GROUP BY country.region";
        //Create populations arraylist to store population data
        ArrayList<Population> populations = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create population object and set data in setter method */
            Population population = new Population();
            population.setName(resultSet.getString("region"));
            population.setPopulation(resultSet.getLong("TotalPopulation"));
            population.setPopInCity(resultSet.getLong("popInCity"));
            population.setPopNotInCity(resultSet.getLong("popNotInCity"));
            population.setPercentagePopulationInCities(resultSet.getFloat("percentInCities"));
            population.setPercentagePopulationNotInCities(resultSet.getFloat("percentNotInCities"));
            // Add population object in populations array list
            populations.add(population);
        }
        // Return populations array list
        return populations;
    }

    /**
     * Methods for retrieve data for AdditionalReportOne
     * @return populations ArrayList
     * @throws SQLException
     */
    public ArrayList<Population> additionalReportOne() throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "SELECT sum(population) As population FROM country";
        //Create populations arraylist to store population data
        ArrayList<Population> populations = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
            while (resultSet.next()) {
                /* Create population object and set data in setter method */
                Population population = new Population();
                population.setName("World Population");
                population.setPopulation(resultSet.getLong("population"));
                // Add population object in populations array list
                populations.add(population);
            }
        // Return populations array list
        return populations;
    }

      /**
     * Methods for retrieve data for AdditionalReportTwo
     * @param continent name
     * @return populations ArrayList
     * @throws SQLException
     */
    public ArrayList<Population> additionalReportTwo(String continent) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "SELECT continent, sum(population) AS population FROM country WHERE continent = '"+continent+"' group by continent";
        //Create populations arraylist to store population data
        ArrayList<Population> populations = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create population object and set data in setter method */
                Population population = new Population();
                population.setName(resultSet.getString("continent"));
                population.setPopulation(resultSet.getLong("population"));
            // Add population object in populations array list
                populations.add(population);
            }
        // Return populations array list
        return populations;
    }

      /**
     * Methods for retrieve data for AdditionalReportThree
     * @param region name
     * @return populations ArrayList
     * @throws SQLException
     */
    public ArrayList<Population> additionalReportThree(String region) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "SELECT region, sum(population) AS population FROM country WHERE region = '"+region+"' group by region";
        //Create populations arraylist to store population data
        ArrayList<Population> populations = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create population object and set data in setter method */
                Population population = new Population();
                population.setName(resultSet.getString("region"));
                population.setPopulation(resultSet.getLong("population"));
            // Add population object in populations array list
                populations.add(population);
        }
        // Return populations array list
        return populations;
    }

      /**
     * Methods for retrieve data for AdditionalReportFour
     * @param country name
     * @return populations ArrayList
     * @throws SQLException
     */
    public ArrayList<Population> additionalReportFour(String country) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "SELECT name, sum(population) AS population FROM country WHERE name ='"+country+"' group by name";
        //Create populations arraylist to store population data
        ArrayList<Population> populations = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create population object and set data in setter method */
                Population population = new Population();
                population.setName(resultSet.getString("name"));
                population.setPopulation(resultSet.getLong("population"));
            // Add population object in populations array list
                populations.add(population);
        }
        // Return populations array list
        return populations;
    }

      /**
     * Methods for retrieve data for AdditionalReportSeven
     * @return populations ArrayList
     * @throws SQLException
     */
    public ArrayList<Population> additionalReportSeven() throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select cl.language, sum(cl.percentage*c.population) as speakerlangugaepop, sum(c.population*cl.percentage)/(select sum(population) from country) as worldpercentage from countrylanguage cl, country c where cl.countrycode=c.code and cl.language in ('English','Arabic','Hindi','Chinese','Spanish') group by cl.language order by speakerlangugaepop DESC";
        //Create populations arraylist to store population data
        ArrayList<Population> populations = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create population object and set data in setter method */
                Population population = new Population();
                population.setName(resultSet.getString("language"));
                population.setPopulation(resultSet.getLong("speakerlangugaepop"));
                population.setPercentagePopulationInCities(resultSet.getFloat("worldpercentage"));
            // Add population object in populations array list
                populations.add(population);
        }
        // Return populations array list
        return populations;
    }


}