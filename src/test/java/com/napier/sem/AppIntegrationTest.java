package com.napier.sem;

import com.napier.sem.model.Country;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
    void testGetCountry() throws SQLException {
        Country countries = db.countryReportOne().get(0);
        assertEquals(countries.getCode(), "CHN");
//        System.out.println(countries.getCode());
    }

    @Test
    void testReportOne() throws SQLException {
        ArrayList<Country> countries = db.countryReportOne();
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        report.countryReportTemplate(countries);
//        System.out.println(countries.getCode());
    }

}
