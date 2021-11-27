package com.example.imed.Presenters.Farmaceutico;

import android.content.Context;
import android.widget.Toast;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPFarmaceutico;
import com.example.imed.Model.Farmaceutico;
import com.example.imed.Model.Login.Login;
import com.example.imed.Model.Login.LoginFarmaceutico;
import com.example.imed.Model.Medico;
import com.example.imed.Model.UsuarioFactory;


public class FarmaceuticoLoginPresenter implements MVPFarmaceutico.IPresenterFarmaceuticoLogin {

    private UsuarioFactory factory = new UsuarioFactory();
    private Farmaceutico farmaceutico = (Farmaceutico) factory.criarNovoUsuario("farmaceutico");
    private MVPFarmaceutico.IViewFarmaceuticoToast view;
    private Login strategyLogin;

    public FarmaceuticoLoginPresenter(){}

    public FarmaceuticoLoginPresenter(String login, String senha, Context context,MVPFarmaceutico.IViewFarmaceuticoToast view){

        farmaceutico.setCrf(login);
        farmaceutico.setSenha(senha);

        this.view = view;

        strategyLogin = new Login(new LoginFarmaceutico(context));
    }

    public boolean makeLogin(){
        if(strategyLogin.realizarLogin(farmaceutico.getCrf(), farmaceutico.getSenha())) {
            view.showToast("Login efetuado com sucesso");
            return true;
        } else {
            view.showToast("Dados incorretos!");
            return false;
        }
    }

    @Override
    public void destruirView() { this.view = null; }


}
