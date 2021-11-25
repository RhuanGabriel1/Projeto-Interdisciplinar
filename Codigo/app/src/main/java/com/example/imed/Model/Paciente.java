package com.example.imed.Model;
import com.example.imed.Model.Usuario;

public class Paciente extends Usuario {

    String cpf;

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
