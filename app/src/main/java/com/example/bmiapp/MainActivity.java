package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout outlook;
        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btn,nextscreen;
        TextView result;

        outlook=findViewById(R.id.outlook);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        edtWeight=findViewById(R.id.edtWeight);
        btn=findViewById(R.id.btn);
        result=findViewById(R.id.result);
        nextscreen=findViewById(R.id.nextscreen);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt=Integer.parseInt(edtWeight.getText().toString());
                int hFt=Integer.parseInt(edtHeightFt.getText().toString());
                int hIn=Integer.parseInt(edtHeightIn.getText().toString());

                int total=hIn+12*hFt;
                double totInCm=total*2.53;
                double totInm=totInCm/100;
                double bmi=wt/(totInm*totInm);

                // making of toast
                Toast.makeText(MainActivity.this, "Your Result is Ready!", Toast.LENGTH_LONG).show();

                if(bmi>25){
                    result.setText("You are Over Weight");
                    outlook.setBackgroundColor(getResources().getColor(R.color.over));
                }
                else if(bmi<18){
                    result.setText("You are Under Weight");
                    outlook.setBackgroundColor(getResources().getColor(R.color.under));
                }
                else{
                    result.setText("You are Healthy");
                    outlook.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }
        });

        nextscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outlook.setBackgroundColor(getResources().getColor(R.color.change));
                int wt=Integer.parseInt(edtWeight.getText().toString());
                int hFt=Integer.parseInt(edtHeightFt.getText().toString());
                int hIn=Integer.parseInt(edtHeightIn.getText().toString());

                Intent gonext=new Intent(MainActivity.this,Display.class);
                gonext.putExtra("weight", wt);
                gonext.putExtra("HFt", hFt);
                gonext.putExtra("HIn", hIn);
                startActivity(gonext);
            }
        });
    }
}