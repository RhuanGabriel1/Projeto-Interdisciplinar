package com.example.imed.Views.TelasAdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imed.Controllers.Adm.AdmCriarContaFarmMedController;
import com.example.imed.Database.ClasseDAO;
import com.example.imed.R;
import com.example.imed.Controllers.Farmaceutico;
import com.example.imed.Controllers.Medico;

public class tela_adm_criar_conta_farm_e_med extends AppCompatActivity {


    private ImageButton imageButton_tela_create_account_adm_back;
    private RadioButton radioButton_medico, radioButton_farmaceutico;
    private Button button_criar_conta;
    private TextView textView_nome_farm_med, textView_crm_crf, textView_senha_farm_med, textView_repetir_senha_farm_med;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_adm_criar_conta_farm_e_med);

        //Recebendo dado de qual adm está logado
        Intent intent = getIntent();
        String valor  = intent.getStringExtra("ContaAdm");
        //=======================================//

        //=========================================================================//
        imageButton_tela_create_account_adm_back = findViewById(R.id.imageButton_tela_create_account_adm_back);
        //=========================================================================//

        //Botão criado para retornar para a tela anterior
        imageButton_tela_create_account_adm_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_adm_criar_conta_farm_e_med.this, tela_adm_inicio.class);
                intent.putExtra("ContaAdm", valor);//Envia o dado de qual adm está logado
                startActivity(intent);
            }

        });
        //=================================================//

        //=========================================================================//
        radioButton_farmaceutico = findViewById(R.id.radioButton_farmaceutico);
        radioButton_farmaceutico.setChecked(true);

        radioButton_medico = findViewById(R.id.radioButton_medico);

        button_criar_conta = findViewById(R.id.button_criar_conta);

        textView_nome_farm_med = findViewById(R.id.textView_nome_farm_med);
        textView_nome_farm_med.setFilters(new InputFilter[]{new InputFilter.LengthFilter(29)});

        textView_crm_crf = findViewById(R.id.textView_crm_crf);
        textView_crm_crf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(7)});

        textView_senha_farm_med = findViewById(R.id.textView_senha_farm_med);
        textView_senha_farm_med.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        textView_repetir_senha_farm_med = findViewById(R.id.textView_repetir_senha_farm_med);
        textView_repetir_senha_farm_med.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        //=======================================================================//

        // Início do método de selecionar apenas um dos radioButtons
        radioButton_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton_medico.isChecked()){
                    radioButton_farmaceutico.setChecked(false);
                }
            }
        });

        radioButton_farmaceutico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton_farmaceutico.isChecked()){
                    radioButton_medico.setChecked(false);
                }
            }
        });
        // Fim do método de selecionar apenas um dos radioButton

        //Método para criar conta farmacêutico/médico

        button_criar_conta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdmCriarContaFarmMedController adm = new AdmCriarContaFarmMedController(
                        radioButton_farmaceutico.isChecked(),textView_nome_farm_med.getText().toString(),
                        textView_crm_crf.getText().toString(),textView_senha_farm_med.getText().toString(),
                        textView_repetir_senha_farm_med.getText().toString(),valor,getApplicationContext()
                );

                if(adm.makeAccount()){
                    Intent intent = new Intent(tela_adm_criar_conta_farm_e_med.this, tela_adm_inicio.class);
                    intent.putExtra("ContaAdm", valor);//Envia o dado de qual adm está logado
                    startActivity(intent);
                }
            }
        });

        //Fim do método para criar conta farmacêutico/médico

    }
}