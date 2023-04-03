package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView wt,heightFt,heightIn;

        wt=findViewById(R.id.wt);
        heightFt=findViewById(R.id.heightFt);
        heightIn=findViewById(R.id.heightIn);

        Intent fromprev=getIntent();
        int prevwt=fromprev.getIntExtra("weight", -1);
        int prevheightFt=fromprev.getIntExtra("HFt", -1);
        int prevheightIn=fromprev.getIntExtra("HIn", -1);

        wt.setText("Weight "+prevwt);
        heightFt.setText("HeightFt "+prevheightFt);
        heightIn.setText("HeightIn "+prevheightIn);
    }
}