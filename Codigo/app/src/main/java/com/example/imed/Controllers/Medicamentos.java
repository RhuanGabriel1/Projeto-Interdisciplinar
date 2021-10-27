package com.example.imed.Controllers;

public class Medicamentos {

//    private String catmat, pr_ativo, concentracao, fornecimento, forma_farm,nome_medicamento,fk_idReceita,fk_crm_med,fk_crf_farm;
//    deixei as partes referentes ao banco de dados de fora, repensar futuramente
    private String catmat;
    private String principioAtivo;
    private String concentracao;
    private String fornecedor;
    private String  formaFarmaceutica;
    private String nomeMedicamento;
    private Farmaceutico farmaceutico;

    public String getCatmat() {
        return catmat;
    }

    public void setCatmat(String catmat) {
        this.catmat = catmat;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(String concentracao) {
        this.concentracao = concentracao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public Farmaceutico getFarmaceutico() {
        return farmaceutico;
    }

    public void setFarmaceutico(Farmaceutico farmaceutico) {
        this.farmaceutico = farmaceutico;
    }

    @Override
    public  String toString(){
        return "Nome do Medicamento: " + getNome_medicamento() + "\nCódigo CATMAT: " + getCatmat() +
                "\nPrincípio ativo: " + getPr_ativo() + "\nConcentração: " + getConcentracao() +
                "\nFornecimento: " + getFornecimento() + "\nForma Farmacêutica: " + getForma_farm();
    }


}
