package com.google.zashcode.processors;

import com.google.zashcode.model.Picture;
import com.google.zashcode.model.Slide;
import com.google.zashcode.model.Slideshow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CrazyMagicProcessor implements MagicProcessor {

    public Slideshow process(List<Picture> pictures) {
        List<Slide> slideList = new ArrayList<>();

        Picture lastVerticalPicture = null;

        for (Picture picture : pictures) {

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

        Collections.sort(slideList, new Comparator<Slide>(){
            public int compare(Slide p1, Slide p2) {
                return p1.getTags().size()- p2.getTags().size();
            }
        });


        return new Slideshow(slideList);
    }

}
