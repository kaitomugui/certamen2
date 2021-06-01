package com.example.certamen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class VerAutos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_autos)

        //Lista de ID
        val idAutos = arrayListOf<String>()

        //Baso de Datos
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val bd = admin.writableDatabase
        val buscarID = bd.rawQuery("select id from autos", null)

        while(buscarID.moveToNext()){
            idAutos.add(buscarID.getInt(0).toString())
        }
        bd.close()

        //Spinner Id Autos
        val spVIdAutos = findViewById<Spinner>(R.id.spVIdAutos)
        val adaptadorV1 = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, idAutos)
        spVIdAutos.adapter = adaptadorV1

        //Variable de Text View
        val tvMarca = findViewById<TextView>(R.id.tvVMarca)
        val tvChasis = findViewById<TextView>(R.id.tvVChasis)
        val tvCilindrada = findViewById<TextView>(R.id.tvVCilindrada)
        val tvTipoAuto = findViewById<TextView>(R.id.tvVTipoAuto)
        val tvDetalle = findViewById<TextView>(R.id.tvVDetalle)
        val tvPrecio = findViewById<TextView>(R.id.tvVPrecio)
        val tvColor = findViewById<TextView>(R.id.tvVColor)

        //Variable Boton
        val btMostrar = findViewById<Button>(R.id.btVMostrar)
        val btSalir = findViewById<Button>(R.id.btVSalir)


        //Evento Mostrar al apretrar boton
        btMostrar.setOnClickListener {
            val adminMostrar = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bdMostrar = adminMostrar.writableDatabase
            val datos = bdMostrar.rawQuery("select * from autos WHERE id = ${spVIdAutos.selectedItem.toString()}", null)
            if (datos.moveToFirst()) {
                tvMarca.setText(datos.getString(1))
                tvChasis.setText(datos.getString(2))
                tvCilindrada.setText(datos.getString(3))
                tvTipoAuto.setText(datos.getString(4))
                tvDetalle.setText(datos.getString(5))
                tvPrecio.setText(datos.getString(6))
                tvColor.setText(datos.getString(7))

            } else
                Toast.makeText(this, "No existe un artículo con dicha id", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        btSalir.setOnClickListener {
            finish()
        }
    }
}