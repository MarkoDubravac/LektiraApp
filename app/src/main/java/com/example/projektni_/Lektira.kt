package com.example.projektni_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class Lektira : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lektira)

        val lektiraTitle = findViewById<TextView>(R.id.lektiraTitle)
        val lektiraAuthor = findViewById<TextView>(R.id.lektiraAuthor)
        val lektiraPlace = findViewById<TextView>(R.id.lektiraPlace)
        val lektiraCharacters = findViewById<TextView>(R.id.lektiraCharacters)
        val lektiraPlot = findViewById<TextView>(R.id.lektiraPlot)
        //val lektiraImage = findViewById<ImageView>(R.id.image)

        val bundle: Bundle? = intent.extras
        val title = bundle!!.getString("title")
        val author = bundle!!.getString("author")
        val place = bundle!!.getString("place")
        val characters = bundle!!.getString("characters")
        val plot = bundle!!.getString("plot")
        //val imageID = bundle!!.getInt("imageID")
        lektiraTitle.text = title
        lektiraAuthor.text = author
        lektiraPlace.text = place
        lektiraCharacters.text = characters
        lektiraPlot.text = plot
        //lektiraImage.setImageResource(imageID)
    }

}