package com.example.imed.Model.Login;

public class LoginPaciente implements LoginStrategy{

    @Override
    public Boolean realizarLogin(String login, String senha) {
        return true;
    }

}
