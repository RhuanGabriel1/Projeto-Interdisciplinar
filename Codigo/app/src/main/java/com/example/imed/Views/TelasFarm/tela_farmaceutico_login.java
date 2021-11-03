package com.example.imed.Views.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.imed.Controllers.Farmaceutico.FarmaceuticoLoginController;
import com.example.imed.R;
import com.example.imed.Views.Main.MainActivity;

public class tela_farmaceutico_login extends AppCompatActivity {

    private ImageButton imageButton_back_tela_login_farmaceutico;
    private Button tela_login_farmaceutico_entrar;
    private TextView textView_tela_login_farmaceutico_crf,textView_tela_login_farmaceutico_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_login);

        //=============================================================================================//
        textView_tela_login_farmaceutico_crf = findViewById(R.id.textView_tela_login_farmaceutico_crf);
        textView_tela_login_farmaceutico_crf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});

        textView_tela_login_farmaceutico_senha = findViewById(R.id.textView_tela_login_farmaceutico_senha);
        textView_tela_login_farmaceutico_senha.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});


        imageButton_back_tela_login_farmaceutico = findViewById(R.id.imageButton_back_tela_login_farmaceutico);
        tela_login_farmaceutico_entrar = findViewById(R.id.tela_login_farmaceutico_entrar);

        //=============================================================================================//

        //Botão criado para retornar para a tela anterior
        imageButton_back_tela_login_farmaceutico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_login.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //===============================================//

        //Botão criado para entrar na tela início do farmacêutico
        tela_login_farmaceutico_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FarmaceuticoLoginController farmaceuticoLoginController = new FarmaceuticoLoginController(textView_tela_login_farmaceutico_crf.getText().toString(),
                        textView_tela_login_farmaceutico_senha.getText().toString(), getApplicationContext());

                if(farmaceuticoLoginController.makeLogin()){
                    Intent intent = new Intent(tela_farmaceutico_login.this, tela_farmaceutico_inicio.class);
                    intent.putExtra("FarmCrf", textView_tela_login_farmaceutico_crf.getText().toString());//Envia o dado de qual farmacêutico está logado
                    startActivity(intent);
                }
            }
        });
        //===========================================================//


    }
}