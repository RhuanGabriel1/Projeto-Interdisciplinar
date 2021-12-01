package com.example.imed.MVP;

public interface MVPMedico {

    interface IViewMedicoToast{
        void showToast(String mensagem);
    }

    interface IPresenterMedicoLogin{
        boolean fazerLogin();
        void destruirView();
    }

    interface IPresenterMedicoCriarConta{
        boolean criarConta();
        void destruirView();
    }

    interface IPresenterMedicoGerarReceita{
        void destruirView();
        boolean gerarReceita();

    }

}
