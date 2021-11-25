package com.example.imed.Model.Login;

public class LoginPacienteInterface implements LoginStrategyInterface {

    @Override
    public Boolean realizarLogin(String login, String senha) {
        return true;
    }

}
