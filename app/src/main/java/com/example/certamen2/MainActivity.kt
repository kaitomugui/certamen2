package com.example.certamen2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usuario = "uvm"
        val password = "pwm2021"

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etContra = findViewById<EditText>(R.id.etContra)

        val btLogin = findViewById<Button>(R.id.btLogin)
        val btReset = findViewById<Button>(R.id.btReset)

        btLogin.setOnClickListener {
            if(etContra.text.toString().length == 0 || etUsuario.text.toString().length == 0) {
                Toast.makeText(this, "Los campos no pueden quedar vacíos", Toast.LENGTH_LONG).show()
            } else if(etUsuario.text.toString() == usuario && etContra.text.toString() == password) {
                Toast.makeText(this, "Conexion Correcta", Toast.LENGTH_LONG).show()
                val acceso = Intent(this, MenuOpciones::class.java)
                startActivity(acceso)
            }else{
                Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_LONG).show()
            }
        }

        btReset.setOnClickListener {
            etUsuario.setText("")
            etContra.setText("")

        }

    }
}