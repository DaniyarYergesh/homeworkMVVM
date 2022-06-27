package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.widget.Button as Button

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var viewModel: MainViewModel
    lateinit var listOfPin: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)


        val pinTextView = findViewById<PinTextViewGen>(R.id.pinTextViewGen)
        listOfPin = mutableListOf()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.pinCode.observe(this, Observer {
            listOfPin.add(it)
        })


        val listOfButtons = listOf(
            button0,
            button1,
            button2,
            button3,
            button4,
            button5,
            button6,
            button7,
            button8,
            button9
        )
        for (curButton in listOfButtons) {
            curButton.setOnClickListener {
                viewModel.pinCode(curButton.text.toString())
                pinTextView.append(curButton.text.toString().toInt())
            }
        }


        val buttonBack: Button = findViewById(R.id.back)
        buttonBack.setOnClickListener {
            pinTextView.clear()
        }
        buttonBack.setOnLongClickListener {
            pinTextView.clearAll()
            true
        }


        val buttonOk: Button = findViewById(R.id.OK)
        buttonOk.setOnClickListener {
            pinTextView.checking()
        }
    }
}
