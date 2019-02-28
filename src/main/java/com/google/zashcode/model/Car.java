package com.google.zashcode.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Car {

    private Integer id;

    private List<Ride> rides;

    private Integer steps;

    public Car() {
        rides = new ArrayList<Ride>();
        steps = 0;
    }

    @Override
    public String toString() {
        String line = rides.size()+"";
        for(Ride ride: rides){
            line += " "+ride.getId();
        }
        return line;
    }

}
