package org.xhin.laverpool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.stetho.Stetho;

import org.xhin.laverpool.R;
import org.xhin.laverpool.utils.SessionManager;

public class home extends AppCompatActivity {

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Stetho.initializeWithDefaults(this);

        sessionManager = new SessionManager(this);
        if (!sessionManager.isLoggedIn())
        {
            Intent intent = new Intent(home.this,masuk.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            finish();
        }


    }
    @Override //ini baru dibuat 13-06-2020
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        else if (item.getItemId()==R.id.action_logout)
        {
            Intent intent = new Intent(home.this,masuk.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            finish();
        }
        return  super.onOptionsItemSelected(item);
    }


    public void clickFood(View view){
        Intent intentFood = new Intent(this, food.class);
        startActivity(intentFood);
    }
    public void clickDrink(View view){
        Intent intentDrink = new Intent(this, drink.class);
        startActivity(intentDrink);
    }
    public void clickDessert(View view){
        Intent intentDessert = new Intent(this, dessert.class);
        startActivity(intentDessert);
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