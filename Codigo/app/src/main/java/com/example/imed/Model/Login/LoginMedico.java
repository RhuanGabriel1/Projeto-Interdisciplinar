package com.example.imed.Model.Login;

import android.content.Context;

import com.example.imed.Database.ClasseDAO;

public class LoginMedico implements LoginStrategyInterface {

    private ClasseDAO dao;
    private Context context;

    public LoginMedico(Context context) {
        this.context = context;
        this.dao = new ClasseDAO(this.context);

    }

    @Override
    public Boolean realizarLogin(String login, String senha) {
        try{
            if (dao.obterLoginMedico(login).equals(senha)) {
                return true;
            } else {
                return false;
            }
        }catch (NullPointerException e){
            return  false;
        }
    }
}
