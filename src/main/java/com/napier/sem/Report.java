package com.napier.sem;

import java.util.ArrayList;

public class Report {

    public void regionReport(ArrayList<Country> country){
        System.out.println("This is region");

    public void countryReport(ArrayList<Country> country){

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
}
