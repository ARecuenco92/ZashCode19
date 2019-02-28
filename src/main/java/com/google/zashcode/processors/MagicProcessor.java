package com.google.zashcode.processors;

import com.google.zashcode.model.Picture;
import com.google.zashcode.model.Slideshow;

import java.util.List;

public interface MagicProcessor {

    Slideshow process(List<Picture> pictures);
}
