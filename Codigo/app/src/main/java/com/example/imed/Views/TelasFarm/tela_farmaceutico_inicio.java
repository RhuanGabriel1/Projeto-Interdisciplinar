package com.example.imed.Views.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;

public class tela_farmaceutico_inicio extends AppCompatActivity {


    ImageButton ImageButton_tela_login_screen_medico_back;
    ImageButton imageButtont_tela_farmaceutico_cadastrar_medicamento_entrar;
    ImageButton imageButton_tela_farmaceutico_verifica_receita_entrar;
    ImageButton imageButton_farmaceutico_go_to_estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_inicio);

        //Recebendo dado de qual farmacêutico está logado
        Intent intent = getIntent();
        String valor = intent.getStringExtra("FarmCrf");
        //==============================================//


        //============================================================//

        imageButton_farmaceutico_go_to_estoque = findViewById(R.id.imageButton_farmaceutico_go_to_estoque);
        ImageButton_tela_login_screen_medico_back = findViewById(R.id.ImageButton_tela_login_screen_medico_back);
        imageButtont_tela_farmaceutico_cadastrar_medicamento_entrar = findViewById(R.id.imageButtont_tela_farmaceutico_cadastrar_medicamento_entrar);
        imageButton_tela_farmaceutico_verifica_receita_entrar = findViewById(R.id.imageButton_tela_farmaceutico_verifica_receita_entrar);

        //============================================================//


        //Botão criado para retornar para a tela anterior
        ImageButton_tela_login_screen_medico_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_inicio.this, tela_farmaceutico_login.class);
                startActivity(intent);
            }
        });
        //===================================================//

        //Botão criado para ir para a tela de cadastrar medicamento
        imageButtont_tela_farmaceutico_cadastrar_medicamento_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_inicio.this, tela_farmaceutico_cadastrar_medicamento.class);
                intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
                startActivity(intent);
            }
        });
        //=======================================================//

        //Botão criado para ir para a tela de verificar a receita
        imageButton_tela_farmaceutico_verifica_receita_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_inicio.this, tela_farmaceutico_checar_receita.class);
                intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
                startActivity(intent);
            }
        });
        //===========================================================//

        //Botão criado para ir para a tela de estoque
        imageButton_farmaceutico_go_to_estoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_inicio.this, tela_farmaceutico_estoque.class);
                intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
                startActivity(intent);
            }
        });
        //==========================================//
    }
}