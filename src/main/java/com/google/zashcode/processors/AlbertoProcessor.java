package com.google.zashcode.processors;

import com.google.zashcode.Utils;
import com.google.zashcode.model.Picture;
import com.google.zashcode.model.Slide;
import com.google.zashcode.model.Slideshow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AlbertoProcessor implements MagicProcessor{

    public Slideshow process(List<Picture> pictureList) {
        List<Slide> slideList = new ArrayList<>();

        sortByTags(pictureList);

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

    public void sortByTags(List<Picture> pictureList){
        pictureList.sort(new CustomComparator());
    }

    public void sortNextBestImage(List<Slide> pictureList){
        pictureList.sort(new BestPointsComparator());
    }

    public class CustomComparator implements Comparator<Picture> {
        @Override
        public int compare(Picture o1, Picture o2) {
            return o1.getTags().size() - o2.getTags().size();
        }
    }

    public class BestPointsComparator implements Comparator<Slide> {
        @Override
        public int compare(Slide o1, Slide o2) {



            return o1.getTags().size() - o2.getTags().size();
        }
    }
}
