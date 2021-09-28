package com.example.sudhanshu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sudhanshu.Adapter.CountryAdapter;
import com.example.sudhanshu.Model.Countrymodel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class AllCountryFragment extends Fragment {
    RecyclerView recyclerView;
    View view;
    private EditText searchbar;
    private CountryAdapter countryAdapter;

    ArrayList<Countrymodel> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_all_country, container, false);
        viewinit();
        getCountryData();
        return(view);
    }

    private void getCountryData() {



        String url="https://corona.lmao.ninja/v2/countries?yesterday&sort";
            arrayList=new ArrayList<>();
            StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray jsonArray = new JSONArray (response);
                        //JSONArray jsonArray=jsonObject.getJSONArray("");
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject data=jsonArray.getJSONObject(i);
                            arrayList.add(new Countrymodel(data.getString("country"), data.getString("cases"), data.getString("deaths"), data.getString("recovered")));
                        }viewinit();

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
            Volley.newRequestQueue(getActivity()).add(stringRequest);
            searchbar.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    filter(s.toString());
                }
            });






    }

    private void filter(String text) {
        ArrayList<Countrymodel>filterlist=new ArrayList<>();
        for(Countrymodel items:arrayList){
            if(items.getCountryName().toLowerCase().contains(text.toLowerCase())){
                filterlist.add(items);
            }
        }
        countryAdapter.filterlist(filterlist);
    }

    private void viewinit() {
        recyclerView=view.findViewById(R.id.recyclerviewCountry);
        searchbar=view.findViewById(R.id.search_bar);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        countryAdapter=new CountryAdapter(arrayList);
        recyclerView.setAdapter(countryAdapter);
    }
}