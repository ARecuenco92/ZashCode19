package com.google.zashcode;

import com.google.zashcode.model.Picture;
import com.google.zashcode.model.Slideshow;
import com.google.zashcode.processors.MagicProcessor;
import com.google.zashcode.processors.Processor;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {

        System.out.println("Wer are Acquisition Hackers!!!");


        List<Picture> picturesA = new DataLoader("a_example.txt").getSlideShow();

        List<Picture> picturesB = new DataLoader("b_lovely_landscapes.txt").getSlideShow();

        List<Picture> picturesC = new DataLoader("c_memorable_moments.txt").getSlideShow();

        List<Picture> picturesD = new DataLoader("d_pet_pictures.txt").getSlideShow();


        MagicProcessor processor = new Processor();

        Slideshow slideshow = processor.process(picturesA);
        Utils.getResults(slideshow);
        DataOutput.write("out_a", slideshow);
    }

}
