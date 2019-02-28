package com.google.zashcode.processors;

import com.google.zashcode.Utils;
import com.google.zashcode.model.Picture;
import com.google.zashcode.model.Slide;
import com.google.zashcode.model.Slideshow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Processor implements MagicProcessor{

    public Slideshow process(List<Picture> pictureList) {
        List<Slide> slideList = new ArrayList<>();

        Picture lastVerticalPicture = null;

        for (Picture picture : pictureList) {

            if (picture.isHorizontal()) {

                slideList.add(new Slide(picture));
            } else { // vertical

                if (lastVerticalPicture != null) {
                    slideList.add(new Slide(lastVerticalPicture, picture));
                    lastVerticalPicture = null;
                } else {
                    lastVerticalPicture = picture;
                }
            }

        }
        return new Slideshow(slideList);
    }

    public static void main(String[] args) {

        Processor processor = new Processor();
        List<Picture> pictureList = new ArrayList<>();
        pictureList.add(new Picture(1, true, Arrays.asList("tag1", "tag2")));
        pictureList.add(new Picture(2, true, Arrays.asList("tag2", "tag3")));
        pictureList.add(new Picture(3, true, Arrays.asList("tag3", "tag4")));
        System.out.println("points="+Utils.getResults(processor.process(pictureList)));
    }


}
