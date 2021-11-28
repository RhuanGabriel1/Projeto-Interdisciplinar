package com.example.imed.Model;


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
