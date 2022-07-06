package org.xhin.laverpool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.xhin.laverpool.R;

public class pesanmakan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pesanmakan);
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
        Intent intentgambar = new Intent(this, pembayaran.class);
        startActivity(intentgambar);
    }
}