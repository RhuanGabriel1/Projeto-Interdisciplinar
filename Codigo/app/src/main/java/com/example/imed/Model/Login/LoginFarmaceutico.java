package com.example.imed.Model.Login;

public class LoginFarmaceutico implements LoginStrategy {

    @Override
    public Boolean realizarLogin(String login, String senha) {
        return false;
    }

}
