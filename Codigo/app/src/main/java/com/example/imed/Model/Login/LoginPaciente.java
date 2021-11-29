package com.example.imed.Model.Login;

import android.content.Context;

import com.example.imed.Database.ClasseDAO;

public class LoginPaciente implements LoginStrategyInterface {

    private ClasseDAO dao;
    private Context context;

    public LoginPaciente(Context context){
        this.context = context;
        dao = new ClasseDAO(this.context);
    }

    @Override
    public Boolean realizarLogin(String login, String senha) {

        try{
            if(dao.obterLoginPaciente(login)[0].toString().equals(senha)) {
                return true;
            } else {
                return false;
            }
        }catch (NullPointerException e ){
            return false;
        }

    }

}
