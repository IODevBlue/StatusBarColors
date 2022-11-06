Status Bar Colors
=================

Status Bar Colors is a Kotlin utility library which aids in manipulating the Android platform's status bar.

Dependencies
------------
The sample implementation of this library uses [DesignColors](https://github.com/IODevBlue/DesignColors) to provide random colors.
This is already bundled into the sample project.

Installation
------------
- The main file (`StatusBarColors.kt`) is a singleton object class which can be copied directly to your working directory. It contains no
  external dependencies apart from Android SDK classes.
- Also the (`Extensions.kt`) file contains optional Kotlin extensions which can be helpful to shorten code syntax.

Advantages
----------
- This library uses up-to-date Kotlin code for status bar manipulation and supports Android API 23+. 
- Most available libraries still use the deprecated `WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS` which works on older Android API
but this becomes problematic when handling newer Android APIs. This library solves the problem.

Uses
----
Use Status Bar Colors when you need to manipulate the Android status bar without worrying too much about implementation details and deprecated code. 

Usage
-----
- Suppose there is a `blue` color in `colors.xml`
```XML
<color name="blue">#FF0000FF</color>
```
- To change the status bar color to `blue`:
```KOTLIN
val blueColor = ContextCompat.getColor(this, R.color.blue)
StatusBarColors.setStatusBarColor(activity, blueColor)
```
- An optional alpha value (range = 0-255) can be passed into the `setStatusBarColor()` function:
```KOTLIN
val blueColor = ContextCompat.getColor(this, R.color.blue)
StatusBarColors.setStatusBarColor(activity, blueColor, 50)
```
<p align="center"><img src="/art/change_color.gif" alt="Change Color"></p>

- To get the current status bar color:
```KOTLIN
  StatusBarColors.getStatusBarColor(activity)
```

- To change the status bar color to a gradient color, you would need a `View` which is anchored directly under the status bar. This is usually a `Toolbar`
or an `AppbarLayout`. The trick here is that the status bar goes transparent and uses the background of the `View` directly underneath it as its background.
**NOTE:** The `View`'s background **MUST** be a [GradientDrawable](https://developer.android.com/reference/android/graphics/drawable/GradientDrawable).
See sample implementation for more details.
Create a `Toolbar`:
```XML
<androidx.appcompat.widget.Toolbar
android:id="@+id/toolbar"
android:layout_width="match_parent"
android:layout_height="?attr/actionBarSize"
android:background="@color/blue"/>
```
- Retrieve the `Toolbar` and set its background to a `GradientDrawable`:
```KOTLIN
val mToolbar = findViewById<Toolbar>(R.id.toolbar)
val colors = intArrayOf(0xff000000, 0xff000000)
val gradientDrawable = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors)
mToolbar.background = gradientDrawable
StatusBarColors.setGradientColor(activity, mToolbar)
```
Gradient Background:
<p align="center"><img src="/art/gradient (1).png" alt="Gradient Background"></p>
<p align="center"><img src="/art/gradient (2).png" alt="Gradient Background"></p>

- To make the status bar transparent for the current `Activity`:
```KOTLIN
StatusBarColors.setTransparentForWindow(activity)
```
<p align="center"><img src="/art/transparent (1).png" alt="Transparent Background"></p>
<p align="center"><img src="/art/transparent (2).png" alt="Transparent Background"></p>
<p align="center"><img src="/art/transparent (3).png" alt="Transparent Background"></p>

- In situations where you have a transparent status bar and you need to add a padding to give an illusion that the status bar is still available or 
in any similar situation:
```KOTLIN
StatusBarColors.setPaddingTop(context, view)
```
The `view` parameter is the `View` or `ViewGroup` anchored directly under the status bar.


- To switch between dark and light status bar icons:
```KOTLIN
StatusBarColors.setDarkStatusBarIcons(activity) //switch to dark tinted icons
StatusBarColors.setLightStatusBarIcons(activity) //switch to light colored icons
```
Light Mode:
<p align="center"><img src="/art/light_mode (2).png" alt="Transparent Background"></p>
<p align="center"><img src="/art/light_mode (1).png" alt="Transparent Background"></p>

Dark Mode:
<p align="center"><img src="/art/dark_mode (1).png" alt="Transparent Background"></p>
<p align="center"><img src="/art/dark_mode (2).png" alt="Transparent Background"></p>


- To retrieve the default height of the status bar:
```KOTLIN
StatusBarColors.getDefaultStatusBarHeight(context)
```

You can also listen for changes to the status bar background color, gradient background color and transparency changes.
- Listen for gradient color changes:
```KOTLIN
StatusBarColors.apply {
    setGradientColor(this@MainActivity, mToolbar)
    statusBarColorChangeListener = object: StatusBarColors.OnStatusBarColorChangeListener {
        override fun onColorChange(color: Int) {}
        override fun onGradientColorChange(colorArray: GradientDrawable?) {
            colorArray?.let {
                Toast.makeText(this@MainActivity, "Status bar color changed to gradient!!", Toast.LENGTH_SHORT).show()
            } 
        }
    }
}
```
- Listen for transparency changes:
```KOTLIN
StatusBarColors.apply {
    setTransparentForWindow(this@TransparencyActivity)
    transparencyChangeListener = object : StatusBarColors.OnTransparencyChangeListener {
        override fun onTransparencyChange(transparent: Boolean) {
            if(transparent) {
                Toast.makeText(this@TransparencyActivity, "Status bar is transparent!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
``` 
- Listen for background color changes:
```KOTLIN
StatusBarColors.setStatusBarColor(color, statusBarColorChangeListener =  object: StatusBarColors.OnStatusBarColorChangeListener{
    override fun onColorChange(color: Int) { 
        Toast.makeText(this@MainActivity, "Status bar color changed!!", Toast.LENGTH_SHORT).show()
    }
    override fun onGradientColorChange(colorArray: GradientDrawable?) {}
    }
)
```

Java Interoperability
---------------------
This library is completely interoperable with Java projects.


Changelog
---------
* **1.0.0**
  * Initial release
  
## License
    Copyright (C) 2022 IO DevBlue

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.




