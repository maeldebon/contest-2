package com.maeldebon.contest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        var db = DatabaseHandler(context)

        var data = db.readData()
        tv_result.text = ""
        for (i in 0..(data.size-1)) {
            tv_result.append(data.get(i).id.toString() + " " + data.get(i).name + "\n")
        }
    }
}