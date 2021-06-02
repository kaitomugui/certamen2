package com.example.certamen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class EliminarAutos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*setContentView(R.layout.activity_eliminar_auto)

 //La de ID
val idAutos = arrayListOf<String>()

//Base de Datos
val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
val bd = admin.writableDatabase
val buscarID = bd.rawQuery("select id from autos", null)

while(buscarID.moveToNext()){
   idAutos.add(buscarID.getInt(0).toString())
}
bd.close()

//Spinner Id Autos
val spIdAutos = findViewById<Spinner>(R.id.spIdAutos)
val adaptadorV1 = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, idAutos)
spIdAutos.adapter = adaptadorV1

//Variable de Text View
val tvMarca = findViewById<TextView>(R.id.tVMarca)
val tvChasis = findViewById<TextView>(R.id.tVNChasis)
val tvCilindrada = findViewById<TextView>(R.id.tVCilin)
val tvTipoAuto = findViewById<TextView>(R.id.tVTAuto)
val tvDetalle = findViewById<TextView>(R.id.tVDetalle)
val tvPrecio = findViewById<TextView>(R.id.tVPVenta)
val tvColor = findViewById<TextView>(R.id.tVCCarro)

//Variable Boton
val btEliminar = findViewById<Button>(R.id.btEliminar)
val btSalir = findViewById<Button>(R.id.btVSalir)


//Evento Mostrar al presionar boton eliminar
btEliminar.setOnClickListener {
   val adminEliminar = AdminSQLiteOpenHelper(this, "administracion", null, 1)
   val bdEliminar = adminEliminar.writableDatabase
   val datos = bdEliminar.rawQuery("delete from autos WHERE id = ${spIdAutos.selectedItem.toString()}", null)
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
}*/
}
}