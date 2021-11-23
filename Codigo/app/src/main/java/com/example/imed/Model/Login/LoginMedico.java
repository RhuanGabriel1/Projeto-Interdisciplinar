package com.example.imed.Model.Login;

public class LoginMedico implements LoginStrategy {

    @Override
    public Boolean realizarLogin(String login, String senha) {
        return false;
    }

}
