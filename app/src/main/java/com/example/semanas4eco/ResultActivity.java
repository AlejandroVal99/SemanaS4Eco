package com.example.semanas4eco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class ResultActivity extends AppCompatActivity {

    private Button bt_again;
    private TextView text_messageF, text_FinalN;
    private ConstraintLayout back_Result;
    private String userName;
    private double notaF;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        bt_again = findViewById(R.id.bt_again);
        text_messageF = findViewById(R.id.text_messageF);
        text_FinalN = findViewById(R.id.text_FinalN);
        back_Result = findViewById(R.id.back_Result);

        userName =  getIntent().getExtras().getString("username");
        notaF = getIntent().getExtras().getDouble("notaFinal");
        //Log.e("Nombre usurio", userName );

        text_messageF.setText("Hola "+userName+", tu nota final es de:");
        text_FinalN.setText(""+notaF);

        bt_again.setOnClickListener(
                view -> {
                    Intent i  = new Intent(this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
        );
    }

    protected void onResume() {

        SharedPreferences preferences= getSharedPreferences("backColor",MODE_PRIVATE);
        String valor = preferences.getString("Color","No_Color");
        switch (valor) {

            case "Azul":
                back_Result.setBackgroundColor(BLUE);

                break;
            case "Verde":
                back_Result.setBackgroundColor(GREEN);
                break;
            case "Amarillo":
                back_Result.setBackgroundColor(WHITE);
                break;


        }
        super.onResume();
    }
}