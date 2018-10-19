package com.example.em7mdmoussa.soleeklabtask.View.Activity.mainactivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.em7mdmoussa.soleeklabtask.R;
import com.example.em7mdmoussa.soleeklabtask.View.Activity.countries.Countries;
import com.example.em7mdmoussa.soleeklabtask.View.Activity.signup.SignUp;
import com.example.em7mdmoussa.soleeklabtask.utils.checklogin;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnsign, btnlogin;
    EditText etlogin, etpassword;
    private String mail, password;
    TextView tvskip;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        action();
        presentdata();


    }

    private void init() {

        tvskip = (TextView) findViewById(R.id.tv_skip);
        btnsign = (Button) findViewById(R.id.btn_signup);
        btnlogin = (Button) findViewById(R.id.btn_Login);
        etlogin = (EditText) findViewById(R.id.et_login_email);
        etpassword = (EditText) findViewById(R.id.et_login_password);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Connecting");
    }

    private void action() {

        btnlogin.setOnClickListener(this);
        btnsign.setOnClickListener(this);
        tvskip.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_Login:
                mail = etlogin.getText().toString().trim();
                password = etpassword.getText().toString().trim();
                if (new checklogin().checklogin(mail, password) && checkfirebase(mail, password)) {
//                    Toast.makeText(this, "Mail is :" + mail + " and password is " + password, Toast.LENGTH_LONG).show();
//                    startActivity(new Intent(this, Countries.class));
                } else {

                    etlogin.setError("Enter user name");
                    etpassword.setError("Enter valid password");


                }
                break;


            case R.id.btn_signup:
                startActivity(new Intent(this, SignUp.class));
                break;

            case R.id.tv_skip:
                startActivity(new Intent(this, Countries.class));
                break;
        }
    }


    public boolean checkfirebase(String mail, String password) {

        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    startActivity(new Intent(getApplicationContext(), Countries.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Check your user name and password", Toast.LENGTH_LONG).show();
                    etlogin.setError("Enter user name");
                    etpassword.setError("Enter valid password");
                }
            }
        });
        return true;
    }

    private void presentdata() {


    }


}
