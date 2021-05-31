package com.example.certamen2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLiteOpenHelper (context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int): SQLiteOpenHelper(context, name, factory, version){

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table autos (id int primary key AutoIncrement, marca text, numero_chasis int, cilindrada real, tipo_auto text, detalle text, precio_venta int, color text)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

}