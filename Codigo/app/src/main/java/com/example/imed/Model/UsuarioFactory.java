package com.example.imed.Model;

public class UsuarioFactory {

    public Usuario criarNovoUsuario(String tipoDeUsuario) {

        switch (tipoDeUsuario) {
            case "paciente":
                return new Paciente();
            case "medico":
                return new Medico();
            case "farmaceutico":
                return new Farmaceutico();
            default:
                return null;
        }

    }
}
