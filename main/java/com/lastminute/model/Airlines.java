package com.lastminute.model;

import com.lastminute.model.Airline;
import java.io.IOException;
import java.util.Optional;

public class Airlines extends Abstract<Airline>  {
    
    public Airlines(String csvFile) throws IOException {
        super(csvFile);
    }

    @Override
    protected Airline buildObject(String line) {
        return new Airline(line.split(","));
    }

    public Optional<Airline> queryByCode(String code){
        return data.stream()
                .filter(f->f.getIATACode().equals(code)).findFirst();
    }
}