package com.example.semanas4eco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.WHITE;

public class ConfigActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_green, bt_blue, bt_white;
    private ConstraintLayout back_Con;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        bt_green = findViewById(R.id.bt_green);
        bt_green.setOnClickListener(this);
        bt_blue = findViewById(R.id.bt_blue);
        bt_blue.setOnClickListener(this);
        bt_white = findViewById(R.id.bt_white);
        bt_white.setOnClickListener(this);
        back_Con=findViewById(R.id.back_Con);
        
    }

    private void backHome(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View view) {

        SharedPreferences preferences = getSharedPreferences("backColor",MODE_PRIVATE);

        switch (view.getId()){

            case R.id.bt_blue:
                preferences.edit().putString("Color","Azul").apply();
                backHome();
                break;
            case R.id.bt_green:
                preferences.edit().putString("Color","Verde").apply();
                backHome();
                break;
            case R.id.bt_white:
                preferences.edit().putString("Color","Amarillo").apply();
                backHome();
                break;

        }
    }
    protected void onResume() {

        SharedPreferences preferences= getSharedPreferences("backColor",MODE_PRIVATE);
        String valor = preferences.getString("Color","No_Color");
        switch (valor) {

            case "Azul":
                back_Con.setBackgroundColor(BLUE);

                break;
            case "Verde":
                back_Con.setBackgroundColor(GREEN);
                break;
            case "Amarillo":
                back_Con.setBackgroundColor(WHITE);
                break;


        }
        super.onResume();
    }
}