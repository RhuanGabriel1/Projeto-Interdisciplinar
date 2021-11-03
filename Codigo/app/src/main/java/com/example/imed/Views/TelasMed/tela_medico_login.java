package com.example.imed.Views.TelasMed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.imed.Controllers.Medico.MedicoLoginController;
import com.example.imed.R;
import com.example.imed.Views.Main.MainActivity;

public class tela_medico_login extends AppCompatActivity {

    private ImageButton imgButton_back_tela_login_screen_medico;
    private Button button_tela_login_screen_medico_entrar;
    private TextView textField_tela_login_screen_medico_crm,textPassword_tela_login_screen_medico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_login);

        //==========================================================================//
        textField_tela_login_screen_medico_crm = findViewById(R.id.textField_tela_login_screen_medico_crm);
        textField_tela_login_screen_medico_crm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});

        textPassword_tela_login_screen_medico = findViewById(R.id.textPassword_tela_login_screen_medico);
        textPassword_tela_login_screen_medico.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        button_tela_login_screen_medico_entrar = findViewById(R.id.button_tela_login_screen_medico_entrar);
        imgButton_back_tela_login_screen_medico = findViewById(R.id.imgButton_back_tela_login_screen_medico);
        //==========================================================================//


        //Botão para retornar para a tela anterior
        imgButton_back_tela_login_screen_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_login.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //========================================//

        //Botão criado para entrar na tela início médico
        //Método criado para verificar se o login do médico é valido
        button_tela_login_screen_medico_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedicoLoginController medicoLoginController = new MedicoLoginController(textField_tela_login_screen_medico_crm.getText().toString(),
                        textPassword_tela_login_screen_medico.getText().toString(), getApplicationContext());

                if(medicoLoginController.makeLogin()){
                    Intent intent = new Intent(tela_medico_login.this, tela_medico_inicio.class);
                    intent.putExtra("MedicoCrm", textField_tela_login_screen_medico_crm.getText().toString());//Envia o dado de qual médico está logado
                    startActivity(intent);
                }
            }
        });
        //Fim do método para verificar o login

    }
}