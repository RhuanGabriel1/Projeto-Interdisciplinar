package com.example.imed.Presenters.Medico;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import com.example.imed.Database.ClasseDAO;
import com.example.imed.MVP.MVPMedico;
import com.example.imed.Presenters.Receita;

import java.util.Random;

public class MedicoGerarReceitaPresenter implements MVPMedico.IPresenterMedicoGerarReceita {

    private String cpfPacienteTextView, medicamentoTextView, dosagemTextView, frequenciaTextView, valor;
    private Context context;
    private ClasseDAO dao;
    private MVPMedico.IViewMedicoToast view;
    private Random random = new Random();
    private Receita receita = new Receita();

    public MedicoGerarReceitaPresenter(){}

    public MedicoGerarReceitaPresenter(String cpfPacienteTextView, String medicamentoTextView, String dosagemTextView,
                                       String frequenciaTextView,String valor, Context context, MVPMedico.IViewMedicoToast view){

        this.cpfPacienteTextView = cpfPacienteTextView;
        this.medicamentoTextView = medicamentoTextView;
        this.dosagemTextView = dosagemTextView;
        this.frequenciaTextView = frequenciaTextView;
        this.valor = valor;
        this.context = context;
        this.view = view;

        this.dao = new ClasseDAO(this.context);
    }

    @Override
    public boolean gerarReceita() {
        try {
            int idReceita = random.nextInt(5000) + 1000;

            receita.setIdReceita(idReceita+"");
            receita.setDosagem(dosagemTextView);
            receita.setHorario(frequenciaTextView);
            receita.setNomeRemedio(medicamentoTextView);
            receita.setFkPacienteReceita(cpfPacienteTextView);
            receita.setFkMedico(valor);

            dao.inserirFkCrmMed(valor, medicamentoTextView);
            dao.inserirFkIdReceita(idReceita, medicamentoTextView);

            if(cpfPacienteTextView.equals("") ||
                    medicamentoTextView.equals("") ||
                    dosagemTextView.equals("") ||
                    frequenciaTextView.equals("")){
                view.showToast("Há campos vazios!");
                return false;
            }
            else if(cpfPacienteTextView.length()>0 && cpfPacienteTextView.length()<12) {
                if(cpfPacienteTextView.equals(dao.retornaCPF(cpfPacienteTextView))){
                    dao.gerarReceita(receita);
                    view.showToast("Receita criada com sucesso");
                    return true;
                }
                else{
                    view.showToast("CPF ínvalido");
                    return false;
                }
            }
            else{
                view.showToast("CPF ínvalido");
                return false;
            }
        }
        catch (SQLiteConstraintException e){ //Repetimos o código caso o id de uma receita já criado tente inserir no banco e dados
            int idReceita = random.nextInt(5000) + 1000;

            receita.setIdReceita(idReceita+"");
            receita.setDosagem(dosagemTextView);
            receita.setHorario(frequenciaTextView);
            receita.setNomeRemedio(medicamentoTextView);
            receita.setFkPacienteReceita(cpfPacienteTextView);
            receita.setFkMedico(valor);

            dao.inserirFkCrmMed(valor, medicamentoTextView);
            dao.inserirFkIdReceita(idReceita, medicamentoTextView);

            if(cpfPacienteTextView.equals("")  ||
                    medicamentoTextView.equals("") ||
                    dosagemTextView.equals("") ||
                    frequenciaTextView.equals("")){
                view.showToast("Há campos vazios!");
                return false;
            }
            else if(cpfPacienteTextView.length()>0 && cpfPacienteTextView.length()<12) {
                if(cpfPacienteTextView.equals(dao.retornaCPF(cpfPacienteTextView))){
                    dao.gerarReceita(receita);
                    view.showToast("Receita criada com sucesso");
                    return true;
                }
                else{
                    view.showToast("CPF ínvalido");
                    return false;
                }
            }
            else{
                view.showToast("CPF ínvalido");
                return false;
            }
        }
    }

    @Override
    public void destruirView() { this.view = null; }
}
