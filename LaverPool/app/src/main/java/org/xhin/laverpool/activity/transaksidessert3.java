//package org.xhin.laverpool.activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import org.xhin.laverpool.R;
//
//public class transaksi extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.transaksi);
//    }
//    public void clickHome(View view){
//        Intent intentHome = new Intent(this, home.class);
//        startActivity(intentHome);
//    }
//}

package org.xhin.laverpool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.xhin.laverpool.R;

//import org.xhin.laverpool.activity.home;

public class transaksidessert3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaksidessert3);
        //menerima data dari put extra
        String jumlah_barang_beli = getIntent().getStringExtra("jumlah barang");
        String jumlah_bayar_semua = getIntent().getStringExtra("jumlah bayar");
        String tingkat = getIntent().getStringExtra("tingkat");



        TextView jumlahpesanan = (TextView) findViewById(R.id.tvjumlahpesanan1);
        TextView tingkatkepedasan = (TextView) findViewById(R.id.tvtingkatkepedasan1);
        TextView totalbayar = (TextView) findViewById(R.id.txttotalbayar1);




        jumlahpesanan.setText(jumlah_barang_beli);
        tingkatkepedasan.setText(tingkat);
        totalbayar.setText(jumlah_bayar_semua);
    }
    public void clickHome(View view){
        Intent intentHome = new Intent(this, home.class);
        startActivity(intentHome);
    }
}