package com.blueiobase.api.android.statusbarcolors

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import androidx.appcompat.widget.Toolbar
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import com.blueiobase.api.android.statusbarcolors.StatusBarColors.getDefaultStatusBarHeight

/**
 * Extension function on an [Activity] to set the color of the Status bar.
 * @param color The color to set as the Status bar background color.
 * @param alpha The alpha transparency to apply on the [color].
 * @param statusBarColorChangeListener Listener for changes to the status bar color.
 * @see StatusBarColors.setStatusBarColor
 * @see Fragment.setStatusBarColor
 */
fun Activity.setStatusBarColor(
    @ColorInt color: Int,
    @IntRange(from = 0, to = 255) alpha: Int = StatusBarColors.DEFAULT_ALPHA,
    statusBarColorChangeListener: StatusBarColors.OnStatusBarColorChangeListener? = null) {
    window.apply{
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            statusBarColor = StatusBarColors.parseColor(color, alpha)
        } else {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            StatusBarColors.setTranslucentView(window.decorView as ViewGroup, color, alpha)
            StatusBarColors.setRootView(this@setStatusBarColor, true)
        }
    }
    StatusBarColors.let {
        it.statusBarColorChangeListener?.apply {
            onColorChange(color)
            onGradientColorChange(null)
        }
        it.transparencyChangeListener?.onTransparencyChange(false)
    }
    statusBarColorChangeListener?.apply {
        onColorChange(color)
        onGradientColorChange(null)
    }
}

/**
 * Extension function on a [Fragment] to set the color of the Status bar.
 *
 * **NOTE:** The [Fragment] must be attached to an [Activity].
 * @param color The color to set as the Status bar background color.
 * @param alpha The alpha transparency to apply on the [color].
 * @param statusBarColorChangeListener Listener for changes to the status bar color.
 * @see StatusBarColors.setStatusBarColor
 * @see Activity.setStatusBarColor
 */
fun Fragment.setStatusBarColor(
    @ColorInt color: Int,
    @IntRange(from = 0, to = 255) alpha: Int = StatusBarColors.DEFAULT_ALPHA,
    statusBarColorChangeListener: StatusBarColors.OnStatusBarColorChangeListener? = null) {
    this.requireActivity().window.apply{
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            statusBarColor = StatusBarColors.parseColor(color, alpha)
        } else {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            StatusBarColors.setTranslucentView(this.decorView as ViewGroup, color, alpha)
            StatusBarColors.setRootView(this@setStatusBarColor.requireActivity(), true)
        }
    }
    StatusBarColors.let {
        it.statusBarColorChangeListener?.apply {
            onColorChange(color)
            onGradientColorChange(null)
        }
        it.transparencyChangeListener?.onTransparencyChange(false)
    }
    statusBarColorChangeListener?.apply {
        onColorChange(color)
        onGradientColorChange(null)
    }
}

/**
 * Extension function on an [Activity] to set the color of the Status bar to a gradient color.
 *
 * The [view] parameter **MUST** have a background which is a [GradientDrawable] unless an [IllegalStateException] is thrown.
 *
 *               <androidx.appcompat.widget.Toolbar
 *                android:id="@+id/toolbar"
 *                android:layout_width="match_parent"
 *                android:layout_height="?attr/actionBarSize"
 *                android:background="@color/blue"/>`
 *
 *                val mToolbar = findViewById<Toolbar>(R.id.toolbar)
 *                val colors = intArrayOf(0xff000000, 0xff000000)
 *                val gradientDrawable = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);
 *                mToolbar.background = gradientDrawable
 *                StatusBarColors.setGradientColor(activity, mToolbar)
 * @param view The view anchored directly at the bottom of the status bar
 * with a gradient colored background to sync with the status bar preferably a [Toolbar].
 * @see StatusBarColors.setGradientColor
 * @see Fragment.setGradientColor
 */
fun Activity.setGradientColor(view: View, statusBarColorChangeListener: StatusBarColors.OnStatusBarColorChangeListener? = null) {
    require(view.background is GradientDrawable) { "The background of the view is not a Gradient Drawable." }
    val decorView = window.decorView as ViewGroup
    val fakeStatusBarView = decorView.findViewById<View>(android.R.id.custom)
    fakeStatusBarView?.let {
        decorView.removeView(it)
    }
    val background = (view.background as GradientDrawable)
    StatusBarColors.let {
        it.setRootView(this, false)
        it.setTransparentForWindow(this)
        it.setPaddingTop(this, view)
        it.statusBarColorChangeListener?.onGradientColorChange(background)
    }
    statusBarColorChangeListener?.onGradientColorChange(background)
}

/**
 *  Extension function on a [Fragment] to set the color of the Status bar to a gradient color.
 *
 * The [view] parameter **MUST** have a background which is a [GradientDrawable] unless an [IllegalStateException] is thrown.
 *
 *               <androidx.appcompat.widget.Toolbar
 *                android:id="@+id/toolbar"
 *                android:layout_width="match_parent"
 *                android:layout_height="?attr/actionBarSize"
 *                android:background="@color/blue"/>`
 *
 *                val mToolbar = findViewById<Toolbar>(R.id.toolbar)
 *                val colors = intArrayOf(0xff000000, 0xff000000)
 *                val gradientDrawable = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);
 *                mToolbar.background = gradientDrawable
 *                StatusBarColors.setGradientColor(activity, mToolbar)
 *
 * **NOTE:** The [Fragment] must be attached to an [Activity].
 *
 * @param view The view anchored directly at the bottom of the status bar
 * with a gradient colored background to sync with the status bar preferably a [Toolbar].
 * @see StatusBarColors.setGradientColor
 * @see Activity.setGradientColor
 */
fun Fragment.setGradientColor(view: View, statusBarColorChangeListener: StatusBarColors.OnStatusBarColorChangeListener? = null) {
    require(view.background is GradientDrawable) { "The background of the view is not a Gradient Drawable." }
    val activity = this.requireActivity()
    val decorView = activity.window.decorView as ViewGroup
    val fakeStatusBarView = decorView.findViewById<View>(android.R.id.custom)
    fakeStatusBarView?.let {
        decorView.removeView(it)
    }
    val background = (view.background as GradientDrawable)
    StatusBarColors.let {
        it.setRootView(activity, false)
        it.setTransparentForWindow(activity)
        it.setPaddingTop(activity, view)
        it.statusBarColorChangeListener?.onGradientColorChange(background)
    }
    statusBarColorChangeListener?.onGradientColorChange(background)
}

/**
 * Extension function on an [Activity] to set the background color of the status bar to transparent.
 *
 * This function removes the padding set by the status bar and fits the content anchored below
 * the status bar to the top of the screen.
 * @see WindowCompat.setDecorFitsSystemWindows
 * @see StatusBarColors.setTransparentForWindow
 * @see Fragment.setTransparentForWindow
 */
fun Activity.setTransparentForWindow(transparencyChangeListener: StatusBarColors.OnTransparencyChangeListener? = null) {
    this.window.apply {
        statusBarColor = Color.TRANSPARENT
        WindowCompat.setDecorFitsSystemWindows(this, false)
    }
    StatusBarColors.transparencyChangeListener?.onTransparencyChange(true)
    transparencyChangeListener?.onTransparencyChange(true)
}

/**
 * Extension function on an [Fragment] to set the background color of the status bar to transparent.
 *
 * This function removes the padding set by the status bar and fits the content anchored below
 * the status bar to the top of the screen.
 *
 * **NOTE:** The [Fragment] must be attached to an [Activity].
 * @see StatusBarColors.setTransparentForWindow
 * @see Activity.setTransparentForWindow
 * @see WindowCompat.setDecorFitsSystemWindows
 */
fun Fragment.setTransparentForWindow(transparencyChangeListener: StatusBarColors.OnTransparencyChangeListener? = null) {
    this.requireActivity().window.apply {
        statusBarColor = Color.TRANSPARENT
        WindowCompat.setDecorFitsSystemWindows(this, false)
    }
    StatusBarColors.transparencyChangeListener?.onTransparencyChange(true)
    transparencyChangeListener?.onTransparencyChange(true)
}

/**
 * Extension function on an [Activity] to insets a top padding using the [getDefaultStatusBarHeight] on the [view].
 *
 * The implementation of this method is in relation to the [view] parameter which is assumed
 * to be directly anchored below the status bar (usually a [Toolbar]). It gives the [view] a top margin space which is the same dimension occupied
 * by a status bar.
 * Use cases can be in scenarios where the status bar has been made transparent or removed and a top padding is still needed at the topmost [View]
 * to give the illusion that the status bar is still there.
 * @param view The [View] which a top padding should be added.
 * @see StatusBarColors.setPaddingTop
 * @see Fragment.setPaddingTop
 */
fun Activity.setPaddingTop(view: View) {
    view.apply {
        layoutParams?.let {
            if (it.height > 0 && paddingTop == 0) {
                it.height += getDefaultStatusBarHeight(this@setPaddingTop)
                setPadding(
                    paddingLeft, paddingTop + getDefaultStatusBarHeight(this@setPaddingTop),
                    paddingRight, paddingBottom
                )
            }
        }
    }
}

/**
 * Extension function on an [Fragment] to insets a top padding using the [getDefaultStatusBarHeight] on the [view].
 *
 * The implementation of this method is in relation to the [view] parameter which is assumed
 * to be directly anchored below the status bar (usually a [Toolbar]). It gives the [view] a top margin space which is the same dimension occupied
 * by a status bar.
 * Use cases can be in scenarios where the status bar has been made transparent or removed and a top padding is still needed at the topmost [View]
 * to give the illusion that the status bar is still there.
 *
 * **NOTE:** The [Fragment] must be attached to an [Activity].
 * @param view The [View] which a top padding should be added.
 * @see StatusBarColors.setPaddingTop
 * @see Activity.setPaddingTop
 */
fun Fragment.setPaddingTop(view: View) {
    view.apply {
        layoutParams?.let {
            if (it.height > 0 && paddingTop == 0) {
                it.height += getDefaultStatusBarHeight(this@setPaddingTop.requireActivity())
                setPadding(
                    paddingLeft, paddingTop + getDefaultStatusBarHeight(this@setPaddingTop.requireActivity()),
                    paddingRight, paddingBottom
                )
            }
        }
    }
}

