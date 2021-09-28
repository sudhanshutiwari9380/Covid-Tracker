package com.example.sudhanshu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Callfragment extends Fragment {

    public Callfragment(){

    }
    Button button1,button3,button4,button5,button6,button7;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view=inflater.inflate(R.layout.call, container, false);
        viewInit();
        //getData();


        return view;
    }

    private void viewInit() {
        button1=view.findViewById(R.id.call1);
        button3=view.findViewById(R.id.call3);
        button4=view.findViewById(R.id.call4);
        button5=view.findViewById(R.id.call5);
        button6=view.findViewById(R.id.call6);
        button7=view.findViewById(R.id.call7);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //your handler code here
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "1075"));

                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //your handler code here
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "1098"));

                startActivity(intent);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //your handler code here
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "08046110007"));

                startActivity(intent);

            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //your handler code here
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "14567"));

                startActivity(intent);

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //your handler code here
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "14443"));

                startActivity(intent);

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //your handler code here
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "9013151515"));

                startActivity(intent);

            }
        });
    }


}
