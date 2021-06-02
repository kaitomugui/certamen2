package com.example.certamen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AcercaDe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)

        val TextViewADV = findViewById<TextView>(R.id.TextViewADV)
        val TextViewADD = findViewById<TextView>(R.id.TextViewADD)
        val TextViewADC = findViewById<TextView>(R.id.TextViewADC)
        val buttonASalir = findViewById<TextView>(R.id.buttonASalir)


        TextViewADV.setText("Version 1.0.0")
        TextViewADD.setText("Esta aplicacion es una base de datos con el cual puede ingresar nuevos datos modificarlos y eliminarlos sin generar conflictos entre un auto y otro")
        TextViewADC.setText("Desarrolladores: Franco Ortega Humberto Ponce Joaquin Hernandez")











        buttonASalir.setOnClickListener {
            finish()
        }
    }
}