package com.example.imed.Presenters.Medico;

import android.content.Context;

import com.example.imed.MVP.MVPMedico;
import com.example.imed.Model.Login.Login;
import com.example.imed.Model.Login.LoginMedico;
import com.example.imed.Model.Usuarios.Medico;
import com.example.imed.Model.Usuarios.UsuarioFactory;

public class MedicoLoginPresenter implements MVPMedico.IPresenterMedicoLogin {

    private UsuarioFactory factory = new UsuarioFactory();
    private Medico medico = (Medico) factory.criarNovoUsuario("medico");
    private MVPMedico.IViewMedicoToast view;
    private Login strategyLogin;

    public MedicoLoginPresenter(){}

    public MedicoLoginPresenter(String login, String senha, Context context, MVPMedico.IViewMedicoToast view){
        medico.setCrm(login);
        medico.setSenha(senha);

        this.view = view;

        strategyLogin = new Login(new LoginMedico(context));
    }


    public boolean fazerLogin(){
        if(strategyLogin.realizarLogin(medico.getCrm(), medico.getSenha())) {
            view.showToast("Login efetuado com sucesso!");
            return true;
        } else {
            view.showToast("Dados incorretos");
            return false;
        }
    }

    @Override
    public void destruirView() {this.view = null;}

}
