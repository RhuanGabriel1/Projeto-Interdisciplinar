package com.example.imed.Views.TelasFarm;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imed.MVP.MVPFarmaceutico;
import com.example.imed.Presenters.Farmaceutico.FarmaceuticoCriarContaPresenter;
import com.example.imed.R;

public class TelaFarmaceuticoCriarConta extends AppCompatActivity implements MVPFarmaceutico.IViewFarmaceuticoToast {

    private ImageButton retornarButton;
    private Button criarContaButton;
    private EditText crfEditText;
    private EditText nomeEditText;
    private EditText senhaEditText;
    private EditText repetirSenhaEditText;
    private FarmaceuticoCriarContaPresenter presenter;
    private MVPFarmaceutico.IViewFarmaceuticoToast view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_criar_conta);

        nomeEditText = findViewById(R.id.farmaceutico_criar_conta_nome_textfield);
        nomeEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        crfEditText = findViewById(R.id.farmaceutico_criar_conta_crf_textfield);
        crfEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});

        senhaEditText = findViewById(R.id.farmaceutico_criar_conta_senha_textfield);
        senhaEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        repetirSenhaEditText = findViewById(R.id.farmaceutico_criar_conta_repetir_senha_textfield);
        repetirSenhaEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        this.view = this;
        presenter = new FarmaceuticoCriarContaPresenter();

        retornar();
        criarConta();
    }


    public void retornar(){
        retornarButton = findViewById(R.id.farmaceutico_criar_conta_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaFarmaceuticoCriarConta.this, TelaFarmaceuticoLogin.class);
                startActivity(intent);
            }
        });
    }

    public void criarConta(){
        criarContaButton = findViewById(R.id.criar_conta_farmaceutico_criar_conta_button);
        criarContaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FarmaceuticoCriarContaPresenter farmaceuticoCriarContaPresenter = new FarmaceuticoCriarContaPresenter(
                        nomeEditText.getText().toString(),
                        senhaEditText.getText().toString(),
                        repetirSenhaEditText.getText().toString(),
                        crfEditText.getText().toString(),
                        getApplicationContext(),
                        view);
                if(farmaceuticoCriarContaPresenter.criarConta()){
                    Intent intent = new Intent(TelaFarmaceuticoCriarConta.this, TelaFarmaceuticoLogin.class);
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
