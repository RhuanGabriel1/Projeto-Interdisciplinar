package com.example.imed.Model.Login;

import android.content.Context;

import com.example.imed.Database.ClasseDAO;

public class LoginFarmaceutico implements LoginStrategyInterface {

    private ClasseDAO dao;
    private Context context;

    public LoginFarmaceutico(Context context) {
        this.context = context;
    }

    @Override
    public Boolean realizarLogin(String login, String senha) {
        if(dao.obterLoginFarmaceutico(login)[0].toString().equals(senha)){
            return true;
        } else {
            return false;
        }
    }

}
