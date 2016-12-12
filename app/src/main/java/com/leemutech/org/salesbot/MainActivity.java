package com.leemutech.org.salesbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText_username;
    private EditText editText_password;
    private Button button_go;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////////////////////////////////Load Ui Widgets////////////////////////////
        editText_username = (EditText) findViewById(R.id.et_name);
        editText_password = (EditText) findViewById(R.id.et_pw);
        button_go = (Button) findViewById(R.id.btn_go);

        /////////////////calling of ui widgets//////////////////////////
        button_go.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_go:
                Toast.makeText(this, "Button Pressed", Toast.LENGTH_SHORT).show();
                if (editText_username.getText().toString().equals("Admin") && editText_password.getText().toString().equals("Admin")) {

                    Intent intent = new Intent(this, MainMenu.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Enter All Fields", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;

        }
    }
}
