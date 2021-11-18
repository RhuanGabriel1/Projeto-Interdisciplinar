package com.example.imed.Presenters.Medico;


import com.example.imed.Presenters.Usuario;

public class Medico extends Usuario {

    String crm, fkAdmMed;

    public String getCrm() {
        return crm;
    }

    public String getFkAdmMed() {
        return fkAdmMed;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString(){
        return "CRM-SP " + getCrm() + "   ---   " + "Nome: " + getNome();
    }
}
