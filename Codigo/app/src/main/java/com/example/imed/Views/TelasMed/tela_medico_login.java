package com.example.imed.Views.TelasMed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.imed.Presenters.Medico.MedicoLoginPresenter;
import com.example.imed.R;
import com.example.imed.Views.Main.MainActivity;

public class tela_medico_login extends AppCompatActivity {

    private ImageButton imgButtonGoBackTelaLoginScreenMedico;
    private Button buttonTelaLoginScreenMedicoEntrar;
    private TextView textFieldTelaLoginScreenMedicoCrm, textPasswordTelaLoginScreenMedico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_login);

        //==========================================================================//
        textFieldTelaLoginScreenMedicoCrm = findViewById(R.id.textField_tela_login_screen_medico_crm);
        textFieldTelaLoginScreenMedicoCrm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});

        textPasswordTelaLoginScreenMedico = findViewById(R.id.textPassword_tela_login_screen_medico);
        textPasswordTelaLoginScreenMedico.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        buttonTelaLoginScreenMedicoEntrar = findViewById(R.id.button_tela_login_screen_medico_entrar);
        imgButtonGoBackTelaLoginScreenMedico = findViewById(R.id.imgButton_back_tela_login_screen_medico);
        //==========================================================================//


        //Botão para retornar para a tela anterior
        imgButtonGoBackTelaLoginScreenMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_login.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //========================================//

        //Botão criado para entrar na tela início médico
        //Método criado para verificar se o login do médico é valido
        buttonTelaLoginScreenMedicoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedicoLoginPresenter medicoLoginPresenter = new MedicoLoginPresenter(textFieldTelaLoginScreenMedicoCrm.getText().toString(),
                        textPasswordTelaLoginScreenMedico.getText().toString(), getApplicationContext());

                if(medicoLoginPresenter.makeLogin()){
                    Intent intent = new Intent(tela_medico_login.this, tela_medico_inicio.class);
                    intent.putExtra("MedicoCrm", textFieldTelaLoginScreenMedicoCrm.getText().toString());//Envia o dado de qual médico está logado
                    startActivity(intent);
                }
            }
        });
        //Fim do método para verificar o login

    }
}