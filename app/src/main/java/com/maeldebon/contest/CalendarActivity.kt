package com.maeldebon.contest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class CalendarActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var editText: EditText
    lateinit var string: String
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        title = "KotlinApp"
        button = findViewById(R.id.button)
        val date = Date()
        val cal = Calendar.getInstance()
        cal.time = date
        var myDate = cal.time
        textView = findViewById(R.id.textView)
        button.setOnClickListener {
            textView.text = myDate.toString()
        }
    }
}