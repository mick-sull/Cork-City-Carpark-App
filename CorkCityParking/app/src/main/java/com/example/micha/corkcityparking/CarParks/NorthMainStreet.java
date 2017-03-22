package com.example.micha.corkcityparking.CarParks;

import com.example.micha.corkcityparking.ParkingDetailsInterface;

import java.sql.Array;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by micha on 25/09/2016.
 */

public class NorthMainStreet implements ParkingDetailsInterface {
    Time currentTime;
    double cost;
    String[] durationTextArray = {"Up to 1 hour" ,
            "Up to 2 hours",
            "Up to 3 hours" ,
            "Up to 4 hours" ,
            "Up to 5 hours" ,
            "Up to 6 hours" ,
            "Up to 7 hours" ,
            "Up to 8 hours" ,
            "Up to 9 hours" ,
            "Up to 9 hours" ,
            "Overnight Charge"};

    String[] priceTextArray = {
            "€1.70",
                    "€3.50" ,
                    "€5.00" ,
                    "€7.00" ,
                    "€9.00" ,
                    "€12.00" ,
                    "€14.00" ,
                    "€16.00" ,
                    "€18.00" ,
                    "€20.00" ,
                    "€12.90"
                     };

    @Override
    public void ParkingDetailsInterface(Time timeParked) throws ParseException {
        java.text.DateFormat df = new java.text.SimpleDateFormat("hh:mm:ss");
        java.util.Date date1 = df.parse(currentTime.toString());
        java.util.Date date2 = df.parse(timeParked.toString());
        long diff = date2.getTime() - date1.getTime();
        //calculateCost(currentTime.getTime() - timeParked.getTime());
        calculateCost(diff);
    }


    private void calculateCost(long diff) {

    }

    @Override
    public double getParkingCost(double cost) {
        return 0;
    }

    public String toString(){
       return "";
    }

    public String getDurationsText(){
        return (
                "Up to 1 hour\n" +
                "Up to 2 hours\n" +
                "Up to 3 hours\n" +
                "Up to 4 hours\n" +
                "Up to 5 hours\n" +
                "Up to 6 hours\n" +
                "Up to 7 hours\n" +
                "Up to 8 hours\n" +
                "Up to 9 hours\n" +
                "Up to 9 hours\n" +
                "Overnight Charge");
    }
    public String getHourlyPricing(){
        return (
                "€1.70\n" +
                "€3.50\n" +
                "€5.00\n" +
                "€7.00\n" +
                "€9.00\n" +
                "€12.00\n" +
                "€14.00\n" +
                "€16.00\n" +
                "€18.00\n" +
                "€20.00\n" +
                "€12.90");
    }
}
