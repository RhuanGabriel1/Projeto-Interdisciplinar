package com.example.imed.Presenters.Medico;

import android.content.Context;
import android.widget.Toast;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPMedico;
import com.example.imed.Model.Login.Login;
import com.example.imed.Model.Login.LoginMedico;
import com.example.imed.Model.Login.LoginPaciente;
import com.example.imed.Model.Medico;
import com.example.imed.Model.Paciente;
import com.example.imed.Model.UsuarioFactory;

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


    public boolean makeLogin(){
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
