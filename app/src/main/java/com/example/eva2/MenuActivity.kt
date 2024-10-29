package com.example.eva2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Encuentra el botón por su ID
        val crudButton = findViewById<Button>(R.id.crudButton)

        // Asigna un OnClickListener al botón
        crudButton.setOnClickListener {
            // Acción que se realiza al presionar el botón
            val intent = Intent(this, CrudActivity::class.java)
            startActivity(intent)
        }
    }
}


