package com.example.mypc.hostelcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Permission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        Button b=(Button)findViewById(R.id.request_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Permission.this, "Request Sent!!!!"+"\n"+"You will be replied soon", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Permission.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Permission.this,MainActivity.class);
        startActivity(intent);
    }
}
