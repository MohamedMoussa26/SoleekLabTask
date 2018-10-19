package com.example.em7mdmoussa.soleeklabtask.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.em7mdmoussa.soleeklabtask.R;


public class RVHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView txt;

    public RVHolder(@NonNull View v) {
        super(v);
        img = (ImageView) v.findViewById(R.id.cntryimg);
        txt = (TextView) v.findViewById(R.id.cntrytxt);
    }
}
