package com.google.zashcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataOutput {

    public static void write(String file, List<Car> cars) {
        List<String> lines = new ArrayList<String>();

        for (Car car : cars) {
            lines.add(car.toString());
        }

        try {
            Files.createDirectories(Paths.get("src/main/java/resources/outputs/"));
            Files.write(Paths.get( "src/main/java/resources/outputs/" +file + ".out"), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
