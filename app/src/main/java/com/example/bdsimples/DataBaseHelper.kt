package com.example.bdsimples

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context): SQLiteOpenHelper (
    /*parâmetros do construtor
    * contexto
    * nome do banco de dados
    * cursor personalizado (não vamos utilizar)
    * versão */
    context,
    "simples.db",
    null,
    1) {

    override fun onCreate(db: SQLiteDatabase?) {
       var sql = "create table if NOT EXISTS cadastroPessoa(id_pessoa integer NOT null PRIMARY KEY AUTOINCREMENT, nome Varchar(60))";

        try {
            db?.execSQL(sql)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}