package com.example.imed.Presenters.Paciente;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.widget.Toast;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPPaciente;

public class PacienteCriarContaPresenter implements MVPPaciente.IPresenterPacienteCriarConta {


    private Paciente paciente = new Paciente();
    private String textView_senha_paciente,textView_repetir_senha_paciente, textView_nome_paciente,textView_cpf_paciente;
    private Context context;
    private ClasseDAO dao;
    private MVPPaciente.IViewPacienteToast view;


    public PacienteCriarContaPresenter(){}

    public PacienteCriarContaPresenter(String textView_nome_paciente, String textView_cpf_paciente, String textView_senha_paciente,
                                       String textView_repetir_senha_paciente, Context context, MVPPaciente.IViewPacienteToast view) {

        this.textView_nome_paciente = textView_nome_paciente;
        this.textView_cpf_paciente = textView_cpf_paciente;
        this.textView_senha_paciente = textView_senha_paciente;
        this.textView_repetir_senha_paciente = textView_repetir_senha_paciente;
        this.context = context;
        this.view = view;

        this.dao = new ClasseDAO(this.context);
    }
    @Override
    public boolean createAccount(){
        try {
            paciente.setNome(textView_nome_paciente);
            paciente.setSenha(textView_senha_paciente);
            paciente.setCpf(textView_cpf_paciente);

            if(textView_nome_paciente.equals("") || textView_cpf_paciente.equals("")
                    || textView_senha_paciente.equals("") || textView_repetir_senha_paciente.equals("")){
                view.showToast("Há campos vazios!");
                return false;
            }
            else if(paciente.getSenha().equals(textView_repetir_senha_paciente)){
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
