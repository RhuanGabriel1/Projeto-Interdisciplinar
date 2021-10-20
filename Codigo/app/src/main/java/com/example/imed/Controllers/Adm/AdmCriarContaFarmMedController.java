package com.example.imed.Controllers.Adm;
import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.widget.Toast;
import com.example.imed.Controllers.Farmaceutico;
import com.example.imed.Controllers.Medico.Medico;
import com.example.imed.Database.ClasseDAO;

public class AdmCriarContaFarmMedController {

    private Medico medico = new Medico();
    private Farmaceutico farmaceutico = new Farmaceutico();
    private boolean isFarmaceutico;
    private String nome_farm_med,crm_crf,senha_farm_med,valor,repetir_senha_farm_med;
    private Context context;
    private ClasseDAO dao;

    public AdmCriarContaFarmMedController(boolean isFarmaceutico, String nome_farm_med, String crm_crf,
                                          String senha_farm_med, String repetir_senha_farm_med,String valor,Context context) {
        this.isFarmaceutico =isFarmaceutico;
        this.nome_farm_med = nome_farm_med;
        this.crm_crf = crm_crf;
        this.senha_farm_med = senha_farm_med;
        this.repetir_senha_farm_med = repetir_senha_farm_med;
        this.context = context;
        this.valor = valor;
        this.dao = new ClasseDAO(context);
    }


        public boolean makeAccount(){
            try{
                if(isFarmaceutico){
                    farmaceutico.setNome(nome_farm_med);//Recebendo os valores dos textFields
                    farmaceutico.setCrf(crm_crf);
                    farmaceutico.setSenha(senha_farm_med);
                    farmaceutico.setFk_adm_farm(valor);

                    if(nome_farm_med.equals("") || crm_crf.equals("")
                            || senha_farm_med.equals("") || repetir_senha_farm_med.equals("")){
                        Toast.makeText(context, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                        return false;

                    }
                    else if (farmaceutico.getSenha().equals(repetir_senha_farm_med)){
                        dao.inserirFarmaceutico(farmaceutico);
                        return true;
                    }
                    else{
                        Toast.makeText(context, "Os campos das senhas não são iguais", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
                else{
                    medico.setNome(nome_farm_med);//Recebendo os valores dos textFields
                    medico.setCrm(crm_crf);
                    medico.setSenha(senha_farm_med);
                    medico.setFk_adm_med(valor);

                    if(nome_farm_med.equals("") || crm_crf.equals("")
                            || senha_farm_med.equals("")
                            || repetir_senha_farm_med.equals("")){
                        Toast.makeText(context, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                    return false;
                    }
                    else if(medico.getSenha().equals(repetir_senha_farm_med)){
                        dao.inserirMedico(medico);
                        Toast.makeText(context, "Conta criada com sucesso!", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                    else{
                        Toast.makeText(context, "Os campos das senhas não são iguais", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                }
            }catch (SQLiteConstraintException e){
                Toast.makeText(context, "Esse CRM/CRF já foi cadastrado!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
}
