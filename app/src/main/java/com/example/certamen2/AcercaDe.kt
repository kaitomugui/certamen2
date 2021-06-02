package com.example.certamen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AcercaDe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)

        val TextViewADV = findViewById<EditText>(R.id.TextViewADV)
        val TextViewADD = findViewById<EditText>(R.id.TextViewADD)
        val TextViewADC = findViewById<EditText>(R.id.TextViewADC)
        val ButtonASalir = findViewById<Button>(R.id.ButtonASalir)


        TextViewADV.text "Version 1.0.0"
        TextViewADD.text "Esta aplicacion es una base de datos con el cual puede ingresar nuevos datos modificarlos y eliminarlos sin generar conflictos entre un auto y otro"
        TextViewADC.text "Desarrolladores: Franco Ortega Humberto Ponce Joaquin Hernandez"











        ButtonASalir.setOnClickListener {
            finish()
        }
    }
}