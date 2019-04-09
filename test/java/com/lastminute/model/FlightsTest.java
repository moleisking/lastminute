package com.lastminute.test;

import com.lastminute.model.Flight;
import org.junit.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlightsTest {

    private final String csvFile = getClass().getResource("/Flights.csv").getFile();

    @Test
    public void shouldCreateANewObjectFromACVSFile() throws IOException {
        
        Flights flights = new Flights(csvFile);
        
        assertEquals("Not expected rows count", 89, flights.getData().size());
    }

    @Test
    public void shouldFindAFlightAndReturnJustOne() throws IOException {
        
        Flights flights = new Flights(csvFile);
        List<Flight> results = flights.queryByOriginAndDestination("FCO", "MAD");
       
        assertNotNull(results);
        assertEquals(1, results.size());

        Flight flight = results.get(0);

        assertEquals("FCO", flight.getOrigin());
        assertEquals("MAD", flight.getDestination());
        assertEquals("BA1164", flight.getCode());
        assertEquals(118.0, flight.getBasePrice(), 0);
    }

    @Test
    public void shouldFindAFlightAndReturnMultiple() throws IOException {
       
        Flights flights = new Flights(csvFile);
        List<Flight> results = flights.queryByOriginAndDestination("AMS", "FRA");
        
        assertNotNull(results);
        assertEquals(3, results.size());
    }

    @Test
    public void shouldFindAFlightAndReturnEmptyList() throws IOException {
        
        Flights flights = new Flights(csvFile);
        List<Flight> results = flights.queryByOriginAndDestination("CDG", "FRA");

        assertNotNull(results);
        assertEquals(0, results.size());
    }
}
