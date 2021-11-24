package com.example.imed.Views.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.imed.Database.MySQLConnection;
import com.example.imed.Helper.TimeOut;
import com.example.imed.Model.ModelPaciente.PacienteLoginModel;
import com.example.imed.R;
import com.example.imed.Views.TelasFarm.TelaFarmaceuticoLogin;
import com.example.imed.Views.TelasPaciente.TelaPacienteLogin;
import com.example.imed.Views.TelasMed.TelaMedicoLogin;

public class MainActivity extends AppCompatActivity {

    private ImageButton pacienteButton;
    private ImageButton medicoButton;
    private ImageButton farmaceuticoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        paciente();
        medico();
        farmaceutico();
    }

    private void initFarmaceutico(Object[] data){

        for(int i = 0; i < data.length;i++){
            System.out.println(data[i]);
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                farmaceuticoButton.setBackgroundColor(Color.BLUE);
                Toast.makeText(getApplicationContext(), data[0].toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void farmaceutico(){
        farmaceuticoButton = findViewById(R.id.main_farmaceutico_button);
        farmaceuticoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, TelaFarmaceuticoLogin.class);
//                startActivity(intent);
                Object[] data;
                PacienteLoginModel model = new  PacienteLoginModel(getApplicationContext());
                data = model.dadosLogin();
                new TimeOut().setTimeout(()->initFarmaceutico(data),1000);
            }
        });
    }
    public void medico(){
        medicoButton = findViewById(R.id.main_medico_button);
        medicoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaMedicoLogin.class);
                startActivity(intent);
            }
        });
    }
    public void paciente(){
        pacienteButton = findViewById(R.id.main_paciente_button);
        pacienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaPacienteLogin.class);
                startActivity(intent);
            }
        });
    }



}