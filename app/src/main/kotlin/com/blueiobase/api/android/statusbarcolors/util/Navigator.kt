package com.blueiobase.api.android.statusbarcolors.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * Top level extension function used to navigate between [Activity] classes.
 *
 * @param clazz The [Activity] class to Navigate to.
 * @param init The DSL method which accepts a [Bundle] for extra information to be retrieved in
 * the destination [Activity].
 */
fun Context.navigateTo(clazz: Class<out Activity>, init:()->Bundle) {
    val intent = Intent(this, clazz)
    intent.putExtras(init())
    this.startActivity(intent)
}