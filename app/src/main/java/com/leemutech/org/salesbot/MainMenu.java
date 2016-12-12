package com.leemutech.org.salesbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    private Button button_f1;
    private Button button_f2;
    private Button button_f3;
    private Button button_f4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ////////////////Load Ui Widgets////////////////////
        button_f1= (Button) findViewById(R.id.btn_1);
        button_f2= (Button) findViewById(R.id.btn_2);
        button_f3= (Button) findViewById(R.id.btn_3);
        button_f4= (Button) findViewById(R.id.btn_4);
        //////////////////Call Ui Widgets////////////////
        button_f1.setOnClickListener(this);
        button_f2.setOnClickListener(this);
        button_f3.setOnClickListener(this);
        button_f4.setOnClickListener(this);
        //////////display home button///////
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_1:
                Toast.makeText(this,"Button 1 pressed",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_2:
                Toast.makeText(this,"Button 2 pressed",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_3:
                Toast.makeText(this,"Button 3 pressed",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_4:
                Toast.makeText(this,"Button 4 pressed",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void onBackPressed() {
        //   super.onBackPressed();
        Intent intent = new Intent(MainMenu.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}
