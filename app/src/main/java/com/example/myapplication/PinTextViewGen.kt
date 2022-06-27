package com.example.myapplication

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class PinTextViewGen @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var pinTextView1: PinTextView
    private var pinTextView2: PinTextView
    private var pinTextView3: PinTextView
    private var pinTextView4: PinTextView
    private var listOfPin: List<PinTextView>

    init {
        val view = inflate(context, R.layout.pin_text_view, this)
        pinTextView1 = view.findViewById(R.id.pinTextView_1)
        pinTextView2 = view.findViewById(R.id.pinTextView_2)
        pinTextView3 = view.findViewById(R.id.pinTextView_3)
        pinTextView4 = view.findViewById(R.id.pinTextView_4)
        listOfPin = listOf(pinTextView1, pinTextView2, pinTextView3, pinTextView4)
    }

    fun append(number: Int) {
        for (pin in listOfPin) {
            if (pin.text == "") {
                pin.text = number.toString()
                pin.setBorderColor(ContextCompat.getColor(context, R.color.blue))
                pin.invalidate()
                pin.setTextColor(ContextCompat.getColor(context, R.color.blue))
                break
            }
        }
        for (pin in listOfPin) {
            if (pin.text != "") {
                pin.setBorderColor(ContextCompat.getColor(context, R.color.blue))
                pin.setTextColor(ContextCompat.getColor(context, R.color.blue))
            }
            else{
                pin.setBorderColor(ContextCompat.getColor(context, R.color.blankColor))
                pin.setTextColor(ContextCompat.getColor(context, R.color.blue))
            }
        }
    }

    fun clear() {
        for (pin in listOfPin) {
            if (pin.text != "") {
                pin.setBorderColor(ContextCompat.getColor(context, R.color.blue))
                pin.setTextColor(ContextCompat.getColor(context, R.color.blue))
            }
            else{
                pin.setBorderColor(ContextCompat.getColor(context, R.color.blankColor))
                pin.setTextColor(ContextCompat.getColor(context, R.color.blue))
            }
        }
        for (pin in listOfPin.reversed()) {
            if (pin.text != "") {
                pin.text = ""
                pin.setBorderColor(ContextCompat.getColor(context, R.color.blankColor))
                pin.setTextColor(ContextCompat.getColor(context, R.color.blue))
                break
            }
        }
    }

    fun checking() {
        for (pin in listOfPin) {
            if (listOf(
                    pinTextView1.text,
                    pinTextView2.text,
                    pinTextView3.text,
                    pinTextView4.text
                ) == listOf("1", "5", "6", "7")
            ) {
                pin.setBorderColor(ContextCompat.getColor(context, R.color.green))
                pin.setTextColor(ContextCompat.getColor(context, R.color.green))
            } else {
                pin.setBorderColor(ContextCompat.getColor(context, R.color.red))
                pin.setTextColor(ContextCompat.getColor(context, R.color.red))
            }
        }
    }

    fun clearAll() {
        for (pin in listOfPin) {
            pin.setBorderColor(ContextCompat.getColor(context, R.color.blankColor))
            pin.setTextColor(ContextCompat.getColor(context, R.color.blue))
            pin.text = ""
        }
    }

}
