package com.example.em7mdmoussa.soleeklabtask.View.Activity.countries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.em7mdmoussa.soleeklabtask.Data.entities.countryitem;
import com.example.em7mdmoussa.soleeklabtask.Data.remote.Countryjson;
import com.example.em7mdmoussa.soleeklabtask.R;

import java.util.ArrayList;


public class Countries extends AppCompatActivity {

    ArrayList<countryitem> countries;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        recyclerView = (RecyclerView) findViewById(R.id.countryRV);
        countries = new Countryjson().getjsondata(getApplicationContext(), recyclerView);

        init();
        action();
        presentdata();
    }

    private void presentdata() {
    }

    private void init() {
    }

    private void action() {
    }


}

