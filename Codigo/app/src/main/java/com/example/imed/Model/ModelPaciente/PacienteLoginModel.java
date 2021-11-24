package com.example.imed.Model.ModelPaciente;


import android.content.Context;

import com.example.imed.Database.MySQLConnection;
import com.example.imed.Helper.TimeOut;




public class PacienteLoginModel {
    private Context context;
    private Object[] response = new Object[2];

    public PacienteLoginModel(Context context) {
        this.context = context;
    }

    public Object[] retornaDadosLogin(Object[] object) {
        return object;
    }

    public Object[]  dadosLogin() {
        MySQLConnection connection = new MySQLConnection();
        connection.queryMysql("select * from paciente", this.context, result -> {

            for (int i = 0; i < result.length; i++) {
                response[i] = result[i];
            }

        });

        new TimeOut().timeWait(337);

        return response;

    }


}
