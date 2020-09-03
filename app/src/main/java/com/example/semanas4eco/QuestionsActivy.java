package com.example.semanas4eco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class QuestionsActivy extends AppCompatActivity {

    private EditText text_P1,text_P2,text_Pr1,text_Pr2,text_Excer, text_Quiz;
    private Button bt_continueN;
    private ConstraintLayout back_Questions;
    private String userName;

    @SuppressLint("WrongConstant")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_activy);

        bt_continueN = findViewById(R.id.bt_continueN);
        back_Questions = findViewById(R.id.back_Questions);
        text_P1 = findViewById(R.id.text_P1) ;
        text_P2  = findViewById(R.id.text_P2) ;
        text_Pr1  = findViewById(R.id.text_Pr1) ;
        text_Pr2  = findViewById(R.id.text_Pr2) ;
        text_Excer  = findViewById(R.id.text_Excer) ;
        text_Quiz  = findViewById(R.id.text_Quiz) ;

        userName = getIntent().getExtras().getString("userName");




        bt_continueN.setOnClickListener(

                view -> {
                    Log.e("El campo esta", ":"+validacionCampo());
                    if(validacionCampo()){

                        Toast toast = Toast.makeText(this,"Llena todos los campos", Toast.LENGTH_LONG);
                        toast.show();

                    }else{

                        Intent e = new Intent(this, ResultActivity.class);
                        double notaFi = sacarNota();
                        e.putExtra("notaFinal",notaFi);
                        e.putExtra("username",userName);
                        startActivity(e);
                    }

                }
        );
    }


    public boolean validacionCampo(){

        String nP1 = text_P1.getText().toString();
        String nP2 = text_P2.getText().toString();
        String nEjercios = text_Excer.getText().toString();
        String nPro1 = text_Pr2.getText().toString();
        String nPro2 = text_Pr1.getText().toString();
        String nQuices = text_Quiz.getText().toString();

       if (nP1.matches("") || nP2.matches("")|| nEjercios.matches("")|| nPro1.matches("") || nPro2.matches("")|| nQuices.matches("")){
           return true;
       }else return false;

    }




    public double sacarNota(){


        double nP1 = Double.parseDouble(text_P1.getText().toString());
        double nP2 = Double.parseDouble(text_P2.getText().toString());
        double nEjercios = Double.parseDouble(text_Excer.getText().toString());
        double nPro1 = Double.parseDouble(text_Pr2.getText().toString());
        double nPro2 = Double.parseDouble(text_Pr1.getText().toString());
        double nQuices = Double.parseDouble(text_Quiz.getText().toString());

        //Porcentajes

        double porParcial = 0.15;
        double porQuices = 0.15;
        double porProyectos = 0.25;
        double porEjericios = 0.05;

        double notaFinal = (nPro1 * porProyectos)+(nPro2 * porProyectos)+(nP1 * porParcial)+
                (nP2 * porParcial)+(nQuices * porQuices)+(nEjercios * porEjericios);


    return notaFinal;
    }
    protected void onResume() {

        SharedPreferences preferences= getSharedPreferences("backColor",MODE_PRIVATE);
        String colores = preferences.getString("Color","No_Color");
        switch (colores) {

            case "Azul":
                back_Questions.setBackgroundColor(BLUE);

                break;
            case "Verde":
                back_Questions.setBackgroundColor(GREEN);
                break;
            case "Amarillo":
                back_Questions.setBackgroundColor(WHITE);
                break;


        }
        super.onResume();
    }

}