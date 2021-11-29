package com.example.imed.Presenters.Paciente;

import android.content.Context;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPPaciente;
import com.example.imed.Model.Usuarios.Receita;

import java.util.List;

public class PacienteExaminarReceitaPresenter implements MVPPaciente.IPresenterObterReceitas {

    private Context context;
    private ClasseDAO dao;
    private MVPPaciente.IViewExaminarReceita view;
    private String valor;
    private List<Receita> receitas;

    public PacienteExaminarReceitaPresenter(Context context, MVPPaciente.IViewExaminarReceita view,  String valor){
        this.context = context;
        this.view = view;
        this.valor = valor;
        this.dao = new ClasseDAO(this.context);
    }

    @Override
    public  void obterReceitas() {
        this.receitas = dao.obterListaReceita(valor);
        view.mostraReceitas(receitas);
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}
