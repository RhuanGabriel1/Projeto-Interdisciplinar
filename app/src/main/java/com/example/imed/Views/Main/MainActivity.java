package com.example.imed.Views.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.R;
import com.example.imed.Views.TelasAdm.tela_adm_login;
import com.example.imed.Views.TelasFarm.tela_farmaceutico_login;
import com.example.imed.Views.TelasPaciente.tela_paciente_login;
import com.example.imed.Views.TelasMed.tela_medico_login;

public class MainActivity extends AppCompatActivity {

    ImageButton button_paciente;
    ImageButton imageButton_medico;
    ImageButton imageButton_farmaceutico;
    Button button_adm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        button_paciente = findViewById(R.id.button_paciente);
        button_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.abrir();
                Intent intent = new Intent(MainActivity.this, tela_paciente_login.class);
                startActivity(intent);
            }
        });


        imageButton_medico = findViewById(R.id.imageButton_medico);
        imageButton_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.abrir();
                Intent intent = new Intent(MainActivity.this, tela_medico_login.class);
                startActivity(intent);
            }
        });


        button_adm = findViewById(R.id.button_adm);
        button_adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.abrir();
                Intent intent = new Intent(MainActivity.this, tela_adm_login.class);
                startActivity(intent);
            }
        });


        imageButton_farmaceutico = findViewById(R.id.imageButton_farmaceutico);
        imageButton_farmaceutico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.abrir();
                Intent intent = new Intent(MainActivity.this, tela_farmaceutico_login.class);
                startActivity(intent);
            }
        });


    }
}