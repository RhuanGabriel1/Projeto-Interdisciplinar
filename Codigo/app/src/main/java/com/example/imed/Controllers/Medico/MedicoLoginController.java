package com.example.imed.Controllers.Medico;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.Views.TelasMed.tela_medico_inicio;
import com.example.imed.Views.TelasMed.tela_medico_login;

public class MedicoLoginController {

    private String login,password;
    private Context context;
    private ClasseDAO dao;

    public MedicoLoginController(String login, String password, Context context){
        this.login = login;
        this.password = password;
        this.context = context;

        this.dao = new ClasseDAO(this.context);
    }


    public boolean makeLogin(){
        try{
            if(dao.obterLoginMedico(login)[0].toString().equals(password)){

                Toast.makeText(context, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                return true;
            }
            else{
                Toast.makeText(context, "Dados incorretos", Toast.LENGTH_SHORT).show();
                return false;
            }
        }catch (NullPointerException e){
            Toast.makeText(context, "Dados incorretos", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
