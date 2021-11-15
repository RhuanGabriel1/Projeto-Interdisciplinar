package com.example.imed.MVP;

import com.example.imed.Presenters.Receita;

import java.util.List;

public interface MVPPaciente {

    interface IViewPacienteToast {
        void showToast(String mensagem);
    }

    interface IViewExaminarReceita{
        void mostraReceitas(List<Receita> receita);
    }

    interface IPresenterPacienteLogin{
        boolean makeLogin();
        void IPresenterDestruirView();
    }

    interface IPresenterPacienteCriarConta{
        boolean createAccount();
        void IPresenterDestruirView();
    }

    interface IPresenterObterReceitas{
        void obterReceitas();
    }

//    interface IModelPaciente{
//
//    }

}
