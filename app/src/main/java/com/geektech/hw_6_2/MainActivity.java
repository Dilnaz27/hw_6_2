package com.geektech.hw_6_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button button = findViewById(R.id.button);
        TextView makeEnter = findViewById(R.id.make_enter);
        TextView register = findViewById(R.id.register);
        TextView forgotPassword = findViewById(R.id.forgot_password);
        TextView tapHere = findViewById(R.id.tap_here);


        email.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (email.getText().toString().isEmpty()){
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.grey));
                }else{
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.orange));
                }
            }
        });

        password.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (password.getText().toString().isEmpty()){
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.grey));
                }else{
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.orange));
                }
            }
        });



        button.findViewById(R.id.button).setOnClickListener(view -> {
            if (email.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                email.setVisibility(View.GONE);
                password.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                forgotPassword.setVisibility(View.GONE);
                tapHere.setVisibility(View.GONE);
                makeEnter.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
                Toast.makeText(this, "Вы успешно вошли в аккаунт.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Неверно введен логин или пароль.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}