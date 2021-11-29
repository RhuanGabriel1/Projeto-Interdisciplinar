package com.example.imed.Presenters.Farmaceutico;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPFarmaceutico;
import com.example.imed.Model.Usuarios.Farmaceutico;
import com.example.imed.Model.Usuarios.UsuarioFactory;

public class FarmaceuticoCriarContaPresenter implements MVPFarmaceutico.IPresenterFarmaceuticoCriarConta {


    private Farmaceutico farmaceutico;
    private UsuarioFactory factory = new UsuarioFactory();
    private String nome, senha,repetirSenha, crf;
    private Context context;
    private ClasseDAO dao;
    private MVPFarmaceutico.IViewFarmaceuticoToast view;

    public FarmaceuticoCriarContaPresenter(){}

    public FarmaceuticoCriarContaPresenter(String nome,
                                           String senha,
                                           String repetirSenha,
                                           String crf,
                                           Context context,
                                           MVPFarmaceutico.IViewFarmaceuticoToast view ){
        farmaceutico = (Farmaceutico) factory.criarNovoUsuario("farmaceutico");
        this.nome = nome;
        this.senha = senha;
        this.repetirSenha = repetirSenha;
        this.crf = crf;
        this.context = context;
        this.view = view;

        this.dao = new ClasseDAO(this.context);
    }

    @Override
    public boolean criarConta() {
        try {
            farmaceutico.setNome(nome);
            farmaceutico.setSenha(senha);
            farmaceutico.setCrf(crf);

            if(nome.equals("") || crf.equals("")
                    || senha.equals("") || repetirSenha.equals("")){
                view.showToast("Há campos vazios!");
                return false;
            }
            else if(farmaceutico.getSenha().equals(repetirSenha)){
                dao.inserirFarmaceutico(farmaceutico);
                view.showToast("Conta criada com sucesso!");
                return true;
            }
            else {
                view.showToast("Os campos das senhas não são iguais");
                return false;
            }
        }catch (SQLiteConstraintException e){
            view.showToast("Esse CRF já foi cadastrado");
            return false;
        }
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}
