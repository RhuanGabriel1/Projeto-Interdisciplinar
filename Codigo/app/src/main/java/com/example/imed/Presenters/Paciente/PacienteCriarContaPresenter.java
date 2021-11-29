package com.example.imed.Presenters.Paciente;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPPaciente;
import com.example.imed.Model.Usuarios.Paciente;
import com.example.imed.Model.Usuarios.UsuarioFactory;

public class PacienteCriarContaPresenter implements MVPPaciente.IPresenterPacienteCriarConta {


    private UsuarioFactory factory  = new UsuarioFactory();
    private Paciente paciente;
    private String senha, repetirSenha, nome, cpf;
    private Context context;
    private ClasseDAO dao;
    private MVPPaciente.IViewPacienteToast view;


    public PacienteCriarContaPresenter(){}

    public PacienteCriarContaPresenter(String nome,
                                       String cpf,
                                       String senha,
                                       String repetirSenha,
                                       Context context,
                                       MVPPaciente.IViewPacienteToast view) {

        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.repetirSenha = repetirSenha;
        this.context = context;
        this.view = view;

        paciente = (Paciente) factory.criarNovoUsuario("paciente");
        this.dao = new ClasseDAO(this.context);
    }

    @Override
    public boolean criarConta(){
        try {
            paciente.setNome(nome);
            paciente.setSenha(senha);
            paciente.setCpf(cpf);

            if(nome.equals("") || cpf.equals("")
                    || senha.equals("") || repetirSenha.equals("")){
                view.showToast("Há campos vazios!");
                return false;
            }
            else if(paciente.getSenha().equals(repetirSenha)){
                dao.inserirPaciente(paciente);
                view.showToast("Conta criada com sucesso!");
                return true;
            }
            else {
                view.showToast("Os campos das senhas não são iguais");
                return false;
            }
        }catch (SQLiteConstraintException e){
            view.showToast("Esse CPF já foi cadastrado");
            return false;
        }
    }

    @Override
    public void destruirView() { this.view = null; }



}
