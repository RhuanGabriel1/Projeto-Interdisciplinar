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

    private ImageButton retornarButton;
    private Button entrarButton;
    private TextView crmTextField;
    private TextView senhaTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_login);

        //==========================================================================//
        crmTextField = findViewById(R.id.medico_login_crm_textview);
        crmTextField.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});

        senhaTextField = findViewById(R.id.medico_login_senha_textview);
        senhaTextField.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        entrarButton = findViewById(R.id.medico_login_entrar_button);
        retornarButton = findViewById(R.id.medico_login_retornar_button);
        //==========================================================================//


        //Botão para retornar para a tela anterior
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_login.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //========================================//

        //Botão criado para entrar na tela início médico
        //Método criado para verificar se o login do médico é valido
        entrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedicoLoginPresenter medicoLoginPresenter = new MedicoLoginPresenter(crmTextField.getText().toString(),
                        senhaTextField.getText().toString(), getApplicationContext());

                if(medicoLoginPresenter.makeLogin()){
                    Intent intent = new Intent(tela_medico_login.this, tela_medico_inicio.class);
                    intent.putExtra("MedicoCrm", crmTextField.getText().toString());//Envia o dado de qual médico está logado
                    startActivity(intent);
                }
            }
        });
        //Fim do método para verificar o login

    }
}