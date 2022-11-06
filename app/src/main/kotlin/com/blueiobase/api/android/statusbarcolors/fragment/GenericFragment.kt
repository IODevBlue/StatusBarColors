package com.blueiobase.api.android.statusbarcolors.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.blueiobase.api.android.designcolors.DesignColors
import com.blueiobase.api.android.statusbarcolors.R
import com.blueiobase.api.android.statusbarcolors.StatusBarColors
import com.blueiobase.api.android.statusbarcolors.setPaddingTop
import com.blueiobase.api.android.statusbarcolors.setTransparentForWindow


class GenericFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_generic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val root by lazy { view.findViewById<LinearLayout>(R.id.root) }
        root.setBackgroundResource(requireArguments().getInt("photo"))
    }
}