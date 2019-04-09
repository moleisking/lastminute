package com.lastminute.test;

import com.lastminute.model.Airport;
import org.junit.Test;
import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.*;

public class AirportsTest {

    private final String csvFile = getClass().getResource("/Airports.csv").getFile();

    @Test
    public void shouldCreateANewObjectFromACVSFile() throws IOException {
       
        Airports airports = new Airports(csvFile);
        
        assertEquals("Not expected rows count", 9, airports.getData().size());
    }

    @Test
    public void shouldFindAnAirportFromCity() throws IOException {
       
        Airports airports = new Airports(csvFile);
        Optional<Airport> result = airports.queryByCity("Madrid");
       
        assertNotNull(result);
        assertNotEquals(Optional.empty(), result);

        Airport airport = result.get();

        assertEquals("Madrid", airport.getCity());
        assertEquals("MAD", airport.getIataCode());
    }

    @Test
    public void shouldFindAirportFromCityButReturnEmpty() throws IOException {
        
        Airports airports = new Airports(csvFile);
        Optional<Airport> result = airports.queryByCity("Ciudad Real");
        
        assertNotNull(result);
        assertEquals(Optional.empty(), result);
    }

}
