package com.example.imed.Telas.TelasMed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;

public class tela_medico_inicio extends AppCompatActivity {

    ImageButton imageButton_tela_login_screen_medico_back;
    ImageButton imageButton_tela_medico_estoque;
    ImageButton imageButton_go_to_gerar_receita_med;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_inicio);

        //Recebendo dado de qual médico está logado
        Intent intent = getIntent();
        String valor = intent.getStringExtra("MedicoCrm");
        //===========================================//

        //=================================================//

        imageButton_tela_login_screen_medico_back = findViewById(R.id.imageButton_tela_login_screen_medico_back);
        imageButton_tela_medico_estoque = findViewById(R.id.imageButton_tela_medico_estoque1);
        imageButton_go_to_gerar_receita_med = findViewById(R.id.imageButton_go_to_gerar_receita_med);

        //=================================================//


        //Botão criado para retornar para a tela anterior
        imageButton_tela_login_screen_medico_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_inicio.this, tela_medico_login.class);
                startActivity(intent);
            }
        });
        //===================================================//

        //Botão criado para ir a tela de estoque médico
        imageButton_tela_medico_estoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_inicio.this, tela_medico_estoque.class);
                intent.putExtra("MedicoCrm",valor);//Envia o dado de qual médico está logado
                startActivity(intent);
            }
        });
        //================================================//

        //Botão criado para ir a tela de gerar receita
        imageButton_go_to_gerar_receita_med.setOnClickListener(new View.OnClickListener() {
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