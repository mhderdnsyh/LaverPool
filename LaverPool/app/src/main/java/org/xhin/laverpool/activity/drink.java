package org.xhin.laverpool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.xhin.laverpool.R;

public class drink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drink);
    }
    public void clickBack(View view){
        Intent intentBack = new Intent(this, home.class);
        startActivity(intentBack);
    }
    public void clickEsdawet(View view){
        Intent intentEsdawet = new Intent(this, drink2.class);
        startActivity(intentEsdawet);
    }
    public void clickTehbandrek(View view){
        Intent intentTehbandrek = new Intent(this, drink3.class);
        startActivity(intentTehbandrek);
    }
}