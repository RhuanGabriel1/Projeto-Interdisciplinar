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

    private ImageButton retornarButton;
    private Button entrarButton;
    private Button criarContaButton;
    private TextView cpfTextView;
    private TextView senhaTextView;
    private MVPPaciente.IViewPacienteToast view;
    private PacienteLoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_login);

        cpfTextView = findViewById(R.id.paciente_login_cpf_textfield);
        cpfTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});

        senhaTextView = findViewById(R.id.paciente_login_senha_textfield);
        senhaTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        presenter = new PacienteLoginPresenter();

        this.view = this;

        retornar();
        fazerLogin();
        criarConta();
    }

    public void fazerLogin(){
        entrarButton = findViewById(R.id.paciente_login_entrar_button);
        entrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PacienteLoginPresenter pacienteLoginPresenter = new PacienteLoginPresenter(cpfTextView.getText().toString(),
                        senhaTextView.getText().toString(), getApplicationContext(),view);
                if(pacienteLoginPresenter.makeLogin()) {
                    Intent intent = new Intent(tela_paciente_login.this, tela_paciente_inicio.class);
                    intent.putExtra("PacienteCpf", cpfTextView.getText().toString());//Envia o dado de qual paciente está logado
                    startActivity(intent);
                }
            }
        });
    }

    public void retornar(){
        retornarButton = findViewById(R.id.paciente_login_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void criarConta(){
        criarContaButton = findViewById(R.id.paciente_login_criar_conta);
        criarContaButton.setOnClickListener(new View.OnClickListener() {
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