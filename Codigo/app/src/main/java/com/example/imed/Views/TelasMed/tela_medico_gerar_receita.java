
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
    private TextView frequenciaTextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Random random = new Random();
        ClasseDAO dao = new ClasseDAO(this  );
        Receita receita = new Receita();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_gerar_receita);

        //Recebendo dado de qual médico está logado
        Intent intent = getIntent();
        String valor = intent.getStringExtra("MedicoCrm");
        //===========================================//

        //==========================================================//
        retornarButton = findViewById(R.id.medico_gerar_receita_retornar_button);
        buttonGerarReceita = findViewById(R.id.medico_gerar_receita_gerar_button);

        cpfPacienteTextView = findViewById(R.id.medico_gerar_receita_cpf_paciente_textview);
        cpfPacienteTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        medicamentoTextView = findViewById(R.id.medico_gerar_receita_medicamento_textfield);
        medicamentoTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        dosagemTextView = findViewById(R.id.medico_gerar_receita_dosagem_textview);
        dosagemTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        frequenciaTextView = findViewById(R.id.medico_gerar_receita_frequencia_textview);
        frequenciaTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});
        //==========================================================//


        //Método criado para gerar uma regeita
        buttonGerarReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int idReceita = random.nextInt(6000) + 1000;

                    receita.setIdReceita(idReceita+"");
                    receita.setDosagem(medicamentoTextView.getText().toString());
                    receita.setHorario(dosagemTextView.getText().toString());
                    receita.setNomeRemedio(cpfPacienteTextView.getText().toString());
                    receita.setInstrucoes(frequenciaTextView.getText().toString());
                    receita.setFkPacienteReceita(textViewCpfDoPaciente.getText().toString());
                    receita.setFkMedico(valor);

                    dao.inserirFkCrmMed(valor, cpfPacienteTextView.getText().toString());
                    dao.inserirFkIdReceita(idReceita, cpfPacienteTextView.getText().toString());

                    if(cpfPacienteTextView.getText().toString().equals("") || textViewCpfDoPaciente.getText().toString().equals("") ||
                            medicamentoTextView.getText().toString().equals("") || dosagemTextView.getText().toString().equals("") ||
                            frequenciaTextView.getText().toString().equals("")){
                        Toast.makeText(tela_medico_gerar_receita.this, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                    }
                    else if(textViewCpfDoPaciente.getText().toString().length()>0 && textViewCpfDoPaciente.getText().toString().length()<12) {
                        if(textViewCpfDoPaciente.getText().toString().equals(dao.retornaCPF(textViewCpfDoPaciente.getText().toString()))){
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
                    receita.setDosagem(medicamentoTextView.getText().toString());
                    receita.setHorario(dosagemTextView.getText().toString());
                    receita.setNomeRemedio(cpfPacienteTextView.getText().toString());
                    receita.setInstrucoes(frequenciaTextView.getText().toString());
                    receita.setFkPacienteReceita(textViewCpfDoPaciente.getText().toString());
                    receita.setFkMedico(valor);

                    dao.inserirFkCrmMed(valor, cpfPacienteTextView.getText().toString());
                    dao.inserirFkIdReceita(idReceita, cpfPacienteTextView.getText().toString());

                    if(cpfPacienteTextView.getText().toString().equals("") || textViewCpfDoPaciente.getText().toString().equals("") ||
                            medicamentoTextView.getText().toString().equals("") || dosagemTextView.getText().toString().equals("") ||
                            frequenciaTextView.getText().toString().equals("")){
                        Toast.makeText(tela_medico_gerar_receita.this, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                    }
                    else if(textViewCpfDoPaciente.getText().toString().length()>0 && textViewCpfDoPaciente.getText().toString().length()<12) {
                        if(textViewCpfDoPaciente.getText().toString().equals(dao.retornaCPF(textViewCpfDoPaciente.getText().toString()))){
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
        //Fim do método para gerar um receita

        //Botão criado para retornar para a tela anterior
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_gerar_receita.this, tela_medico_inicio.class);
                intent.putExtra("MedicoCrm",valor);//Envia o dado de qual médico está logado
                startActivity(intent);
            }
        });
        //=================================================//


    }
}