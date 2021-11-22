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

        db.execSQL("create table medico(crm varchar (7) primary key not null, " +
                "med_nome varchar(29), " +
                "med_senha varchar(20) not null)");

        db.execSQL("create table farmaceutico(crf varchar(7) primary key not null, " +
                "farm_nome varchar(29)," +
                "farm_senha varchar(20) not null)");

        db.execSQL("create table paciente(cpf varchar(11) primary key not null," +
                "paciente_nome varchar(29) ," +
                "paciente_senha varchar(20) not null)");

        db.execSQL("create table receita(idReceita integer primary key not null," +
                "nome_remedio varchar(29) not null, "+
                "horario varchar(29) not null," +
                "dosagem varchar(29) not null," +
                "fk_paciente_rec varchar(11) not null," +
                "fk_farm varchar(7) not null," +
                "fk_med varchar(7) not null," +
                "foreign key(fk_paciente_rec) references paciente(cpf)," +
                "foreign key(fk_farm) references farmaceutico(crf)," +
                "foreign key(fk_med) references medico(crm))");


        db.execSQL("insert into paciente(cpf,paciente_nome,paciente_senha) values('18693915002','Juraci de Oliveira','senhapaciente')");
        db.execSQL("insert into paciente(cpf,paciente_nome,paciente_senha) values('05925005007','Eduardo Trevisoli','senhapaciente')");
        db.execSQL("insert into paciente(cpf,paciente_nome,paciente_senha) values('12345678901','Rodrigo Magalhães','senhapaciente')");

        db.execSQL("insert into farmaceutico(crf,farm_nome,farm_senha) values('1000000','Geraldo Silva','senhafarmaceutico')");
        db.execSQL("insert into farmaceutico(crf,farm_nome,farm_senha) values('1100000','Luka Salomão','senhafarmaceutico')");
        db.execSQL("insert into farmaceutico(crf,farm_nome,farm_senha) values('1234567','Marcelo Trevisoli','senhafarmaceutico')");

        db.execSQL("insert into medico(crm,med_nome,med_senha) values('1000000','Marcio Ballas','senhamedico')");
        db.execSQL("insert into medico(crm,med_nome,med_senha) values('1100000','Elidio Sanna','senhamedico')");
        db.execSQL("insert into medico(crm,med_nome,med_senha) values('1234567','Daniel Tausig','senhamedico')");

        db.execSQL("insert into receita(idReceita,nome_remedio,horario,dosagem,fk_paciente_rec,fk_farm,fk_med)" +
                "values('1001', 'Loratadina','Tomar a cada 8 horas','10 mg', '12345678901','1000000', '1000000')");
        db.execSQL("insert into receita(idReceita,nome_remedio,horario,dosagem,fk_paciente_rec,fk_farm,fk_med)" +
                "values('1002', 'Omeprazol','Tomar a cada 12 horas','10 mg', '05925005007','1100000', '1100000')");
        db.execSQL("insert into receita(idReceita,nome_remedio,horario,dosagem,fk_paciente_rec,fk_farm,fk_med)" +
                "values('1003', 'Nicotina','Tomar a cada 1 hora','14 mg', '18693915002','1234567', '1234567')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

}
