package com.example.imed.Views.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imed.MVP.MVPFarmaceutico;
import com.example.imed.Presenters.Farmaceutico.FarmaceuticoLoginPresenter;
import com.example.imed.R;
import com.example.imed.Views.Main.MainActivity;

public class tela_farmaceutico_login extends AppCompatActivity implements MVPFarmaceutico.IViewFarmaceuticoToast {

    private ImageButton retornarButton;
    private Button entrarButton;
    private Button criarContaButton;
    private TextView crfTextView;
    private TextView senhaTextView;
    private MVPFarmaceutico.IViewFarmaceuticoToast view;
    private FarmaceuticoLoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_login);

        crfTextView = findViewById(R.id.farmaceutico_login_crf_textview);
        crfTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});

        senhaTextView = findViewById(R.id.farmaceutico_login_senha_textfield);
        senhaTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        this.view = this;
        presenter = new FarmaceuticoLoginPresenter();

        retornar();
        fazerLogin();
        criarConta();
    }

    public void retornar() {
        retornarButton = findViewById(R.id.farmaceutico_login_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_login.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }

    public void fazerLogin() {
        entrarButton = findViewById(R.id.farmaceutico_login_entrar_button);
        entrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FarmaceuticoLoginPresenter farmaceuticoLoginPresenter = new FarmaceuticoLoginPresenter(crfTextView.getText().toString(),
                        senhaTextView.getText().toString(), getApplicationContext(), view);

                if(farmaceuticoLoginPresenter.makeLogin()){
                    Intent intent = new Intent(tela_farmaceutico_login.this, tela_farmaceutico_inicio.class);
                    intent.putExtra("FarmCrf", crfTextView.getText().toString());//Envia o dado de qual farmacêutico está logado
                    startActivity(intent);
                }
            }
        });
    }

    public void criarConta(){
        criarContaButton = findViewById(R.id.farmaceutico_login_criar_conta);
        criarContaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_login.this, tela_farmaceutico_criar_conta.class);
                startActivity(intent);
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