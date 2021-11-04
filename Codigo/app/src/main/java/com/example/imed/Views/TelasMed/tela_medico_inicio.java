package com.example.imed.Views.TelasMed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;

public class tela_medico_inicio extends AppCompatActivity {

    private ImageButton imageButtonTelaGoBackLoginScreenMedico;
    private ImageButton imageButtonTelaMedicoEstoque;
    private ImageButton imageButtonGoToGerarReceitaMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_inicio);

        //Recebendo dado de qual médico está logado
        Intent intent = getIntent();
        String valor = intent.getStringExtra("MedicoCrm");
        //===========================================//

        //=================================================//

        imageButtonTelaGoBackLoginScreenMedico = findViewById(R.id.imageButton_tela_login_screen_medico_back);
        imageButtonTelaMedicoEstoque = findViewById(R.id.imageButton_tela_medico_estoque1);
        imageButtonGoToGerarReceitaMed = findViewById(R.id.imageButton_go_to_gerar_receita_med);

        //=================================================//


        //Botão criado para retornar para a tela anterior
        imageButtonTelaGoBackLoginScreenMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_inicio.this, tela_medico_login.class);
                startActivity(intent);
            }
        });
        //===================================================//

        //Botão criado para ir a tela de estoque médico
        imageButtonTelaMedicoEstoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_inicio.this, tela_medico_estoque.class);
                intent.putExtra("MedicoCrm",valor);//Envia o dado de qual médico está logado
                startActivity(intent);
            }
        });
        //================================================//

        //Botão criado para ir a tela de gerar receita
        imageButtonGoToGerarReceitaMed.setOnClickListener(new View.OnClickListener() {
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