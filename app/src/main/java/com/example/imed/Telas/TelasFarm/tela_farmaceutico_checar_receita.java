package com.example.imed.Telas.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.R;

public class tela_farmaceutico_checar_receita extends AppCompatActivity {

    ImageButton imageButton_tela_verifica_receita_back;
    EditText editText_verifica_receita;
    Button button_verificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_checar_receita);

        //Recebendo dado de qual farmacêutico está logado
        Intent intent = getIntent();
        String valor = intent.getStringExtra("FarmCrf");
        //==================================================//
        
        //==================================================================================================//
        imageButton_tela_verifica_receita_back = findViewById(R.id.imageButton_tela_verifica_receita_back);
        button_verificar = findViewById(R.id.button_verificar);

        editText_verifica_receita = findViewById(R.id.editText_verifica_receita);
        editText_verifica_receita.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        //==================================================================================================//


        //Botão que retornar para a tela anterior
        imageButton_tela_verifica_receita_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(tela_farmaceutico_checar_receita.this, tela_farmaceutico_inicio.class);
                intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
                startActivity(intent);
            }
        });
        //=============================================//

        //Método para verificar se a receita é válida
        button_verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int id = Integer.parseInt(editText_verifica_receita.getText().toString());
                        if(editText_verifica_receita.getText().toString().equals(dao.retornaIdReceita(editText_verifica_receita.getText().toString()))){
                            dao.inserirFkFarm(valor, id);

                            Intent intent = new Intent(tela_farmaceutico_checar_receita.this, tela_farmaceutico_apresentacao_receita.class);
                            intent.putExtra("receita", editText_verifica_receita.getText().toString());//Envia o dado do id da receita
                            intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
                            startActivity(intent);

                            Toast.makeText(tela_farmaceutico_checar_receita.this, "Receita válida", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(tela_farmaceutico_checar_receita.this, "Dados incorretors/Receita ínvalida", Toast.LENGTH_SHORT).show();
                        }
                }catch (Exception e){
                    Toast.makeText(tela_farmaceutico_checar_receita.this, "Dados incorretos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Fim do método de verificar se a receita é válida


    }
}