package com.google.zashcode.model;

import lombok.Data;

import java.util.List;

@Data
public class City {

    private Integer columns;

    private Integer rows;

    private List<Car> cars;

    private List<Ride> rides;

    private Integer bonus;

    private Integer steps;

}
