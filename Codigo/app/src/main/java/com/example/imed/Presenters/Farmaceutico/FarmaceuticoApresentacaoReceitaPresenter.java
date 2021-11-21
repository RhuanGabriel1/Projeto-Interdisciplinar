package com.example.imed.Presenters.Farmaceutico;

import android.content.Context;
import android.widget.TextView;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPFarmaceutico;

public class FarmaceuticoApresentacaoReceitaPresenter implements MVPFarmaceutico.IPresenterFarmaceuticoObterReceita {

    private ClasseDAO dao;
    private Context context;
    private MVPFarmaceutico.IViewFarmaceuticoApresentarReceita view;
    private String cpfPacienteTextView, medicamentoTextView, dosagemTextView, frequenciaTextView;
    private String receita;



    public FarmaceuticoApresentacaoReceitaPresenter(Context context, String receita, MVPFarmaceutico.IViewFarmaceuticoApresentarReceita view){
        this.context = context;
        this.view = view;
        this.receita = receita;

        this.dao = new  ClasseDAO(this.context);
    }

    @Override
    public void obterReceita() {
        cpfPacienteTextView = (dao.obterReceita(receita)[0].toString());
        medicamentoTextView = (dao.obterReceita(receita)[1].toString());
        dosagemTextView = (dao.obterReceita(receita)[2].toString());
        frequenciaTextView = (dao.obterReceita(receita)[3].toString());
        view.mostrarReceita(cpfPacienteTextView, medicamentoTextView, dosagemTextView, frequenciaTextView);
    }

    @Override
    public void destruirView() {
        this.view = null;
    }


}
