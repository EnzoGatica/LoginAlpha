package com.example.loginalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText textName = findViewById(R.id.textName);
        EditText textPass = findViewById(R.id.textPass);

        Button btnIngreso = findViewById(R.id.btnIngreso);

        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = textName.getText().toString();
                String pass = textPass.getText().toString();

                if(usuario.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getBaseContext(), "Faltan campos por completar", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!PasswordValidator.validatePassword(pass)) {
                    Toast.makeText(getBaseContext(), "No cumple con la seguridad necesaria", Toast.LENGTH_SHORT).show();
                }else {
                    Intent permitido = new Intent(MainActivity.this, Ingreso.class);
                    startActivity(permitido);
                }

            }
        });

    }

    public class PasswordValidator {
        private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[*\\-._@]).{8,}$";

        public static boolean validatePassword(String password) {
            Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
            return pattern.matcher(password).matches();
        }
    }
}