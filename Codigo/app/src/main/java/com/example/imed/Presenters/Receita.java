package com.example.imed.Presenters;

public class Receita {

    private String idReceita, nomeRemedio,horario,dosagem,fkPacienteReceita,fkMedico;

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

    public String getFkPacienteReceita() { return fkPacienteReceita; }

    public String getFkMedico() {
        return fkMedico;
    }

    @Override
    public String toString(){
        return"Id da receita: " + getIdReceita() +  "\nNome do Remédio: " + getNomeRemedio() + "\nDosagem: " + getDosagem() +
                "\nHorário: "+ getHorario() + "\nCrm médico: " + getFkMedico();
    }
}
