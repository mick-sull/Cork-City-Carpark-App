package com.example.micha.corkcityparking;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.micha.corkcityparking.models.Record;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by micha on 20/09/2016.
 */

public class ParkingAdapter extends RecyclerView.Adapter<ParkingAdapter.ParkingViewHolder>{


    private List<Record> parking;
    private int rowLayout;
    private Context context;


    public static class ParkingViewHolder extends RecyclerView.ViewHolder{
        LinearLayout parkingLayout;
        TextView name;
        TextView spaces;
        TextView freeSpaces;
        TextView openingTimes;



        public ParkingViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            spaces = (TextView) v.findViewById(R.id.spaces);
            freeSpaces = (TextView) v.findViewById(R.id.free_spaces);
            openingTimes = (TextView) v.findViewById(R.id.opening_times);
            v.getId();

        }
    }

    public ParkingAdapter(List<Record> parking, int rowLayout, Context context) {
        this.parking = parking;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ParkingAdapter.ParkingViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ParkingViewHolder(view);
    }

    public void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.bounce_interpolator);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }
    @Override
    public void onBindViewHolder(ParkingViewHolder holder, final int position) {

        String date =  parking.get(position).getDate().toString().substring(0,10);
        String year = date.substring(0,4);
        String month = date.substring(5,7);
        String day = date.substring(8,10);
        String hours =  parking.get(position).getDate().toString().substring(11,16);
        date = day + "-" + month+ "-" + year + " " + hours ;


        holder.name.setText(parking.get(position).getName());
        //holder.spaces.setText("Last Updated: " + parking.get(position).getDate().toString());
        holder.spaces.setText("Last Updated: " + date);
        holder.freeSpaces.setText("Free Spaces: " + parking.get(position).getFreeSpaces().toString() + " out of " + parking.get(position).getSpaces().toString());
        holder.openingTimes.setText(parking.get(position).getOpeningTimes().toString());
        //animate(holder);

    }



    @Override
    public int getItemCount() {
        return parking.size();
    }
}
