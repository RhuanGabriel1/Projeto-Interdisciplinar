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
import com.example.imed.MVP.MVPMedico;
import com.example.imed.Presenters.Medico.MedicoGerarReceitaPresenter;
import com.example.imed.R;
import com.example.imed.Presenters.Receita;

import java.util.Random;

public class tela_medico_gerar_receita extends AppCompatActivity implements MVPMedico.IViewMedicoToast {

    private ImageButton retornarButton;
    private Button buttonGerarReceita;
    private TextView cpfPacienteTextView;
    private TextView medicamentoTextView;
    private TextView dosagemTextView;
    private TextView frequenciaTextView;
    private String valor;
    private MedicoGerarReceitaPresenter presenter;
    private MVPMedico.IViewMedicoToast view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_gerar_receita);

        Intent intent = getIntent();
        valor = intent.getStringExtra("MedicoCrm");

        cpfPacienteTextView = findViewById(R.id.medico_gerar_receita_cpf_paciente_textview);
        cpfPacienteTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});

        medicamentoTextView = findViewById(R.id.medico_gerar_receita_medicamento_textfield);
        medicamentoTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        dosagemTextView = findViewById(R.id.medico_gerar_receita_dosagem_textview);
        dosagemTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        frequenciaTextView = findViewById(R.id.medico_gerar_receita_frequencia_textview);
        frequenciaTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(28)});

        this.view = this;
        presenter = new MedicoGerarReceitaPresenter();

        retornar();
        gerarReceita();
    }
    public void retornar(){
        retornarButton = findViewById(R.id.medico_gerar_receita_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_gerar_receita.this, tela_medico_inicio.class);
                intent.putExtra("MedicoCrm",valor);
                startActivity(intent);
            }
        });
    }

    public void gerarReceita(){
        buttonGerarReceita = findViewById(R.id.medico_gerar_receita_gerar_button);
        buttonGerarReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedicoGerarReceitaPresenter medicoGerarReceitaPresenter = new MedicoGerarReceitaPresenter(cpfPacienteTextView.getText().toString(),
                        medicamentoTextView.getText().toString(), dosagemTextView.getText().toString(), frequenciaTextView.getText().toString(),
                        valor, getApplicationContext(),view);
                if(medicoGerarReceitaPresenter.gerarReceita()){
                    Intent intent = new Intent(tela_medico_gerar_receita.this, tela_medico_inicio.class);
                    intent.putExtra("MedicoCrm",valor);//Envia o dado de qual médico está logado
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destruirView();
    }

    @Override
    public void showToast(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}