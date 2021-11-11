package com.example.imed.Presenters.Paciente;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.widget.Toast;

import com.example.imed.Database.ClasseDAO;

public class PacienteCriarContaPresenter {


    private Paciente paciente = new Paciente();
    private String textView_senha_paciente,textView_repetir_senha_paciente, textView_nome_paciente,textView_cpf_paciente;
    private Context context;
    private ClasseDAO dao;

    public PacienteCriarContaPresenter(String textView_nome_paciente, String textView_cpf_paciente, String textView_senha_paciente,
                                       String textView_repetir_senha_paciente, Context context){

        this.textView_nome_paciente = textView_nome_paciente;
        this.textView_cpf_paciente = textView_cpf_paciente;
        this.textView_senha_paciente = textView_senha_paciente;
        this.textView_repetir_senha_paciente = textView_repetir_senha_paciente;

        this.context = context;
        this.dao = new ClasseDAO(this.context);
    }

    public boolean createAccount(){
        try {
            paciente.setNome(textView_nome_paciente);
            paciente.setSenha(textView_senha_paciente);
            paciente.setCpf(textView_cpf_paciente);

            if(textView_nome_paciente.equals("") || textView_cpf_paciente.equals("")
                    || textView_senha_paciente.equals("") || textView_repetir_senha_paciente.equals("")){

                Toast.makeText(context, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                return false;
            }
            else if(paciente.getSenha().equals(textView_repetir_senha_paciente)){
                dao.inserirPaciente(paciente);
                Toast.makeText(context, "Conta criada com sucesso!", Toast.LENGTH_SHORT).show();
                return true;
            }
            else {
                Toast.makeText(context, "Os campos das senhas não são iguais", Toast.LENGTH_SHORT).show();
                return false;
            }
        }catch (SQLiteConstraintException e){
            Toast.makeText(context, "Esse CPF já foi cadastrado", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
