package com.example.age_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button agebtn,clearbtn;
    private EditText byeartxt, cyeartxt;
    private TextView r_age;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            this.getSupportActionBar().hide();
        }catch(NullPointerException e){

        }


        agebtn = findViewById(R.id.btnage);
        clearbtn = findViewById(R.id.btnclear);
        byeartxt = findViewById(R.id.txtByear);
        cyeartxt = findViewById(R.id.txtCyear);
        r_age = findViewById(R.id.txtAge);

        agebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cure_y = Integer.parseInt(cyeartxt.getText().toString());
                int birth =  Integer.parseInt(byeartxt.getText().toString());


                if(cure_y < birth){
                    Toast.makeText(MainActivity.this, "Current year should be higher than birth year!", Toast.LENGTH_SHORT).show();
                    cyeartxt.setError("Current year must be greater than birth year!");
                }else {
                    int difference = cure_y-birth;
                    String tot = String.valueOf(difference);
                    r_age.setText("Your are "+tot+" years!");

                }

            }
        });

        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_age.setText("");
                byeartxt.setText("");
                byeartxt.findFocus();
                cyeartxt.setText("");
            }
        });

    }
}