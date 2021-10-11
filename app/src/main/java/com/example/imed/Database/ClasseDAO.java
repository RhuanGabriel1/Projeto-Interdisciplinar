
package com.example.imed.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.imed.Controllers.Farmaceutico;
import com.example.imed.Controllers.Medicamentos;
import com.example.imed.Controllers.Medico;
import com.example.imed.Controllers.Paciente;
import com.example.imed.Controllers.Receita;

import java.util.ArrayList;
import java.util.List;

public class ClasseDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ClasseDAO(Context context) {

        try {
            conexao = new Conexao(context);
            banco = conexao.getWritableDatabase();
        }catch (Exception e){
            Toast.makeText(context, "Conexão com o banco falhou", Toast.LENGTH_SHORT).show();
        }

    }

    public void abrir(){ }

    //Método para cadastrar um paciente
    public void inserirPaciente(Paciente paciente){
        ContentValues values = new ContentValues();
        values.put("cpf", paciente.getCpf());
        values.put("paciente_nome", paciente.getNome());
        values.put("paciente_senha", paciente.getSenha());
        banco.insertOrThrow("paciente",null,values);
    }//====================================//

    //Método para cadastrar um medico
    public void inserirMedico(Medico medico) {

        ContentValues values = new ContentValues();
        values.put("crm", medico.getCrm());
        values.put("med_nome", medico.getNome());
        values.put("med_senha", medico.getSenha());
        values.put("fk_adm_med", medico.getFk_adm_med());
        banco.insertOrThrow("medico",null,values);
    }
    //====================================//

    //Método para cadastrar um farmaceutico
    public void inserirFarmaceutico(Farmaceutico farmaceutico){
        ContentValues values = new ContentValues();
        values.put("crf", farmaceutico.getCrf());
        values.put("farm_nome",farmaceutico.getNome());
        values.put("farm_senha", farmaceutico.getSenha());
        values.put("fk_adm_farm", farmaceutico.getFk_adm_farm());
        banco.insertOrThrow("farmaceutico",null,values);
    }
    //====================================//

    //Método para cadastrar um medicamento
    public void inserirMedicamentos(Medicamentos medicamentos){
        ContentValues values = new ContentValues();
        values.put("catmat", medicamentos.getCatmat());
        values.put("nome_medicamento", medicamentos.getNome_medicamento());
        values.put("pr_ativo", medicamentos.getPr_ativo());
        values.put("concentracao", medicamentos.getConcentracao());
        values.put("fornecimento", medicamentos.getFornecimento());
        values.put("forma_farm",medicamentos.getForma_farm());
        values.put("fk_crf_farm", medicamentos.getFk_crf_farm());
        values.put("fk_crm_med", "");
        values.put("fk_idReceita", "");
        banco.insertOrThrow("medicamento", null, values);
    }
    //====================================//

    //Método para gerar uma receita
    public void gerarReceita(Receita receita){
        ContentValues values = new ContentValues();
        values.put("idReceita",receita.getIdReceita());
        values.put("nome_remedio", receita.getNome_remedio());
        values.put("horario", receita.getHorario());
        values.put("dosagem", receita.getDosagem());
        values.put("instrucoes", receita.getInstrucoes());
        values.put("fk_paciente_rec", receita.getFk_paciente_rec());
        values.put("fk_med", receita.getFk_med());
        values.put("fk_farm", "");

        banco.insertOrThrow("receita",null,values);
    }
    //====================================//

    // Método para atualizar os dados da tabela medicamento
    public void inserirFkIdReceita(int id, String nomeRemedio){
        banco.execSQL("UPDATE "+"medicamento"+" SET fk_idReceita = "+"'"+id+"' "+ "WHERE nome_medicamento = "+"'"+nomeRemedio+"'");
    }
    //====================================//

    // Método para atualizar os dados da tabela medicamento
    public void inserirFkCrmMed(String fkCrm, String nomeRemedio){
        banco.execSQL("UPDATE "+"medicamento"+" SET fk_crm_med = "+"'"+fkCrm+"' "+ "WHERE nome_medicamento = "+"'"+nomeRemedio+"'");
    }
    //====================================//

    // Método para atualizar os dados da tabela receita
    public void inserirFkFarm(String fkFarm, int id){
        banco.execSQL("UPDATE "+"receita"+" SET fk_farm = "+"'"+fkFarm+"' "+ "WHERE idReceita = "+"'"+id+"'");
    }
    //====================================//

    //Método para obter o login dos pacientes
    public Object[] obterLoginPaciente(String cpf){
        Object[] objeto = new Object[1];

        String busca = "select paciente_senha from paciente where cpf = " + "'" + cpf + "'";
        Cursor cursor = banco.rawQuery(busca, null);
        while (cursor.moveToNext()) {
            objeto[0] = cursor.getString(cursor.getColumnIndex("paciente_senha"));
        }
        cursor.close();
        return objeto;
    }
    //====================================//

    //Método para obter o login dos médicos
    public Object[] obterLoginMedico(String crm){
        Object[] objeto = new Object[1];

        String busca = "select med_senha from medico where crm =" + "'"+ crm +"'";
        Cursor cursor = banco.rawQuery(busca,null);
        while (cursor.moveToNext()) {
            objeto[0] = cursor.getString(cursor.getColumnIndex("med_senha"));
        }
        cursor.close();
        return objeto;
    }
    //====================================//

    //Método para obter o login dos farmacêuticos
    public Object[] obterLoginFarmaceutico(String crf){
        Object[] objeto = new Object[1];
        String busca = "select farm_senha from farmaceutico where crf =" + "'" + crf + "'";
        Cursor cursor = banco.rawQuery(busca,null);

        while (cursor.moveToNext()) {
            objeto[0] = cursor.getString(cursor.getColumnIndex("farm_senha"));
        }
        cursor.close();
        return objeto;
    }
    //====================================//

    //Método para obter o login dos adms
    public Object[] obterLoginAdm(String nome){
        Object[] objeto = new Object[1];

        String busca = "select adm_senha from adm where adm_nome = " + "'" + nome + "'";
        Cursor cursor = banco.rawQuery(busca,null);

        while (cursor.moveToNext()) {
            objeto[0] = cursor.getString(cursor.getColumnIndex("adm_senha"));
        }
        cursor.close();
        return objeto;
    }
    //====================================//

    //Método para retornar receita para o farmacêutico
    public Object[] obterReceita(String idReceita){
        Object[] objeto = new Object[6];
        String busca = "select idReceita, nome_remedio, horario, dosagem, instrucoes, fk_med from receita where idReceita = '"+ idReceita +"'";
        Cursor cursor = banco.rawQuery(busca, null);

        while (cursor.moveToNext()){
            objeto[0] = cursor.getString(cursor.getColumnIndex("idReceita"));
            objeto[1] = cursor.getString(cursor.getColumnIndex("nome_remedio"));
            objeto[2] = cursor.getString(cursor.getColumnIndex("horario"));
            objeto[3] = cursor.getString(cursor.getColumnIndex("dosagem"));
            objeto[4] = cursor.getString(cursor.getColumnIndex("instrucoes"));
            objeto[5] = cursor.getString(cursor.getColumnIndex("fk_med"));
        }
        cursor.close();

        return  objeto;
    }
    //====================================//

    //Método para o cpf do paciente
    public String retornaCPF(String cpf){
        String retornaCpf="";
        String busca ="select cpf from paciente where cpf=" + "'" + cpf + "'";
        Cursor cursor = banco.rawQuery(busca,null);
        while(cursor.moveToNext()){
            retornaCpf = cursor.getString(cursor.getColumnIndex("cpf"));
        }
        cursor.close();

        return  retornaCpf;
    }
    //====================================//

    //Método que retorna idReceita
    public  String retornaIdReceita(String idReceita){
        String retornaIdReceita = "";
        String busca = "select idReceita from receita where idReceita= '" + idReceita+ "'";
        Cursor cursor = banco.rawQuery(busca,null);

        while (cursor.moveToNext()){
            retornaIdReceita = cursor.getString(cursor.getColumnIndex("idReceita"));
        }
        cursor.close();

        return retornaIdReceita;
    }
    //====================================//

    //Método para obter a lista de farmacêuticos
    public List<Farmaceutico> obterListaFarmaceutico(){
        ArrayList<Farmaceutico> farmaceuticos = new ArrayList<>();
        Cursor cursor = banco.query("farmaceutico", new String[]{"crf","farm_nome"},null,null,null,null,null);
        while(cursor.moveToNext()) {
            Farmaceutico f = new Farmaceutico();
            f.setCrf(cursor.getString(cursor.getColumnIndex("crf")));
            f.setNome(cursor.getString(cursor.getColumnIndex("farm_nome")));
            farmaceuticos.add(f);
        }
        cursor.close();

        return farmaceuticos;
    }
    //====================================//
    //Método para obter a lista de médicos
    public List<Medico> obterListaMedico(){
        ArrayList<Medico> medicos = new ArrayList<>();
        Cursor cursor = banco.query("medico", new String[]{"crm", "med_nome"},null,null,null,null,null);

        while(cursor.moveToNext()){
            Medico m = new Medico();
            m.setCrm(cursor.getString(cursor.getColumnIndex("crm")));
            m.setNome(cursor.getString(cursor.getColumnIndex("med_nome")));
            medicos.add(m);
        }
        cursor.close();

        return medicos;
    }
    //====================================//

    //Método para obter a lista de receitas
    public List<Receita> obterListaReceita(String cpf){
        ArrayList<Receita> receitas = new ArrayList<>();
        Cursor cursor = banco.query("receita", new String[]{"idReceita","nome_remedio", "horario", "dosagem", "instrucoes" , "fk_med",}
        ,"fk_paciente_rec = "+cpf,null,null,null,null);

        while(cursor.moveToNext()){
            Receita r = new Receita();
            r.setIdReceita(cursor.getString(cursor.getColumnIndex("idReceita")));
            r.setNome_remedio(cursor.getString(cursor.getColumnIndex("nome_remedio")));
            r.setDosagem(cursor.getString(cursor.getColumnIndex("dosagem")));
            r.setHorario(cursor.getString(cursor.getColumnIndex("horario")));
            r.setInstrucoes(cursor.getString(cursor.getColumnIndex("instrucoes")));
            r.setFk_med(cursor.getString(cursor.getColumnIndex("fk_med")));
            receitas.add(r);
        }
        cursor.close();

        return receitas;
    }
    //====================================//

    //Método para obter a lista de medicamentos
    public List<Medicamentos> obterListaMedicamentos(){
        ArrayList<Medicamentos> medicamentos = new ArrayList<>();
        Cursor cursor = banco.query("medicamento", new String[]{"catmat","nome_medicamento","pr_ativo","concentracao","fornecimento","forma_farm"}
        ,null,null,null,null,null );

        while (cursor.moveToNext()) {
            Medicamentos me = new Medicamentos();
            me.setNome_medicamento(cursor.getString(cursor.getColumnIndex("nome_medicamento")));
            me.setCatmat(cursor.getString(cursor.getColumnIndex("catmat")));
            me.setPr_ativo(cursor.getString(cursor.getColumnIndex("pr_ativo")));
            me.setConcentracao(cursor.getString(cursor.getColumnIndex("concentracao")));
            me.setFornecimento(cursor.getString(cursor.getColumnIndex("fornecimento")));
            me.setForma_farm(cursor.getString(cursor.getColumnIndex("forma_farm")));
            medicamentos.add(me);
        }
        cursor.close();

        return medicamentos;
    }
    //====================================//


    //método para deletar contas de médicos
    public void deletarContaMedico(String m){
        banco.delete("medico", "crm = ?", new String[]{m});
    }
    //====================================//

    //método para deletar contas de farmacêuticos
    public void deletarContaFarmaceutico(String f){
        banco.delete("farmaceutico", "crf = ?", new String[]{f});
    }
    //====================================//



}
