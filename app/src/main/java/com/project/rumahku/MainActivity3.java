package com.project.rumahku;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    Button btLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btLink=(Button)findViewById(R.id.btLink);
        btLink.setOnClickListener(this::onClick);

    }

    public void onClick(View v){

        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://linktr.ee/beningradiktya")));

    }

}