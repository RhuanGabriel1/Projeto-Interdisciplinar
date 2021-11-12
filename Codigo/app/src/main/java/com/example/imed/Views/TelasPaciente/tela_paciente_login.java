package com.example.imed.Views.TelasPaciente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imed.MVP.MVPPaciente;
import com.example.imed.Presenters.Paciente.PacienteLoginPresenter;
import com.example.imed.R;
import com.example.imed.Views.Main.MainActivity;

public class tela_paciente_login extends AppCompatActivity implements MVPPaciente.IViewPacienteLogin{

    private ImageButton retornarPacienteLoginButton;
    private Button entrarPacienteButton, criarPacienteButton;
    private TextView cpfTextView, senhaPacienteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_login);

        //=========================================================================================================//
        entrarPacienteButton = findViewById(R.id.entrarPacienteButton);
        retornarPacienteLoginButton = findViewById(R.id.retornarPacienteLoginButton);
        criarPacienteButton = findViewById(R.id.criarPacienteButton);

        cpfTextView = findViewById(R.id.cpfTextView);
        cpfTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});

        senhaPacienteTextView = findViewById(R.id.senhaPacienteTextView);
        senhaPacienteTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        //=========================================================================================================//

        //Botão criado para entrar na tela início médico
        //Método criado para verificar se o login do médico é valido
        entrarPacienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PacienteLoginPresenter pacienteLoginPresenter = new PacienteLoginPresenter(cpfTextView.getText().toString(),
                        senhaPacienteTextView.getText().toString(), getApplicationContext());
                if(pacienteLoginPresenter.makeLogin()) {
                    showToast("Login efetuado com sucesso");
                    Intent intent = new Intent(tela_paciente_login.this, tela_paciente_inicio.class);
                    intent.putExtra("PacienteCpf", cpfTextView.getText().toString());//Envia o dado de qual paciente está logado
                    startActivity(intent);
                }
            }
        });
        //Fim do método para verificar o login

        //Botão criado para ir a tela de criação de conta paciente
        criarPacienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_login.this, tela_paciente_criar_conta.class);
                startActivity(intent);
            }
        });
        //=====================================================//

        //Botão criado para retornar para a tela anterior
        retornarPacienteLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_login.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //====================================================//

    }

    @Override
    public void showToast(String mensagem){
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
    }

}