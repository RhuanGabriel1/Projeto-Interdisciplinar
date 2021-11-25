package com.example.imed.Model;

public class UsuarioFactory {

    public Usuario criarNovoUsuario(String tipoDeUsuario) {

        if(tipoDeUsuario == "paciente") {
            return new Paciente();
        } else if(tipoDeUsuario == "medico") {
            return new Medico();
        } else if(tipoDeUsuario == "farmaceutico") {
            return new Farmaceutico();
        }

        return null;
    }
}
