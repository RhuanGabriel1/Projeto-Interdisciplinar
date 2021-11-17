package com.example.imed.Views.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;

public class tela_farmaceutico_inicio extends AppCompatActivity {


    ImageButton retornarButton;
    ImageButton verificarReceitaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_inicio);

        //Recebendo dado de qual farmacêutico está logado
        Intent intent = getIntent();
        String valor = intent.getStringExtra("FarmCrf");
        //==============================================//


        //============================================================//

        retornarButton = findViewById(R.id.farmaceutico_inicio_retornar_button);
        verificarReceitaButton = findViewById(R.id.farmaceutico_inicio_verificar_receita_button);

        //============================================================//


        //Botão criado para retornar para a tela anterior
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_inicio.this, tela_farmaceutico_login.class);
                startActivity(intent);
            }
        });
        //===================================================//

        //Botão criado para ir para a tela de verificar a receita
        verificarReceitaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_inicio.this, tela_farmaceutico_checar_receita.class);
                intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
                startActivity(intent);
            }
        });
        //===========================================================//
    }
}