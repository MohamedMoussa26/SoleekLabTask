package com.example.em7mdmoussa.soleeklabtask.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.em7mdmoussa.soleeklabtask.Data.entities.countryitem;
import com.example.em7mdmoussa.soleeklabtask.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RVAdapter extends RecyclerView.Adapter<RVHolder> {

    Context context;
    ArrayList<countryitem> countryitems;

    public RVAdapter(Context context, ArrayList<countryitem> countryitems) {
        this.context = context;
        this.countryitems = countryitems;
        Log.e("mousssa", "9");
    }


    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.e("mousssa", "10");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.countryitem, viewGroup, false);
        Log.e("mousssa", "10");
        return new RVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder rvHolder, int i) {
        rvHolder.txt.setText((countryitems.get(i)).getName());
        Log.e("mousssa", "11");
        rvHolder.img.setImageResource(R.drawable.flag);


        Picasso.get()
                .load("https://www.countryflags.io/" + (countryitems.get(i)).getId() + "/shiny/64.png")
                .resize(50, 50)
                .centerCrop()
                .into(rvHolder.img);
        Log.e("mousssa", "13");

    }

    @Override
    public int getItemCount() {
        Log.e("mousssa", "11");
        return countryitems.size();
    }
}
