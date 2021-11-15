package com.example.imed.MVP;

public interface MVPPaciente {

    interface IViewPacienteToast {
        void showToast(String mensagem);
    }

    interface IPresenterPacienteLogin{
        boolean makeLogin();
        void IPresenterDestruirView();
    }

    interface IPresenterPacienteCriarConta{
        boolean createAccount();
        void IPresenterDestruirView();
    }

//    interface IModelPaciente{
//
//    }

}
