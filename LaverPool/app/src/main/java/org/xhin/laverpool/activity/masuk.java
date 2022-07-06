package org.xhin.laverpool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.xhin.laverpool.R;
import org.xhin.laverpool.model.User;
import org.xhin.laverpool.response.ResponseLogin;
import org.xhin.laverpool.rest.ApiClient;
import org.xhin.laverpool.rest.ApiInterface;
import org.xhin.laverpool.utils.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class masuk extends AppCompatActivity {

    @BindView(R.id.btnmasuk)
    Button login;

    @BindView(R.id.etusername)
//    TextInputLayout username;
//    TextInputEditText etusername;
    com.google.android.material.textfield.TextInputEditText etusername;

    @BindView(R.id.etpassword)
//    TextInputLayout password;
//    TextInputEditText etpassword;
    com.google.android.material.textfield.TextInputEditText etpassword;

//    @BindView(R.id.tvregister)
//    TextInputLayout register_user;

    ApiInterface apiservice;
    SessionManager sessionManager;

    private static final String TAG ="masuk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.masuk);
        ButterKnife.bind(this);

        apiservice = ApiClient.getClient().create(ApiInterface.class);
        sessionManager = new SessionManager(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

//        register_user.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                register_user();
//            }
//        });
    }
    public void clickBack(View view){
        Intent intentBack = new Intent(this, pembayaran.class);
        startActivity(intentBack);
    }
//    public void loginUser(View view){
//        String user_login = username.getText().toString();  //tambahan bapak
//        Intent intentLanjut = new Intent(this, home.class);
//        intentLanjut.putExtra("USERNAME", user_login);  //tambahan bapak
//        startActivity(intentLanjut);
//
//    }
    private void loginUser() {
        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();

        apiservice.login(username, password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if(response.isSuccessful())
                {
                    User userLoggedIn = response.body().getUser();
                    sessionManager.createLoginSession(userLoggedIn);

                    Intent intent = new Intent(masuk.this, home.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    finish();
                }
                else if (!response.isSuccessful())
                {
                    Toast.makeText(masuk.this, "User tidak ditemukan",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.e(TAG,"onFailure:"+t.getLocalizedMessage());
                Toast.makeText(masuk.this, "Gagal terhubung ke server",Toast.LENGTH_SHORT).show();
            }
        });
    }
}