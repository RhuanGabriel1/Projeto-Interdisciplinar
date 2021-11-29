package com.example.imed.MVP;

import com.example.imed.Model.Usuarios.Receita;

import java.util.List;

public interface MVPPaciente {

    interface IViewPacienteToast {
        void showToast(String mensagem);
    }

    interface IViewExaminarReceita{
        void mostraReceitas(List<Receita> receita);
    }

    interface IPresenterPacienteLogin{
        boolean fazerLogin();
        void destruirView();
    }

    interface IPresenterPacienteCriarConta{
        boolean criarConta();
        void destruirView();
    }

    interface IPresenterObterReceitas{
        void obterReceitas();
        void destruirView();
    }

//    interface IModelPaciente{
//
//    }

}
