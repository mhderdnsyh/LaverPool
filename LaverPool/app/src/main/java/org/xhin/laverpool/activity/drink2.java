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
//public class food2 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.food2);
//    }
//    public void clickTambahpesanan(View view){
//        Intent intentTambahpesanan = new Intent(this, transaksi.class);
//        startActivity(intentTambahpesanan);
//    }
//}
package org.xhin.laverpool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import org.xhin.laverpool.R;

public class drink2 extends AppCompatActivity {
    private EditText etjumlah_barang;
    private Button btntambahpesanana;
    private RadioGroup rgtingkat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drink2);

        etjumlah_barang = (EditText) findViewById(R.id.et_jumlahBarang);
        btntambahpesanana = (Button) findViewById(R.id.btntambahpesanana);
        rgtingkat= (RadioGroup) findViewById(R.id.rgtingkat);

        btntambahpesanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                print_sukses();
            }
        });
    }
    private void print_sukses() {
        Intent i = new Intent(drink2.this, org.xhin.laverpool.activity.transaksidrink2.class);

        String jumlah_barang = etjumlah_barang.getText().toString();
        final String tingkat = ((RadioButton) findViewById(rgtingkat.getCheckedRadioButtonId())).getText().toString();

        //faktur
        int harga = 15000;
        int barang = Integer.parseInt(jumlah_barang);

        int jumlah_bayar = harga * barang;

        String sHarga = String.valueOf(harga);
        String sJumlah_bayar = String.valueOf(jumlah_bayar);

        //mengirim data pelanggan
        i.putExtra("jumlah barang", jumlah_barang);
        i.putExtra("jumlah bayar", sJumlah_bayar);
        i.putExtra("tingkat", tingkat);
        startActivity(i);
    }

}