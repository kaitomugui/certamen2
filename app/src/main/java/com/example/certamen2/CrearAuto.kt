package com.example.certamen2

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class CrearAuto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_auto)

        //Variables Edit Text
        val edMarca = findViewById<EditText>(R.id.edtCMarca)
        val edChasis = findViewById<EditText>(R.id.edtCChasis)
        val edCilindrada = findViewById<EditText>(R.id.edtCCilindrada)
        val edDescripcion = findViewById<EditText>(R.id.edtCDescripcion)
        val edPrecio = findViewById<EditText>(R.id.edtCPrecio)
        val edColor = findViewById<EditText>(R.id.edtCColor)

        //Spinner Tipo Auto
        val spTipoAuto = findViewById<Spinner>(R.id.spCTipoAuto)
        val tipoAuto = arrayListOf<String>("Sedan","SUV","PickUp") // Sedán, SUV, PickUp
        val adaptadorC1 = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, tipoAuto)
        spTipoAuto.adapter = adaptadorC1

        //Variables Botones
        val botonCrear = findViewById<Button>(R.id.btCCrear)
        val botonReset = findViewById<Button>(R.id.btCReset)
        val botonSalir = findViewById<Button>(R.id.btCSalir)

        //Evento para crear auto
        botonCrear.setOnClickListener {
            if(edMarca.text.toString().length == 0 || edChasis.text.toString().length == 0 || edCilindrada.text.toString().length == 0 || edDescripcion.text.toString().length == 0
                || edPrecio.text.toString().length == 0 || edColor.text.toString().length == 0) {
                Toast.makeText(this, "Los campos no pueden quedar vacíos", Toast.LENGTH_LONG).show()
            } else {
                val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
                val bd = admin.writableDatabase
                val registro = ContentValues()
                registro.put("marca", edMarca.getText().toString())
                registro.put("numero_chasis", edChasis.getText().toString())
                registro.put("cilindrada", edCilindrada.getText().toString())
                registro.put("tipo_auto", spTipoAuto.selectedItem.toString())
                registro.put("detalle", edDescripcion.getText().toString())
                registro.put("precio_venta", edPrecio.getText().toString())
                registro.put("color", edColor.getText().toString())
                bd.insert("autos", null, registro)
                bd.close()
                Toast.makeText(this, "Se cargaron los datos del Auto", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        //Evento para limpiar formulario
        botonReset.setOnClickListener {
            edMarca.setText("")
            edChasis.setText("")
            edCilindrada.setText("")
            edColor.setText("")
            edDescripcion.setText("")
            edPrecio.setText("")
        }

        //Evento para salir del crear
        botonSalir.setOnClickListener {
            finish()
        }


    }
}