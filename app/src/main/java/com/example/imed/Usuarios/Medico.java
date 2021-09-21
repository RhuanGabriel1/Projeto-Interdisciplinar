package com.example.imed.Usuarios;

public class Medico extends Usuario {

    String crm,fk_adm_med;

    public String getCrm() {
        return crm;
    }

    public String getFk_adm_med() {
        return fk_adm_med;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setFk_adm_med(String fk_adm_med) {
        this.fk_adm_med = fk_adm_med;
    }

    @Override
    public String toString(){
        return "CRM-SP " + getCrm() + "   ---   " + "Nome: " + getNome();
    }
}
