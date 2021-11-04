package com.example.imed.Views.TelasMed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.Controllers.Medicamentos;
import com.example.imed.R;

import java.util.List;

public class tela_medico_estoque extends AppCompatActivity {

    ImageButton imageButtonGoBackEstoqueMedico;
    ListView listaMedicamentosDisponivel;
    SearchView searchViewMedicamentosMedico;

    private List<Medicamentos> listaMedicamentos;
    private ArrayAdapter<Medicamentos> adapterMedicamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_medico_estoque);

        //Recebendo dado de qual médico está logado
        Intent intent = getIntent();
        String valor = intent.getStringExtra("MedicoCrm");
        //===========================================//


        //===========================================================================================//
        imageButtonGoBackEstoqueMedico = findViewById(R.id.imageButton_go_back_estoque_medico);
        searchViewMedicamentosMedico = findViewById(R.id.SearchView_contas);
        listaMedicamentosDisponivel = findViewById(R.id.ListaMedicamentosDisponivel);
        searchViewMedicamentosMedico = findViewById(R.id.SearchView_contas);
        //===========================================================================================//

        //===========================================================================================//
        listaMedicamentos = dao.obterListaMedicamentos();
        adapterMedicamentos = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listaMedicamentos);
        listaMedicamentosDisponivel.setAdapter(adapterMedicamentos);
        //==================================================//



        //Método criado para pesquisar um medicamento na SearchView
        searchViewMedicamentosMedico.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tela_medico_estoque.this.adapterMedicamentos.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                tela_medico_estoque.this.adapterMedicamentos.getFilter().filter(newText);
                return false;
            }
        });
        //Fim do método criado para pesquisar na SearchView

        //Botão criado para retornar para a tela anterior
        imageButtonGoBackEstoqueMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_medico_estoque.this, tela_medico_inicio.class);
                intent.putExtra("MedicoCrm",valor);
                startActivity(intent);
            }
        });
        //==================================================//
    }
}