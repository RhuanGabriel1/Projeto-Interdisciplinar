package com.example.imed.Model.Login;

import android.content.Context;

import com.example.imed.Database.ClasseDAO;

public class LoginMedico implements LoginStrategyInterface {

    private ClasseDAO dao;

    public LoginMedico(Context context) {

        this.dao = new ClasseDAO(context);

    }

    @Override
    public Boolean realizarLogin(String login, String senha) {
        if (dao.obterLoginMedico(login)[0].toString().equals(senha)) {
            return true;
        } else {
            return false;
        }
    }
}
