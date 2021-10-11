package com.example.imed.Telas.TelasFarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.R;

public class tela_farmaceutico_apresentacao_receita extends AppCompatActivity {

    ImageButton imageButton_go_back_checar_receita;
    TextView textView_id_receita,textView_nome_remedio_receita,textView_horario_receita,textView_dosagem_receita,textView_instrucoes_receita,textView_crm_receita;

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
        imageButton_go_back_checar_receita = findViewById(R.id.imageButton_go_back_checar_receita);

        textView_id_receita = findViewById(R.id.textView_id_receita);
        textView_nome_remedio_receita = findViewById(R.id.textView_nome_remedio_receita);
        textView_horario_receita = findViewById(R.id.textView_horario_receita);
        textView_dosagem_receita = findViewById(R.id.textView_dosagem_receita);
        textView_instrucoes_receita = findViewById(R.id.textView_instrucoes_receita);
        textView_crm_receita = findViewById(R.id.textView_crm_receita);
        //============================================================================================//

        //============================================================================================//
        textView_id_receita.setEnabled(false);//textView setado em false para que apenas exiba os dados da receita
        textView_nome_remedio_receita.setEnabled(false);
        textView_horario_receita.setEnabled(false);
        textView_dosagem_receita.setEnabled(false);
        textView_instrucoes_receita.setEnabled(false);
        textView_crm_receita.setEnabled(false);
        //============================================================================================//

        //============================================================================================//
        textView_id_receita.setText(dao.obterReceita(receita)[0].toString());//populando os textView com os dados da receita
        textView_nome_remedio_receita.setText(dao.obterReceita(receita)[1].toString());
        textView_horario_receita.setText(dao.obterReceita(receita)[2].toString());
        textView_dosagem_receita.setText(dao.obterReceita(receita)[3].toString());
        textView_instrucoes_receita.setText(dao.obterReceita(receita)[4].toString());
        textView_crm_receita.setText(dao.obterReceita(receita)[5].toString());
        //============================================================================================//

        //Botão criado para retornar a tela anterior
        imageButton_go_back_checar_receita.setOnClickListener(new View.OnClickListener() {
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