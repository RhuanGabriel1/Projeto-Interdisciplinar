package com.example.imed.Controllers.Paciente;

import android.content.Context;
import android.widget.Toast;

import com.example.imed.Database.ClasseDAO;


public class PacienteLoginController {

    private String login, password;
    private Context context;
    private ClasseDAO dao;

    public PacienteLoginController(String login, String senha, Context context){
        this.login = login;
        this.password = senha;
        this.context = context;

        this.dao = new ClasseDAO(this.context);
    }

    public boolean makeLogin(){
        try{
            if(dao.obterLoginPaciente(login)[0].toString().equals(password)){
                Toast.makeText(context, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                return true;
            }
            else{
                Toast.makeText(context, "Dados incorretos", Toast.LENGTH_SHORT).show();
                return false;
            }
        }catch (NullPointerException e){
            Toast.makeText(context, "Dados incorretos!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


}
