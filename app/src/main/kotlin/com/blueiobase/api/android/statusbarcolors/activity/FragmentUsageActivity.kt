package com.blueiobase.api.android.statusbarcolors.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.blueiobase.api.android.statusbarcolors.R
import com.blueiobase.api.android.statusbarcolors.fragment.GenericFragment
import com.blueiobase.api.android.statusbarcolors.setTransparentForWindow

class FragmentUsageActivity: AppCompatActivity() {
    private val wallpapers = arrayOf(R.drawable.dance, R.drawable.itachi, R.drawable.mat3,
        R.drawable.earplugs, R.drawable.iphonewall)
    private val mViewPager2 by lazy { findViewById<ViewPager2>(R.id.view_pager2) }
    private val mViewPagerAdapter by lazy { ViewPagerAdapter(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_usage)
        setTransparentForWindow()
        mViewPager2.adapter = mViewPagerAdapter
    }

    private inner class ViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
        override fun getItemCount() = wallpapers.size

        override fun createFragment(position: Int): Fragment {
            when(position) {
                0, 1, 2, 3, 4, 5, 6 -> GenericFragment().also{
                    it.arguments = bundleOf("photo" to wallpapers[position])
                }
            }
            return GenericFragment().also{
                it.arguments = bundleOf("photo" to wallpapers[position])
            }
        }

    }

}