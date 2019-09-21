package com.jiadibo.digitalentsandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private MyButton myButton;
    private MyEditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myButton = findViewById(R.id.my_button);
        myEditText = findViewById(R.id.my_edittext);
        setMyButtonEnabled();

        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setMyButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, myEditText.getText(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setMyButtonEnabled(){
        Editable result = myEditText.getText();
        if (result != null && !result.toString().isEmpty()){
            myButton.setEnabled(true);
        } else {
            myButton.setEnabled(false);
        }
    }
}

