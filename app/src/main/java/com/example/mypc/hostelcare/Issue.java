package com.example.mypc.hostelcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Issue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);
        Button b=(Button)findViewById(R.id.submit_issue);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Issue.this, "Your Problem is Submitted!!!!!", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Issue.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Issue.this,MainActivity.class);
        startActivity(intent);
    }
}
