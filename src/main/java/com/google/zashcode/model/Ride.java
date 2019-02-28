package com.google.zashcode.model;

import lombok.Data;

@Data
public class Ride {

    private Integer id;

    private Integer startX;

    private Integer startY;

    private Integer endX;

    private Integer endY;

    private Integer startTime;

    private Integer endTime;

    private boolean done = false;

}
