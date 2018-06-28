package com.example.mypc.hostelcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Query extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        Button b=(Button)findViewById(R.id.button_submit_remark);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Query.this, "Your review is saved!!!!", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Query.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Query.this,MainActivity.class);
        startActivity(intent);
    }
}
