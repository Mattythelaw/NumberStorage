package com.example.numberstorage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val numbers = arrayOfNulls<Int>(10)
    var counter = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Binding the XML views to Kotlin//
        val editNum = findViewById<EditText>(R.id.edtNum)
        val editAdd = findViewById<Button>(R.id.edtAdd)

        //Setting up the click listener for the button//
        editAdd.setOnClickListener {
            if (counter >= 10) {
                Toast.makeText(this, "No more values can be stored",
                    Toast.LENGTH_SHORT).show()
            }else{
                val inputText = editNum.text.toString()

                if (inputText.isNotEmpty()) {
                    val valueToStore = inputText.toInt()

                    numbers[counter] = valueToStore

                    //Incrementing the counter so the next click targets the next index//
                    counter ++
            }

        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}