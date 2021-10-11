package com.example.imed.Views.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.Controllers.Medicamentos;
import com.example.imed.R;

public class tela_farmaceutico_cadastrar_medicamento extends AppCompatActivity {

    Medicamentos medicamentos = new Medicamentos();

    private ImageButton imageButton_tela_cadastrar_medicamento_back;
    private Button Button_cadastrar_medicamentos;
    private EditText editText_catmat,editText_pr_ativo,editText_concentracao,editText_forma_farm,editText_fornecimento,editText_nome_medicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_cadastrar_medicamento);

        //Recebendo dado de qual farmacêutico está logado
        Intent intent = getIntent();
        String valor = intent.getStringExtra("FarmCrf");
        //===============================================//

        //======================================================================================================//
        imageButton_tela_cadastrar_medicamento_back = findViewById(R.id.imageButton_tela_cadastrar_medicamento_back);
        Button_cadastrar_medicamentos = findViewById(R.id.Button_cadastrar_medicamentos);

        editText_catmat = findViewById(R.id.editText_catmat);
        editText_catmat.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        editText_pr_ativo = findViewById(R.id.editText_pr_ativo);
        editText_pr_ativo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        editText_concentracao = findViewById(R.id.editText_concentracao);
        editText_concentracao.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        editText_forma_farm = findViewById(R.id.editText_forma_farm);
        editText_forma_farm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        editText_fornecimento = findViewById(R.id.editText_fornecimento);
        editText_fornecimento.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        editText_nome_medicamento = findViewById(R.id.editText_nome_medicamento);
        editText_nome_medicamento.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});
        //======================================================================================================//

        //Botão que retornar para a tela anterior
        imageButton_tela_cadastrar_medicamento_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_cadastrar_medicamento.this, tela_farmaceutico_inicio.class);
                intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
                startActivity(intent);
            }
        });
        //=======================================//


        //Método para cadastrar um medicamento novo
        Button_cadastrar_medicamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    medicamentos.setCatmat(editText_catmat.getText().toString());
                    medicamentos.setConcentracao(editText_concentracao.getText().toString());
                    medicamentos.setPr_ativo(editText_pr_ativo.getText().toString());
                    medicamentos.setForma_farm(editText_forma_farm.getText().toString());
                    medicamentos.setFornecimento(editText_fornecimento.getText().toString());
                    medicamentos.setNome_medicamento(editText_nome_medicamento.getText().toString());
                    medicamentos.setFk_crf_farm(valor);

                    if(editText_catmat.getText().toString().equals("") || editText_concentracao.getText().toString().equals("")
                            || editText_pr_ativo.getText().toString().equals("") || editText_forma_farm.getText().toString().equals("")
                            || editText_fornecimento.getText().toString().equals("")
                            || editText_nome_medicamento.getText().toString().equals("")) {
                        Toast.makeText(tela_farmaceutico_cadastrar_medicamento.this, "Há campos vazios", Toast.LENGTH_SHORT).show();
                    }else{

                        dao.inserirMedicamentos(medicamentos);

                        editText_catmat.setText("");
                        editText_nome_medicamento.setText("");
                        editText_pr_ativo.setText("");
                        editText_concentracao.setText("");
                        editText_forma_farm.setText("");
                        editText_fornecimento.setText("");

                        Toast.makeText(tela_farmaceutico_cadastrar_medicamento.this, "Medicamento cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(tela_farmaceutico_cadastrar_medicamento.this,tela_farmaceutico_inicio.class);
                        intent.putExtra("FarmCrf",valor);//Envia o dado de qual farmacêutico está logado
                    }
                }catch (SQLiteConstraintException e){
                    Toast.makeText(tela_farmaceutico_cadastrar_medicamento.this, "Esse medicamento já está cadastrado", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Fim do método para cadastrar um medicamento novo

    }
}