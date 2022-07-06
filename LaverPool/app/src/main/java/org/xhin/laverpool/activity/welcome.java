package org.xhin.laverpool.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.xhin.laverpool.R;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
    }
    public void clickMasuk(View view){
        Intent intentMasuk = new Intent(this, masuk.class);
        startActivity(intentMasuk);
    }
    public void clickBelumAdaAkun(View view){
        Intent intentBelumAdaAkun = new Intent(this, daftar.class);
        startActivity(intentBelumAdaAkun);
    }
    public void clickgambar(View view){
        Intent intentgambar = new Intent(this, pesanmakan.class);
        startActivity(intentgambar);
    }
}