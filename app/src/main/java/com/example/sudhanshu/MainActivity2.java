package com.example.sudhanshu;
import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import android.widget.TextView;
import android.widget.Toast;

import com.example.sudhanshu.Model.AwareFragment;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
public class MainActivity2 extends AppCompatActivity {
    TextView t2,t3;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    CollapsingToolbarLayout collapsingToolbarLayout;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        viewIninit();
        toolbarSetup();
        bottomSetup();
        getData();
    }

    private void getData() {


    }

    @SuppressLint("NonConstantResourceId")
    private void bottomSetup() {
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
           switch (item.getItemId()){
               case R.id.Home:
                   Fragment homeFrag=new Homefragment();
                   FragmentManager fragmentManager=getSupportFragmentManager();
                   FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                   fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                   fragmentTransaction.replace(R.id.container,homeFrag).commit();

                   Toast.makeText(getApplicationContext(), "Clicked on Home", Toast.LENGTH_SHORT).show();
                   break;
               case R.id.India:
                   Fragment indiaFrag=new IndiaFragment();
                   FragmentManager fragmentManageri=getSupportFragmentManager();
                   FragmentTransaction fragmentTransactioni=fragmentManageri.beginTransaction();
                   fragmentTransactioni.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                   fragmentTransactioni.replace(R.id.container,indiaFrag).commit();
                   Toast.makeText(getApplicationContext(), "Clicked on India", Toast.LENGTH_SHORT).show();
                   break;
               case R.id.allcountry:
                   Fragment allcountryFrag=new AllCountryFragment();
                   FragmentManager fragmentManagerc=getSupportFragmentManager();
                   FragmentTransaction fragmentTransactionc=fragmentManagerc.beginTransaction();
                   fragmentTransactionc.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                   fragmentTransactionc.replace(R.id.container,allcountryFrag).commit();

                   Toast.makeText(getApplicationContext(), "Clicked on Allcountry", Toast.LENGTH_SHORT).show();
                   break;
               case R.id.Awareness:

                   Fragment awareFrag=new AwareFragment();
                   FragmentManager fragmentManagera=getSupportFragmentManager();
                   FragmentTransaction fragmentTransactiona=fragmentManagera.beginTransaction();
                   fragmentTransactiona.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                   fragmentTransactiona.replace(R.id.container,awareFrag).commit();
                   Toast.makeText(getApplicationContext(), "Clicked on Awareness", Toast.LENGTH_SHORT).show();



                   break;
           }
            return false;
        });
    }

    private void toolbarSetup() {
        setSupportActionBar(toolbar);
        //toolbar.setNavigationOnClickListener(v -> Toast.makeText(getApplicationContext(), "Clicked on Menu", Toast.LENGTH_SHORT).show());
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(Gravity.LEFT));
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        Fragment homeFrag=new Homefragment();
                        FragmentManager fragmentManager=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction.replace(R.id.container,homeFrag).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        //Toast.makeText(getApplicationContext(), "Clicked on Home", Toast.LENGTH_SHORT).show();
                        
                        break;
                    case R.id.share:

                        Intent myIntent = new Intent(Intent.ACTION_SEND);
                        myIntent.setType("text/plain");
                        String shareBody = "This is The best App \n For COrona tracking  \n This is The Free App Hurry up ! Download Now \n" +  "https://play.google.com/store/apps/details?id=com.example.sudhanshu&hl=en";
                        String shareSub = "Best App for Corona tracking";
                        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                        myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

                        startActivity(Intent.createChooser(myIntent, "Share using"));
                        drawerLayout.closeDrawer(GravityCompat.START);


                        break;
                    case R.id.call:
                        Fragment callFrag=new Callfragment();
                        FragmentManager fragmentManagerc=getSupportFragmentManager();
                        FragmentTransaction fragmentTransactionc=fragmentManagerc.beginTransaction();
                        fragmentTransactionc.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransactionc.replace(R.id.container,callFrag).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);

                        break;
                    case R.id.about:

                        break;
                    case R.id.injection:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://selfregistration.cowin.gov.in/")));

                        break;
                }

                return false;
            }
        });

        ;
    }

    private void viewIninit() {
        //t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        toolbar=findViewById(R.id.toolbar);
        bottomNavigationView=findViewById(R.id.bottom_Menu);
        collapsingToolbarLayout=findViewById(R.id.colLayout);
        drawerLayout=findViewById(R.id.drawwerLayout);
        navigationView=findViewById(R.id.navBar);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Fragment homeFrag=new Homefragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.replace(R.id.container,homeFrag).commit();
    }


}