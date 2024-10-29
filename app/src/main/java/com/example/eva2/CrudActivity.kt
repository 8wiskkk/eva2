package com.example.eva2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CrudActivity : AppCompatActivity() {
    private val items = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)

        val itemName = findViewById<EditText>(R.id.itemName)
        val addButton = findViewById<Button>(R.id.addButton)
        val deleteButton = findViewById<Button>(R.id.deleteButton)
        val itemList = findViewById<ListView>(R.id.itemList)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        itemList.adapter = adapter

        // Botón para agregar un nuevo elemento
        addButton.setOnClickListener {
            val item = itemName.text.toString()
            if (item.isNotEmpty()) {
                items.add(item)
                adapter.notifyDataSetChanged()
                itemName.text.clear()
            }
        }

        // Botón para eliminar el último elemento
        deleteButton.setOnClickListener {
            if (items.isNotEmpty()) {
                items.removeAt(items.size - 1)  // Elimina el último elemento
                adapter.notifyDataSetChanged()   // Notifica al adaptador del cambio
            } else {
                Toast.makeText(this, "No hay elementos para eliminar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
