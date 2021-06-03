package com.example.certamen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class EliminarAuto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar_auto)

        //Lista que almacena las ID
        val idAutos = arrayListOf<String>()

        //Base de Datos
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val bd = admin.writableDatabase
        val buscarID = bd.rawQuery("select id from autos", null)

        while (buscarID.moveToNext()) {
            idAutos.add(buscarID.getInt(0).toString())
        }
        bd.close()

        //Spinner Id Autos
        val spIdAutos = findViewById<Spinner>(R.id.spEAutos)
        val adaptadorV1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, idAutos)
        spIdAutos.adapter = adaptadorV1

        //Variable Boton
        val btEliminar = findViewById<Button>(R.id.btEliminar)
        val btSalir = findViewById<Button>(R.id.btESalir)


        //Evento Para eliminar el un auto
        btEliminar.setOnClickListener {
            val adminEliminar = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bdEliminar = adminEliminar.writableDatabase
            val cant = bdEliminar.delete("autos", "id=${spIdAutos.selectedItem.toString()}", null)
            bd.close()
            if (cant == 1) {
                Toast.makeText(this, "Se ha eliminado el auto correctamente", Toast.LENGTH_SHORT).show()
                finish()
            } else
                Toast.makeText(this, "No existe un auto con dicha id", Toast.LENGTH_SHORT).show()

        }

        btSalir.setOnClickListener {
            finish()

        }
    }
}