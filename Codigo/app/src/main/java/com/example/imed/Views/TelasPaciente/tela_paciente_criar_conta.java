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
import com.example.imed.Presenters.Paciente.PacienteCriarContaPresenter;
import com.example.imed.R;

public class tela_paciente_criar_conta extends AppCompatActivity implements MVPPaciente.IViewPacienteToast {

    private ImageButton retornarButton;
    private Button criarContaButton;
    private TextView nomeTextView;
    private TextView cpfTextView;
    private TextView senhaTextView;
    private TextView repetirSenhaTextView;
    private MVPPaciente.IViewPacienteToast view;

    public PacienteCriarContaPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_criar_conta);

        nomeTextView = findViewById(R.id.criar_conta_paciente_nome_textfield);
        nomeTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        cpfTextView = findViewById(R.id.criar_conta_paciente_cpf_textfield);
        cpfTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        
        senhaTextView = findViewById(R.id.criar_conta_paciente_senha_textfield);
        senhaTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        repetirSenhaTextView = findViewById(R.id.criar_conta_paciente_repetir_senha_textfield);
        repetirSenhaTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        presenter = new PacienteCriarContaPresenter();

        this.view = this;

        criarConta();
        retornar();
    }

    public void criarConta(){
        criarContaButton = findViewById(R.id.criar_conta_paciente_criar_conta_button);
        criarContaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PacienteCriarContaPresenter pacienteCriarContaPresenter = new PacienteCriarContaPresenter(nomeTextView.getText().toString(), cpfTextView.getText().toString(),
                        senhaTextView.getText().toString(), repetirSenhaTextView.getText().toString(), getApplicationContext(), view);

                if(pacienteCriarContaPresenter.createAccount()){
                    Intent intent = new Intent(tela_paciente_criar_conta.this, tela_paciente_login.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void retornar(){
        retornarButton = findViewById(R.id.imageButton_tela_create_account_login_paciente_back);

        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_criar_conta.this, tela_paciente_login.class);
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