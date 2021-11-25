package com.example.imed.Model.ModelPaciente;


import android.content.Context;

import com.example.imed.Database.MySQLConnection;
import com.example.imed.Helper.TimeOut;




public class PacienteLoginModel {
    private Context context;


    public PacienteLoginModel(Context context) {
        this.context = context;
    }

    public Object[]  dadosLogin() {
        MySQLConnection connection = new MySQLConnection();
        Object[] objRequest;
        String nome = "Joao";
        String query = "select * from teste";
        objRequest = connection.queryMysql(query, this.context,8);
        return objRequest;
    }


}
