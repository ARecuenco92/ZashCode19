package com.google.zashcode.model;

import lombok.Data;

import java.util.List;

@Data
public class Slideshow {

    private List<Slide> slides;

    private int numberOfPictures = 0;

    private List<Picture> pictures;

    public Slideshow(List<Picture> pictures) {
        this.pictures = pictures;
    }

}
