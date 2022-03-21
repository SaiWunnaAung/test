package com.napier.sem;



public class App
{
    private final static DatabaseConnection db = DatabaseConnection.Instance(); // Instance of database
    public static void main(String[] args)
    {
        if (args.length < 1) {
            db.connect("localhost:33060");

        } else {
            System.out.println(args[0]);
            db.connect(args[0]);
        }
        db.regionreport1Output();
        db.disconnect();
    }
}