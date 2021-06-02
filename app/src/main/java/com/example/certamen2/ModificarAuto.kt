package com.example.certamen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ModificarAuto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_auto)

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
        val spMIdAutos = findViewById<Spinner>(R.id.spMIdAutos)
        val adaptadorM1 = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, idAutos)
        spMIdAutos.adapter = adaptadorM1

        //Variables Edit Text
        val edtMMarca = findViewById<EditText>(R.id.edtMMarca)
        val edtMChasis = findViewById<EditText>(R.id.edtMChasis)
        val edtMCilindrada = findViewById<EditText>(R.id.edtMCilindrada)
        val edtMDetalle = findViewById<EditText>(R.id.edtMDetalle)
        val edtMColor = findViewById<EditText>(R.id.edtMColor)
        val edtMPrecio = findViewById<EditText>(R.id.edtMPrecio)

        //Spinner Tipo Auto
        val spMTipoAuto = findViewById<Spinner>(R.id.spMTipoAuto)
        val tipoAuto = arrayListOf<String>("Sedan","SUV","PickUp") // Sedán, SUV, PickUp
        val adaptadorM2 = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, tipoAuto)
        spMTipoAuto.adapter = adaptadorM2

        //Variables Botones
        val botonSalir = findViewById<Button>(R.id.btMSalir)
        val botonModificar = findViewById<Button>(R.id.btMModificar)
        val botonSeleccionar = findViewById<Button>(R.id.btMSeleccionar)

        botonSeleccionar.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val datosM1 = bd.rawQuery("select * from autos where id='${spMIdAutos.selectedItem.toString()}'", null)
            if (datosM1.moveToFirst()) {
                edtMMarca.setText(datosM1.getString(1))
                edtMChasis.setText(datosM1.getString(2))
                edtMCilindrada.setText(datosM1.getString(3))
                //spMTipoAuto.selectedItem
                edtMDetalle.setText(datosM1.getString(5))
                edtMColor.setText(datosM1.getString(6))
                edtMPrecio.setText(datosM1.getString(7))


            } else
                Toast.makeText(this, "No existe un artículo con dicha descripción", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        botonModificar.setOnClickListener {

        }

        botonSalir.setOnClickListener {
            finish()
        }

    }
}