
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

    private ImageButton imageButtonGoBackTelaMedicoLoggedin;
    private Button buttonGerarReceita;
    private TextView textViewNomeRemedio, textViewDosagem, textViewNomeHorario, textViewInstrucoes, textViewCpfDoPaciente;

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
        imageButtonGoBackTelaMedicoLoggedin = findViewById(R.id.imageButton_go_back_tela_medico_loggedin);
        buttonGerarReceita = findViewById(R.id.button_gerar_receita_med);

        textViewNomeRemedio = findViewById(R.id.textView_nome_remedio);
        textViewNomeRemedio.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        textViewDosagem = findViewById(R.id.textView_dosagem);
        textViewDosagem.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        textViewNomeHorario = findViewById(R.id.textView_nome_horario);
        textViewNomeHorario.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        textViewInstrucoes = findViewById(R.id.textView_instrucoes);
        textViewInstrucoes.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        textViewCpfDoPaciente = findViewById(R.id.textView_cpf_do_paciente);
        textViewCpfDoPaciente.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        //==========================================================//


        //Método criado para gerar uma regeita
        buttonGerarReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int idReceita = random.nextInt(6000) + 1000;

                    receita.setIdReceita(idReceita+"");
                    receita.setDosagem(textViewDosagem.getText().toString());
                    receita.setHorario(textViewNomeHorario.getText().toString());
                    receita.setNomeRemedio(textViewNomeRemedio.getText().toString());
                    receita.setInstrucoes(textViewInstrucoes.getText().toString());
                    receita.setFkPacienteReceita(textViewCpfDoPaciente.getText().toString());
                    receita.setFkMedico(valor);

                    dao.inserirFkCrmMed(valor, textViewNomeRemedio.getText().toString());
                    dao.inserirFkIdReceita(idReceita, textViewNomeRemedio.getText().toString());

                    if(textViewNomeRemedio.getText().toString().equals("") || textViewCpfDoPaciente.getText().toString().equals("") ||
                            textViewDosagem.getText().toString().equals("") || textViewNomeHorario.getText().toString().equals("") ||
                            textViewInstrucoes.getText().toString().equals("")){
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
                    receita.setDosagem(textViewDosagem.getText().toString());
                    receita.setHorario(textViewNomeHorario.getText().toString());
                    receita.setNomeRemedio(textViewNomeRemedio.getText().toString());
                    receita.setInstrucoes(textViewInstrucoes.getText().toString());
                    receita.setFkPacienteReceita(textViewCpfDoPaciente.getText().toString());
                    receita.setFkMedico(valor);

                    dao.inserirFkCrmMed(valor, textViewNomeRemedio.getText().toString());
                    dao.inserirFkIdReceita(idReceita, textViewNomeRemedio.getText().toString());

                    if(textViewNomeRemedio.getText().toString().equals("") || textViewCpfDoPaciente.getText().toString().equals("") ||
                            textViewDosagem.getText().toString().equals("") || textViewNomeHorario.getText().toString().equals("") ||
                            textViewInstrucoes.getText().toString().equals("")){
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
        imageButtonGoBackTelaMedicoLoggedin.setOnClickListener(new View.OnClickListener() {
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