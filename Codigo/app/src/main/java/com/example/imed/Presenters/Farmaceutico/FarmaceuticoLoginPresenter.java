package com.example.imed.Presenters.Farmaceutico;

import android.content.Context;
import android.widget.Toast;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPFarmaceutico;


public class FarmaceuticoLoginPresenter implements MVPFarmaceutico.IPresenterFarmaceuticoLogin {

    private String login,password;
    private Context context;
    private ClasseDAO dao;
    private MVPFarmaceutico.IViewFarmaceuticoToast view;

    public FarmaceuticoLoginPresenter(){}

    public FarmaceuticoLoginPresenter(String login, String password, Context context,MVPFarmaceutico.IViewFarmaceuticoToast view){
        this.login = login;
        this.password = password;
        this.context = context;
        this.view = view;

        this.dao = new ClasseDAO(this.context);
    }

    public boolean makeLogin(){
        try{
            if(dao.obterLoginFarmaceutico(login)[0].toString().equals(password)){
                view.showToast("Login efetuado com sucesso");
                return true;
            }
            else{
                view.showToast("Dados incorretos!");
                return false;
            }
        }catch (NullPointerException e){
            view.showToast("Dados incorretos!");
            return false;
        }
    }

    @Override
    public void destruirView() { this.view = null; }


}
