package com.example.projektni_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        val aboutButton = findViewById<Button>(R.id.aboutButton)
        startButton.setOnClickListener{
            val intent = Intent(this, Lektire::class.java)
            startActivity(intent)
        }
        aboutButton.setOnClickListener{
            val intent = Intent(this, About::class.java)
            startActivity(intent)
        }
    }
}