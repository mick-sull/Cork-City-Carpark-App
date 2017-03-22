package com.example.micha.corkcityparking;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.micha.corkcityparking.models.Parking;
import com.example.micha.corkcityparking.models.Record;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.util.Log.e;

public class MainActivity extends AppCompatActivity {


    Context ctx;
    ParkingAdapter parkingAdapter;

    List<Record> parkingArray = new ArrayList<Record>();
    RecyclerView recyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.parking_recycler_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        ctx = this;
        //getData();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });



        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(ctx, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        changeActivity(position);
                    }


                })
        );

        }

    private void changeActivity(int position) {
        Intent intent = new Intent(this, ParkingDetails.class);
        intent.putExtra( "test", parkingArray.get(position).getName());
        startActivity(intent);
    }


    private void getData() {

        if (isNetworkAvailable(this) == true) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            ParkingAPI.Factory.getInstance().getParking().enqueue(new Callback<Parking>() {
                @Override
                public void onResponse(Call<Parking> call, Response<Parking> response) {
                    parkingArray = response.body().getResult().getRecords();
                    updateView();
                    mSwipeRefreshLayout.setRefreshing(false);

                }

                @Override
                public void onFailure(Call<Parking> call, Throwable t) {
                    Log.e("Failed", t.getMessage());
                }
            });
        } else {
            mSwipeRefreshLayout.setRefreshing(false);
            displayDialog();
        }
    }


    private void updateView() {
        recyclerView.setAdapter(new ParkingAdapter(parkingArray, R.layout.list_item_parking, ctx));

        //recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    public void displayDialog() {
        mSwipeRefreshLayout.setRefreshing(false);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("No Internet Connection");
        alertDialogBuilder.setMessage("You are offline please check your internet connection");
        Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(MainActivity.this,"No Internet Connection",Toast.LENGTH_LONG).show();
            }
        });
        alertDialogBuilder.setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
