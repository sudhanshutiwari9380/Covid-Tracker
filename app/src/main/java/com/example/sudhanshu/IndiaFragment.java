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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sudhanshu.Adapter.StateAdapter;
import com.example.sudhanshu.Model.Statemodel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**

 * create an instance of this fragment.
 */
public class IndiaFragment extends Fragment {

    private ArrayList<Statemodel> arrayList;
    StateAdapter stateAdapter;
    RecyclerView recyclerView;
    private EditText searchbar_state;
    View view;
    private TextView totalcasein,deathin,recoveredin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_india, container, false);
        viewinit();
        getData();
        getStateData();
        adsetup();

        return view;
    }

    private void adsetup() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        stateAdapter=new StateAdapter(arrayList);
        recyclerView.setAdapter(stateAdapter);
    }

    private void getStateData() {
        String url="https://api.rootnet.in/covid19-in/stats/latest";
        arrayList=new ArrayList<>();
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONObject("data").getJSONArray("regional");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject data=jsonArray.getJSONObject(i);
                        arrayList.add(new Statemodel(data.getString("loc"), data.getString("totalConfirmed"), data.getString("deaths"),data.getString("discharged") ));
                    }adsetup();

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


    }

    private void getData() {
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        String url="https://api.rootnet.in/covid19-in/stats/latest";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response).getJSONObject("data").getJSONObject("summary");
                    totalcasein.setText(jsonObject.getString("total"));
                    deathin.setText(jsonObject.getString("deaths"));
                    recoveredin.setText(jsonObject.getString("discharged"));
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
        searchbar_state.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filterstate(s.toString());

            }
        });
    }

    private void filterstate(String text) {
        ArrayList<Statemodel> filterliststate=new ArrayList<>();
        for(Statemodel items:arrayList){
            if(items.getStateName().toLowerCase().contains(text.toLowerCase())){
                filterliststate.add(items);
            }
        }
        stateAdapter.filterliststate(filterliststate);
    }

    private void viewinit() {
        totalcasein=view.findViewById(R.id.totalcasein);
        deathin=view.findViewById(R.id.deathin);
        recoveredin=view.findViewById(R.id.recoveredin);
        recyclerView=view.findViewById(R.id.recyclerview);
        searchbar_state=view.findViewById(R.id.search_barState);
    }
}