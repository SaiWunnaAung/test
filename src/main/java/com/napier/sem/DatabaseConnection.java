package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Declaring public class for DatabaseConnection
 */
public class DatabaseConnection {

    private static Connection con = null;
    private static DatabaseConnection instance = null;
    private DatabaseConnection databaseConnection;

    /**
     * Method that instantiates _instance if null
     *
     * @return Instance of DatabaseHandler
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

    public void connect(String location) {
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
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://"+location+"/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(10000);
                // Exit for loop
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



    public ArrayList<Country> regionreport1(String query){

    public ArrayList<Country> report1(String query){

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

    public void regionreport1Output(){
        Report report = new Report();
        ArrayList<Country> country ;
        country = regionreport1("select con.code, con.name, con.continent, con.region, con.population, cit.name as capital from country con join city cit on capital=id order by population DESC");
        report.regionReport(country);

    public void report1Output(){
        Report report = new Report();
        ArrayList<Country> country ;
        country = report1("select con.code, con.name, con.continent, con.region, con.population, cit.name as capital from country con join city cit on capital=id order by population DESC");
        report.countryReport(country);

    }
}
