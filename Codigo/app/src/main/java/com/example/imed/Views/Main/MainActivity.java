package com.example.imed.Views.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.Database.MySQLConnection;
import com.example.imed.R;
import com.example.imed.Views.TelasAdm.tela_adm_login;
import com.example.imed.Views.TelasFarm.tela_farmaceutico_login;
import com.example.imed.Views.TelasPaciente.tela_paciente_login;
import com.example.imed.Views.TelasMed.tela_medico_login;

public class MainActivity extends AppCompatActivity {

    private ImageButton pacienteButton;
    private ImageButton medicoButton;
    private ImageButton farmaceuticoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        pacienteButton = findViewById(R.id.pacienteButton);
        pacienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tela_paciente_login.class);
                startActivity(intent);
            }
        });

        medicoButton = findViewById(R.id.medicoButton);
        medicoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tela_medico_login.class);
                startActivity(intent);
            }
        });

        farmaceuticoButton = findViewById(R.id.farmaceuticoButton);
        farmaceuticoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tela_farmaceutico_login.class);
                startActivity(intent);
            }
        });
    }
}