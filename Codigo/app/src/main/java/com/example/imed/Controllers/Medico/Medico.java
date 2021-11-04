package com.example.imed.Controllers.Medico;


import com.example.imed.Controllers.Usuario;

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

    public void setFkAdmMed(String fkAdmMed) {
        this.fkAdmMed = fkAdmMed;
    }

    @Override
    public String toString(){
        return "CRM-SP " + getCrm() + "   ---   " + "Nome: " + getNome();
    }
}
