package com.google.zashcode;

import com.google.zashcode.model.Car;
import com.google.zashcode.model.City;
import com.google.zashcode.model.Ride;

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

    public City getCity() throws IOException {
        int numberOfCars,numberOfRides,rideCounter = 0;
        City city = new City();
        List<String> lines = Files.readAllLines(Paths.get(filePath.concat(docName)));

        String cityString = lines.get(0);
            String [] split = cityString.split(" ");
            city.setRows(Integer.parseInt(split[0]));
            city.setColumns(Integer.parseInt(split[1]));
            numberOfCars = Integer.parseInt(split[2]);
            numberOfRides = Integer.parseInt(split[3]);
            city.setBonus(Integer.parseInt(split[4]));
            city.setSteps(Integer.parseInt(split[5]));
        lines.remove(0);

        List<Ride> rides;

        city.setRides(new ArrayList<Ride>());
        for(String stringRide : lines){
            Ride rideAux =  new Ride();
            String [] rideSplit = stringRide.split(" ");
            rideAux.setEndTime(Integer.parseInt(rideSplit[5]));
            rideAux.setEndX(Integer.parseInt(rideSplit[2]));
            rideAux.setEndY(Integer.parseInt(rideSplit[3]));
            rideAux.setId(rideCounter++);
            rideAux.setStartTime(Integer.parseInt(rideSplit[4]));
            rideAux.setStartX(Integer.parseInt(rideSplit[0]));
            rideAux.setStartY(Integer.parseInt(rideSplit[1]));
            city.getRides().add(rideAux);
        }

        city.setCars(new ArrayList<Car>());
        for(int carCounter = 0; carCounter < numberOfCars;carCounter++){
            Car car = new Car();
            car.setId(carCounter);
            city.getCars().add(car);
        }


        return city;
    }


}
