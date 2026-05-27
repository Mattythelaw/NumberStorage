package com.example.numberstorage

import android.R.attr.text
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
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Linking the UI to the main activity//
        val edtNum = findViewById<EditText>(R.id.edtNum)
        val edtAdd = findViewById<Button>(R.id.edtAdd)
        val textMsg = findViewById<TextView>(R.id.textMsg)

        //Setting a click listener for the button//
        edtAdd.setOnClickListener {

            //checking if the array is full//
            if (counter >= numbers.size) {

                //Display a message to let user that no more numbers can be stored//
                textMsg.text = "No more values can be stored"

            } else {

                //Calling the number entered by the user//
                val input = edtNum.text.toString()

                //Checking if the input is empty//
                if (input.isEmpty()) {
                    textMsg.text = "Please enter a number"
                    return@setOnClickListener

                }
                //Storing the array at the current counter position//
                numbers[counter] = input.toInt()

                //Incrementing the counter for next value//
                counter++

                //Displaying the message to the user for when no more values can be stored//
                textMsg.text = "Number saved! (${counter}/10 slots are used"
                


            }
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}