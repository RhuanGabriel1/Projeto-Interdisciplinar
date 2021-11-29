package com.example.imed.MVP;

import com.example.imed.Model.Receita;
import com.example.imed.Presenters.Paciente.PacienteLoginPresenter;

import java.util.List;

public interface MVPPaciente {

    interface IViewPacienteToast {
        void showToast(String mensagem);
    }

    interface IViewWaitLoginPaciente{
        void waitLogin(PacienteLoginPresenter presenter);
    }

    interface IViewExaminarReceita{
        void mostraReceitas(List<Receita> receita);
    }

    interface IPresenterPacienteLogin{
        boolean makeLogin();
        void destruirView();
    }

    interface IPresenterPacienteCriarConta{
        boolean createAccount();
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
