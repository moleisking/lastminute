package com.lastminute.test;

import com.lastminute.model.Airline;
import org.junit.Test;
import java.io.IOException;
import java.util.Optional;
import static org.junit.Assert.*;

public class AirlinesTest {

    private final String csvFile = getClass().getResource("/Airlines.csv").getFile();

    @Test
    public void shouldCreateNewObjectFromACVSFile() throws IOException {

        Airlines airlines = new Airlines(csvFile);
        
        assertEquals("Not expected rows count", 7, airlines.getData().size());
    }

    @Test
    public void shouldFindAirlineFromCode() throws IOException {
        
        Airlines airlines = new Airlines(csvFile);
        Optional<Airline> result = airlines.queryByCode("IB");
       
        assertNotNull(result);
        assertNotEquals(Optional.empty(), result);

        Airline airline = result.get();

        assertEquals("IB", airline.getIATACode());
        assertEquals("Iberia", airline.getName());
        assertEquals(10.0, airline.getInfantPrice(), 0);
    }

    @Test
    public void shouldFindAirlineFromCodeButReturnEmpty() throws IOException {
        
        Airlines airlines = new Airlines(csvFile);       
        Optional<Airline> result = airlines.queryByCode("CV");
        
        assertNotNull(result);
        assertEquals(Optional.empty(), result);
    }
}
