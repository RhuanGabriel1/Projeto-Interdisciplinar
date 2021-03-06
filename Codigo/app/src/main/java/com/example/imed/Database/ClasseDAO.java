
package com.example.imed.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.imed.Model.Usuarios.Farmaceutico;
import com.example.imed.Model.Usuarios.Medico;
import com.example.imed.Model.Usuarios.Paciente;
import com.example.imed.Model.Usuarios.Receita;

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

    public void inserirPaciente(Paciente paciente){
        ContentValues values = new ContentValues();
        values.put("cpf", paciente.getCpf());
        values.put("paciente_nome", paciente.getNome());
        values.put("paciente_senha", paciente.getSenha());
        banco.insertOrThrow("paciente",null,values);
    }

    public void inserirMedico(Medico medico) {

        ContentValues values = new ContentValues();
        values.put("crm", medico.getCrm());
        values.put("med_nome", medico.getNome());
        values.put("med_senha", medico.getSenha());
        banco.insertOrThrow("medico",null,values);
    }

    public void inserirFarmaceutico(Farmaceutico farmaceutico){
        ContentValues values = new ContentValues();
        values.put("crf", farmaceutico.getCrf());
        values.put("farm_nome",farmaceutico.getNome());
        values.put("farm_senha", farmaceutico.getSenha());
        banco.insertOrThrow("farmaceutico",null,values);
    }

    public void gerarReceita(Receita receita){
        ContentValues values = new ContentValues();
        values.put("idReceita",receita.getIdReceita());
        values.put("nome_remedio", receita.getNomeRemedio());
        values.put("horario", receita.getHorario());
        values.put("dosagem", receita.getDosagem());
        values.put("fk_paciente_rec", receita.getFkPacienteReceita());
        values.put("fk_med", receita.getFkMedico());
        values.put("fk_farm", "");

        banco.insertOrThrow("receita",null,values);
    }


    public String obterLoginPaciente(String cpf){
       String resultado = "-";

        String busca = "select paciente_senha from paciente where cpf = " + "'" + cpf + "'";
        Cursor cursor = banco.rawQuery(busca, null);
        while (cursor.moveToNext()) {
            resultado  = cursor.getString(cursor.getColumnIndex("paciente_senha"));
        }
        cursor.close();
        return resultado;
    }

    public String obterLoginMedico(String crm){
        String resultado = "-";

        String busca = "select med_senha from medico where crm =" + "'"+ crm +"'";
        Cursor cursor = banco.rawQuery(busca,null);
        while (cursor.moveToNext()) {
            resultado = cursor.getString(cursor.getColumnIndex("med_senha"));
        }
        cursor.close();
        return resultado;
    }

    public String obterLoginFarmaceutico(String crf){
        String resultado = "-";

        String busca = "select farm_senha from farmaceutico where crf =" + "'" + crf + "'";
        Cursor cursor = banco.rawQuery(busca,null);

        while (cursor.moveToNext()) {
            resultado = cursor.getString(cursor.getColumnIndex("farm_senha"));
        }
        cursor.close();
        return resultado;
    }

    public Object[] obterReceita(String idReceita){
        Object[] objeto = new Object[5];
        String busca = "select idReceita, nome_remedio, horario, dosagem, fk_med from receita where idReceita = '"+ idReceita +"'";
        Cursor cursor = banco.rawQuery(busca, null);

        while (cursor.moveToNext()){
            objeto[0] = cursor.getString(cursor.getColumnIndex("idReceita"));
            objeto[1] = cursor.getString(cursor.getColumnIndex("nome_remedio"));
            objeto[2] = cursor.getString(cursor.getColumnIndex("horario"));
            objeto[3] = cursor.getString(cursor.getColumnIndex("dosagem"));
            objeto[4] = cursor.getString(cursor.getColumnIndex("fk_med"));
        }
        cursor.close();

        return  objeto;
    }

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

    public List<Receita> obterListaReceita(String cpf){
        ArrayList<Receita> receitas = new ArrayList<>();
        Cursor cursor = banco.query("receita", new String[]{"idReceita","nome_remedio", "horario", "dosagem", "fk_med",}
        ,"fk_paciente_rec = "+cpf,null,null,null,null);

        while(cursor.moveToNext()){
            Receita r = new Receita();
            r.setIdReceita(cursor.getString(cursor.getColumnIndex("idReceita")));
            r.setNomeRemedio(cursor.getString(cursor.getColumnIndex("nome_remedio")));
            r.setDosagem(cursor.getString(cursor.getColumnIndex("dosagem")));
            r.setHorario(cursor.getString(cursor.getColumnIndex("horario")));
            r.setFkMedico(cursor.getString(cursor.getColumnIndex("fk_med")));
            receitas.add(r);
        }
        cursor.close();

        return receitas;
    }

    public void inserirFkFarm(String fkFarm, int id){
        banco.execSQL("UPDATE "+"receita"+" SET fk_farm = "+"'"+fkFarm+"' "+ "WHERE idReceita = "+"'"+id+"'");
    }


    public void deletarContaPaciente(String paciente){
        banco.delete("paciente", "crf = ?", new String[]{paciente});
    }

    public void deletarContaFarmaceutico(String f){
        banco.delete("farmaceutico", "crf = ?", new String[]{f});
    }

    public void deletarContaMedico(String m){
        banco.delete("medico", "crm = ?", new String[]{m});
    }
}
