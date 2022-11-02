package com.blueiobase.api.android.statusbarcolors

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import androidx.appcompat.widget.Toolbar
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment


/**
 * This is a utility singleton class which provides methods to change the colors and style of the Android status bar.
 *
 * @author IODevBlue
 * @since v1.0.0
 */
object StatusBarColors {

    /** The default transparency to be applied to a solid color background of the status bar. */
    internal const val DEFAULT_ALPHA = 0
    /** Listener for changes to status bar color. **/
    @JvmStatic
    var statusBarColorChangeListener: OnStatusBarColorChangeListener? = null
    /** Listener for changes to status bar transparency. **/
    @JvmStatic
    var transparencyChangeListener: OnTransparencyChangeListener? = null
    /** Listener for changes to the icon colors on the status bar. **/
    @JvmStatic
    var statusBarIconColorChangeListener: OnStatusBarIconColorChangeListener? = null

    /**
     * Sets the color of the Status bar.
     * @param activity The current [Activity].
     * @param color The color to set as the Status bar background color.
     * @param alpha The alpha transparency to apply on the [color].
     * @see Activity.setStatusBarColor
     */
    @JvmStatic
    fun setStatusBarColor(activity: Activity, @ColorInt color: Int, @IntRange(from = 0, to = 255) alpha: Int = DEFAULT_ALPHA) {
        activity.window.apply{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                statusBarColor = parseColor(color, alpha)
            } else {
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                setTranslucentView(activity.window.decorView as ViewGroup, color, alpha)
                setRootView(activity, true)
            }
        }
        statusBarColorChangeListener?.apply {
            onColorChange(color)
            onGradientColorChange(null)
        }
        transparencyChangeListener?.onTransparencyChange(false)
    }

    /**
     * Sets the color of the Status bar to a gradient color.
     *
     * The [view] parameter **MUST** have a background which is a [GradientDrawable] unless an [IllegalStateException] is thrown.
     *
     *               <androidx.appcompat.widget.Toolbar
     *                android:id="@+id/toolbar"
     *                android:layout_width="match_parent"
     *                android:layout_height="?attr/actionBarSize"
     *                android:background="@color/blue"/>
     *
     *                val mToolbar = findViewById<Toolbar>(R.id.toolbar)
     *                val colors = intArrayOf(0xff000000, 0xff000000)
     *                val gradientDrawable = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);
     *                mToolbar.background = gradientDrawable
     *                StatusBarColors.setGradientColor(activity, mToolbar)
     *
     * **NOTE:** The status bar goes transparent when this method is invoked and the
     * [onTransparencyChange()][OnTransparencyChangeListener.onTransparencyChange] of the [transparencyChangeListener]
     * is fired.
     * @param activity The current [Activity].
     * @param view The view anchored directly at the bottom of the status bar
     * with a gradient colored background to sync with the status bar, preferably a [Toolbar].
     * @see Activity.setGradientColor
     */
    @JvmStatic
    fun setGradientColor(activity: Activity, view: View) {
        require(view.background is GradientDrawable) { "The background of the view is not a Gradient Drawable." }
        val decorView = activity.window.decorView as ViewGroup
        val fakeStatusBarView = decorView.findViewById<View>(android.R.id.custom)
        fakeStatusBarView?.let {
            decorView.removeView(it)
        }
        setRootView(activity, false)
        setTransparentForWindow(activity)
        setPaddingTop(activity, view)
        val background = (view.background as GradientDrawable)
        statusBarColorChangeListener?.apply {
            onGradientColorChange(background)
            onColorChange(0)
        }
    }

    /**
     * Sets the background color of the status bar for the [activity] to transparent.
     *
     * This function removes the padding set by the status bar and fits the content anchored below
     * the status bar to the top of the screen.
     * @param activity The current [Activity].
     * @see WindowCompat.setDecorFitsSystemWindows
     * @see Activity.setTransparentForWindow
     */
    @JvmStatic
    fun setTransparentForWindow(activity: Activity) {
        activity.window.apply {
            statusBarColor = Color.TRANSPARENT
            WindowCompat.setDecorFitsSystemWindows(this, false)
        }
        transparencyChangeListener?.onTransparencyChange(true)
    }

    /**
     * Insets a top padding using the [getDefaultStatusBarHeight] on the [view].
     *
     * The implementation of this method is in relation to the [view] parameter which is assumed
     * to be directly anchored below the status bar (usually a [Toolbar]). It gives the [view] a top margin space which is the same dimension occupied
     * by a status bar.
     * Use cases can be in scenarios where the status bar has been made transparent or removed and a top padding is still needed at the topmost [View]
     * to give the illusion that the status bar is still there.
     * @param context The current [Context].
     * @param view The [View] which a top padding should be added.
     * @see Activity.setPaddingTop
     */
    @JvmStatic
    fun setPaddingTop(context: Context, view: View) {
        view.apply {
            layoutParams?.let {
                if (it.height > 0 && paddingTop == 0) {
                    it.height += getDefaultStatusBarHeight(context)
                    setPadding(
                        paddingLeft, paddingTop + getDefaultStatusBarHeight(context),
                        paddingRight, paddingBottom
                    )
                }
            }
        }
    }

    /**
     * Applies a dark tint on the status bar icons.
     *
     * **NOTE:** This method has no effect on API <23.
     */
    @JvmStatic
    fun setDarkStatusBarIcons(activity: Activity) {
        darkMode(activity.window, true)
        statusBarIconColorChangeListener?.onIconColorChanged(true)
    }

    /**
     * Applies a light tint on the status bar icons.
     *
     * **NOTE:** This method has no effect on API <23.
     */
    @JvmStatic
    fun setLightStatusBarIcons(activity: Activity) {
        darkMode(activity.window, false)
        statusBarIconColorChangeListener?.onIconColorChanged(false)
    }

    /**
     * Gets the default height for the Android platform status bar.
     * @param context A [Context] to retrieve the value.
     * @return The height of a standard status bar.
     */
    @JvmStatic
    fun getDefaultStatusBarHeight(context: Context): Int {
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        return context.resources.getDimensionPixelSize(resourceId)
    }

    private fun darkMode(window: Window, dark: Boolean) {
        darkModeForM(window, dark)
    }

    private fun darkModeForM(window: Window, dark: Boolean) {
        window.apply {
            val wic = WindowInsetsControllerCompat(this, decorView)
            wic.isAppearanceLightStatusBars = !dark
        }
    }

    /** Internal method to include an alpha value to a given color integer. */
    internal fun parseColor(@ColorInt color: Int, alpha: Int): Int {
        if (alpha == 0) {
            return color
        }
        val a = 1 - alpha / 255f
        var red = color shr 16 and 0xff
        var green = color shr 8 and 0xff
        var blue = color and 0xff
        red = (red * a + 0.5).toInt()
        green = (green * a + 0.5).toInt()
        blue = (blue * a + 0.5).toInt()
        return 0xff shl 24 or (red shl 16) or (green shl 8) or blue
    }

    internal fun setTranslucentView(viewGroup: ViewGroup, @ColorInt color: Int, @IntRange(from = 0, to = 255) alpha: Int) {
        val decipherColor = parseColor(color, alpha)
        var translucentView = viewGroup.findViewById<View>(android.R.id.custom)
        if (translucentView == null && decipherColor != 0) {
            translucentView = View(viewGroup.context)
            translucentView.id = android.R.id.custom
            val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                getDefaultStatusBarHeight(viewGroup.context)
            )
            viewGroup.addView(translucentView, params)
        }
        translucentView?.setBackgroundColor(decipherColor)
    }

    internal fun setRootView(activity: Activity, fitSystemWindows: Boolean) {
        val parent = activity.findViewById<ViewGroup>(android.R.id.content)
        var i = 0
        val count = parent.childCount
        while (i < count) {
            val childView = parent.getChildAt(i)
            childView.let {
                if (it is ViewGroup) {
                    it.setFitsSystemWindows(fitSystemWindows)
                    it.clipToPadding = fitSystemWindows
                }
            }
            i++
        }
    }

    /** Interface to listen for changes to status bar color. */
    interface OnStatusBarColorChangeListener {
        /** Callback triggered when a solid background change is detected. */
        fun onColorChange(color: Int)

        /** Callback triggered when a [GradientDrawable] is applied as the background of the status bar. */
        fun onGradientColorChange(colorArray: GradientDrawable?)
   }

    /**  Interface to listen for changes to transparency of the status bar. */
    interface OnTransparencyChangeListener {
        /** Callback triggered when the status bar background is transparent. */
        fun onTransparencyChange(transparent: Boolean)
    }

    /**  Interface to listen for changes to status bar icon colors . */
    interface OnStatusBarIconColorChangeListener {
        /** Callback triggered when the icons on the status bar have a different color. */
        fun onIconColorChanged(isDarkMode: Boolean)
    }
}