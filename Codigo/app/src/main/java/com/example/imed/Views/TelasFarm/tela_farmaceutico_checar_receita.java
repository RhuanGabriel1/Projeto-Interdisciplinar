package com.example.imed.Views.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPFarmaceutico;
import com.example.imed.Presenters.Farmaceutico.FarmaceuticoChecarReceitaPresenter;
import com.example.imed.R;

public class tela_farmaceutico_checar_receita extends AppCompatActivity implements MVPFarmaceutico.IViewFarmaceuticoToast{

    private ImageButton retornarButton;
    private EditText receitaTextField;
    private Button verificarButton;
    private String valor;
    private MVPFarmaceutico.IViewFarmaceuticoToast view;
    private FarmaceuticoChecarReceitaPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_checar_receita);

        Intent intent = getIntent();
        valor = intent.getStringExtra("FarmCrf");


        presenter = new FarmaceuticoChecarReceitaPresenter();
        this.view = this;


        receitaTextField = findViewById(R.id.farmaceutico_checar_receita_receita_textview);
        receitaTextField.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});

        retornar();
        verificarReceita();

    }

    public void retornar(){
        retornarButton = findViewById(R.id.farmaceutico_checar_receita_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_checar_receita.this, tela_farmaceutico_inicio.class);
                intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
                startActivity(intent);
            }
        });
    }

    public void verificarReceita(){
        verificarButton = findViewById(R.id.farmaceutico_checar_receita_verificar_button);
        verificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FarmaceuticoChecarReceitaPresenter farmaceuticoChecarReceitaPresenter = new FarmaceuticoChecarReceitaPresenter(
                        receitaTextField.getText().toString(), valor, getApplicationContext(), view);

                if(farmaceuticoChecarReceitaPresenter.checarReceita()){
                    Intent intent = new Intent(tela_farmaceutico_checar_receita.this, tela_farmaceutico_apresentacao_receita.class);
                    intent.putExtra("receita", receitaTextField.getText().toString());//Envia o dado do id da receita
                    intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
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