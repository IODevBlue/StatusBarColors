package com.blueiobase.api.android.statusbarcolors.activity

import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.blueiobase.api.android.statusbarcolors.R
import com.blueiobase.api.android.statusbarcolors.StatusBarColors

class TransparencyActivity: AppCompatActivity() {

    private val btn by lazy { findViewById<Button>(R.id.button1) }
    private val relativeLayout by lazy { findViewById<RelativeLayout>(R.id.container) }
    private val wallpapers = arrayOf(R.drawable.dance, R.drawable.itachi, R.drawable.mat3,
        R.drawable.earplugs, R.drawable.iphonewall)
    private var currentWallpaper = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transparency)
        StatusBarColors.apply {
            setTransparentForWindow(this@TransparencyActivity)
            transparencyChangeListener = object : StatusBarColors.OnTransparencyChangeListener {
                override fun onTransparencyChange(transparent: Boolean) {
                    if(transparent) {
                        Toast.makeText(this@TransparencyActivity, "Status bar is transparent!!",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        btn.setOnClickListener {
            currentWallpaper++
            changeWallpaper()
        }
    }

    private fun changeWallpaper() {
        relativeLayout.background = if(currentWallpaper < wallpapers.size) {
            ContextCompat.getDrawable(this, wallpapers[currentWallpaper])
        } else {
            currentWallpaper = 0
            ContextCompat.getDrawable(this, wallpapers[0])
        }
    }
}