package com.example.imed.MVP;

public interface MVPFarmaceutico{

    interface IViewFarmaceuticoToast{
        void showToast(String mensagem);
    }
    interface IViewFarmaceuticoApresentarReceita{
        void mostrarReceita(String cpfPaciente, String medicamento, String dosagem, String frequencia);
    }

    interface IPresenterFarmaceuticoLogin{
        boolean fazerLogin();
        void destruirView();
    }

    interface IPresenterFarmaceuticoCriarConta{
        boolean criarConta();
        void destruirView();
    }

    interface IPresenterFarmaceuticoChecarReceita{
        boolean checarReceita();
        void destruirView();
    }

    interface IPresenterFarmaceuticoObterReceita{
        void obterReceita();
        void destruirView();
    }

//    interface IModelFarmaceutico{
//
//    }
}
