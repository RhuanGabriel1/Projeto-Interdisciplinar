
package com.example.imed.Views.TelasMed;

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
import com.example.imed.Presenters.Receita;

import java.util.Random;

public class tela_medico_gerar_receita extends AppCompatActivity {

    private ImageButton retornarButton;
    private Button buttonGerarReceita;
    private TextView cpfPacienteTextView;
    private TextView medicamentoTextView;
    private TextView dosagemTextView;
    private TextView frequenciaTextView;
    private String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_gerar_receita);

        Intent intent = getIntent();
        valor = intent.getStringExtra("MedicoCrm");

        cpfPacienteTextView = findViewById(R.id.medico_gerar_receita_cpf_paciente_textview);
        cpfPacienteTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        medicamentoTextView = findViewById(R.id.medico_gerar_receita_medicamento_textfield);
        medicamentoTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        dosagemTextView = findViewById(R.id.medico_gerar_receita_dosagem_textview);
        dosagemTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        frequenciaTextView = findViewById(R.id.medico_gerar_receita_frequencia_textview);
        frequenciaTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        buttonGerarReceita = findViewById(R.id.medico_gerar_receita_gerar_button);

        Random random = new Random();
        ClasseDAO dao = new ClasseDAO(this  );
        Receita receita = new Receita();

        retornar();
        gerarReceita();

        //Método criado para gerar uma regeita
        buttonGerarReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int idReceita = random.nextInt(6000) + 1000;

                    receita.setIdReceita(idReceita+"");
                    receita.setDosagem(dosagemTextView.getText().toString());
                    receita.setHorario(frequenciaTextView.getText().toString());
                    receita.setNomeRemedio(medicamentoTextView.getText().toString());
                    receita.setFkPacienteReceita(cpfPacienteTextView.getText().toString());
                    receita.setFkMedico(valor);

                    dao.inserirFkCrmMed(valor, cpfPacienteTextView.getText().toString());
                    dao.inserirFkIdReceita(idReceita, cpfPacienteTextView.getText().toString());

                    if(cpfPacienteTextView.getText().toString().equals("") || cpfPacienteTextView.getText().toString().equals("") ||
                            medicamentoTextView.getText().toString().equals("") || dosagemTextView.getText().toString().equals("") ||
                            frequenciaTextView.getText().toString().equals("")){
                        Toast.makeText(tela_medico_gerar_receita.this, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                    }
                    else if(cpfPacienteTextView.getText().toString().length()>0 && cpfPacienteTextView.getText().toString().length()<12) {
                        if(cpfPacienteTextView.getText().toString().equals(dao.retornaCPF(cpfPacienteTextView.getText().toString()))){
                            dao.gerarReceita(receita);
                            Toast.makeText(tela_medico_gerar_receita.this, "Receita criada com sucesso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(tela_medico_gerar_receita.this, tela_medico_inicio.class);
                            intent.putExtra("MedicoCrm",valor);//Envia o dado de qual médico está logado
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(tela_medico_gerar_receita.this, "CPF Ínvalido", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(tela_medico_gerar_receita.this, "CPF Ínvalido", Toast.LENGTH_SHORT).show();
                    }

                }
                catch (SQLiteConstraintException e){ //Repetimos o código caso o id de uma receita já criado tente inserir no banco e dados
                    int idReceita = random.nextInt(5000) + 1000;

                    receita.setIdReceita(idReceita+"");
                    receita.setDosagem(dosagemTextView.getText().toString());
                    receita.setHorario(frequenciaTextView.getText().toString());
                    receita.setNomeRemedio(medicamentoTextView.getText().toString());
                    receita.setFkPacienteReceita(cpfPacienteTextView.getText().toString());
                    receita.setFkMedico(valor);

                    dao.inserirFkCrmMed(valor, cpfPacienteTextView.getText().toString());
                    dao.inserirFkIdReceita(idReceita, cpfPacienteTextView.getText().toString());

                    if(cpfPacienteTextView.getText().toString().equals("") || cpfPacienteTextView.getText().toString().equals("") ||
                            medicamentoTextView.getText().toString().equals("") || dosagemTextView.getText().toString().equals("") ||
                            frequenciaTextView.getText().toString().equals("")){
                        Toast.makeText(tela_medico_gerar_receita.this, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                    }
                    else if(cpfPacienteTextView.getText().toString().length()>0 && cpfPacienteTextView.getText().toString().length()<12) {
                        if(cpfPacienteTextView.getText().toString().equals(dao.retornaCPF(cpfPacienteTextView.getText().toString()))){
                            dao.gerarReceita(receita);
                            Toast.makeText(tela_medico_gerar_receita.this, "Receita criada com sucesso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(tela_medico_gerar_receita.this, tela_medico_inicio.class);
                            intent.putExtra("MedicoCrm",valor);//Envia o dado de qual médico está logado
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(tela_medico_gerar_receita.this, "CPF Ínvalido", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(tela_medico_gerar_receita.this, "CPF Ínvalido", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }

    public void retornar(){
        retornarButton = findViewById(R.id.medico_inicio_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_gerar_receita.this, tela_medico_inicio.class);
                intent.putExtra("MedicoCrm",valor);//Envia o dado de qual médico está logado
                startActivity(intent);
            }
        });
    }

    public void gerarReceita(){ //Necessita mexer

    }
}