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
        System.out.format("%-9s %-9s  %-40s  %-30.25s  %-30s  %-20s  %-20s", "No", "CODE", "NAME", "CONTINENT", "REGION", "POPULATION", "CAPITAL");
        System.out.println("\n");
        int count = 0;
        for (Country countries:country){
            count++;
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
        System.out.format("%-9s %-30.25s  %-30s  %-20s  %-20s", "No",  "NAME", "CONTINENT", "DISTRICT", "POPULATION");
        System.out.println("\n");
        int count = 0;
        for (City cities:city){
            count++;
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
        System.out.format("%-9s %-30.25s  %-30s  %-20s", "No",  "NAME", "CONTINENT","POPULATION");
        System.out.println("\n");
        int count = 0;
        for (CapitalCity capitalCities:capitalCity){
            count++;
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
        System.out.format("%-9s %-30.25s  %-20s", "No",  "NAME", "POPULATION");
        System.out.println("\n");
        int count = 0;
        for (Population populations:population){
            count++;
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
        System.out.format("%-9s %-30.25s  %-37.25s  %-20s", "No",  "LANGUAGE NAME", "POPULATION NUMBER", "POPULATION PERCENTAGE (%)");
        System.out.println("\n");
        int count = 0;
        for (Population populations:population){
            count++;
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
