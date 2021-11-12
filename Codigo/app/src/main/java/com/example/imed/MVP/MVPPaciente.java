package com.example.imed.MVP;

public interface MVPPaciente {

    interface IViewPacienteLogin{
        void showToast(String mensagem);
    }

    interface IViewPacienteCriarConta{

    }
    interface IViewPacienteExaminarReceita{

    }

    interface IPresenterPacienteLogin{
        boolean makeLogin();
    }

    interface IPresenterPacienteCriarConta{
        boolean createAccount();
    }

//    interface IModelPaciente{
//
//    }

}
