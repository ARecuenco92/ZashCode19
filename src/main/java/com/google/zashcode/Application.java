package com.google.zashcode;

import com.google.zashcode.model.Slideshow;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        System.out.println("Wer are Acquisition Hackers!!!");


        Slideshow slideA = new DataLoader("a_example.txt").getSlideShow();

        Slideshow slideB = new DataLoader("b_lovely_landscapes.txt").getSlideShow();

        Slideshow slideC = new DataLoader("c_memorable_moments.txt").getSlideShow();

        Slideshow slideD = new DataLoader("d_pet_pictures.txt").getSlideShow();

    }

}
