package com.example.imed.Views.TelasMed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;

public class tela_medico_inicio extends AppCompatActivity {

    private ImageButton retornarButton;
    private ImageButton gerarReceitaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_inicio);

        //Recebendo dado de qual médico está logado
        Intent intent = getIntent();
        String valor = intent.getStringExtra("MedicoCrm");
        //===========================================//

        //=================================================//

        retornarButton = findViewById(R.id.medico_inicio_retornar_button);
        gerarReceitaButton = findViewById(R.id.medico_inicio_gerar_receita_button);

        //=================================================//


        //Botão criado para retornar para a tela anterior
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_inicio.this, tela_medico_login.class);
                startActivity(intent);
            }
        });

        //================================================//

        //Botão criado para ir a tela de gerar receita
        gerarReceitaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_inicio.this, tela_medico_gerar_receita.class);
                intent.putExtra("MedicoCrm",valor);//Envia o dado de qual médico está logado
                startActivity(intent);
            }
        });
        //==============================================//
    }
}