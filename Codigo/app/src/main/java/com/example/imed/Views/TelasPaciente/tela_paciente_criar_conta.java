package com.example.imed.Views.TelasPaciente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.R;
import com.example.imed.Controllers.Paciente;

public class tela_paciente_criar_conta extends AppCompatActivity {

    Paciente paciente = new Paciente();


    ImageButton imageButton_tela_create_account_login_paciente_back;
    Button Button_criar_conta_paciente;
    TextView textView_nome_paciente, textView_cpf_paciente, textView_senha_paciente, textView_repetir_senha_paciente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_criar_conta);



        ClasseDAO dao = new ClasseDAO(this);
        //==================================================================================================//
        imageButton_tela_create_account_login_paciente_back = findViewById(R.id.imageButton_tela_create_account_login_paciente_back);
        Button_criar_conta_paciente = findViewById(R.id.Button_criar_conta_paciente);

        textView_nome_paciente = findViewById(R.id.textView_nome_paciente);
        textView_nome_paciente.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        textView_cpf_paciente = findViewById(R.id.textView_cpf_paciente);
        textView_cpf_paciente.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        
        textView_senha_paciente = findViewById(R.id.textView_senha_paciente);
        textView_senha_paciente.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        textView_repetir_senha_paciente = findViewById(R.id.textView_repetir_senha_paciente);
        textView_repetir_senha_paciente.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});

        //==================================================================================================//


        //Botão para criar uma conta do tipo paciente
        //Método para criar uma conta do tipo paciente
        Button_criar_conta_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    paciente.setNome(textView_nome_paciente.getText().toString());
                    paciente.setSenha(textView_senha_paciente.getText().toString());
                    paciente.setCpf(textView_cpf_paciente.getText().toString());

                    if(textView_nome_paciente.getText().toString().equals("") || textView_cpf_paciente.getText().toString().equals("")
                            || textView_senha_paciente.getText().toString().equals("") || textView_repetir_senha_paciente.getText().toString().equals("")){
                        Toast.makeText(tela_paciente_criar_conta.this, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                    }
                    else if(paciente.getSenha().equals(textView_repetir_senha_paciente.getText().toString()) == true) {
                        dao.inserirPaciente(paciente);

                        Toast.makeText(tela_paciente_criar_conta.this, "Conta criada com sucesso!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(tela_paciente_criar_conta.this, tela_paciente_login.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(tela_paciente_criar_conta.this, "Os campos das senhas não são iguais", Toast.LENGTH_SHORT).show();
                    }
                }catch (SQLiteConstraintException e){
                    Toast.makeText(tela_paciente_criar_conta.this, "Esse CPF já foi cadastrado", Toast.LENGTH_SHORT).show();
                }
            }
            });
        //Fim  do método de criar conta do tipo paciente

        //Botão criado para retornar para a tela anterior
        imageButton_tela_create_account_login_paciente_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_criar_conta.this, tela_paciente_login.class);
                startActivity(intent);

            }

        });
        //==================================================//

    }
}