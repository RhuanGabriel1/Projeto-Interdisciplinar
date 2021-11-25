package com.example.imed.Model.Login;

public class Login {

    private String login;
    private String senha;

    private LoginStrategyInterface loginStrategy;

    public Login(LoginStrategyInterface loginStrategy) {
        this.loginStrategy = loginStrategy;
    }

    public Boolean realizarLogin(String login, String senha) {
        return loginStrategy.realizarLogin(login, senha);
    }

}
