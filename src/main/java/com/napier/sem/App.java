package com.napier.sem;

import java.util.Scanner;

/**
 * Declaring public class for App
 */
public class App
{
    /**
     * Create Instance of database
     */
    private final static DatabaseConnection db = DatabaseConnection.Instance();

    /**
     * Create Instance of APP
     */
    private static App app;

    public static void main(String[] args)
    {
        app = new App(); // create object
        //Add database connection
        if (args.length < 1) {
            db.connect("localhost:33060",0);
        } else {
            db.connect(args[0],Integer.parseInt(args[1]));
        }
        app.reportMenu();
        //Remove database connection
        db.disconnect();
    }
    /**
     * method for output report menu
     */
    private void reportMenu() {
        Scanner input = new Scanner(System.in);
        do {
            String[] reportNo={
                    "0. Exit from system",
                    "1. All the countries in the world organised by largest population to smallest",
                    "2. All the countries in a continent organised by largest population to smallest",
                    "3. All the countries in a region organised by largest population to smallest",
                    "4. The top N populated countries in the world",
                    "5. The top N populated continent in the world",
                    "6. The top N populated countries in a region",
                    "7. All the cities in the world organised by largest population to smallest",
                    "8. All the cities in a continent organised by largest population to smallest",
                    "9. All the cities in a region organised by largest population to smallest",
                    "10. All the cities in a country organised by largest population to smallest",
                    "11. All the cities in a district organised by largest population to smallest.",
                    "12. The top N populated cities in the world",
                    "13. The top N populated cities in a continent",
                    "14. The top N populated cities in a region",
                    "15. The top N populated cities in a country",
                    "16. The top N populated cities in a district",
                    "17. All the capital cities in the world organised by largest population to smallest",
                    "18. All the capital cities in a continent organised by largest population to smallest",
                    "19. All the capital cities in a region organised by largest to smallest",
                    "20. The top N populated capital cities in the world",
                    "21. The top N populated capital cities in a continent",
                    "22. The top N populated capital cities in a region",
                    "23. The population of people, people living in cities, and people not living in cities in each continent",
                    "24. The population of people, people living in cities, and people not living in cities in each region",
                    "25. The population of people, people living in cities, and people not living in cities in each country",
                    "26. The population of the world",
                    "27. The population of a continent",
                    "28. The population of a region",
                    "29. The population of a country",
                    "30. The population of a district",
                    "31. The population of a city",
                    "32. The number of people who speak Chinese, English, Hindi, Spanish or Arabic in the world."
            };
            System.out.println("*******************Report Menu*******************");
            for(int i=0; i<reportNo.length;i++){
                System.out.println(reportNo[i]);
            }
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Report Number: ");
            chooseMenu(Integer.parseInt(sc.nextLine()));

            System.out.print("Type YES to do again: ");
        }while (input.next().equalsIgnoreCase("YES"));

    }
    /**
     * method for choose report items
     */
    private void chooseMenu(int num){
        Scanner sc = new Scanner(System.in);
        switch (num) {
            case 1:
                System.out.println("All the countries in the world organised by largest population to smallest");
                db.countryReportOneOutput();
                break;

            case 2:
                System.out.println("All the countries in a continent organised by largest population to smallest");
                System.out.print("Enter continent: ");
                db.countryReportTwoOutput(sc.nextLine());
                break;

            case 3:
                System.out.println("Not available in this version");
                break;

            case 4:
                System.out.println("Not available in this version");
                break;

            case 5:
                System.out.println("Not available in this version");
                break;

            case 6:
                System.out.println("Not available in this version");
                break;

            case 7:
                System.out.println("All the cities in the world organised by largest population to smallest");
                db.cityReportOneOutput();
                break;


            case 8:
                System.out.println("All the cities in a continent organised by largest population to smallest");
                System.out.print("Enter Continent: ");
                db.cityReportTwoOutput(sc.nextLine());
                break;


            case 9:
                System.out.println("Not available in this version");
                break;

            case 10:
                System.out.println("Not available in this version");
                break;

            case 11:
                System.out.println("Not available in this version");
                break;

            case 12:
                System.out.println("Not available in this version");
                break;

            case 13:
                System.out.println("Not available in this version");
                break;

            case 14:
                System.out.println("Not available in this version");
                break;

            case 15:
                System.out.println("Not available in this version");
                break;

            case 16:
                System.out.println("Not available in this version");
                break;

            case 17:
                System.out.println("All the capital cities in the world organised by largest population to smallest");
                db.capitalCityReportOneOutput();
                break;


            case 18:
                System.out.println("Not available in this version");
                break;

            case 19:
                System.out.println("Not available in this version");
                break;

            case 20:
                System.out.println("Not available in this version");
                break;

            case 21:
                System.out.println("Not available in this version");
                break;

            case 22:
                System.out.println("Not available in this version");
                break;

            case 23:
                System.out.println("Not available in this version");
                break;

            case 24:
                System.out.println("Not available in this version");
                break;

            case 25:
                System.out.println("Not available in this version");
                break;

            case 26:
                System.out.println("The population of the world");
                db.populationReportOneOutput();
                break;

            case 27:
                System.out.println("The population of a continent");
                System.out.print("Enter Continent: ");
                String contt = sc.nextLine();
                db.populationReportTwoOutput(contt);
                break;

            case 28:
                System.out.println("The population of a region");
                System.out.print("Enter Region: ");
                String regg = sc.nextLine();
                db.populationReportThreeOutput(regg);
                break;

            case 29:
                System.out.println("The population of a country");
                System.out.print("Enter Country: ");
                String cou = sc.nextLine();
                db.populationReportFourOutput(cou);
                break;


            case 30:
                System.out.println("Not available in this version");
                break;

            case 31:
                System.out.println("Not available in this version");
                break;

            case 32:
                System.out.println("The number of people who speak Chinese, English, Hindi, Spanish or Arabic in the world.");
                db.populationReportFiveOutput();
                break;

            default:
                System.out.println("Type error.");
                break;
        }
    }


}