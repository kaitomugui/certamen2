package com.example.certamen2

import android.content.ContentValues
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
                when(datosM1.getString(4)){
                   "Sedan" -> spMTipoAuto.setSelection(0)
                    "SUV" -> spMTipoAuto.setSelection(1)
                    "PickUp" -> spMTipoAuto.setSelection(2)
                }
                edtMDetalle.setText(datosM1.getString(5))
                edtMPrecio.setText(datosM1.getString(6))
                edtMColor.setText(datosM1.getString(7))

            } else
                Toast.makeText(this, "No existe un Auto con dicha id", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        botonModificar.setOnClickListener {
            if(edtMMarca.text.toString().length == 0 || edtMChasis.text.toString().length == 0 || edtMCilindrada.text.toString().length == 0 || edtMDetalle.text.toString().length == 0
                || edtMPrecio.text.toString().length == 0 || edtMColor.text.toString().length == 0) {
                Toast.makeText(this, "Los campos no pueden quedar vacíos", Toast.LENGTH_LONG).show()
            } else {
                val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
                val bd = admin.writableDatabase
                val registro = ContentValues()
                registro.put("marca", edtMMarca.getText().toString())
                registro.put("numero_chasis", edtMChasis.getText().toString())
                registro.put("cilindrada", edtMCilindrada.getText().toString())
                registro.put("tipo_auto", spMTipoAuto.selectedItem.toString())
                registro.put("detalle", edtMDetalle.getText().toString())
                registro.put("precio_venta", edtMPrecio.getText().toString())
                registro.put("color", edtMColor.getText().toString())
                val cant = bd.update("autos", registro, "id=${spMIdAutos.selectedItem.toString()}", null)
                bd.close()
                if (cant == 1) {
                    Toast.makeText(this, "Se modificaron los datos correctamente", Toast.LENGTH_SHORT).show()
                    finish()
                }else
                    Toast.makeText(this, "no existe un auto con el id seleccionado", Toast.LENGTH_SHORT).show()
            }
        }

        botonSalir.setOnClickListener {
            finish()
        }

    }
}