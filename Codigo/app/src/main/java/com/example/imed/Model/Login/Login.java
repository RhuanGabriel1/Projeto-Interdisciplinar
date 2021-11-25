package com.example.imed.Model.Login;

public class Login {

    private String login;
    private String senha;

    private LoginStrategyInterface logger;

    public Login(LoginStrategyInterface logger) {
        this.logger = logger;
    }

    public Boolean realizarLogin(String login, String senha) {
        return logger.realizarLogin(login, senha);
    }

}
