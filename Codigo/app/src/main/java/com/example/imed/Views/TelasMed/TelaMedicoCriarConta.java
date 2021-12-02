package com.example.imed.Views.TelasMed;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imed.MVP.MVPMedico;
import com.example.imed.Presenters.Medico.MedicoCriarContaPresenter;
import com.example.imed.R;

public class TelaMedicoCriarConta extends AppCompatActivity implements MVPMedico.IViewMedicoToast {

    private ImageButton retornarButton;
    private EditText nomeEditText;
    private EditText crmEditText;
    private EditText senhaEditText;
    private EditText repetirSenhaEditText;
    private MedicoCriarContaPresenter presenter;
    private Button criarConta;
    private MVPMedico.IViewMedicoToast view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_criar_conta);

        nomeEditText = findViewById(R.id.medico_criar_conta_nome_textfield);
        nomeEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        crmEditText = findViewById(R.id.medico_criar_conta_crm_textfield);
        crmEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});

        senhaEditText = findViewById(R.id.medico_criar_conta__senha_textfield);
        senhaEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        repetirSenhaEditText = findViewById(R.id.medico_criar_conta_repetir_senha_textfield);
        repetirSenhaEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});


        this.view  = this;
        presenter = new MedicoCriarContaPresenter();

        retornar();
        criarConta();

    }

    public void retornar(){
        retornarButton = findViewById(R.id.medico_criar_conta_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaMedicoCriarConta.this, TelaMedicoLogin.class);
                startActivity(intent);
            }
        });
    }

    public void criarConta(){
        criarConta = findViewById(R.id.criar_conta_medico_criar_conta_button);
        criarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedicoCriarContaPresenter medicoCriarContaPresenter = new MedicoCriarContaPresenter(nomeEditText.getText().toString(),
                                                                                                        senhaEditText.getText().toString(),
                                                                                                        repetirSenhaEditText.getText().toString(),
                                                                                                        crmEditText.getText().toString(),
                                                                                                        getApplicationContext(),
                                                                                                        view);
                if(medicoCriarContaPresenter.criarConta()){
                    Intent intent = new Intent(TelaMedicoCriarConta.this, TelaMedicoLogin.class);
                    startActivity(intent);
                }
            }

        });
    }

    @Override
    public void showToast(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destruirView();
    }
}
