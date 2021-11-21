package com.example.imed.Presenters.Medico;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPMedico;

public class MedicoCriarContaPresenter implements MVPMedico.IPresenterMedicoCriarConta {

    private Medico medico = new Medico();
    private String nome, senha,repetirSenha, crm;
    private Context context;
    private ClasseDAO dao;
    private MVPMedico.IViewMedicoToast view;


    public MedicoCriarContaPresenter(){}

    public MedicoCriarContaPresenter(String nome, String senha, String repetirSenha, String crm ,
                                     Context context,MVPMedico.IViewMedicoToast view ){

        this.nome = nome;
        this.senha = senha;
        this.repetirSenha = repetirSenha;
        this.crm = crm;
        this.context = context;
        this.view = view;

        this.dao = new ClasseDAO(this.context);

    }

    @Override
    public boolean createAccount() {
        try {
            medico.setNome(nome);
            medico.setSenha(senha);
            medico.setCrm(crm);

            if(nome.equals("") || crm.equals("")
                    || senha.equals("") || repetirSenha.equals("")){
                view.showToast("Há campos vazios!");
                return false;
            }
            else if(medico.getSenha().equals(repetirSenha)){
                dao.inserirMedico(medico);
                view.showToast("Conta criada com sucesso!");
                return true;
            }
            else {
                view.showToast("Os campos das senhas não são iguais");
                return false;
            }
        }catch (SQLiteConstraintException e){
            view.showToast("Esse CRM já foi cadastrado");
            return false;
        }
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}
