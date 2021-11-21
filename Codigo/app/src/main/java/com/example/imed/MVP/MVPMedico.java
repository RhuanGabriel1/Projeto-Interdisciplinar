package com.example.imed.MVP;

public interface MVPMedico {

    interface IViewMedicoToast{
        void showToast(String mensagem);
    }

    interface IPresenterMedicoLogin{
        boolean makeLogin();
        void destruirView();
    }

    interface IPresenterMedicoGerarReceita{
        void destruirView();
        boolean gerarReceita();

    }
//    interface IModelMedico{
//
//    }
}
