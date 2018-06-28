package com.example.mypc.hostelcare;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    EditText em,ps;
    Button login;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        em=(EditText)findViewById(R.id.email);
        ps=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.switch_to_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View view) {
             /*   final String email=em.getText().toString();
                final String pass=ps.getText().toString().trim();
                if(!isValidName(email)){
                    em.setError("Email is not valid");
                }

                else if(!isValidPassword(pass)){
                    ps.setError("Password is not valid");
                }
                else{
                    class AddUser extends AsyncTask<Void,Void,String> {
                        ProgressDialog loading;
                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            loading = ProgressDialog.show(LoginActivity.this,"Processing..."," Please Wait...",false,false);
                        }
                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);
                            loading.dismiss();
                            String json = s;
                            try {
                                JSONObject obj = new JSONObject(json);
                                JSONArray result = obj.getJSONArray(Config.TAG_JSON_ARRAY);
                                JSONObject c = result.getJSONObject(0);
                                final String name = c.getString(Config.TAG_NAME);
                                final String mobile = c.getString(Config.TAG_MOBILE);
                                final String email=c.getString(Config.TAG_EMAIL);
                                final String pass = c.getString(Config.TAG_PASSWORD);
                                if (name != "null") {
                                    Toast.makeText(LoginActivity.this, "You Are Registered Successfully", Toast.LENGTH_LONG).show();

                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Intent i = new Intent(LoginActivity.this, Home.class);
                                            startActivity(i);
                                            SharedPreferences prefs = getSharedPreferences("Userdata", MODE_PRIVATE);
                                            SharedPreferences.Editor editor = prefs.edit();
                                            editor.putString("name", name);
                                            editor.putString("mobile", mobile);
                                            editor.putString("email", email);
                                            editor.putString("password", pass);
                                            editor.commit();
                                            finish();
                                        }
                                    }, 2000);
                                } else {
                                    Toast.makeText(LoginActivity.this, "Username and password invalid", Toast.LENGTH_SHORT).show();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        protected String doInBackground(Void... v) {
                            HashMap<String,String> params = new HashMap<>();
                            params.put(Config.KEY_USER_EMAIL,email);
                            params.put(Config.KEY_USER_PASS,pass);

                            RequestHandler rh = new RequestHandler();
                            String res = rh.sendPostRequest(Config.URL_LOGIN, params);
                            return res;
                        }
                    }

                    AddUser addUser = new AddUser();
                    addUser.execute();
                }
*/
             Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                 startActivity(intent);

            }


        });

    }
    private boolean isValidName(String name) {
        if (name.length() != 0) {
            return true;
        }
        return false;
    }
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Intent a=new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
