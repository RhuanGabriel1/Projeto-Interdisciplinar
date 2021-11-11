package com.example.imed.Presenters;

public class Receita {

    String idReceita, nomeRemedio,horario,dosagem,instrucoes,fkPacienteReceita,fkMedico;

    public void setFkPacienteReceita(String fkPacienteReceita) { this.fkPacienteReceita = fkPacienteReceita; }

    public void setIdReceita(String idReceita) {
        this.idReceita = idReceita;
    }

    public void setNomeRemedio(String nomeRemedio) {
        this.nomeRemedio = nomeRemedio;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }


    public void setFkMedico(String fkMedico) { this.fkMedico = fkMedico; }

    public String getIdReceita() {
        return idReceita;
    }

    public String getNomeRemedio() {
        return nomeRemedio;
    }

    public String getHorario() {
        return horario;
    }

    public String getDosagem() {
        return dosagem;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public String getFkPacienteReceita() { return fkPacienteReceita; }

    public String getFkMedico() {
        return fkMedico;
    }

    @Override
    public String toString(){
        return"Id da receita: " + getIdReceita() +  "\nNome do Remédio: " + getNomeRemedio() + "\nDosagem: " + getDosagem() +
                "\nHorário: "+ getHorario() + "\nInstruções: "+ getInstrucoes() +
                "\nCrm médico: " + getFkMedico();
    }
}
