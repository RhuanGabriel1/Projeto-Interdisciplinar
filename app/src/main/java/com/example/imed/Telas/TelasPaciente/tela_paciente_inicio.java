package com.example.imed.Telas.TelasPaciente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;

public class tela_paciente_inicio extends AppCompatActivity {

    ImageButton imageButton_tela_login_paciente_loggedin_back;
    ImageButton imageButton_go_to_minhas_receitas_paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_inicio);

        //Recebendo dado de qual paciente está logado
        Intent intent = getIntent();
        String valor = intent.getStringExtra("PacienteCpf");
        //===========================================//

        //========================================================================//

        imageButton_go_to_minhas_receitas_paciente = findViewById(R.id.imageButton_go_to_minhas_receitas_paciente);
        imageButton_tela_login_paciente_loggedin_back = findViewById(R.id.imageButton_tela_login_paciente_loggedin_back);

        //========================================================================//

        //Botão criado para retornar para a tela anterior
        imageButton_tela_login_paciente_loggedin_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_inicio.this, tela_paciente_login.class);
                startActivity(intent);

            }
        });
        //===============================================//

        //Botão criado para ir a tela de receitas do paciente
        imageButton_go_to_minhas_receitas_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_inicio.this, tela_paciente_examinar_receita.class);
                intent.putExtra("PacienteCpf", valor);//Envia o dado de qual paciente está logado
                startActivity(intent);
            }
        });
        //====================================================//

    }
}