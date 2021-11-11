package com.example.imed.Views.TelasAdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;

import com.example.imed.Presenters.Adm.AdmExcluirContaPresenter;
import com.example.imed.Database.ClasseDAO;
import com.example.imed.R;
import com.example.imed.Presenters.Farmaceutico.Farmaceutico;
import com.example.imed.Presenters.Medico.Medico;

import java.util.List;

public class tela_adm_excluir_conta extends AppCompatActivity {

    private ImageButton imageButton_tela_adm_delete_account_go_back,imageButton_excluir,imageButton_update;
    private RadioButton radioButton_farmaceutico_lista,radioButton_medico_lista;
    private ListView ListaContas;
    private SearchView SearchView_contas;
    private List<Farmaceutico> farmaceuticos;
    private List<Medico> medicos;
    private View previousColor;

    private ArrayAdapter<Farmaceutico> adapterFarmaceutico;
    private ArrayAdapter<Medico> adapterMedico;

    private Farmaceutico itemFarm;
    private Medico itemMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ClasseDAO dao = new ClasseDAO(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_adm_excluir_conta);

        //Recebendo valor do login do adm
        Intent intent = getIntent();
        String valor = intent.getStringExtra("ContaAdm");
        //=================================//

        //==============================================//
        imageButton_tela_adm_delete_account_go_back = findViewById(R.id.imageButton_tela_adm_delete_account_go_back);
        imageButton_excluir = findViewById(R.id.imageButton_excluir);
        radioButton_farmaceutico_lista = findViewById(R.id.radioButton_farmaceutico_lista);
        radioButton_medico_lista = findViewById(R.id.radioButton_medico_lista);
        ListaContas = findViewById(R.id.ListaContas);
        SearchView_contas = findViewById(R.id.SearchView_contas);
        imageButton_update = findViewById(R.id.imageButton_update);
        //==============================================//

        //============================================//
        radioButton_farmaceutico_lista.setChecked(true);
        //============================================//

        //Arrayadpater criado para exibir a lista de contas médico
        medicos = dao.obterListaMedico();
        adapterMedico = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, medicos);
        //=============================================================//

        //Arrayadapter criado para exibir a lista de contas farmacêutico
        farmaceuticos = dao.obterListaFarmaceutico();
        adapterFarmaceutico = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,farmaceuticos);
        ListaContas.setAdapter(adapterFarmaceutico);
        //=============================================================//



        //Método criado para quando clicar no RadioButton farmaceutico exibir a lista das contas faramacêutico
        radioButton_farmaceutico_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton_farmaceutico_lista.isChecked()){
                    radioButton_medico_lista.setChecked(false);
                    ListaContas.setAdapter(adapterFarmaceutico);
                }
            }
        });
        //Fim do método de exibir as contas farmacêutico

        //Método criado para quando clicar no RadioButton médico exibir a lista das contas médicos
        radioButton_medico_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton_medico_lista.isChecked()){
                    radioButton_farmaceutico_lista.setChecked(false);
                    ListaContas.setAdapter(adapterMedico);
                }
            }
        });
        //fim do método de exibir as contas médicos

        //Método criado para pesquisar uma conta na SearchView
        SearchView_contas.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(radioButton_farmaceutico_lista.isChecked()){
                    tela_adm_excluir_conta.this.adapterFarmaceutico.getFilter().filter(query);
                }
                else {
                    tela_adm_excluir_conta.this.adapterMedico.getFilter().filter(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(radioButton_farmaceutico_lista.isChecked()){
                    tela_adm_excluir_conta.this.adapterFarmaceutico.getFilter().filter(newText);
                }
                else {
                    tela_adm_excluir_conta.this.adapterMedico.getFilter().filter(newText);
                }
                return false;
            }
        });
        //Fim do método criado para pesquisar na SearchView

        //Método criado para mudar a cor e manter um item da lista selecionado quando clicado
        ListaContas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drawable corAnterior = view.getBackground();
                if (previousColor != null) {
                    previousColor.setBackground(corAnterior);
                }
                previousColor = view;
                view.setBackgroundColor(Color.parseColor("#00d165"));

                if (radioButton_farmaceutico_lista.isChecked()) {
                    itemFarm = adapterFarmaceutico.getItem(position);
                }
                else {
                    itemMed = adapterMedico.getItem(position);
                }
            }
        });
        //Fim do método criado para manter um item da lista selecionado

        //Método criado para excluir um médico/farmacêutico
        //Utilizando um método da ClasseDAO
        imageButton_excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdmExcluirContaPresenter admExcluirContaPresenter = new AdmExcluirContaPresenter(radioButton_farmaceutico_lista.isChecked(),
                        farmaceuticos, medicos, itemFarm, itemMed,
                        getApplicationContext());
                admExcluirContaPresenter.deleteAccount();
            }
        });
        //Fim do método de excluir conta médico/farmacêutico


        //Método criado para atualizar a lista após um item ter sido excluido
        imageButton_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton_farmaceutico_lista.isChecked()){
                    ListaContas.setAdapter(adapterFarmaceutico);
                }
                else{
                    ListaContas.setAdapter(adapterMedico);
                }
            }
        });
        //Fim do método para atualizar a lista

        //Método criado para voltar a tela anterior
        imageButton_tela_adm_delete_account_go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_adm_excluir_conta.this, tela_adm_inicio.class);
                intent.putExtra("ContaAdm", valor);//Envia o dado de qual adm está logado
                startActivity(intent);
            }
        });
        //Fim do método criado para voltar a tela anterior
    }
}