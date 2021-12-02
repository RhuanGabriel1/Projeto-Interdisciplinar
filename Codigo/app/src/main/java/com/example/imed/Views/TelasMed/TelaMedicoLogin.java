package com.example.imed.Views.TelasMed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imed.MVP.MVPMedico;
import com.example.imed.Presenters.Medico.MedicoLoginPresenter;
import com.example.imed.R;
import com.example.imed.Views.Main.MainActivity;

public class TelaMedicoLogin extends AppCompatActivity implements MVPMedico.IViewMedicoToast {

    private ImageButton retornarButton;
    private Button entrarButton;
    private Button criarContaButton;
    private TextView crmTextField;
    private TextView senhaTextField;
    private MVPMedico.IViewMedicoToast view;
    private MedicoLoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_login);

        crmTextField = findViewById(R.id.medico_login_crm_textview);
        crmTextField.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});

        senhaTextField = findViewById(R.id.medico_login_senha_textview);
        senhaTextField.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        presenter = new MedicoLoginPresenter();

        this.view = this;

        retornar();
        fazerLogin();
        criarConta();

    }

    public void retornar(){
        retornarButton = findViewById(R.id.medico_login_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaMedicoLogin.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void fazerLogin(){
        entrarButton = findViewById(R.id.medico_login_entrar_button);
        entrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedicoLoginPresenter medicoLoginPresenter = new MedicoLoginPresenter(crmTextField.getText().toString(),
                                                                                        senhaTextField.getText().toString(),
                                                                                        getApplicationContext(),
                                                                                        view);
                if(medicoLoginPresenter.fazerLogin()){
                    Intent intent = new Intent(TelaMedicoLogin.this, TelaMedicoInicio.class);
                    intent.putExtra("MedicoCrm", crmTextField.getText().toString());//Envia o dado de qual médico está logado
                    startActivity(intent);
                }
            }
        });
    }

    public void criarConta(){
        criarContaButton = findViewById(R.id.medico_login_criar_conta);
        criarContaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaMedicoLogin.this, TelaMedicoCriarConta.class);
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
        presenter.destruirView();
    }
}