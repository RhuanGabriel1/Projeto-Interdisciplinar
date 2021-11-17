package com.example.imed.Views.TelasPaciente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;

public class tela_paciente_inicio extends AppCompatActivity {


    private ImageButton retornarButton;
    private ImageButton minhasReceitasButton;
    private String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_inicio);

        //Recebendo dado de qual paciente está logado
        Intent intent = getIntent();
        valor = intent.getStringExtra("PacienteCpf");

        retornar();
        receitas();
    }

    public void retornar(){
        retornarButton = findViewById(R.id.main_paciente_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_inicio.this, tela_paciente_login.class);
                startActivity(intent);
            }
        });
    }

    public void receitas(){
        minhasReceitasButton = findViewById(R.id.main_paciente_receitas_button);
        minhasReceitasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_inicio.this, tela_paciente_examinar_receita.class);
                intent.putExtra("PacienteCpf", valor);//Envia o dado de qual paciente está logado
                startActivity(intent);
            }
        });
    }
}