package com.example.imed.Model;


public class Farmaceutico extends Usuario {

    private String crf;

    public String getCrf() {
        return crf;
    }



    public void setCrf(String crf) {
        this.crf = crf;
    }


    @Override
    public String toString(){
        return "CRF-SP " + getCrf() + "   ---   " + "Nome: " +getNome();
    }
}
