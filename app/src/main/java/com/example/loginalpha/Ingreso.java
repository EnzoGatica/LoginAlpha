package com.example.loginalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ingreso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        Button btnUno = findViewById(R.id.btnUno);
        Button btnVolver = findViewById(R.id.btnVolver);




        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent activity = new Intent(Ingreso.this, MainActivity.class);
                startActivity(activity);
            }
        });
    }
}