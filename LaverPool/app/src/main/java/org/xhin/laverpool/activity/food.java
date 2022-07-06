package org.xhin.laverpool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.xhin.laverpool.R;

public class food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);
    }
    public void clickBack(View view){
        Intent intentBack = new Intent(this, home.class);
        startActivity(intentBack);
    }
    public void clickMieaceh(View view){
        Intent intentMieaceh = new Intent(this, food2.class);
        startActivity(intentMieaceh);
    }
    public void clickNasikuning(View view){
        Intent intentNasikuning = new Intent(this, food3.class);
        startActivity(intentNasikuning);
    }
}