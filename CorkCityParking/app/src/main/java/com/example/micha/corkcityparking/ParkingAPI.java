package com.example.micha.corkcityparking;

import com.example.micha.corkcityparking.models.Parking;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by michael on 20/09/2016.
 */


public interface ParkingAPI {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    public static final String BASE_URL = "";


    @GET("")
    Call<Parking> getParking();
    //void getData(Callback<List<Record>> response);
    // void getData(@Path("username") String username, Callback<Record> cb);

    class Factory {
        private static ParkingAPI service;

        public static ParkingAPI getInstance() {

            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build();

                service = retrofit.create(ParkingAPI.class);
                return service;
            } else {
                return service;
            }
        }


    }
}
