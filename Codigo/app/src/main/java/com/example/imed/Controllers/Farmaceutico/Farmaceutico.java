package com.example.imed.Controllers.Farmaceutico;


import com.example.imed.Controllers.Usuario;

public class Farmaceutico extends Usuario {

    // variáveis
    private String crf;
    private String fkFarmaceutico;

    // métodos
    public String getCrf() {
        return crf;
    }

    public void setCrf(String crf) {
        this.crf = crf;
    }

    public String getFkFarmaceutico() {
        return fkFarmaceutico;
    }

    public void setFkFarmaceutico(String fkFarmaceutico) {
        this.fkFarmaceutico = fkFarmaceutico;
    }

    @Override
    public String toString(){
        return "CRF-SP " + getCrf() + "   ---   " + "Nome: " +getNome();
    }

}
