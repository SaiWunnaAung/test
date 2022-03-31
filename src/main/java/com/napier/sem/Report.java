package com.napier.sem;
import com.napier.sem.model.CapitalCity;
import com.napier.sem.model.City;
import com.napier.sem.model.Country;
import com.napier.sem.model.Population;
import java.util.ArrayList;

/**
 * Declaring public class for Report
 */
public class Report {

    /**
     * Methods for countryReportTemplate with table formatted
     * @param country Arraylist
     */
    public void countryReportTemplate(ArrayList<Country> country){
        //Print report title
        System.out.format("%-9s %-9s  %-40s  %-30.25s  %-30s  %-20s  %-20s", "No", "CODE", "NAME", "CONTINENT", "REGION", "POPULATION", "CAPITAL");
        System.out.println("\n");
        // Define counter variable
        int count = 0;
        // Loop and Retrieve data from country array list as a country object
        for (Country countries:country){
            // Increase count
            count++;
            // Print report by formatted design
            System.out.printf("%-9s %-9s  %-40s  %-30.25s  %-30s  %-20s  %-20s",
                    count,
                    countries.getCode(),
                    countries.getName(),
                    countries.getContinent(),
                    countries.getRegion(),
                    countries.getPopulation(),
                    countries.getCapital()
                    );
            System.out.println("\n");
        }
    }

    /**
     * Methods for cityReportTemplate with table formatted
     * @param city Arraylist
     */
    public void cityReportTemplate(ArrayList<City> city){
        //Print report title
        System.out.format("%-9s %-30.25s  %-30s  %-20s  %-20s", "No",  "NAME", "CONTINENT", "DISTRICT", "POPULATION");
        System.out.println("\n");
        // Define counter variable
        int count = 0;
        // Loop and Retrieve data from city array list as a city object
        for (City cities:city){
            // Increase count
            count++;
            // Print report by formatted design
            System.out.printf("%-9s %-30.25s  %-30s  %-20s  %-20s",
                    count,
                    cities.getName(),
                    cities.getCountry(),
                    cities.getDistrict(),
                    cities.getPopulation()
                    );
            System.out.println("\n");
        }
    }

    /**
     * Methods for capitalCityReportTemplate with table formatted
     * @param capitalCity Arraylist
     */
    public void capitalCityReportTemplate(ArrayList<CapitalCity> capitalCity){
        //Print report title
        System.out.format("%-9s %-30.25s  %-30s  %-20s", "No",  "NAME", "CONTINENT","POPULATION");
        System.out.println("\n");
        // Define counter variable
        int count = 0;
        // Loop and Retrieve data from capitalCity array list as a CapitalCity object
        for (CapitalCity capitalCities:capitalCity){
            // Increase count
            count++;
            // Print report by formatted design
            System.out.printf("%-9s %-30.25s  %-30s  %-20s",
                    count,
                    capitalCities.getName(),
                    capitalCities.getCountry(),
                    capitalCities.getPopulation()
            );
            System.out.println("\n");
        }
    }

  /**
     * Methods for simplePopulationReportTemplate with table formatted
     * @param population Arraylist
     */
    public void simplePopulationReportTemplate(ArrayList<Population> population){
        //Print report title
        System.out.format("%-9s %-30.25s  %-20s", "No",  "NAME", "POPULATION");
        System.out.println("\n");
        // Define counter variable
        int count = 0;
        // Loop and Retrieve data from population array list as a Population object
        for (Population populations:population){
            // Increase count
            count++;
            // Print report by formatted design
            System.out.printf("%-9s %-30.25s  %-20s",
                    count,
                    populations.getName(),
                    populations.getPopulation()
            );
            System.out.println("\n");
        }
    }

  /**
     * Methods for advancePopulationReportTemplate with table formatted
     * @param population Arraylist
     */
    public void advancePopulationReportTemplate(ArrayList<Population> population){
        //Print report title
        System.out.format("%-9s %-30.25s  %-37.25s  %-20s", "No",  "LANGUAGE NAME", "POPULATION NUMBER", "POPULATION PERCENTAGE (%)");
        System.out.println("\n");
        // Define counter variable
        int count = 0;
        // Loop and Retrieve data from population array list as a Population object
        for (Population populations:population){
            // Increase count
            count++;
            // Print report by formatted design
            System.out.printf("%-9s %-30.25s  %-37.25s  %-20s",
                    count,
                    populations.getName(),
                    populations.getPopulation(),
                    populations.getPercentagePopulationInCities()
            );
            System.out.println("\n");
        }
    }


}
