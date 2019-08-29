package com.example.instantmeasure;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setSelectedItemId(R.id.account);
        getSupportFragmentManager().beginTransaction().replace(R.id.container1,accountfragment).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    Account accountfragment = new Account();
    Measure measurefragment = new Measure();
    Logout logoutfragment = new Logout();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.account:

                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.container1,accountfragment).commit();
                return true;

            case R.id.measure:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.container1,measurefragment).commit();
                return true;

            case R.id.logout:

                ActivityLogin.firebaseAuth.signOut();
                Intent lo  = new Intent(Home.this,ActivityLogin.class);
                startActivity(lo);
                return true;

        }
        return false;
    }
}
