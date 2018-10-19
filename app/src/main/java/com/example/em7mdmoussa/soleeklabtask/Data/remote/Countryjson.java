package com.example.em7mdmoussa.soleeklabtask.Data.remote;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.em7mdmoussa.soleeklabtask.Adapter.RVAdapter;
import com.example.em7mdmoussa.soleeklabtask.Data.entities.countryitem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Countryjson {

    ArrayList<countryitem> countries;
    RecyclerView recyclerView;

    public Countryjson() {

    }


    public ArrayList<countryitem> getjsondata(final Context context, final RecyclerView recyclerView) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://api.printful.com/countries", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    countries = new ArrayList<>();
                    JSONObject jsoncountries = new JSONObject(response);
                    JSONArray jsonArray = jsoncountries.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        countries.add(new countryitem((jsonArray.getJSONObject(i)).getString("name"), (jsonArray.getJSONObject(i)).getString("code")));
                    }

                    recyclerView.setLayoutManager(new GridLayoutManager(context, 3, 1, false));
                    RVAdapter rvAdapter = new RVAdapter(context, countries);
                    recyclerView.setAdapter(rvAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, "please check your connection", Toast.LENGTH_LONG).show();


            }
        });
        requestQueue.add(stringRequest);

        return countries;

    }


}
