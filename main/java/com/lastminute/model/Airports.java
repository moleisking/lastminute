package com.lastminute.model;

import com.lastminute.model.Airport;
import java.io.IOException;
import java.util.Optional;

public class Airports extends AbstractFile<Airport>  {

    public Airports(String csvFile) throws IOException {
        super(csvFile);
    }

    @Override
    protected Airport buildObject(String line) {
        return new Airport(line.split(","));
    }

    public Optional<Airport> queryByCity(String city){
        return data.stream()
                .filter(f->f.getCity().equals(city)).findFirst();
    }
}