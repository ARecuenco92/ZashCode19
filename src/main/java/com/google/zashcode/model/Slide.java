package com.google.zashcode.model;

import lombok.Data;

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

}
