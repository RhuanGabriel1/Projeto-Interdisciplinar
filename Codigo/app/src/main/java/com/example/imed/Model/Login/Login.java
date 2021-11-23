package com.example.imed.Model.Login;

public class Login {

    private String login;
    private String senha;

    private LoginStrategy logger;

    public Login(LoginStrategy login) {
        logger = login;
    }

    public Boolean realizarLogin(String login, String senha) {
        return logger.realizarLogin(login, senha);
    }

}
