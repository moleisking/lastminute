package com.lastminute.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractFile<T> {

    protected List<T> data;

    public AbstractFile(String csvFile) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(csvFile))) {
            data = stream.map(this::buildObject).collect(Collectors.toList());
        }
    }

    protected abstract T buildObject(String fileLine);

    public List<T> getData() {
        return Collections.unmodifiableList(data);
    }

}
