package com.example.imed.Views.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.R;
import com.example.imed.Views.TelasFarm.tela_farmaceutico_login;
import com.example.imed.Views.TelasPaciente.tela_paciente_login;
import com.example.imed.Views.TelasMed.tela_medico_login;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    private ImageButton pacienteButton;
    private ImageButton medicoButton;
    private ImageButton farmaceuticoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));

        paciente();
        medico();
        farmaceutico();


    }


    public void farmaceutico(){
        farmaceuticoButton = findViewById(R.id.main_farmaceutico_button);
        farmaceuticoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tela_farmaceutico_login.class);
                startActivity(intent);
            }
        });
    }
    public void medico(){
        medicoButton = findViewById(R.id.main_medico_button);
        medicoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tela_medico_login.class);
                startActivity(intent);
            }
        });
    }
    public void paciente(){
        pacienteButton = findViewById(R.id.main_paciente_button);
        pacienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tela_paciente_login.class);
                startActivity(intent);
            }
        });
    }



}