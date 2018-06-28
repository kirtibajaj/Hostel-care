package com.example.mypc.hostelcare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText un,em,ps,cn;
    Button register,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        un = (EditText) findViewById(R.id.ed_username);
        em = (EditText) findViewById(R.id.ed_email);
        ps = (EditText) findViewById(R.id.ed_password);
        cn = (EditText) findViewById(R.id.ed_contact);
        register = (Button) findViewById(R.id.register);
        login = (Button) findViewById(R.id.switch_to_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Uname=un.getText().toString();
                if (!isValidName(Uname)) {
                    un.setError("Name is Required");
                }
                final String pass=ps.getText().toString().trim();
                if (!isValidName(pass)) {
                    ps.setError("Invalid Password");
                }
                final String email=em.getText().toString();
                if (!isValidName(email)) {
                    em.setError("Invalid Email");
                }
                final String phone=cn.getText().toString();
                if (!isValidName(phone)) {
                    cn.setError("Invalid Mobile");
                }
                else{
                    class AddUser extends AsyncTask<Void,Void,String> {

                        ProgressDialog loading;

                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            loading = ProgressDialog.show(RegisterActivity.this,"Processing..."," Please Wait...",false,false);
                        }

                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);
                            loading.dismiss();
                            Toast.makeText(RegisterActivity.this,"You Are Registered Successfully",Toast.LENGTH_LONG).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                            }, 2000);
                        }

                        @Override
                        protected String doInBackground(Void... v) {
                            HashMap<String,String> params = new HashMap<>();
                            params.put(Config.KEY_USER_NAME,Uname);
                            params.put(Config.KEY_USER_PASS,pass);
                            params.put(Config.KEY_USER_EMAIL,email);
                            params.put(Config.KEY_USER_MOBILE,phone);
                            RequestHandler rh = new RequestHandler();
                            String res = rh.sendPostRequest(Config.URL_ADD, params);
                            return res;
                        }
                    }

                    AddUser addUser = new AddUser();
                    addUser.execute();
                }
            }
        });
    }


    private boolean isValidName(String Uname) {
        if (Uname.length() != 0) {
            return true;
        }
        return false;
    }
    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    // validating mobile number
    private boolean isValidMobile(String phone) {
        if (phone != null && phone.length()== 10 ) {
            return true;
        }
        return false;
    }
    // validating Address
    private boolean isValidAddress(String address) {
        if (address.length() != 0) {
            return true;
        }
        return false;
    }
    // validating password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }
}
