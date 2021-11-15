package com.example.imed.Presenters.Paciente;

import android.content.Context;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPPaciente;


public class PacienteLoginPresenter implements MVPPaciente.IPresenterPacienteLogin {

    private String login, password;
    private Context context;
    private ClasseDAO dao;
    private MVPPaciente.IViewPacienteToast view;

    public PacienteLoginPresenter(){}

    public PacienteLoginPresenter(String login, String senha, Context context, MVPPaciente.IViewPacienteToast view){
        this.login = login;
        this.password = senha;
        this.context = context;
        this.view = view;

        this.dao = new ClasseDAO(this.context);
    }

    @Override
    public boolean makeLogin(){
        try{
            if(dao.obterLoginPaciente(login)[0].toString().equals(password)){
                view.showToast("Login efetuado com sucesso!");
                return true;
            }
            else{
               view.showToast("Dados incorretos");
                return false;
            }
        }catch (NullPointerException e){
            view.showToast("Dados incorretos");
            return false;
        }
    }

    @Override
    public void IPresenterDestruirView() {
        this.view = null;
    }


}
