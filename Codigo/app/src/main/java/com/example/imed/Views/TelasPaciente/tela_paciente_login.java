package com.example.imed.Views.TelasPaciente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.imed.Presenters.Paciente.PacienteLoginPresenter;
import com.example.imed.R;
import com.example.imed.Views.Main.MainActivity;

public class tela_paciente_login extends AppCompatActivity {

    private ImageButton imageButtonGoBackTelaLoginPaciente;
    private Button buttonTelaPacienteEntrar, buttonTelaPacienteCriarConta;
    private TextView textViewTelaLoginPacienteCpf, textViewTelaLoginPacienteSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_login);

        //=========================================================================================================//
        buttonTelaPacienteEntrar = findViewById(R.id.button_tela_paciente_entrar);
        imageButtonGoBackTelaLoginPaciente = findViewById(R.id.imageButton_tela_login_paciente_back);
        buttonTelaPacienteCriarConta = findViewById(R.id.button_tela_paciente_criar_conta);

        textViewTelaLoginPacienteCpf = findViewById(R.id.textView_tela_login_paciente_cpf);
        textViewTelaLoginPacienteCpf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});

        textViewTelaLoginPacienteSenha = findViewById(R.id.textView_tela_login_paciente_senha);
        textViewTelaLoginPacienteSenha.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        //=========================================================================================================//


        //Botão criado para entrar na tela início médico
        //Método criado para verificar se o login do médico é valido
        buttonTelaPacienteEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PacienteLoginPresenter pacienteLoginPresenter = new PacienteLoginPresenter(textViewTelaLoginPacienteCpf.getText().toString(),
                        textViewTelaLoginPacienteSenha.getText().toString(),getApplicationContext());
                if(pacienteLoginPresenter.makeLogin()){
                    Intent intent = new Intent(tela_paciente_login.this, tela_paciente_inicio.class);
                    intent.putExtra("PacienteCpf", textViewTelaLoginPacienteCpf.getText().toString());//Envia o dado de qual paciente está logado
                    startActivity(intent);
                }
            }
        });
        //Fim do método para verificar o login

        //Botão criado para ir a tela de criação de conta paciente
        buttonTelaPacienteCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_login.this, tela_paciente_criar_conta.class);
                startActivity(intent);
            }
        });
        //=====================================================//

        //Botão criado para retornar para a tela anterior
        imageButtonGoBackTelaLoginPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_login.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //====================================================//

    }


}