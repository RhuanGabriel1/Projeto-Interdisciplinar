package com.example.imed.Model.Usuarios;

import com.example.imed.Model.Usuarios.Farmaceutico;
import com.example.imed.Model.Usuarios.Medico;
import com.example.imed.Model.Usuarios.Paciente;
import com.example.imed.Model.Usuarios.Usuario;

public class UsuarioFactory {

    public UsuarioFactory() {}

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