package com.example.imed.Views.TelasPaciente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.imed.MVP.MVPPaciente;
import com.example.imed.Presenters.Paciente.PacienteExaminarReceitaPresenter;
import com.example.imed.R;
import com.example.imed.Presenters.Receita;

import java.util.List;

public class tela_paciente_examinar_receita extends AppCompatActivity implements MVPPaciente.IViewExaminarReceita {

    private ImageButton retornarButton;
    private ListView receitasListView;
    private String valor;
    private ArrayAdapter<Receita> adapterReceita;
    private PacienteExaminarReceitaPresenter presenter;
    private MVPPaciente.IViewExaminarReceita view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_examinar_receitas);

        Intent intent = getIntent();
        valor = intent.getStringExtra("PacienteCpf");

        receitasListView = findViewById(R.id.receitas_listview);

        this.view = this;
        presenter = new PacienteExaminarReceitaPresenter(getApplicationContext(),view,valor);
        presenter.obterReceitas();

        retornar();

    }

    public void retornar(){
        retornarButton = findViewById(R.id.receitas_retornar);
        retornarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_examinar_receita.this, tela_paciente_inicio.class);
                intent.putExtra("PacienteCpf", valor);//Envia o dado de qual paciente está logado
                startActivity(intent);
            }
        });
    }

    @Override
    public void mostraReceitas(List<Receita> receita) {
        adapterReceita = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, receita);
        receitasListView.setAdapter(adapterReceita);
    }
}