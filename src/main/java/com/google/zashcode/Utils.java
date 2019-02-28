package com.google.zashcode;

import com.google.zashcode.model.Slide;
import com.google.zashcode.model.Slideshow;

import java.util.List;

public class Utils {

    public Integer getResults(Slideshow slideshow) {
        List<Slide> slides = slideshow.getSlides();

        Integer size = slides.size() - 1;
        Slide first, second;

        Integer points = 0;

        for(int i = 0; i < size; i++) {
            first = slides.get(i);
            second = slides.get(i+1);

            points = points + getResult(first, second);
        }

        System.out.println("Points: " + points);

        return points;
    }

    private Integer getResult(Slide first, Slide second) {
        List<String> tags1 = first.getPicture1().getTags();

        List<String> tags2 = second.getPicture1().getTags();

        Integer intersection = intersection(first, second);

        Integer difference1 = difference(first, second);

        Integer difference2 = difference(second, first);

        return Math.min(Math.min(intersection, difference1), difference2);
    }

    private Integer intersection(Slide first, Slide second) {
        Integer points = 0;

        for(String tag : first.getTags()) {
            points = second.getTags().contains(tag) ? points + 1 : points;
        }

        return points;
    }

    private Integer difference(Slide first, Slide second) {
        Integer points = 0;

        for(String tag : first.getTags()) {
            points = second.getTags().contains(tag) ? points : points + 1;
        }

        return points;
    }

}
