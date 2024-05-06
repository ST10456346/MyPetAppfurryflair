package com.example.st10456346.mypetappfurryflair

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declarations
        val textView = findViewById<TextView>(R.id.textview)
        val enterbutton = findViewById<Button>(R.id.enterbutton)
        enterbutton.setOnClickListener {
        val intent = Intent (this, page_2::class.java)
        startActivity(intent)
        }
    }
}