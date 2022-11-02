package com.blueiobase.api.android.statusbarcolors.activity

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.blueiobase.api.android.designcolors.DesignColors
import com.blueiobase.api.android.statusbarcolors.R
import com.blueiobase.api.android.statusbarcolors.StatusBarColors
import com.blueiobase.api.android.statusbarcolors.setStatusBarColor
import com.blueiobase.api.android.statusbarcolors.util.navigateTo


class MainActivity: AppCompatActivity() {

    private val mToolbar: Toolbar by lazy { findViewById(R.id.toolbar) }
    private val btn: Button by lazy { findViewById(R.id.btn) }
    private val btn1: Button by lazy { findViewById(R.id.btn1) }
    private val btn2: Button by lazy { findViewById(R.id.btn2) }
    private val btn3: Button by lazy { findViewById(R.id.btn3) }
    private val btn4: Button by lazy { findViewById(R.id.btn4) }
    private val btn5: Button by lazy { findViewById(R.id.btn5) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            val color = DesignColors.MaterialDesign.selectRandomColor()
            mToolbar.setBackgroundColor(color)
            setStatusBarColor(color, statusBarColorChangeListener =  object: StatusBarColors.OnStatusBarColorChangeListener{
                override fun onColorChange(color: Int) {
                    Toast.makeText(this@MainActivity, "Status bar color changed!!", Toast.LENGTH_SHORT).show()
                }
                override fun onGradientColorChange(colorArray: GradientDrawable?) {}
            })
        }

        btn1.setOnClickListener {
            navigateTo(TransparencyActivity::class.java) { Bundle() }
        }

        btn2.setOnClickListener {
            val colors = intArrayOf(DesignColors.FlatDesign.selectRandomColor(), DesignColors.FlatDesign.selectRandomColor())
            val gradientDrawable = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors)
            mToolbar.background = gradientDrawable
            StatusBarColors.apply {
                setGradientColor(this@MainActivity, mToolbar)
                statusBarColorChangeListener = object: StatusBarColors.OnStatusBarColorChangeListener {
                    override fun onColorChange(color: Int) {}

                    override fun onGradientColorChange(colorArray: GradientDrawable?) {
                        colorArray?.let {
                            Toast.makeText(this@MainActivity, "Status bar color changed to gradient!!",
                                Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }
        }

        btn3.setOnClickListener {
            navigateTo(FragmentUsageActivity::class.java) { Bundle() }
        }

        btn4.setOnClickListener {
            val color = DesignColors.MaterialDesign.selectRandomColor()
            StatusBarColors.apply {
                setStatusBarColor(this@MainActivity, color)
                setLightStatusBarIcons(this@MainActivity)
            }
            mToolbar.setBackgroundColor(color)
        }

        btn5.setOnClickListener {
            val color = DesignColors.MaterialDesign.selectRandomColor()
            StatusBarColors.apply {
                setStatusBarColor(this@MainActivity, color)
                setDarkStatusBarIcons(this@MainActivity)
            }
            mToolbar.setBackgroundColor(color)
        }
    }
}