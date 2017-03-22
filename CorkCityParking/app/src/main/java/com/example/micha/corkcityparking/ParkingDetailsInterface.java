package com.example.micha.corkcityparking;

import java.sql.Time;
import java.text.ParseException;

/**
 * Created by micha on 25/09/2016.
 */

public interface ParkingDetailsInterface {
    
    public void ParkingDetailsInterface(Time timeParked) throws ParseException;

    public double getParkingCost(double cost) ;

    public String toString();

}


