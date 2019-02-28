package com.google.zashcode;

import com.google.zashcode.model.Slide;
import com.google.zashcode.model.Slideshow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataOutput {

    public static void write(String file, Slideshow slideshow) {
        List<Slide> slideList = slideshow.getSlides();

        List<String> lines = new ArrayList<>();
        lines.add("" + slideList.size());

        for (Slide slide : slideshow.getSlides()) {
            lines.add(slide.toString());
        }

        try {
            Files.createDirectories(Paths.get("src/main/java/resources/outputs/"));
            Files.write(Paths.get( "src/main/java/resources/outputs/" +file + ".out"), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
