package com.project.rumahku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btDinding;
    Button btAtap;
    Button btLantai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btDinding = findViewById(R.id.btDinding);

        btDinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

        btAtap = findViewById(R.id.btAtap);

        btAtap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity3.class));
            }
        });

        btLantai = findViewById(R.id.btLantai);

        btLantai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity4.class));
            }
        });
    }
}