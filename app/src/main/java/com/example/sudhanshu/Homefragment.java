package com.example.sudhanshu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;


public class Homefragment extends Fragment {

    public Homefragment() {

    }

    TextView totalcase,death,recovered;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view=inflater.inflate(R.layout.fragment_homefragment, container, false);
        viewInit();
        getData();
        return view;
    }

    private void getData() {
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        String url="https://corona.lmao.ninja/v2/all?yesterday";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    totalcase.setText(jsonObject.getString("cases"));
                    death.setText(jsonObject.getString("deaths"));
                    recovered.setText(jsonObject.getString("recovered"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), ""+error,Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }


    private void viewInit() {
    totalcase=view.findViewById(R.id.totalcaseN);
    death=view.findViewById(R.id.deathN);
    recovered=view.findViewById(R.id.recoveredN);
    }
}