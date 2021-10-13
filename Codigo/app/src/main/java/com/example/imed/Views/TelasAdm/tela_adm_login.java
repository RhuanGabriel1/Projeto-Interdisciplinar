package com.example.imed.Views.TelasAdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imed.Controllers.Adm.AdmLoginController;
import com.example.imed.Database.ClasseDAO;
import com.example.imed.Views.Main.MainActivity;
import com.example.imed.R;

public class tela_adm_login extends AppCompatActivity {

    ImageButton imgButton_back_tela_login_screen_adm;
    Button button_tela_login_adm_entrar;
    TextView textNumber_tela_login_screen_adm_login,textPassword_tela_login_screen_adm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_adm_login);

        //==================================================================================================//
        textNumber_tela_login_screen_adm_login = findViewById(R.id.textNumber_tela_login_screen_adm_login);
        textNumber_tela_login_screen_adm_login.setFilters(new InputFilter[]{new InputFilter.LengthFilter(29)});

        textPassword_tela_login_screen_adm = findViewById(R.id.textPassword_tela_login_screen_adm);
        textPassword_tela_login_screen_adm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});


        imgButton_back_tela_login_screen_adm = findViewById(R.id.imgButton_back_tela_login_screen_adm);
        button_tela_login_adm_entrar = findViewById(R.id.button_tela_login_adm_entrar);
        //==================================================================================================//

        //Botão criado para retornar para a tela anterior
        imgButton_back_tela_login_screen_adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_adm_login.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //=================================================//

        //Botão criado para entrar na tela início adm
        //Método criado para verificar se o login é um cadastrado
        button_tela_login_adm_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //import controller for get methods
                AdmLoginController adm = new AdmLoginController(
                        textNumber_tela_login_screen_adm_login.getText().toString(),
                        textPassword_tela_login_screen_adm.getText().toString(),
                        getApplicationContext()
                );
                if(adm.makeLogin()){
                    Intent intent = new Intent(getApplicationContext(), tela_adm_inicio.class);
                    intent.putExtra("ContaAdm", textNumber_tela_login_screen_adm_login.getText().toString());//Envia o dado de qual adm está logado
                    startActivity(intent);
                }

            }
        });
        //Fim do método para verificar o login
    }
}