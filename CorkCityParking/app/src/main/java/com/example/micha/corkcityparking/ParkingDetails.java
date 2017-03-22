package com.example.micha.corkcityparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.micha.corkcityparking.CarParks.NorthMainStreet;

public class ParkingDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_details);
        Intent intent = getIntent();
        String test = intent.getStringExtra("test");
        Toast.makeText(this, "Name" + test, Toast.LENGTH_SHORT).show();

        NorthMainStreet northMainStreet = new NorthMainStreet();
        TextView tvDuration = (TextView) findViewById(R.id.lblDurationText);
        TextView tvPricing = (TextView) findViewById(R.id.lblPricingText);
        TextView tvDurationHeader = (TextView) findViewById(R.id.lblDurationHeader);
        TextView tvPricingHeader = (TextView) findViewById(R.id.lblPricingHeader);
        tvDurationHeader.setText("Duration");
        tvPricingHeader.setText("Price");
        tvDuration.setText(northMainStreet.getDurationsText());
        tvPricing.setText(northMainStreet.getHourlyPricing());
    }
}
