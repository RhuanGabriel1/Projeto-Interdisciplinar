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

import com.example.imed.Database.ClasseDAO;
import com.example.imed.R;
import com.example.imed.Controllers.Farmaceutico;
import com.example.imed.Controllers.Medico;

public class tela_adm_criar_conta_farm_e_med extends AppCompatActivity {

    Medico medico = new Medico();
    Farmaceutico farmaceutico = new Farmaceutico();

    ImageButton imageButton_tela_create_account_adm_back;
    RadioButton radioButton_medico, radioButton_farmaceutico;
    Button button_criar_conta;
    TextView textView_nome_farm_med, textView_crm_crf, textView_senha_farm_med, textView_repetir_senha_farm_med;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

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
                try{
                    if(radioButton_farmaceutico.isChecked()){

                        farmaceutico.setNome(textView_nome_farm_med.getText().toString());//Recebendo os valores dos textFields
                        farmaceutico.setCrf(textView_crm_crf.getText().toString());
                        farmaceutico.setSenha(textView_senha_farm_med.getText().toString());
                        farmaceutico.setFk_adm_farm(valor);

                        if(textView_nome_farm_med.getText().toString().equals("") || textView_crm_crf.getText().toString().equals("")
                                || textView_senha_farm_med.getText().toString().equals("") || textView_repetir_senha_farm_med.getText().toString().equals("")){

                            Toast.makeText(tela_adm_criar_conta_farm_e_med.this, "Há campos vazios!", Toast.LENGTH_SHORT).show();

                        }
                        else if (farmaceutico.getSenha().equals(textView_repetir_senha_farm_med.getText().toString())){

                            dao.inserirFarmaceutico(farmaceutico);

                            Toast.makeText(tela_adm_criar_conta_farm_e_med.this, "Conta criada com sucesso!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(tela_adm_criar_conta_farm_e_med.this, tela_adm_inicio.class);
                            intent.putExtra("ContaAdm", valor);//Envia o dado de qual adm está logado
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(tela_adm_criar_conta_farm_e_med.this, "Os campos das senhas não são iguais", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else{

                        medico.setNome(textView_nome_farm_med.getText().toString());//Recebendo os valores dos textFields
                        medico.setCrm(textView_crm_crf.getText().toString());
                        medico.setSenha(textView_senha_farm_med.getText().toString());
                        medico.setFk_adm_med(valor);

                        if(textView_nome_farm_med.getText().toString().equals("") || textView_crm_crf.getText().toString().equals("")
                                || textView_senha_farm_med.getText().toString().equals("")
                                || textView_repetir_senha_farm_med.getText().toString().equals("")){
                            Toast.makeText(tela_adm_criar_conta_farm_e_med.this, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                        }
                        else if(medico.getSenha().equals(textView_repetir_senha_farm_med.getText().toString())){

                            dao.inserirMedico(medico);

                            Toast.makeText(tela_adm_criar_conta_farm_e_med.this, "Conta criada com sucesso!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(tela_adm_criar_conta_farm_e_med.this, tela_adm_inicio.class);
                            intent.putExtra("ContaAdm", valor);//Envia o dado de qual adm está logado
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(tela_adm_criar_conta_farm_e_med.this, "Os campos das senhas não são iguais", Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (SQLiteConstraintException e){
                    Toast.makeText(tela_adm_criar_conta_farm_e_med.this, "Esse CRM/CRF já foi cadastrado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Fim do método para criar conta farmacêutico/médico

    }
}