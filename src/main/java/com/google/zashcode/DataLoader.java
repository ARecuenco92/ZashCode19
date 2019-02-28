package com.google.zashcode;

import com.google.zashcode.model.Picture;
import com.google.zashcode.model.Slideshow;
import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    private final String filePath = "src/main/java/resources/inputs/";

    private String docName;


    public DataLoader(String docName){
        this.docName = docName;
    }

    public Slideshow getSlideShow() throws IOException {



        Slideshow slideshow= new Slideshow(new ArrayList<Picture>());
        List<String> lines = Files.readAllLines(Paths.get(filePath.concat(docName)));

        List<Picture> pictures = new ArrayList<Picture>();

        lines.remove(0);

        Picture picture;
        List<String> tagList;
        boolean horizontal;
        int pictureId = 0;
        for(String pictureLine : lines){
            String[] arrayLine = pictureLine.split(" ");

            horizontal = arrayLine[0].equals("H") ? true:false;
            int numTags = Integer.parseInt(arrayLine[1]);
            tagList = new ArrayList<String>();
            slideshow.getPictures().add(new Picture(pictureId, horizontal,tagList));
        }

        return slideshow;
    }


}
