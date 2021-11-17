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

    ImageButton retornarButton;
    TextView cpfPacienteTextView;
    TextView medicamentoTextView;
    TextView dosagemTextView;
    TextView frequenciaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_farmaceutico_apresentacao_receita);


        //Recebendo dado de qual farmacêutico está logado e o id da receita
        Intent intent = getIntent();
        String receita = intent.getStringExtra("receita");
        String valor = intent.getStringExtra("FarmCrf");
        //==================================================================//

        //===========================================================================================//
        retornarButton = findViewById(R.id.farmaceutico_receita_retornar_button);

        cpfPacienteTextView = findViewById(R.id.farmaceutico_receita_cpf_paciente_textview);
        medicamentoTextView = findViewById(R.id.farmaceutico_receita_medicamento_textfield);
        dosagemTextView = findViewById(R.id.farmaceutico_receita_dosagem_textview);
        frequenciaTextView = findViewById(R.id.farmaceutico_receita_frequencia_textview);

        //============================================================================================//

        //============================================================================================//
        cpfPacienteTextView.setEnabled(false);//textView setado em false para que apenas exiba os dados da receita
        medicamentoTextView.setEnabled(false);
        dosagemTextView.setEnabled(false);
        frequenciaTextView.setEnabled(false);

        //============================================================================================//

        //============================================================================================//
        cpfPacienteTextView.setText(dao.obterReceita(receita)[0].toString());//populando os textView com os dados da receita
        medicamentoTextView.setText(dao.obterReceita(receita)[1].toString());
        dosagemTextView.setText(dao.obterReceita(receita)[2].toString());
        frequenciaTextView.setText(dao.obterReceita(receita)[3].toString());

        //============================================================================================//

        //Botão criado para retornar a tela anterior
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_farmaceutico_apresentacao_receita.this, tela_farmaceutico_checar_receita.class);
                intent.putExtra("FarmCrf", valor);//Envia o dado de qual farmacêutico está logado
                startActivity(intent);
            }
        });
        //=============================================//
    }
}