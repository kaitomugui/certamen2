package com.example.certamen2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuOpciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_opciones)

        val bt1 = findViewById<Button>(R.id.bt1) // Boton Ingresar Automoviles
        val bt2 = findViewById<Button>(R.id.bt2) // Boton Mostrar
        val bt3 = findViewById<Button>(R.id.bt3) // Boton Modificar
        val bt4 = findViewById<Button>(R.id.bt4)  // Boton Eliminar
        val bt5 = findViewById<Button>(R.id.bt5) // Boton Acerca
        val bt6 = findViewById<Button>(R.id.bt6) //Boton Salir


        bt1.setOnClickListener {
            val acceso = Intent(this, CrearAuto::class.java)
            startActivity(acceso)
        }

        bt2.setOnClickListener {
            val acceso = Intent(this, VerAutos::class.java)
            startActivity(acceso)
        }

        bt3.setOnClickListener {
            val acceso = Intent(this, ModificarAuto::class.java)
            startActivity(acceso)
        }

        bt6.setOnClickListener {
            finish()
        }






    }
}