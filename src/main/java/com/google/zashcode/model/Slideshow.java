package com.google.zashcode.model;

import lombok.Data;

import java.util.List;

@Data
public class Slideshow {

    private List<Slide> slides;

    private int numberOfPictures = 0;

    public Slideshow(List<Slide> slides) {
        this.slides = slides;
    }

    public void addSlide(Slide slide) {
        slides.add(slide);
    }


}
