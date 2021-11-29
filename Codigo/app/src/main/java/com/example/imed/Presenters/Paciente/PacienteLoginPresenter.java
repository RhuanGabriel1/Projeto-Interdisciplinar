package com.example.imed.Presenters.Paciente;

import android.content.Context;

import com.example.imed.MVP.MVPPaciente;
import com.example.imed.Model.Login.Login;
import com.example.imed.Model.Login.LoginPaciente;
import com.example.imed.Model.Usuarios.Paciente;
import com.example.imed.Model.Usuarios.UsuarioFactory;


public class PacienteLoginPresenter implements MVPPaciente.IPresenterPacienteLogin {

    private UsuarioFactory factory = new UsuarioFactory();
    private Paciente paciente = (Paciente) factory.criarNovoUsuario("paciente");
    private MVPPaciente.IViewPacienteToast view;
    private Login strategyLogin;

    public PacienteLoginPresenter(){}

    public PacienteLoginPresenter(String login, String senha, Context context, MVPPaciente.IViewPacienteToast view){

        paciente.setCpf(login);
        paciente.setSenha(senha);

        this.view = view;

        strategyLogin = new Login(new LoginPaciente(context));

    }

    @Override
    public boolean fazerLogin() {
        if(strategyLogin.realizarLogin(paciente.getCpf(), paciente.getSenha())) {
            view.showToast("Login efetuado com sucesso!");
            return true;
        } else {
            view.showToast("Dados incorretos");
            return false;
        }
    }

    @Override
    public void destruirView() { this.view = null; }

}
