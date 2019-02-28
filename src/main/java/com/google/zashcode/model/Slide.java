package com.google.zashcode.model;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Slide {

    private Picture picture1;

    private Picture picture2;

    public Slide(Picture picture1) {
        if(picture1.isHorizontal()) {
            this.picture1 = picture1;
        } else {
            System.exit(-1);
        }
    }

    public Slide(Picture picture1, Picture picture2) {
        if(!picture1.isHorizontal() && !picture2.isHorizontal()) {
            this.picture1 = picture1;
            this.picture2 = picture2;
        } else {
            System.exit(-1);
        }
    }

    @Override
    public String toString(){
        String slideString = picture1.getId().toString();
        if(picture2 != null){
            slideString = slideString.concat(" " + picture2.getId().toString());
        }
        return slideString;
    }

    public boolean isEmpty() {
        return picture1 == null && picture2 == null;
    }


    public List<String> getTags() {
        Set<String> set = new HashSet<>();
        if(picture1 != null) {
            set.addAll(picture1.getTags());
        }
        if(picture2 != null) {
            set.addAll(picture2.getTags());
        }
        return set.stream().collect(Collectors.toList());
    }
}
