package com.lastminute.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FlightTest {

    private final String cvsLine = "CPH,FRA,IB2818,186";
    
    @Test
    public void shouldBuildANewFlightFromArray() {
       
        Flight flight = new Flight(cvsLine.split(","));
       
        assertEquals("CPH", flight.getOrigin());
        assertEquals("FRA", flight.getDestination());
        assertEquals("IB2818", flight.getCode());
        assertEquals(186.0, flight.getBasePrice(), 0);
        assertEquals("IB", flight.getAirline());
    }
}
