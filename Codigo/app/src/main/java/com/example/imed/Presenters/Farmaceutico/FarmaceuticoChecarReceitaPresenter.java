package com.example.imed.Presenters.Farmaceutico;

import android.content.Context;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPFarmaceutico;

public class FarmaceuticoChecarReceitaPresenter implements MVPFarmaceutico.IPresenterFarmaceuticoChecarReceita {

    private MVPFarmaceutico.IViewFarmaceuticoToast view;
    private Context context;
    private ClasseDAO dao;
    private String receitaTextField, valor;
    private int id;

    public FarmaceuticoChecarReceitaPresenter(){}

    public FarmaceuticoChecarReceitaPresenter(String receitaTextField,String valor, Context context,MVPFarmaceutico.IViewFarmaceuticoToast view ){

        this.receitaTextField = receitaTextField;
        this.valor = valor;
        this.context = context;
        this.view = view;

        this.dao = new ClasseDAO (this.context);
    }

    @Override
    public boolean checarReceita() {
        try {
            id = Integer.parseInt(receitaTextField);
            if(receitaTextField.equals(dao.retornaIdReceita(receitaTextField))){
                dao.inserirFkFarm(valor, id);
                view.showToast("Receita válida");
                return true;
            }
            else{
                view.showToast("Dados incorretors/Receita ínvalida");
                return false;
            }
        }catch (Exception e){
            view.showToast("Dados incorretos");
            return false;
        }
    }

    @Override
    public void destruirView() { this.view = null; }
}
