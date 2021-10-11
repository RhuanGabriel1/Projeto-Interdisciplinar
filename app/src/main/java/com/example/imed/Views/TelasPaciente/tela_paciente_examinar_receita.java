package com.example.imed.Views.TelasPaciente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.imed.Banco.ClasseDAO;
import com.example.imed.R;
import com.example.imed.Controllers.Receita;

import java.util.List;

public class tela_paciente_examinar_receita extends AppCompatActivity {

    ImageButton imageButton_go_back_tela_paciente_loggedin;
    ListView ListaReceitas;

    private List<Receita> receitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_paciente_examinar_receitas);

        //Recebendo dado de qual paciente está logado
        Intent intent = getIntent();
        String valor = intent.getStringExtra("PacienteCpf");
        //============================================//

        //============================================================================================================//
        imageButton_go_back_tela_paciente_loggedin = findViewById(R.id.imageButton_go_back_tela_paciente_loggedin);
        ListaReceitas = findViewById(R.id.ListaReceitas);
        //============================================================================================================//


        receitas = dao.obterListaReceita(valor);
        ArrayAdapter<Receita> adapterReceita = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, receitas);
        ListaReceitas.setAdapter(adapterReceita);


        imageButton_go_back_tela_paciente_loggedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_paciente_examinar_receita.this, tela_paciente_inicio.class);
                intent.putExtra("PacienteCpf", valor);//Envia o dado de qual paciente está logado
                startActivity(intent);
            }
        });
    }
}