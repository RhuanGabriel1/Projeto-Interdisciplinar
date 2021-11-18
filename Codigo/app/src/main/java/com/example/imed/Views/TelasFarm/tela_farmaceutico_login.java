package com.example.imed.Views.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.imed.Presenters.Farmaceutico.FarmaceuticoLoginPresenter;
import com.example.imed.R;
import com.example.imed.Views.Main.MainActivity;

public class tela_farmaceutico_login extends AppCompatActivity {

    private ImageButton retornarButton;
    private Button entrarButton;
    private TextView crfTextView;
    private TextView senhaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_login);

        crfTextView = findViewById(R.id.farmaceutico_login_crf_textview);
        crfTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});

        senhaTextView = findViewById(R.id.farmaceutico_login_senha_textfield);
        senhaTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        retornar();
        entrar();
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

    public void entrar() {
        entrarButton = findViewById(R.id.farmaceutico_login_entrar_button);
        entrarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FarmaceuticoLoginPresenter farmaceuticoLoginPresenter = new FarmaceuticoLoginPresenter(crfTextView.getText().toString(),
                        senhaTextView.getText().toString(), getApplicationContext());

                if(farmaceuticoLoginPresenter.makeLogin()){
                    Intent intent = new Intent(tela_farmaceutico_login.this, tela_farmaceutico_inicio.class);
                    intent.putExtra("FarmCrf", crfTextView.getText().toString());//Envia o dado de qual farmacêutico está logado
                    startActivity(intent);
                }
            }

        });
    }
}