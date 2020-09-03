package com.example.semanas4eco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class MainActivity extends AppCompatActivity {

    private Button bt_continue, bt_config;
    private EditText text_name;
    private ConstraintLayout back_Main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_continue = findViewById(R.id.bt_continue);
        text_name = findViewById(R.id.text_name);
        bt_config = findViewById(R.id.bt_config);
        back_Main = findViewById(R.id.back_main);


        bt_continue.setOnClickListener(
                (v) -> {
                    String userName = text_name.getText().toString();
                    Intent i = new Intent(this, QuestionsActivy.class);
                    i.putExtra("userName", userName);
                    text_name.setText("");
                    startActivity(i);

                }

        );

        bt_config.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this, ConfigActivity.class);
                    startActivity(i);

                }
        );

    }

    @Override
    protected void onResume() {

       SharedPreferences preferences= getSharedPreferences("backColor",MODE_PRIVATE);
       String colores = preferences.getString("Color","No_Color");
        switch (colores) {

            case "Azul":
                back_Main.setBackgroundColor(BLUE);

                break;
            case "Verde":
                back_Main.setBackgroundColor(GREEN);
                break;
            case "Amarillo":
                back_Main.setBackgroundColor(WHITE);
                break;


        }
        super.onResume();
    }
}