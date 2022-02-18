package com.example.projektni_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val fragments: ArrayList<Fragment> = arrayListOf(
            AboutFragment(),
            aboutFrenchFragment(),
            aboutRussiaFragment(),
            aboutEnglandFragment(),
            aboutCroatiaFragment()
        )

        val adapter = ViewPagerAdapter(fragments,this)
        viewPager.adapter = adapter
    }
}