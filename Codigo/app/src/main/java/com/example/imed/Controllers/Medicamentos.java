package com.example.imed.Controllers;

public class Medicamentos {

    private String catmat, principioAtivo, concentracao, fornecimento, formaFarmaceutica, nomeMedicamento, fkCrfFarmaceutico;


    public void setCatmat(String catmat) {
        this.catmat = catmat;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public void setConcentracao(String concentracao) {
        this.concentracao = concentracao;
    }

    public void setFornecimento(String fornecimento) {
        this.fornecimento = fornecimento;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public void setNomeMedicamento(String nomeMedicamento) { this.nomeMedicamento = nomeMedicamento; }

    public void setFkCrfFarm(String fkCrfFarm) {
        this.fkCrfFarmaceutico = fkCrfFarm;
    }

    public String getFkCrfFarm() {
        return fkCrfFarmaceutico;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public String getCatmat() {
        return catmat;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public String getConcentracao() {
        return concentracao;
    }

    public String getFornecimento() {
        return fornecimento;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }




    @Override
    public  String toString(){
        return "Nome do Medicamento: " + getNomeMedicamento() + "\nCódigo CATMAT: " + getCatmat() +
                "\nPrincípio ativo: " + getPrincipioAtivo() + "\nConcentração: " + getConcentracao() +
                "\nFornecimento: " + getFornecimento() + "\nForma Farmacêutica: " + getFormaFarmaceutica();
    }
}
