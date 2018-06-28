package com.example.mypc.hostelcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Update_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        Button b1,b2;
        b2=(Button)findViewById(R.id.button_update);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Update_profile.this, "DATA UPDATED", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Update_profile.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Update_profile.this,MainActivity.class);
        startActivity(intent);
    }
}
