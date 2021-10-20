package com.example.imed.Controllers.Adm;

import android.content.Context;

import com.example.imed.Controllers.Farmaceutico.Farmaceutico;
import com.example.imed.Controllers.Medico.Medico;
import com.example.imed.Database.ClasseDAO;

import java.util.List;

public class AdmExcluirContaController {

    private boolean radioButton_farmaceutico_lista;
    private List<Farmaceutico> farmaceuticos;
    private List<Medico> medicos;
    private Farmaceutico itemFarm;
    private Medico itemMed;
    private Context context;
    private ClasseDAO dao;




    public AdmExcluirContaController(boolean radioButton_farmaceutico_lista, List<Farmaceutico> farmaceuticos, List<Medico> medicos,
                                     Farmaceutico itemFarm, Medico itemMed, Context context){
        this.radioButton_farmaceutico_lista = radioButton_farmaceutico_lista;
        this.farmaceuticos = farmaceuticos;
        this.medicos = medicos;
        this.itemFarm = itemFarm;
        this.itemMed = itemMed;
        this.context = context;
        this.dao = new ClasseDAO(this.context);
    }

    public void deleteAccount(){
        if(radioButton_farmaceutico_lista) {
            farmaceuticos.remove(itemFarm);
            dao.deletarContaFarmaceutico(itemFarm.getCrf());
        }
        else{
            medicos.remove(itemMed);
            dao.deletarContaMedico(itemMed.getCrm());
        }
    }

}
