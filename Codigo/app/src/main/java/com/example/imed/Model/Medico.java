package com.example.imed.Model;


import com.example.imed.Model.Usuario;

public class Medico extends Usuario {

    private String crm;

    public String getCrm() {
        return crm;
    }


    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString(){
        return "CRM-SP " + getCrm() + "   ---   " + "Nome: " + getNome();
    }
}
