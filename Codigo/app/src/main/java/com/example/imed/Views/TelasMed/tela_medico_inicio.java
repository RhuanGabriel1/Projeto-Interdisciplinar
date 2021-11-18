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
    private String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_inicio);

        Intent intent = getIntent();
        valor = intent.getStringExtra("MedicoCrm");

        retornar();
        gerarReceita();
    }

    public void retornar(){
        retornarButton = findViewById(R.id.medico_inicio_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_inicio.this, tela_medico_login.class);
                startActivity(intent);
            }
        });
    }

    public void gerarReceita(){
        gerarReceitaButton = findViewById(R.id.medico_inicio_gerar_receita_button);
        gerarReceitaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_inicio.this, tela_medico_gerar_receita.class);
                intent.putExtra("MedicoCrm",valor);//Envia o dado de qual médico está logado
                startActivity(intent);
            }
        });
    }
}