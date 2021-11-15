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

public class tela_paciente_login extends AppCompatActivity implements MVPPaciente.IViewPacienteToast {

    private ImageButton retornarPacienteLoginButton;
    private Button entrarPacienteButton, criarPacienteButton;
    private TextView cpfTextView, senhaPacienteTextView;
    private MVPPaciente.IViewPacienteToast view;
    private PacienteLoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_login);

        cpfTextView = findViewById(R.id.cpfTextView);
        cpfTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});

        senhaPacienteTextView = findViewById(R.id.senhaPacienteTextView);
        senhaPacienteTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        presenter = new PacienteLoginPresenter();

        this.view = this;

        retornar();
        fazerLogin();
        criarConta();
    }

    public void fazerLogin(){
        entrarPacienteButton = findViewById(R.id.entrarPacienteButton);
        entrarPacienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PacienteLoginPresenter pacienteLoginPresenter = new PacienteLoginPresenter(cpfTextView.getText().toString(),
                        senhaPacienteTextView.getText().toString(), getApplicationContext(),view);
                if(pacienteLoginPresenter.makeLogin()) {
                    Intent intent = new Intent(tela_paciente_login.this, tela_paciente_inicio.class);
                    intent.putExtra("PacienteCpf", cpfTextView.getText().toString());//Envia o dado de qual paciente está logado
                    startActivity(intent);
                }
            }
        });
    }

    public void retornar(){
        retornarPacienteLoginButton = findViewById(R.id.retornarPacienteLoginButton);
        retornarPacienteLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void criarConta(){
        criarPacienteButton = findViewById(R.id.criarPacienteButton);
        criarPacienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_login.this, tela_paciente_criar_conta.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showToast(String mensagem) {
        Toast.makeText(this  , mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.IPresenterDestruirView();
    }
}