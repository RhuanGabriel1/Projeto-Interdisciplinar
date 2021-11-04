package com.example.imed.Views.TelasPaciente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;

public class tela_paciente_inicio extends AppCompatActivity {


    private ImageButton imageButtonGoBackTelaLoginPacienteLoggedin;
    private ImageButton imageButtonGoToMinhasReceitasPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_inicio);

        //Recebendo dado de qual paciente está logado
        Intent intent = getIntent();
        String valor = intent.getStringExtra("PacienteCpf");
        //===========================================//

        //========================================================================//

        imageButtonGoToMinhasReceitasPaciente = findViewById(R.id.imageButton_go_to_minhas_receitas_paciente);
        imageButtonGoBackTelaLoginPacienteLoggedin = findViewById(R.id.imageButton_tela_login_paciente_loggedin_back);

        //========================================================================//

        //Botão criado para retornar para a tela anterior
        imageButtonGoBackTelaLoginPacienteLoggedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_inicio.this, tela_paciente_login.class);
                startActivity(intent);

            }
        });
        //===============================================//

        //Botão criado para ir a tela de receitas do paciente
        imageButtonGoToMinhasReceitasPaciente.setOnClickListener(new View.OnClickListener() {
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