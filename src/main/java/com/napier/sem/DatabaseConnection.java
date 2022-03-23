package com.napier.sem;
import com.napier.sem.model.CapitalCity;
import com.napier.sem.model.City;
import com.napier.sem.model.Country;
import com.napier.sem.model.Population;

import java.sql.*;
import java.util.ArrayList;

/**
 * Declaring public class for DatabaseConnection
 */
public class DatabaseConnection {

    private static Connection con = null;
    private static DatabaseConnection instance = null;

    /**
     * Method for database singleton
     *
     * @return Instance of DatabaseConnection
     */
    public static DatabaseConnection Instance() {
        if (instance == null){
            instance = new DatabaseConnection();
        }
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

    public void connect(String location, long delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 20;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://"+location+"/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }


    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
                System.out.println("--------------------------------------");
                System.out.println("Connection to database closed");
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }


    /**
     * Methods for retrieve data for CountryReportOne
     * @param query of sql
     * @return countries ArrayList
     */
    public ArrayList<Country> countryReportOne(String query){
         Statement statement;
         ResultSet resultSet;
        ArrayList<Country> countries = new ArrayList<>();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Country country = new Country();
                country.setName(resultSet.getString("name"));
                country.setContinent(resultSet.getString("continent"));
                country.setRegion(resultSet.getString("region"));
                country.setPopulation(resultSet.getLong("population"));
                country.setCapital(resultSet.getString("capital"));
                country.setCode(resultSet.getString("code"));
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return countries;
    }

    /**
     *Methods for output data for CountryReportOne
     */
    public void countryReportOneOutput(){
        Report report = new Report();
        ArrayList<Country> country ;
        country = countryReportOne("select con.code, con.name, con.continent, con.region, con.population, cit.name as capital from country con join city cit on capital=id order by population DESC");
        report.countryReportTemplate(country);
    }

    /**
     * Methods for retrieve data for CountryReportTwo
     * @param query of sql
     * @return countries ArrayList
     */
    public ArrayList<Country> countryReportTwo(String query){
         Statement statement;
         ResultSet resultSet;
        ArrayList<Country> countries = new ArrayList<>();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Country country = new Country();
                country.setName(resultSet.getString("name"));
                country.setContinent(resultSet.getString("continent"));
                country.setRegion(resultSet.getString("region"));
                country.setPopulation(resultSet.getLong("population"));
                country.setCapital(resultSet.getString("capital"));
                country.setCode(resultSet.getString("code"));
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return countries;
    }

    /**
     *Methods for output data for CountryReportTwo
     */
    public void countryReportTwoOutput(String continent){
        Report report = new Report();
        ArrayList<Country> country ;
        country = countryReportTwo("select con.code, con.name, con.continent, con.region , con.population, cit.name as capital from country con join city cit on capital=id where continent ='"+continent+"' order by population DESC");
        report.countryReportTemplate(country);
    }

    /**
     * Methods for retrieve data for CityReportOne
     * @param query of sql
     * @return cities ArrayList
     */
    public ArrayList<City> cityReportOne(String query){
         Statement statement;
         ResultSet resultSet;
        ArrayList<City> cities = new ArrayList<>();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                City city = new City();
                city.setName(resultSet.getString("name"));
                city.setCountry(resultSet.getString("country"));
                city.setDistrict(resultSet.getString("district"));
                city.setPopulation(resultSet.getLong("population"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return cities;
    }

    /**
     *Methods for output data for CityReportOne
     */
    public void cityReportOneOutput(){
        Report report = new Report();
        ArrayList<City> city ;
        city = cityReportOne("select city.name, country.name AS country, city.district, city.population from city city join country country on CountryCode=code order by city.population DESC");
        report.cityReportTemplate(city);
    }

    /**
     * Methods for retrieve data for CityReportTwo
     * @param query of sql
     * @return capitalCities ArrayList
     */
    public ArrayList<City> cityReportTwo(String query){
         Statement statement;
         ResultSet resultSet;
        ArrayList<City> cities = new ArrayList<>();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                City city = new City();
                city.setName(resultSet.getString("name"));
                city.setCountry(resultSet.getString("country"));
                city.setDistrict(resultSet.getString("district"));
                city.setPopulation(resultSet.getLong("population"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return cities;
    }

    /**
     *Methods for output data for CityReportTwo
     */
    public void cityReportTwoOutput(String continent){
        Report report = new Report();
        ArrayList<City> city ;
        city = cityReportTwo("select city.name, country.name As country, city.district, city.population from city city join country country on CountryCode=code where country.continent = '"+continent+"' order by city.population DESC");
        report.cityReportTemplate(city);
    }


    /**
     * Methods for retrieve data for CapitalCityReportOne
     * @param query of sql
     * @return capitalCities ArrayList
     */
    public ArrayList<CapitalCity> capitalCityReportOne(String query){
         Statement statement;
         ResultSet resultSet;
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                CapitalCity capitalCity = new CapitalCity();
                capitalCity.setName(resultSet.getString("name"));
                capitalCity.setCountry(resultSet.getString("country"));
                capitalCity.setPopulation(resultSet.getLong("population"));
                capitalCities.add(capitalCity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return capitalCities;
    }

    /**
     *Methods for output data for CapitalCityReportOne
     */
    public void capitalCityReportOneOutput(){
        Report report = new Report();
        ArrayList<CapitalCity> capitalCity ;
        capitalCity = capitalCityReportOne("select city.name, country.name As country, city.population from city city join country country on id=capital order by city.population DESC");
        report.capitalCityReportTemplate(capitalCity);
    }

    /**
     * Methods for retrieve data for PopulationReportOne
     * @param query of sql
     * @return populations ArrayList
     */
    public ArrayList<Population> populationReportOne(String query){
        Statement statement;
        ResultSet resultSet;
        ArrayList<Population> populations = new ArrayList<>();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Population population = new Population();
                population.setName("World Population");
                population.setPopulation(resultSet.getLong("population"));
                populations.add(population);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return populations;
    }

    /**
     *Methods for output data for PopulationReportOne
     */
    public void populationReportOneOutput(){
        Report report = new Report();
        ArrayList<Population> population ;
        population = populationReportOne("SELECT sum(population) As population FROM country");
        report.simplePopulationReportTemplate(population);
    }

      /**
     * Methods for retrieve data for PopulationReportTwo
     * @param query of sql
     * @return populations ArrayList
     */
    public ArrayList<Population> populationReportTwo(String query){
        Statement statement;
        ResultSet resultSet;
        ArrayList<Population> populations = new ArrayList<>();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Population population = new Population();
                population.setName(resultSet.getString("continent"));
                population.setPopulation(resultSet.getLong("population"));
                populations.add(population);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return populations;
    }

    /**
     *Methods for output data for PopulationReportTwo
     */
    public void populationReportTwoOutput(String continent){
        Report report = new Report();
        ArrayList<Population> population ;
        population = populationReportTwo("SELECT continent, sum(population) AS population FROM country WHERE continent = '"+continent+"' group by continent");
        report.simplePopulationReportTemplate(population);
    }


      /**
     * Methods for retrieve data for PopulationReportThree
     * @param query of sql
     * @return populations ArrayList
     */
    public ArrayList<Population> populationReportThree(String query){
        Statement statement;
        ResultSet resultSet;
        ArrayList<Population> populations = new ArrayList<>();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Population population = new Population();
                population.setName(resultSet.getString("region"));
                population.setPopulation(resultSet.getLong("population"));
                populations.add(population);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return populations;
    }

    /**
     *Methods for output data for PopulationReportThree
     */
    public void populationReportThreeOutput(String region){
        Report report = new Report();
        ArrayList<Population> population ;
        population = populationReportThree("SELECT region, sum(population) AS population FROM country WHERE region = '"+region+"' group by region");
        report.simplePopulationReportTemplate(population);
    }

      /**
     * Methods for retrieve data for PopulationReportFour
     * @param query of sql
     * @return populations ArrayList
     */
    public ArrayList<Population> populationReportFour(String query){
        Statement statement;
        ResultSet resultSet;
        ArrayList<Population> populations = new ArrayList<>();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Population population = new Population();
                population.setName(resultSet.getString("name"));
                population.setPopulation(resultSet.getLong("population"));
                populations.add(population);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return populations;
    }

    /**
     *Methods for output data for PopulationReportFour
     */
    public void populationReportFourOutput(String country){
        Report report = new Report();
        ArrayList<Population> population ;
        population = populationReportFour("SELECT name, sum(population) AS population FROM country WHERE name ='"+country+"' group by name");
        report.simplePopulationReportTemplate(population);
    }

      /**
     * Methods for retrieve data for PopulationReportFive
     * @param query of sql
     * @return populations ArrayList
     */
    public ArrayList<Population> populationReportFive(String query){
        Statement statement;
        ResultSet resultSet;
        ArrayList<Population> populations = new ArrayList<>();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Population population = new Population();
                population.setName(resultSet.getString("language"));
                population.setPopulation(resultSet.getLong("speakerlangugaepop"));
                population.setPercentagePopulationInCities(resultSet.getFloat("worldpercentage"));
                populations.add(population);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return populations;
    }

    /**
     *Methods for output data for PopulationReportFive
     */
    public void populationReportFiveOutput(){
        Report report = new Report();
        ArrayList<Population> population ;
        population = populationReportFive("select cl.language, sum(cl.percentage*c.population) as speakerlangugaepop, sum(c.population*cl.percentage)/(select sum(population) from country) as worldpercentage from countrylanguage cl, country c where cl.countrycode=c.code and cl.language in ('English','Arabic','Hindi','Chinese','Spanish') group by cl.language order by speakerlangugaepop DESC");
        report.advancePopulationReportTemplate(population);
    }


}
