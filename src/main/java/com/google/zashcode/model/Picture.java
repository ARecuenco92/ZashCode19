package com.google.zashcode.model;

import lombok.Data;

import java.util.List;

@Data
public class Picture {

    private Integer id;

    private boolean horizontal;

    private List<String> tags;

    public Picture(Integer id, boolean horizontal, List tags) {
        this.id = id;
        this.horizontal = horizontal;
        this.tags = tags;
    }

}
