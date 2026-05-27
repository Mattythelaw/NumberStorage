package com.example.numberstorage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Global so that they are accessible everywhere the class//
    //Created an array of size 10 to store the values//
    val numbers = IntArray(10)

    //This counter is to track which element to store the next value in//
    val counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Linking the UI to the main activity//
        val edtNum = findViewById<EditText>(R.id.edtNum)
        val edtAdd = findViewById<Button>(R.id.edtAdd)
        val textMsg = findViewById<TextView>(R.id.textMsg)

        





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}