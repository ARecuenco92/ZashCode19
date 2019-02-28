package com.google.zashcode.processors;

import com.google.zashcode.Utils;
import com.google.zashcode.model.Picture;
import com.google.zashcode.model.Slide;
import com.google.zashcode.model.Slideshow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        Slideshow slideshow = new Slideshow(slideList);
        sortGabi(slideshow);
        return slideshow;
    }

    public void sortByTags(List<Picture> pictureList){
        pictureList.sort(new CustomComparator());
    }

    public void sortNextBestImage(List<Slide> pictureList){
        pictureList.sort(new BestPointsComparator());
    }

    public void sortGabi(Slideshow slideshowIn) {

        final int MAX_TRIES = 50;

        Queue<Slide> freeSlides = new LinkedList<>();
        ((LinkedList<Slide>) freeSlides).addAll(slideshowIn.getSlides());
        Slide firstSlide = ((LinkedList<Slide>) freeSlides).removeFirst();

        Slide currentSlide = firstSlide;
        List<Slide> initList = new ArrayList<>();
        initList.add(firstSlide);
        Slideshow slideshowResult = new Slideshow(initList);
        int count = 0;
        while (!freeSlides.isEmpty()) {

            int bestResult = -1;
            Slide bestNextSlide = null;

            int numTries = 0;
            for (Slide slide : freeSlides) {
                Slideshow slideshow = new Slideshow(Arrays.asList(currentSlide, slide));
                if(Utils.getResults(slideshow) > bestResult) {
                    bestResult = Utils.getResults(slideshow);
                    bestNextSlide = slide;
                }
                numTries++;
                if (numTries >= MAX_TRIES) {
                    break;
                }
            }
            freeSlides.remove(bestNextSlide);
            slideshowResult.addSlide(bestNextSlide);
            count++;
            if (count % 1000 == 0) {
//                System.out.println(freeSlides.size());
            }
//            System.out.println(freeSlides.size());
        }
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
