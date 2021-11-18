package com.example.imed.Presenters.Farmaceutico;


import com.example.imed.Presenters.Usuario;

public class Farmaceutico extends Usuario {

    private String crf,fk_adm_farm;

    public String getCrf() {
        return crf;
    }

    public String getFk_adm_farm() {
        return fk_adm_farm;
    }

    public void setCrf(String crf) {
        this.crf = crf;
    }

    public void setFk_adm_farm(String fk_adm_farm) {
        this.fk_adm_farm = fk_adm_farm;
    }

    @Override
    public String toString(){
        return "CRF-SP " + getCrf() + "   ---   " + "Nome: " +getNome();
    }
}
