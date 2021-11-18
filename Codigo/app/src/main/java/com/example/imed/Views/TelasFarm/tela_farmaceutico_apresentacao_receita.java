package com.example.imed.Views.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.R;

public class tela_farmaceutico_apresentacao_receita extends AppCompatActivity {

    private ImageButton retornarButton;
    private TextView cpfPacienteTextView;
    private TextView medicamentoTextView;
    private TextView dosagemTextView;
    private TextView frequenciaTextView;
    private String valor, receita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_apresentacao_receita);

        Intent intent = getIntent();
        receita = intent.getStringExtra("receita");
        valor = intent.getStringExtra("FarmCrf");

        retornar();
        configurarTextView();

        cpfPacienteTextView.setText(dao.obterReceita(receita)[0].toString());//populando os textView com os dados da receita
        medicamentoTextView.setText(dao.obterReceita(receita)[1].toString());
        dosagemTextView.setText(dao.obterReceita(receita)[2].toString());
        frequenciaTextView.setText(dao.obterReceita(receita)[3].toString());
    }

    public void retornar(){
        retornarButton = findViewById(R.id.farmaceutico_receita_retornar_button);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_apresentacao_receita.this, tela_farmaceutico_checar_receita.class);
                intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
                startActivity(intent);
            }
        });
    }

    public void configurarTextView(){
        cpfPacienteTextView = findViewById(R.id.farmaceutico_receita_cpf_paciente_textview);
        cpfPacienteTextView.setEnabled(false);
        medicamentoTextView = findViewById(R.id.farmaceutico_receita_medicamento_textfield);
        medicamentoTextView.setEnabled(false);
        dosagemTextView = findViewById(R.id.farmaceutico_receita_dosagem_textview);
        dosagemTextView.setEnabled(false);
        frequenciaTextView = findViewById(R.id.farmaceutico_receita_frequencia_textview);
        frequenciaTextView.setEnabled(false);
    }
}