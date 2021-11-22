package com.example.imed.Views.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;

public class TelaFarmaceuticoInicio extends AppCompatActivity {


    private ImageButton retornarButton;
    private ImageButton verificarReceitaButton;
    private String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_inicio);

        Intent intent = getIntent();
        valor = intent.getStringExtra("FarmCrf");

        voltar();
        verificarReceita();
    }

    public void voltar() {
        retornarButton = findViewById(R.id.farmaceutico_inicio_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaFarmaceuticoInicio.this, TelaFarmaceuticoLogin.class);
                startActivity(intent);
            }
        });
    }

    // TODO: acho que o esse trecho de código precisa ser alinhado futuramente com o banco
    public void verificarReceita() {
        verificarReceitaButton = findViewById(R.id.farmaceutico_inicio_verificar_receita_button);
        verificarReceitaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaFarmaceuticoInicio.this, TelaFarmaceuticoChecarReceita.class);
                intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
                startActivity(intent);
            }
        });
    }
}