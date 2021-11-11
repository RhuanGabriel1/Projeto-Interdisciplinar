package com.example.imed.Presenters.Farmaceutico;

import android.content.Context;
import android.widget.Toast;

import com.example.imed.Database.ClasseDAO;


public class FarmaceuticoLoginPresenter {

    private String login,password;
    private Context context;
    private ClasseDAO dao;

    public FarmaceuticoLoginPresenter(String login, String password, Context context){
        this.login = login;
        this.password = password;
        this.context = context;

        this.dao = new ClasseDAO(this.context);
    }

    public boolean makeLogin(){
        try{
            if(dao.obterLoginFarmaceutico(login)[0].toString().equals(password)){
                Toast.makeText(context, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                return true;
            }
            else{
                Toast.makeText(context, "Dados incorretos!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }catch (NullPointerException e){
            Toast.makeText(context, "Dados incorretos!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


}
