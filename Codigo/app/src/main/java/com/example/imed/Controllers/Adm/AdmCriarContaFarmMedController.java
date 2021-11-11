package com.example.imed.Controllers.Adm;
import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.widget.Toast;
import com.example.imed.Controllers.Farmaceutico;
import com.example.imed.Controllers.Medico;
import com.example.imed.Database.ClasseDAO;

public class AdmCriarContaFarmMedController {

    private Medico medico = new Medico();
    private Farmaceutico farmaceutico = new Farmaceutico();
    private boolean isFarmaceutico;
    private String nomeFarmaceuticoMedico,crmOuCrf,senhaFarmaceuticoMedico,valor,repetir_senhaFarmaceuticoMedico;
    private Context context;
    private ClasseDAO dao;

    public AdmCriarContaFarmMedController(boolean isFarmaceutico, String nomeFarmaceuticoMedico, String crmOuCrf,
                                          String senhaFarmaceuticoMedico, String repetir_senhaFarmaceuticoMedico,String valor,Context context) {
        this.isFarmaceutico =isFarmaceutico;
        this.nomeFarmaceuticoMedico = nomeFarmaceuticoMedico;
        this.crmOuCrf = crmOuCrf;
        this.senhaFarmaceuticoMedico = senhaFarmaceuticoMedico;
        this.repetir_senhaFarmaceuticoMedico = repetir_senhaFarmaceuticoMedico;
        this.context = context;
        this.valor = valor;
        this.dao = new ClasseDAO(context);
    }


        public boolean makeAccount(){
            try{
                if(isFarmaceutico){
                    farmaceutico.setNome(nomeFarmaceuticoMedico);//Recebendo os valores dos textFields
                    farmaceutico.setCrf(crmOuCrf);
                    farmaceutico.setSenha(senhaFarmaceuticoMedico);
                    farmaceutico.setFk_adm_farm(valor);

                    if(nomeFarmaceuticoMedico.equals("") || crmOuCrf.equals("")
                            || senhaFarmaceuticoMedico.equals("") || repetir_senhaFarmaceuticoMedico.equals("")){

                        Toast.makeText(context, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                        return false;

                    }
                    else if (farmaceutico.getSenha().equals(repetir_senhaFarmaceuticoMedico)){
                        dao.inserirFarmaceutico(farmaceutico);
                        return true;

                    }
                    else{
                        Toast.makeText(context, "Os campos das senhas não são iguais", Toast.LENGTH_SHORT).show();
                        return false;

                    }
                }
                else{

                    medico.setNome(nomeFarmaceuticoMedico);//Recebendo os valores dos textFields
                    medico.setCrm(crmOuCrf);
                    medico.setSenha(senhaFarmaceuticoMedico);
                    medico.setFk_adm_med(valor);

                    if(nomeFarmaceuticoMedico.equals("") || crmOuCrf.equals("")
                            || senhaFarmaceuticoMedico.equals("")
                            || repetir_senhaFarmaceuticoMedico.equals("")){
                        Toast.makeText(context, "Há campos vazios!", Toast.LENGTH_SHORT).show();
                    return false;
                    }
                    else if(medico.getSenha().equals(repetir_senhaFarmaceuticoMedico)){
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
