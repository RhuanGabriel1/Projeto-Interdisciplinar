package com.example.imed.Model.Usuarios;

public class Paciente extends Usuario {

    private String cpf;

    public Paciente() {
        super();
    }

    public Paciente(String cpf) {
        super();
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}

