package com.example.imed.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {
    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    private static final String name = "banco.db";
    private static final int version = 1;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Pragma foreign_keys = ON;");

        db.execSQL("create table adm(adm_nome varchar(29) primary key not null, " +
                "adm_senha varchar(20))");

        db.execSQL("create table medico(crm varchar (7) primary key not null, " +
                "med_nome varchar(29), " +
                "med_senha varchar(20) not null, " +
                "fk_adm_med varchar (29) not null," +
                "foreign key (fk_adm_med) references adm(adm_nome))");

        db.execSQL("create table farmaceutico(crf varchar(7) primary key not null, " +
                "farm_nome varchar(29)," +
                "farm_senha varchar(20) not null," +
                "fk_adm_farm varchar(29) not null," +
                "foreign key (fk_adm_farm) references adm(adm_nome))");

        db.execSQL("create table paciente(cpf varchar(11) primary key not null," +
                "paciente_nome varchar(29) ," +
                "paciente_senha varchar(20) not null)");

        db.execSQL("create table receita(idReceita integer primary key not null," +
                "nome_remedio varchar(29) not null, "+
                "horario varchar(29) not null," +
                "dosagem varchar(29) not null," +
                "instrucoes varchar(29)not null," +
                "fk_paciente_rec varchar(11) not null," +
                "fk_farm varchar(7) not null," +
                "fk_med varchar(7) not null," +
                "foreign key(fk_paciente_rec) references paciente(cpf)," +
                "foreign key(fk_farm) references farmaceutico(crf)," +
                "foreign key(fk_med) references medico(crm))");

        db.execSQL("create table medicamento(catmat varchar(12) primary key not null," +
                "nome_medicamento varchar(29),"+
                "concentracao varchar(29) not null," +
                "pr_ativo varchar(29) not null, " +
                "fornecimento varchar(29) not null," +
                "forma_farm varchar(29) not null," +
                "fk_idReceita integer not null," +
                "fk_crm_med varchar(7) not null," +
                "fk_crf_farm varchar(7) not null," +
                "foreign key(fk_idReceita) references receita(idReceita)," +
                "foreign key(fk_crm_med) references medico(crm)," +
                "foreign key(fk_crf_farm) references farmaceutico(crf))");

        db.execSQL("insert into adm(adm_nome, adm_senha) values('contaadm','senhaadm')");
        db.execSQL("insert into adm(adm_nome, adm_senha) values('adm','123')");
        db.execSQL("insert into adm(adm_nome, adm_senha) values('Rhuan Martins','senharhuanadm')");
        db.execSQL("insert into adm(adm_nome, adm_senha) values('Luciano Moura','senhalucianoadm')");
        
        db.execSQL("insert into paciente(cpf,paciente_nome,paciente_senha) values('18693915002','Juraci de Oliveira','senhapaciente')");
        db.execSQL("insert into paciente(cpf,paciente_nome,paciente_senha) values('05925005007','Eduardo Trevisoli','senhapaciente')");
        db.execSQL("insert into paciente(cpf,paciente_nome,paciente_senha) values('12345678901','Rodrigo Magalhães','senhapaciente')");

        db.execSQL("insert into farmaceutico(crf,farm_nome,farm_senha,fk_adm_farm) values('1000000','Geraldo Silva','senhafarmaceutico','adm')");
        db.execSQL("insert into farmaceutico(crf,farm_nome,farm_senha,fk_adm_farm) values('1100000','Luka Salomão','senhafarmaceutico','adm')");
        db.execSQL("insert into farmaceutico(crf,farm_nome,farm_senha,fk_adm_farm) values('1234567','Marcelo Trevisoli','senhafarmaceutico','adm')");

        db.execSQL("insert into medico(crm,med_nome,med_senha,fk_adm_med) values('1000000','Marcio Ballas','senhamedico','adm')");
        db.execSQL("insert into medico(crm,med_nome,med_senha,fk_adm_med) values('1100000','Elidio Sanna','senhamedico','adm')");
        db.execSQL("insert into medico(crm,med_nome,med_senha,fk_adm_med) values('1234567','Daniel Tausig','senhamedico','adm')");

        db.execSQL("insert into medicamento(catmat,nome_medicamento,concentracao,pr_ativo,fornecimento,forma_farm,fk_crf_farm,fk_crm_med,fk_idReceita) " +
                "values('BR0273466','Loratamed','10 mg','Loratadina','Comprimido','Comprimido','1000000','1000000','1001')");
        db.execSQL("insert into medicamento(catmat,nome_medicamento,concentracao,pr_ativo,fornecimento,forma_farm,fk_crf_farm,fk_crm_med,fk_idReceita) " +
                "values('BR0376106','Nicotinell','14 mg','Nicotina','Unidade','Adesivo transdérmico','1100000','1100000','1002')");
        db.execSQL("insert into medicamento(catmat,nome_medicamento,concentracao,pr_ativo,fornecimento,forma_farm,fk_crf_farm,fk_crm_med,fk_idReceita) " +
                "values('BR0267711','GastroBlock','10 mg','Omeprazol','Cápsula','Cápsula','1234567','1234567','1003')");
        db.execSQL("insert into medicamento(catmat,nome_medicamento,concentracao,pr_ativo,fornecimento,forma_farm,fk_crf_farm,fk_crm_med,fk_idReceita) " +
                "values('BR20J2456','Neosoro','0,5mg/ml','Cloridrato de nasazolina','Frasco gotejador', 'Frasco gotejador', '1234567','1000000','1003')");

        db.execSQL("insert into receita(idReceita,nome_remedio,horario,dosagem,instrucoes,fk_paciente_rec,fk_farm,fk_med)" +
                "values('1001', 'Loratadina','Tomar a cada 8 horas','10 mg','Tomar antes de comer', '12345678901','1000000', '1000000')");
        db.execSQL("insert into receita(idReceita,nome_remedio,horario,dosagem,instrucoes,fk_paciente_rec,fk_farm,fk_med)" +
                "values('1002', 'Omeprazol','Tomar a cada 12 horas','10 mg','Tomar depois de comer', '05925005007','1100000', '1100000')");
        db.execSQL("insert into receita(idReceita,nome_remedio,horario,dosagem,instrucoes,fk_paciente_rec,fk_farm,fk_med)" +
                "values('1003', 'Nicotina','Tomar a cada 1 hora','14 mg','Sempre que a vontade aparecer', '18693915002','1234567', '1234567')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}
