package org.xhin.laverpool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.xhin.laverpool.R;

public class dessert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dessert);
    }
    public void clickBack(View view){
        Intent intentBack = new Intent(this, home.class);
        startActivity(intentBack);
    }
    public void clickKuelumpur(View view){
        Intent intentKuelumpur = new Intent(this, dessert2.class);
        startActivity(intentKuelumpur);
    }
    public void clickKueklepon(View view){
        Intent intentKueklepon = new Intent(this, dessert3.class);
        startActivity(intentKueklepon);
    }
}