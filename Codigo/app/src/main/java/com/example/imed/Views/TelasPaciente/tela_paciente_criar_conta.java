package com.example.imed.Views.TelasPaciente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.imed.Presenters.Paciente.PacienteCriarContaPresenter;
import com.example.imed.R;

public class tela_paciente_criar_conta extends AppCompatActivity {

    private ImageButton imageButtonGoBackTelaCreateAccountLoginPaciente;
    private Button buttonCriarContaPaciente;
    private TextView textViewNomePaciente, textViewCpfPaciente, textViewSenhaPaciente, textViewRepetirSenhaPaciente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_criar_conta);


        //==================================================================================================//
        imageButtonGoBackTelaCreateAccountLoginPaciente = findViewById(R.id.imageButton_tela_create_account_login_paciente_back);
        buttonCriarContaPaciente = findViewById(R.id.Button_criar_conta_paciente);

        textViewNomePaciente = findViewById(R.id.textView_nome_paciente);
        textViewNomePaciente.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        textViewCpfPaciente = findViewById(R.id.textView_cpf_paciente);
        textViewCpfPaciente.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        
        textViewSenhaPaciente = findViewById(R.id.textView_senha_paciente);
        textViewSenhaPaciente.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        textViewRepetirSenhaPaciente = findViewById(R.id.textView_repetir_senha_paciente);
        textViewRepetirSenhaPaciente.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        //==================================================================================================//


        //Botão para criar uma conta do tipo paciente
        //Método para criar uma conta do tipo paciente
        buttonCriarContaPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PacienteCriarContaPresenter pacienteCriarContaPresenter = new PacienteCriarContaPresenter(textViewNomePaciente.getText().toString(), textViewCpfPaciente.getText().toString(),
                        textViewSenhaPaciente.getText().toString(), textViewRepetirSenhaPaciente.getText().toString(), getApplicationContext());

                if(pacienteCriarContaPresenter.createAccount()){
                    Intent intent = new Intent(tela_paciente_criar_conta.this, tela_paciente_login.class);
                    startActivity(intent);
                }
            }
            });
        //Fim  do método de criar conta do tipo paciente

        //Botão criado para retornar para a tela anterior
        imageButtonGoBackTelaCreateAccountLoginPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_criar_conta.this, tela_paciente_login.class);
                startActivity(intent);
            }

        });
        //==================================================//

    }
}