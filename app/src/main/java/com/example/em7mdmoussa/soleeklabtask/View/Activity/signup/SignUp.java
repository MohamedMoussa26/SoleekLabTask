package com.example.em7mdmoussa.soleeklabtask.View.Activity.signup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.em7mdmoussa.soleeklabtask.R;
import com.example.em7mdmoussa.soleeklabtask.View.Activity.countries.Countries;
import com.example.em7mdmoussa.soleeklabtask.View.Activity.mainactivity.MainActivity;
import com.example.em7mdmoussa.soleeklabtask.utils.checklogin;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    EditText etmail, etpass, etpass2;
    TextView tvback;
    Button btnregister;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        init();
        action();
        presentdata();
    }


    private void init() {

        etmail = (EditText) findViewById(R.id.et_signup_email);
        etpass = (EditText) findViewById(R.id.et_signup_pass);
        etpass2 = (EditText) findViewById(R.id.et_signup_ConfirmPpass);
        tvback = (TextView) findViewById(R.id.et_signup_back);
        btnregister = (Button) findViewById(R.id.btn_signup_register);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);


    }

    private void action() {
        btnregister.setOnClickListener(this);
        tvback.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String mail, pass, pass2;

        switch (view.getId()) {
            case R.id.btn_signup_register:
                mail = etmail.getText().toString().trim();
                pass = etpass.getText().toString().trim();
                pass2 = etpass2.getText().toString().trim();

                checklogin checklogin = new checklogin();


                if (checklogin.checklogin(mail, pass)) {
                    if (pass.matches(pass2)) {

                        progressDialog.setMessage("Connecting");
                        Log.e("moussa", "1");
                        progressDialog.show();
                        Log.e("moussa", "2");
                        firebaseAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.e("moussa", "3");
                                progressDialog.cancel();
                                if (task.isSuccessful()) {
                                    Log.e("moussa", "4");
                                    Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(), Countries.class));
                                } else {
                                    etmail.setError("Enter user name");
                                    etpass.setError("Enter valid password");
                                    etpass2.setError("Enter valid password");
                                }
                            }
                        });

                    } else {
                        Toast.makeText(this, "passwords not matches", Toast.LENGTH_LONG).show();
                        etpass.setError("Enter valid password");
                        etpass2.setError("Enter valid password");
                    }
                } else {

                    etmail.setError("Enter user name");
                    etpass.setError("Enter valid password");
                    etpass2.setError("Enter valid password");


                }
                break;


            case R.id.et_signup_back:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }

    }

    private void presentdata() {
    }

}

