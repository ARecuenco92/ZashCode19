package com.google.zashcode.model;

import lombok.Data;

import java.util.List;

@Data
public class Slideshow {

    private List<Slide> slides;

    public Slideshow(List<Slide> slides) {
        this.slides = slides;
    }
}
