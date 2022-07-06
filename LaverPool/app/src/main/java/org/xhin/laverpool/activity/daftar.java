package org.xhin.laverpool.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.xhin.laverpool.R;
import org.xhin.laverpool.rest.ApiClient;
import org.xhin.laverpool.rest.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class daftar extends AppCompatActivity {

    @BindView(R.id.etusername)
    com.google.android.material.textfield.TextInputEditText etUsername;

    @BindView(R.id.email)
    com.google.android.material.textfield.TextInputEditText email;

    @BindView(R.id.etpassword)
    com.google.android.material.textfield.TextInputEditText etPassword;

    @BindView(R.id.btndaftar)
    Button btnDaftar;

    ApiInterface apiService;
    ProgressDialog pd;

    private static final String TAG = daftar.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar);
        ButterKnife.bind(this);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        btnDaftar.setOnClickListener((view) -> {register();});  // JGN LUPA LANJUTKAN //ini masi kurang tanda kurung biasa sebelum tanda kurung view
    }

    public void register() {
        Log.d(TAG,"Menjalankan method Daftar");
        pd = ProgressDialog.show(this,null,"Sedang mendaftarkan account",true,false);
        String strUsername = etUsername.getText().toString();
        String strEmail = email.getText().toString();
        String strPassword = etPassword.getText().toString();

        Log.d(TAG,"mendapatkan data dari edit text");
        apiService.register(strUsername,strEmail,strPassword).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG,"berhasil memanggil api");
                if (response.isSuccessful()) {
                    pd.dismiss();
                    Log.d(TAG,"success mendapatkan api");
                    Intent intentLanjut = new Intent(daftar.this, masuk.class);
                    intentLanjut.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intentLanjut);
                    finish();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                pd.dismiss();
                Log.e(TAG,t.getLocalizedMessage());
                Toast.makeText(getApplicationContext(),"Gagal",Toast.LENGTH_SHORT).show();

            }
        });

    }
//
//    @Override
//    public void onFailure(retrofit2.Call<>)

    public void clickBack(View view){
        Intent intentBack = new Intent(this, pembayaran.class);
        startActivity(intentBack);
    }

    //YANG DIBAWAH INI GAPERLU
    public void clickLanjut(View view){
        Intent intentLanjut = new Intent(this, masuk.class);
        startActivity(intentLanjut);
    }
}