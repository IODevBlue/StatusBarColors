package com.blueiobase.api.android.designcolors

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import androidx.core.graphics.ColorUtils

/**
 * DesignColors is a Kotlin Singleton object that provides access to:
 *
 * - Material Design Colors specified in the [Material Color System][https://material.io/design/color/the-color-system.html#color-theme-creation].
 * - Flat UI colors used in web design.
 * - Official colors for several mainstream companies.
 *
 * @author IO DevBlue
 * @since 1.0.0
 */
object DesignColors {

    /** Utility class for the [DesignColors] library. */
    object Util {

        /**
         * Adds transparency to the provided [color].
         * 
         * @param color The color to which an alpha value would be added.
         * @param alphaValue The alpha value. Range: (0-255)
         * @return A color [Int] with the provided alpha value.
         */
        @JvmStatic fun addAlpha(@ColorInt color: Int, @IntRange(from=0, to=255) alphaValue: Int) = Color.argb(alphaValue, Color.red(color), Color.green(color), Color.blue(color))

        /**
         * Validates if the given color is a light or dark color.
         *
         * @param color The color whose brightness should be determined.
         * @return `true` if [color] is a dark color, `false` if otherwise.
         */
        @JvmStatic fun isDarkColor(color: Int): Boolean {
            val darkness = (1 - (0.2126 * Color.red(color) + 0.7152 * Color.green(color) + 0.0722 * Color.blue(color)) / 255 * (Color.alpha(color) / 255))
            return darkness >= 0.5
        }

        /**
         * Separates the RGB values of a color integer.
         *
         * @param color The color integer.,
         * @return An [IntArray] containing the RGB values in this order: {red, green, blue}.
         */
        @JvmStatic fun getRGB(@ColorInt color: Int): IntArray {
            val red = (color shr 16) and 0xFF
            val green = (color shr 8) and 0xFF
            val blue = color and 0xFF
            return intArrayOf(red, green, blue)
        }

        /**
         * Creates a color from the provided [red], [green] and [blue] values.
         * @param red The **RED** component
         * @param green The **GREEN** component
         * @param blue The **BLUE** component
         * @return A color [Int].
         */
        @JvmStatic fun createColor(
            @IntRange(from = 0, to = 255) red: Int,
            @IntRange(from = 0, to = 255) green: Int,
            @IntRange(from = 0, to = 255) blue: Int
        ):  Int {
            return (red shl 16) or (green shl 8) or blue
        }
    }

    /** The Material Design color system helps you apply color to your UI in a meaningful way. */
    object MaterialDesign {

        @ColorInt @JvmStatic val RED_50 = Color.rgb(255, 235, 238)
        @ColorInt @JvmStatic val RED_100 = Color.rgb(255, 205, 210)
        @ColorInt @JvmStatic val RED_200 = Color.rgb(239, 154, 154)
        @ColorInt @JvmStatic val RED_300 = Color.rgb(229, 115, 115)
        @ColorInt @JvmStatic val RED_400 = Color.rgb(239, 83, 80)
        @ColorInt @JvmStatic val RED_500 = Color.rgb(244, 67, 54)
        @ColorInt @JvmStatic val RED_600 = Color.rgb(229, 57, 53)
        @ColorInt @JvmStatic val RED_700 = Color.rgb(211, 47, 47)
        @ColorInt @JvmStatic val RED_800 = Color.rgb(198, 40, 40)
        @ColorInt @JvmStatic val RED_900 = Color.rgb(183, 28, 28)
        @ColorInt @JvmStatic val RED_A100 = Color.rgb(255, 138, 128)
        @ColorInt @JvmStatic val RED_A200 = Color.rgb(255, 82, 82)
        @ColorInt @JvmStatic val RED_A400 = Color.rgb(255, 23, 68)
        @ColorInt @JvmStatic val RED_A700 = Color.rgb(213, 0, 0)

        @ColorInt @JvmStatic val PINK_50 = Color.rgb(252, 228, 236)
        @ColorInt @JvmStatic val PINK_100 = Color.rgb(248, 187, 208)
        @ColorInt @JvmStatic val PINK_200 = Color.rgb(244, 143, 177)
        @ColorInt @JvmStatic val PINK_300 = Color.rgb(240, 98, 146)
        @ColorInt @JvmStatic val PINK_400 = Color.rgb(236, 64, 122)
        @ColorInt @JvmStatic val PINK_500 = Color.rgb(233, 30, 99)
        @ColorInt @JvmStatic val PINK_600 = Color.rgb(216, 27, 91)
        @ColorInt @JvmStatic val PINK_700 = Color.rgb(194, 24, 91)
        @ColorInt @JvmStatic val PINK_800 = Color.rgb(173, 20, 87)
        @ColorInt @JvmStatic val PINK_900 = Color.rgb(136, 14, 79)
        @ColorInt @JvmStatic val PINK_A100 = Color.rgb(255, 128, 171)
        @ColorInt @JvmStatic val PINK_A200 = Color.rgb(255, 64, 129)
        @ColorInt @JvmStatic val PINK_A400 = Color.rgb(245, 0, 87)
        @ColorInt @JvmStatic val PINK_A700 = Color.rgb(197, 17, 98)

        @ColorInt @JvmStatic val PURPLE_50 = Color.rgb(243, 229, 245)
        @ColorInt @JvmStatic val PURPLE_100 = Color.rgb(225, 190, 231)
        @ColorInt @JvmStatic val PURPLE_200 = Color.rgb(206, 147, 216)
        @ColorInt @JvmStatic val PURPLE_300 = Color.rgb(186, 104,200)
        @ColorInt @JvmStatic val PURPLE_400 = Color.rgb(171, 71, 188)
        @ColorInt @JvmStatic val PURPLE_500 = Color.rgb(156, 39, 176)
        @ColorInt @JvmStatic val PURPLE_600 = Color.rgb(142, 36, 170)
        @ColorInt @JvmStatic val PURPLE_700 = Color.rgb(123, 31, 162)
        @ColorInt @JvmStatic val PURPLE_800 = Color.rgb(106, 27, 154)
        @ColorInt @JvmStatic val PURPLE_900 = Color.rgb(74, 20, 140)
        @ColorInt @JvmStatic val PURPLE_A100 = Color.rgb(234, 128, 252)
        @ColorInt @JvmStatic val PURPLE_A200 = Color.rgb(224, 64, 251)
        @ColorInt @JvmStatic val PURPLE_A400 = Color.rgb(213, 0, 249)
        @ColorInt @JvmStatic val PURPLE_A700 = Color.rgb(170, 0, 255)

        @ColorInt @JvmStatic val DEEP_PURPLE_50 = Color.rgb(237, 231, 246)
        @ColorInt @JvmStatic val DEEP_PURPLE_100 = Color.rgb(209, 196, 233)
        @ColorInt @JvmStatic val DEEP_PURPLE_200 = Color.rgb(179, 157, 219)
        @ColorInt @JvmStatic val DEEP_PURPLE_300 = Color.rgb(149, 117, 205)
        @ColorInt @JvmStatic val DEEP_PURPLE_400 = Color.rgb(126, 87, 194)
        @ColorInt @JvmStatic val DEEP_PURPLE_500 = Color.rgb(103, 58, 183)
        @ColorInt @JvmStatic val DEEP_PURPLE_600 = Color.rgb(94, 53, 177)
        @ColorInt @JvmStatic val DEEP_PURPLE_700 = Color.rgb(81, 45, 168)
        @ColorInt @JvmStatic val DEEP_PURPLE_800 = Color.rgb(69, 39, 160)
        @ColorInt @JvmStatic val DEEP_PURPLE_900 = Color.rgb(49, 27, 146)
        @ColorInt @JvmStatic val DEEP_PURPLE_A100 = Color.rgb(179, 136, 255)
        @ColorInt @JvmStatic val DEEP_PURPLE_A200 = Color.rgb(124, 77, 255)
        @ColorInt @JvmStatic val DEEP_PURPLE_A400 = Color.rgb(101, 31, 255)
        @ColorInt @JvmStatic val DEEP_PURPLE_A700 = Color.rgb(98, 0, 234)

        @ColorInt @JvmStatic val INDIGO_50 = Color.rgb(232, 234, 246)
        @ColorInt @JvmStatic val INDIGO_100 = Color.rgb(197, 202, 233)
        @ColorInt @JvmStatic val INDIGO_200 = Color.rgb(159, 168, 218)
        @ColorInt @JvmStatic val INDIGO_300 = Color.rgb(121, 134, 203)
        @ColorInt @JvmStatic val INDIGO_400 = Color.rgb(92, 107, 192)
        @ColorInt @JvmStatic val INDIGO_500 = Color.rgb(63, 81, 181)
        @ColorInt @JvmStatic val INDIGO_600 = Color.rgb(57, 73, 171)
        @ColorInt @JvmStatic val INDIGO_700 = Color.rgb(48, 63, 159)
        @ColorInt @JvmStatic val INDIGO_800 = Color.rgb(40, 53, 147)
        @ColorInt @JvmStatic val INDIGO_900 = Color.rgb(26, 35, 126)
        @ColorInt @JvmStatic val INDIGO_A100 = Color.rgb(140, 158, 255)
        @ColorInt @JvmStatic val INDIGO_A200 = Color.rgb(83, 109, 254)
        @ColorInt @JvmStatic val INDIGO_A400 = Color.rgb(61, 90, 254)
        @ColorInt @JvmStatic val INDIGO_A700 = Color.rgb(48, 79, 254)

        @ColorInt @JvmStatic val BLUE_50 = Color.rgb(227, 242, 253)
        @ColorInt @JvmStatic val BLUE_100 = Color.rgb(187, 222, 251)
        @ColorInt @JvmStatic val BLUE_200 = Color.rgb(144, 202, 249)
        @ColorInt @JvmStatic val BLUE_300 = Color.rgb(100, 181, 246)
        @ColorInt @JvmStatic val BLUE_400 = Color.rgb(66, 165, 245)
        @ColorInt @JvmStatic val BLUE_500 = Color.rgb(33, 150, 243)
        @ColorInt @JvmStatic val BLUE_600 = Color.rgb(30, 136, 229)
        @ColorInt @JvmStatic val BLUE_700 = Color.rgb(25, 118, 210)
        @ColorInt @JvmStatic val BLUE_800 = Color.rgb(21, 101, 192)
        @ColorInt @JvmStatic val BLUE_900 = Color.rgb(13, 71, 161)
        @ColorInt @JvmStatic val BLUE_A100 = Color.rgb(130, 177, 255)
        @ColorInt @JvmStatic val BLUE_A200 = Color.rgb(68, 138, 255)
        @ColorInt @JvmStatic val BLUE_A400 = Color.rgb(41, 121, 255)
        @ColorInt @JvmStatic val BLUE_A700 = Color.rgb(41, 98, 255)

        @ColorInt @JvmStatic val LIGHT_BLUE_50 = Color.rgb(225, 245, 254)
        @ColorInt @JvmStatic val LIGHT_BLUE_100 = Color.rgb(179, 229, 252)
        @ColorInt @JvmStatic val LIGHT_BLUE_200 = Color.rgb(129, 212, 250)
        @ColorInt @JvmStatic val LIGHT_BLUE_300 = Color.rgb(79, 195, 247)
        @ColorInt @JvmStatic val LIGHT_BLUE_400 = Color.rgb(41, 182, 246)
        @ColorInt @JvmStatic val LIGHT_BLUE_500 = Color.rgb(3, 169, 244)
        @ColorInt @JvmStatic val LIGHT_BLUE_600 = Color.rgb(3, 155, 229)
        @ColorInt @JvmStatic val LIGHT_BLUE_700 = Color.rgb(2, 136, 209)
        @ColorInt @JvmStatic val LIGHT_BLUE_800 = Color.rgb(2, 119, 189)
        @ColorInt @JvmStatic val LIGHT_BLUE_900 = Color.rgb(1, 87, 155)
        @ColorInt @JvmStatic val LIGHT_BLUE_A100 = Color.rgb(128, 216, 255)
        @ColorInt @JvmStatic val LIGHT_BLUE_A200 = Color.rgb(64, 196, 255)
        @ColorInt @JvmStatic val LIGHT_BLUE_A400 = Color.rgb(0, 176, 255)
        @ColorInt @JvmStatic val LIGHT_BLUE_A700 = Color.rgb(0, 145, 234)

        @ColorInt @JvmStatic val CYAN_50 = Color.rgb(224, 247, 250)
        @ColorInt @JvmStatic val CYAN_100 = Color.rgb(178, 235, 242)
        @ColorInt @JvmStatic val CYAN_200 = Color.rgb(128, 222, 234)
        @ColorInt @JvmStatic val CYAN_300 = Color.rgb(77, 208, 225)
        @ColorInt @JvmStatic val CYAN_400 = Color.rgb(38, 198, 218)
        @ColorInt @JvmStatic val CYAN_500 = Color.rgb(0, 188, 212)
        @ColorInt @JvmStatic val CYAN_600 = Color.rgb(0, 172, 193)
        @ColorInt @JvmStatic val CYAN_700 = Color.rgb(0, 151, 167)
        @ColorInt @JvmStatic val CYAN_800 = Color.rgb(0, 131, 143)
        @ColorInt @JvmStatic val CYAN_900 = Color.rgb(0, 96, 100)
        @ColorInt @JvmStatic val CYAN_A100 = Color.rgb(133, 255, 255)
        @ColorInt @JvmStatic val CYAN_A200 = Color.rgb(24, 255, 255)
        @ColorInt @JvmStatic val CYAN_A400 = Color.rgb(0, 229, 255)
        @ColorInt @JvmStatic val CYAN_A700 = Color.rgb(0, 184, 212)

        @ColorInt @JvmStatic val TEAL_50 = Color.rgb(224, 242, 241)
        @ColorInt @JvmStatic val TEAL_100 = Color.rgb(178, 223, 219)
        @ColorInt @JvmStatic val TEAL_200 = Color.rgb(128, 203, 196)
        @ColorInt @JvmStatic val TEAL_300 = Color.rgb(77, 182, 172)
        @ColorInt @JvmStatic val TEAL_400 = Color.rgb(38, 166, 154)
        @ColorInt @JvmStatic val TEAL_500 = Color.rgb(0, 150, 136)
        @ColorInt @JvmStatic val TEAL_600 = Color.rgb(0, 137, 123)
        @ColorInt @JvmStatic val TEAL_700 = Color.rgb(0, 121, 107)
        @ColorInt @JvmStatic val TEAL_800 = Color.rgb(0, 105, 92)
        @ColorInt @JvmStatic val TEAL_900 = Color.rgb(0, 77, 64)
        @ColorInt @JvmStatic val TEAL_A100 = Color.rgb(167, 255, 235)
        @ColorInt @JvmStatic val TEAL_A200 = Color.rgb(100, 255, 218)
        @ColorInt @JvmStatic val TEAL_A400 = Color.rgb(29, 233, 182)
        @ColorInt @JvmStatic val TEAL_A700 = Color.rgb(0, 191, 165)

        @ColorInt @JvmStatic val GREEN_50 = Color.rgb(232, 245, 233)
        @ColorInt @JvmStatic val GREEN_100 = Color.rgb(200, 230, 201)
        @ColorInt @JvmStatic val GREEN_200 = Color.rgb(165, 214, 167)
        @ColorInt @JvmStatic val GREEN_300 = Color.rgb(129, 199, 132)
        @ColorInt @JvmStatic val GREEN_400 = Color.rgb(102, 187, 106)
        @ColorInt @JvmStatic val GREEN_500 = Color.rgb(76, 175, 80)
        @ColorInt @JvmStatic val GREEN_600 = Color.rgb(67, 160, 71)
        @ColorInt @JvmStatic val GREEN_700 = Color.rgb(56, 142, 60)
        @ColorInt @JvmStatic val GREEN_800 = Color.rgb(46, 125, 50)
        @ColorInt @JvmStatic val GREEN_900 = Color.rgb(27, 94, 32)
        @ColorInt @JvmStatic val GREEN_A100 = Color.rgb(185, 246, 202)
        @ColorInt @JvmStatic val GREEN_A200 = Color.rgb(105, 240, 174)
        @ColorInt @JvmStatic val GREEN_A400 = Color.rgb(0, 230, 118)
        @ColorInt @JvmStatic val GREEN_A700 = Color.rgb(0, 200, 83)

        @ColorInt @JvmStatic val LIGHT_GREEN_50 = Color.rgb(241, 248, 233)
        @ColorInt @JvmStatic val LIGHT_GREEN_100 = Color.rgb(220, 237, 200)
        @ColorInt @JvmStatic val LIGHT_GREEN_200 = Color.rgb(197, 225, 165)
        @ColorInt @JvmStatic val LIGHT_GREEN_300 = Color.rgb(174, 213, 219)
        @ColorInt @JvmStatic val LIGHT_GREEN_400 = Color.rgb(156, 204, 101)
        @ColorInt @JvmStatic val LIGHT_GREEN_500 = Color.rgb(139, 195, 74)
        @ColorInt @JvmStatic val LIGHT_GREEN_600 = Color.rgb(124, 179, 66)
        @ColorInt @JvmStatic val LIGHT_GREEN_700 = Color.rgb(104, 159, 56)
        @ColorInt @JvmStatic val LIGHT_GREEN_800 = Color.rgb(85, 139, 47)
        @ColorInt @JvmStatic val LIGHT_GREEN_900 = Color.rgb(51, 105, 30)
        @ColorInt @JvmStatic val LIGHT_GREEN_A100 = Color.rgb(204, 255, 144)
        @ColorInt @JvmStatic val LIGHT_GREEN_A200 = Color.rgb(178, 255, 89)
        @ColorInt @JvmStatic val LIGHT_GREEN_A400 = Color.rgb(118, 255, 3)
        @ColorInt @JvmStatic val LIGHT_GREEN_A700 = Color.rgb(100, 221, 23)

        @ColorInt @JvmStatic val LIME_50 = Color.rgb(249, 251, 231)
        @ColorInt @JvmStatic val LIME_100 = Color.rgb(240, 244, 195)
        @ColorInt @JvmStatic val LIME_200 = Color.rgb(230, 238, 156)
        @ColorInt @JvmStatic val LIME_300 = Color.rgb(220, 231, 117)
        @ColorInt @JvmStatic val LIME_400 = Color.rgb(212, 225, 87)
        @ColorInt @JvmStatic val LIME_500 = Color.rgb(205, 220, 57)
        @ColorInt @JvmStatic val LIME_600 = Color.rgb(192, 202, 51)
        @ColorInt @JvmStatic val LIME_700 = Color.rgb(175, 180, 43)
        @ColorInt @JvmStatic val LIME_800 = Color.rgb(158, 157, 36)
        @ColorInt @JvmStatic val LIME_900 = Color.rgb(130, 119, 23)
        @ColorInt @JvmStatic val LIME_A100 = Color.rgb(244, 255, 129)
        @ColorInt @JvmStatic val LIME_A200 = Color.rgb(238, 255, 65)
        @ColorInt @JvmStatic val LIME_A400 = Color.rgb(198, 255, 0)
        @ColorInt @JvmStatic val LIME_A700 = Color.rgb(174, 234, 0)

        @ColorInt @JvmStatic val YELLOW_50 = Color.rgb(255, 253, 231)
        @ColorInt @JvmStatic val YELLOW_100 = Color.rgb(255, 249, 196)
        @ColorInt @JvmStatic val YELLOW_200 = Color.rgb(255, 245, 157)
        @ColorInt @JvmStatic val YELLOW_300 = Color.rgb(255, 241, 118)
        @ColorInt @JvmStatic val YELLOW_400 = Color.rgb(255, 238, 88)
        @ColorInt @JvmStatic val YELLOW_500 = Color.rgb(255, 235, 59)
        @ColorInt @JvmStatic val YELLOW_600 = Color.rgb(253, 216, 53)
        @ColorInt @JvmStatic val YELLOW_700 = Color.rgb(251, 192, 45)
        @ColorInt @JvmStatic val YELLOW_800 = Color.rgb(249, 168, 37)
        @ColorInt @JvmStatic val YELLOW_900 = Color.rgb(245, 127, 23)
        @ColorInt @JvmStatic val YELLOW_A100 = Color.rgb(255, 255, 130)
        @ColorInt @JvmStatic val YELLOW_A200 = Color.rgb(255, 255, 0)
        @ColorInt @JvmStatic val YELLOW_A400 = Color.rgb(255, 234, 0)
        @ColorInt @JvmStatic val YELLOW_A700 = Color.rgb(255, 214, 0)

        @ColorInt @JvmStatic val AMBER_50 = Color.rgb(255, 248, 225)
        @ColorInt @JvmStatic val AMBER_100 = Color.rgb(255, 236, 179)
        @ColorInt @JvmStatic val AMBER_200 = Color.rgb(255, 224, 130)
        @ColorInt @JvmStatic val AMBER_300 = Color.rgb(255, 213, 79)
        @ColorInt @JvmStatic val AMBER_400 = Color.rgb(255, 202, 40)
        @ColorInt @JvmStatic val AMBER_500 = Color.rgb(255, 193, 7)
        @ColorInt @JvmStatic val AMBER_600 = Color.rgb(255, 179, 0)
        @ColorInt @JvmStatic val AMBER_700 = Color.rgb(255, 160, 0)
        @ColorInt @JvmStatic val AMBER_800 = Color.rgb(255, 143, 0)
        @ColorInt @JvmStatic val AMBER_900 = Color.rgb(255, 111, 0)
        @ColorInt @JvmStatic val AMBER_A100 = Color.rgb(255, 229, 127)
        @ColorInt @JvmStatic val AMBER_A200 = Color.rgb(255, 215, 64)
        @ColorInt @JvmStatic val AMBER_A400 = Color.rgb(255, 196, 0)
        @ColorInt @JvmStatic val AMBER_A700 = Color.rgb(255, 171, 0)

        @ColorInt @JvmStatic val ORANGE_50 = Color.rgb(255, 243 , 224)
        @ColorInt @JvmStatic val ORANGE_100 = Color.rgb(255, 224, 178)
        @ColorInt @JvmStatic val ORANGE_200 = Color.rgb(255, 204, 128)
        @ColorInt @JvmStatic val ORANGE_300 = Color.rgb(255, 183, 77)
        @ColorInt @JvmStatic val ORANGE_400 = Color.rgb(255, 167, 38)
        @ColorInt @JvmStatic val ORANGE_500 = Color.rgb(255, 152, 0)
        @ColorInt @JvmStatic val ORANGE_600 = Color.rgb(251, 140, 0)
        @ColorInt @JvmStatic val ORANGE_700 = Color.rgb(245, 124, 0)
        @ColorInt @JvmStatic val ORANGE_800 = Color.rgb(239, 108, 0)
        @ColorInt @JvmStatic val ORANGE_900 = Color.rgb(230, 81, 0)
        @ColorInt @JvmStatic val ORANGE_A100 = Color.rgb(255, 209, 128)
        @ColorInt @JvmStatic val ORANGE_A200 = Color.rgb(255, 171, 64)
        @ColorInt @JvmStatic val ORANGE_A400 = Color.rgb(255, 145, 0)
        @ColorInt @JvmStatic val ORANGE_A700 = Color.rgb(255, 109, 0)

        @ColorInt @JvmStatic val DEEP_ORANGE_50 = Color.rgb(251, 233, 231)
        @ColorInt @JvmStatic val DEEP_ORANGE_100 = Color.rgb(255, 204, 188)
        @ColorInt @JvmStatic val DEEP_ORANGE_200 = Color.rgb(255, 171, 145)
        @ColorInt @JvmStatic val DEEP_ORANGE_300 = Color.rgb(255, 138, 101)
        @ColorInt @JvmStatic val DEEP_ORANGE_400 = Color.rgb(255, 112, 67)
        @ColorInt @JvmStatic val DEEP_ORANGE_500 = Color.rgb(255, 87, 34)
        @ColorInt @JvmStatic val DEEP_ORANGE_600 = Color.rgb(244, 81, 30)
        @ColorInt @JvmStatic val DEEP_ORANGE_700 = Color.rgb(230, 74, 25)
        @ColorInt @JvmStatic val DEEP_ORANGE_800 = Color.rgb(216, 67, 21)
        @ColorInt @JvmStatic val DEEP_ORANGE_900 = Color.rgb(191, 54, 12)
        @ColorInt @JvmStatic val DEEP_ORANGE_A100 = Color.rgb(255, 158, 128)
        @ColorInt @JvmStatic val DEEP_ORANGE_A200 = Color.rgb(255, 110, 64)
        @ColorInt @JvmStatic val DEEP_ORANGE_A400 = Color.rgb(255, 61, 0)
        @ColorInt @JvmStatic val DEEP_ORANGE_A700 = Color.rgb(221, 44, 0)

        @ColorInt @JvmStatic val BROWN_50 = Color.rgb(239, 235, 233)
        @ColorInt @JvmStatic val BROWN_100 = Color.rgb(215, 204, 200)
        @ColorInt @JvmStatic val BROWN_200 = Color.rgb(188, 170, 164)
        @ColorInt @JvmStatic val BROWN_300 = Color.rgb(161, 136, 127)
        @ColorInt @JvmStatic val BROWN_400 = Color.rgb(141, 110, 99)
        @ColorInt @JvmStatic val BROWN_500 = Color.rgb(121, 85, 72)
        @ColorInt @JvmStatic val BROWN_600 = Color.rgb(109, 76, 65)
        @ColorInt @JvmStatic val BROWN_700 = Color.rgb(93, 64, 55)
        @ColorInt @JvmStatic val BROWN_800 = Color.rgb(78, 52, 46)
        @ColorInt @JvmStatic val BROWN_900 = Color.rgb(62, 39, 35)

        @ColorInt @JvmStatic val GREY_50 = Color.rgb(250, 250, 250)
        @ColorInt @JvmStatic val GREY_100 = Color.rgb(245, 245, 245)
        @ColorInt @JvmStatic val GREY_200 = Color.rgb(238, 238, 238)
        @ColorInt @JvmStatic val GREY_300 = Color.rgb(224, 224, 224)
        @ColorInt @JvmStatic val GREY_400 = Color.rgb(189, 189, 189)
        @ColorInt @JvmStatic val GREY_500 = Color.rgb(158, 158, 158)
        @ColorInt @JvmStatic val GREY_600 = Color.rgb(117, 117, 117)
        @ColorInt @JvmStatic val GREY_700 = Color.rgb(97, 97, 97)
        @ColorInt @JvmStatic val GREY_800 = Color.rgb(66, 66, 66)
        @ColorInt @JvmStatic val GREY_900 = Color.rgb(33, 33, 33)

        @ColorInt @JvmStatic val BLUE_GREY_50 = Color.rgb(236, 239, 241)
        @ColorInt @JvmStatic val BLUE_GREY_100 = Color.rgb(207, 216, 220)
        @ColorInt @JvmStatic val BLUE_GREY_200 = Color.rgb(176, 190, 197)
        @ColorInt @JvmStatic val BLUE_GREY_300 = Color.rgb(144, 164, 174)
        @ColorInt @JvmStatic val BLUE_GREY_400 = Color.rgb(120, 144, 156)
        @ColorInt @JvmStatic val BLUE_GREY_500 = Color.rgb(96, 125, 139)
        @ColorInt @JvmStatic val BLUE_GREY_600 = Color.rgb(84, 110, 122)
        @ColorInt @JvmStatic val BLUE_GREY_700 = Color.rgb(69, 90, 100)
        @ColorInt @JvmStatic val BLUE_GREY_800 = Color.rgb(55, 71, 79)
        @ColorInt @JvmStatic val BLUE_GREY_900 = Color.rgb(38, 50, 56)

        @ColorInt @JvmStatic val WHITE = Color.WHITE
        @ColorInt @JvmStatic val BLACK = Color.BLACK

        /** An array containing all 14 Material RED colors. */
        @JvmStatic val redColorArray = intArrayOf(RED_50, RED_100, RED_200, RED_300, RED_400, RED_500, RED_600, RED_700, RED_800, RED_900, RED_A100, RED_A200, RED_A400, RED_A700)

        /** An array containing all 14 Material PINK colors. */
        @JvmStatic val pinkColorArray = intArrayOf(PINK_50, PINK_100, PINK_200, PINK_300, PINK_400, PINK_500, PINK_600, PINK_700, PINK_800, PINK_900, PINK_A100, PINK_A200, PINK_A400, PINK_A700)

        /** An array containing all 14 Material PURPLE colors. */
        @JvmStatic val purpleColorArray = intArrayOf(PURPLE_50, PURPLE_100, PURPLE_200, PURPLE_300, PURPLE_400, PURPLE_500, PURPLE_600, PURPLE_700, PURPLE_800, PURPLE_900, PURPLE_A100, PURPLE_A200, PURPLE_A400, PURPLE_A700)

        /** An array containing all 14 Material DEEP PURPLE colors. */
        @JvmStatic val deepPurpleColorArray = intArrayOf(DEEP_PURPLE_50, DEEP_PURPLE_100, DEEP_PURPLE_200, DEEP_PURPLE_300, DEEP_PURPLE_400, DEEP_PURPLE_500, DEEP_PURPLE_600, DEEP_PURPLE_700, DEEP_PURPLE_800, DEEP_PURPLE_900, DEEP_PURPLE_A100, DEEP_PURPLE_A200, DEEP_PURPLE_A400, DEEP_PURPLE_A700)

        /** An array containing all 14 Material INDIGO colors. */
        @JvmStatic val indigoColorArray = intArrayOf(INDIGO_50, INDIGO_100, INDIGO_200, INDIGO_300, INDIGO_400, INDIGO_500, INDIGO_600, INDIGO_700, INDIGO_800, INDIGO_900, INDIGO_A100, INDIGO_A200, INDIGO_A400, INDIGO_A700)

        /** An array containing all 14 Material BLUE colors. */
        @JvmStatic val blueColorArray = intArrayOf(BLUE_50, BLUE_100, BLUE_200, BLUE_300, BLUE_400, BLUE_500, BLUE_600, BLUE_700, BLUE_800, BLUE_900, BLUE_A100, BLUE_A200, BLUE_A400, BLUE_A700)

        /** An array containing all 14 Material LIGHT BLUE colors. */
        @JvmStatic val lightBlueColorArray = intArrayOf(LIGHT_BLUE_50, LIGHT_BLUE_100, LIGHT_BLUE_200, LIGHT_BLUE_300, LIGHT_BLUE_400, LIGHT_BLUE_500, LIGHT_BLUE_600, LIGHT_BLUE_700, LIGHT_BLUE_800, LIGHT_BLUE_900, LIGHT_BLUE_A100, LIGHT_BLUE_A200, LIGHT_BLUE_A400, LIGHT_BLUE_A700)

        /** An array containing all 14 Material  CYAN colors. */
        @JvmStatic val cyanColorArray = intArrayOf(CYAN_50, CYAN_100, CYAN_200, CYAN_300, CYAN_400, CYAN_500, CYAN_600, CYAN_700, CYAN_800, CYAN_900, CYAN_A100, CYAN_A200, CYAN_A400, CYAN_A700)

        /** An array containing all 14 Material TEAL colors. */
        @JvmStatic val tealColorArray = intArrayOf(TEAL_50, TEAL_100, TEAL_200, TEAL_300, TEAL_400, TEAL_500, TEAL_600, TEAL_700, TEAL_800, TEAL_900, TEAL_A100, TEAL_A200, TEAL_A400, TEAL_A700)

        /** An array containing all 14 Material GREEN colors. */
        @JvmStatic val greenColorArray = intArrayOf(GREEN_50, GREEN_100, GREEN_200, GREEN_300, GREEN_400, GREEN_500, GREEN_600, GREEN_700, GREEN_800, GREEN_900, GREEN_A100, GREEN_A200, GREEN_A400, GREEN_A700)

        /** An array containing all 14 Material LIGHT GREEN colors. */
        @JvmStatic val lightGreenColorArray = intArrayOf(LIGHT_GREEN_50, LIGHT_GREEN_100, LIGHT_GREEN_200, LIGHT_GREEN_300, LIGHT_GREEN_400, LIGHT_GREEN_500, LIGHT_GREEN_600, LIGHT_GREEN_700, LIGHT_GREEN_800, LIGHT_GREEN_900, LIGHT_GREEN_A100, LIGHT_GREEN_A200, LIGHT_GREEN_A400, LIGHT_GREEN_A700)

        /** An array containing all 14 Material LIME colors. */
        @JvmStatic val limeColorArray = intArrayOf(LIME_50, LIME_100, LIME_200, LIME_300, LIME_400, LIME_500, LIME_600, LIME_700, LIME_800, LIME_900, LIME_A100, LIME_A200, LIME_A400, LIME_A700)

        /**  An array containing all 14 Material YELLOW colors. */
        @JvmStatic val yellowColorArray = intArrayOf(YELLOW_50, YELLOW_100, YELLOW_200, YELLOW_300, YELLOW_400, YELLOW_500, YELLOW_600, YELLOW_700, YELLOW_800, YELLOW_900, YELLOW_A100, YELLOW_A200, YELLOW_A400, YELLOW_A700)

        /** An array containing all 14 Material AMBER colors. */
        @JvmStatic val amberColorArray = intArrayOf(AMBER_50, AMBER_100, AMBER_200, AMBER_300, AMBER_400, AMBER_500, AMBER_600, AMBER_700, AMBER_800, AMBER_900, AMBER_A100, AMBER_A200, AMBER_A400, AMBER_A700)

        /** An array containing all 14 Material ORANGE colors. */
        @JvmStatic val orangeColorArray = intArrayOf(ORANGE_50, ORANGE_100, ORANGE_200, ORANGE_300, ORANGE_400, ORANGE_500, ORANGE_600, ORANGE_700, ORANGE_800, ORANGE_900, ORANGE_A100, ORANGE_A200, ORANGE_A400, ORANGE_A700)

        /** An array containing all 14 Material DEEP ORANGE colors. */
        @JvmStatic val deepOrangeColorArray = intArrayOf(DEEP_ORANGE_50, DEEP_ORANGE_100, DEEP_ORANGE_200, DEEP_ORANGE_300, DEEP_ORANGE_400, DEEP_ORANGE_500, DEEP_ORANGE_600, DEEP_ORANGE_700, DEEP_ORANGE_800, DEEP_ORANGE_900, DEEP_ORANGE_A100, DEEP_ORANGE_A200, DEEP_ORANGE_A400, DEEP_ORANGE_A700)

        /** An array containing all 10 Material BROWN colors. */
        @JvmStatic val brownColorArray = intArrayOf(BROWN_50, BROWN_100, BROWN_200, BROWN_300, BROWN_400, BROWN_500, BROWN_600, BROWN_700, BROWN_800, BROWN_900)

        /** An array containing all 10 Material PINK colors. */
        @JvmStatic val greyColorArray = intArrayOf(GREY_50, GREY_100, GREY_200, GREY_300, GREY_400, GREY_500, GREY_600, GREY_700, GREY_800, GREY_900)

        /** An array containing all 10 Material BLUE GREY colors. */
        @JvmStatic val blueGreyColorArray = intArrayOf(BLUE_GREY_50, BLUE_GREY_100, BLUE_GREY_200, BLUE_GREY_300, BLUE_GREY_400, BLUE_GREY_500, BLUE_GREY_600, BLUE_GREY_700, BLUE_GREY_800, BLUE_GREY_900)

        private val arrayOfAllColorArrays = arrayOf(
            redColorArray, pinkColorArray, purpleColorArray, deepPurpleColorArray, indigoColorArray, blueColorArray,
            lightBlueColorArray, cyanColorArray, tealColorArray, greenColorArray, lightGreenColorArray, limeColorArray,
            yellowColorArray, amberColorArray, orangeColorArray, deepOrangeColorArray, brownColorArray, greyColorArray,
            blueGreyColorArray
        )

        /**
         * Gets a random shade of Material RED from the [Red Color Array][redColorArray].
         *
         * @return @[ColorInt] RED.
         */
        @JvmStatic fun randomRedColor() = redColorArray[(redColorArray.indices).random()]

        /**
         * Gets a random shade of Material PINK from the [Pink Color Array][pinkColorArray].
         *
         * @return @[ColorInt] PINK.
         */
        @JvmStatic fun randomPinkColor() = pinkColorArray[(pinkColorArray.indices).random()]

        /**
         * Gets a random shade of Material PURPLE from the [Purple Color Array][purpleColorArray].
         *
         * @return @[ColorInt] PURPLE.
         */
        @JvmStatic fun randomPurpleColor() = purpleColorArray[(purpleColorArray.indices).random()]

        /**
         * Gets a random shade of Material DEEP PURPLE from the [Deep Purple Color Array][deepPurpleColorArray].
         *
         * @return @[ColorInt] DEEP PURPLE.
         */
        @JvmStatic fun randomDeepPurpleColor() = deepPurpleColorArray[(deepPurpleColorArray.indices).random()]

        /**
         * Gets a random shade of Material INDIGO from the [Indigo Color Array][indigoColorArray].
         *
         * @return @[ColorInt] INDIGO.
         */
        @JvmStatic fun randomIndigoColor() = indigoColorArray[(indigoColorArray.indices).random()]

        /**
         * Gets a random shade of Material BLUE from the [Blue Color Array][blueColorArray].
         *
         * @return @[ColorInt] BLUE.
         */
        @JvmStatic fun randomBlueColor() = blueColorArray[(blueColorArray.indices).random()]

        /**
         * Gets a random shade of Material LIGHT BLUE from the [Light Blue Color Array][lightBlueColorArray].
         *
         * @return @[ColorInt] LIGHT BLUE.
         */
        @JvmStatic fun randomLightBlueColor() = lightBlueColorArray[(lightBlueColorArray.indices).random()]

        /**
         * Gets a random shade of Material CYAN  from the [Cyan Color Array][cyanColorArray].
         *
         * @return @[ColorInt] CYAN.
         */
        @JvmStatic fun randomCyanColor() = cyanColorArray[(cyanColorArray.indices).random()]

        /**
         * Gets a random shade of Material TEAL from the [Teal Color Array][tealColorArray].
         *
         * @return @[ColorInt] TEAL.
         */
        @JvmStatic fun randomTealColor() = tealColorArray[(tealColorArray.indices).random()]

        /**
         * Gets a random shade of Material GREEN from the [Green Color Array][greenColorArray].
         *
         * @return @[ColorInt] GREEN.
         */
        @JvmStatic fun randomGreenColor() = greenColorArray[(greenColorArray.indices).random()]

        /**
         * Gets a random shade of Material LIGHT GREEN from the [Light Green Color Array][lightGreenColorArray].
         *
         * @return @[ColorInt] LIGHT GREEN.
         */
        @JvmStatic fun randomLightGreenColor() = lightGreenColorArray[(lightGreenColorArray.indices).random()]

        /**
         * Gets a random shade of Material LIME from the [Lime Color Array][limeColorArray].
         *
         * @return @[ColorInt] LIME.
         */
        @JvmStatic fun randomLimeColor() = limeColorArray[(limeColorArray.indices).random()]

        /**
         * Gets a random shade of Material YELLOW from the [Yellow Color Array][yellowColorArray].
         *
         * @return @[ColorInt] YELLOW.
         */
        @JvmStatic fun randomYellowColor() = yellowColorArray[(yellowColorArray.indices).random()]

        /**
         * Gets a random shade of Material AMBER from the [Amber Color Array][amberColorArray].
         *
         * @return @[ColorInt] AMBER.
         */
        @JvmStatic fun randomAmberColor() = amberColorArray[(amberColorArray.indices).random()]

        /**
         * Gets a random shade of Material ORANGE from the [Orange Color Array][orangeColorArray].
         *
         * @return @[ColorInt] ORANGE.
         */
        @JvmStatic fun randomOrangeColor() = orangeColorArray[(orangeColorArray.indices).random()]

        /**
         * Gets a random shade of Material DEEP ORANGE from the [Deep Orange Color Array][deepOrangeColorArray].
         *
         * @return @[ColorInt] DEEP ORANGE.
         */
        @JvmStatic fun randomDeepOrangeColor() = deepOrangeColorArray[(deepOrangeColorArray.indices).random()]

        /**
         * Gets a random shade of Material BROWN from the [Brown Color Array][brownColorArray].
         *
         * @return @[ColorInt] BROWN.
         */
        @JvmStatic fun randomBrownColor() = brownColorArray[(brownColorArray.indices).random()]

        /**
         * Gets a random shade of Material GREY from the [Grey Color Array][greyColorArray].
         *
         * @return @[ColorInt] GREY.
         */
        @JvmStatic fun randomGreyColor() = greyColorArray[(greyColorArray.indices).random()]

        /**
         * Gets a random shade of Material BLUE GREY from the [Blue Grey Color Array][blueGreyColorArray].
         *
         * @return @[ColorInt] BLUE GREY.
         */
        @JvmStatic fun randomBlueGreyColor() = blueGreyColorArray[(blueGreyColorArray.indices).random()]

        /**
         * Picks a random color from one of the [MaterialDesign] colors.
         *
         */
        @JvmStatic fun selectRandomColor(): Int {
            val anyColorIntArray = arrayOfAllColorArrays[(arrayOfAllColorArrays.indices).random()]
            return anyColorIntArray[((anyColorIntArray.indices).random())]
        }
    }

    /**
     * The Flat Design UI colors are popular in web design and are used to create simple user-friendly interfaces.
     * Flat Design technique uses simple effects to create designs without effects like shadows, bevels, gradients and embossing.
     */
    object FlatDesign {

        @ColorInt @JvmStatic val POMEGRANATE_50 = Color.rgb(249, 235, 234)
        @ColorInt @JvmStatic val POMEGRANATE_100 = Color.rgb(242, 215, 213)
        @ColorInt @JvmStatic val POMEGRANATE_200 = Color.rgb(230, 176, 170)
        @ColorInt @JvmStatic val POMEGRANATE_300 = Color.rgb(217, 136, 128)
        @ColorInt @JvmStatic val POMEGRANATE_400 = Color.rgb(205, 97, 85)
        @ColorInt @JvmStatic val POMEGRANATE_500 = Color.rgb(192, 57, 43)
        @ColorInt @JvmStatic val POMEGRANATE_600 = Color.rgb(169, 50, 38)
        @ColorInt @JvmStatic val POMEGRANATE_700 = Color.rgb(146, 43, 33)
        @ColorInt @JvmStatic val POMEGRANATE_800 = Color.rgb(123, 36, 28)
        @ColorInt @JvmStatic val POMEGRANATE_900 = Color.rgb(100, 30, 22)

        @ColorInt @JvmStatic val ALIZARIN_50 = Color.rgb(253, 237, 236)
        @ColorInt @JvmStatic val ALIZARIN_100 = Color.rgb(250, 219, 216)
        @ColorInt @JvmStatic val ALIZARIN_200 = Color.rgb(245, 183, 177)
        @ColorInt @JvmStatic val ALIZARIN_300 = Color.rgb(241, 148, 138)
        @ColorInt @JvmStatic val ALIZARIN_400 = Color.rgb(236, 112, 99)
        @ColorInt @JvmStatic val ALIZARIN_500 = Color.rgb(231, 76, 60)
        @ColorInt @JvmStatic val ALIZARIN_600 = Color.rgb(203, 67, 53)
        @ColorInt @JvmStatic val ALIZARIN_700 = Color.rgb(176, 58, 46)
        @ColorInt @JvmStatic val ALIZARIN_800 = Color.rgb(148, 49, 38)
        @ColorInt @JvmStatic val ALIZARIN_900 = Color.rgb(120, 40, 31)

        @ColorInt @JvmStatic val AMETHYST_50 = Color.rgb(245, 238, 248)
        @ColorInt @JvmStatic val AMETHYST_100 = Color.rgb(235, 222, 240)
        @ColorInt @JvmStatic val AMETHYST_200 = Color.rgb(215, 189, 226)
        @ColorInt @JvmStatic val AMETHYST_300 = Color.rgb(195, 155, 211)
        @ColorInt @JvmStatic val AMETHYST_400 = Color.rgb(175, 122, 197)
        @ColorInt @JvmStatic val AMETHYST_500 = Color.rgb(155, 89, 182)
        @ColorInt @JvmStatic val AMETHYST_600 = Color.rgb(136, 78, 160)
        @ColorInt @JvmStatic val AMETHYST_700 = Color.rgb(118, 68, 138)
        @ColorInt @JvmStatic val AMETHYST_800 = Color.rgb(99, 57, 116)
        @ColorInt @JvmStatic val AMETHYST_900 = Color.rgb(81, 46, 95)

        @ColorInt @JvmStatic val WISTERIA_50 = Color.rgb(244, 236, 247)
        @ColorInt @JvmStatic val WISTERIA_100 = Color.rgb(232, 218, 239)
        @ColorInt @JvmStatic val WISTERIA_200 = Color.rgb(210, 180, 222)
        @ColorInt @JvmStatic val WISTERIA_300 = Color.rgb(187, 143, 206)
        @ColorInt @JvmStatic val WISTERIA_400 = Color.rgb(165, 105, 189)
        @ColorInt @JvmStatic val WISTERIA_500 = Color.rgb(142, 68, 173)
        @ColorInt @JvmStatic val WISTERIA_600 = Color.rgb(125, 60, 152)
        @ColorInt @JvmStatic val WISTERIA_700 = Color.rgb(108, 52, 131)
        @ColorInt @JvmStatic val WISTERIA_800 = Color.rgb(91, 44, 111)
        @ColorInt @JvmStatic val WISTERIA_900 = Color.rgb(74, 35, 90)

        @ColorInt @JvmStatic val BELIZE_HOLE_50 = Color.rgb(234, 242, 248)
        @ColorInt @JvmStatic val BELIZE_HOLE_100 = Color.rgb(212, 230, 241)
        @ColorInt @JvmStatic val BELIZE_HOLE_200 = Color.rgb(169, 204, 227)
        @ColorInt @JvmStatic val BELIZE_HOLE_300 = Color.rgb(127, 179, 213)
        @ColorInt @JvmStatic val BELIZE_HOLE_400 = Color.rgb(84, 153, 199)
        @ColorInt @JvmStatic val BELIZE_HOLE_500 = Color.rgb(41, 128, 185)
        @ColorInt @JvmStatic val BELIZE_HOLE_600 = Color.rgb(36, 113, 163)
        @ColorInt @JvmStatic val BELIZE_HOLE_700 = Color.rgb(31, 97, 141)
        @ColorInt @JvmStatic val BELIZE_HOLE_800 = Color.rgb(26, 82, 118)
        @ColorInt @JvmStatic val BELIZE_HOLE_900 = Color.rgb(21, 67, 96)

        @ColorInt @JvmStatic val PETER_RIVER_50 = Color.rgb(235, 245, 251)
        @ColorInt @JvmStatic val PETER_RIVER_100 = Color.rgb(214, 234, 248)
        @ColorInt @JvmStatic val PETER_RIVER_200 = Color.rgb(174, 214, 241)
        @ColorInt @JvmStatic val PETER_RIVER_300 = Color.rgb(133, 193, 233)
        @ColorInt @JvmStatic val PETER_RIVER_400 = Color.rgb(93, 173, 226)
        @ColorInt @JvmStatic val PETER_RIVER_500 = Color.rgb(52, 152, 219)
        @ColorInt @JvmStatic val PETER_RIVER_600 = Color.rgb(46, 134, 193)
        @ColorInt @JvmStatic val PETER_RIVER_700 = Color.rgb(40, 116, 166)
        @ColorInt @JvmStatic val PETER_RIVER_800 = Color.rgb(33, 97, 140)
        @ColorInt @JvmStatic val PETER_RIVER_900 = Color.rgb(27, 79, 114)

        @ColorInt @JvmStatic val TORQUOISE_50 = Color.rgb(232, 248, 245)
        @ColorInt @JvmStatic val TORQUOISE_100 = Color.rgb(209, 242, 235)
        @ColorInt @JvmStatic val TORQUOISE_200 = Color.rgb(163, 228, 215)
        @ColorInt @JvmStatic val TORQUOISE_300 = Color.rgb(118, 215, 196)
        @ColorInt @JvmStatic val TORQUOISE_400 = Color.rgb(72, 201, 176)
        @ColorInt @JvmStatic val TORQUOISE_500 = Color.rgb(26, 188, 156)
        @ColorInt @JvmStatic val TORQUOISE_600 = Color.rgb(23, 165, 137)
        @ColorInt @JvmStatic val TORQUOISE_700 = Color.rgb(20, 143, 119)
        @ColorInt @JvmStatic val TORQUOISE_800 = Color.rgb(17, 120, 100)
        @ColorInt @JvmStatic val TORQUOISE_900 = Color.rgb(14, 98, 81)

        @ColorInt @JvmStatic val GREEN_SEA_50 = Color.rgb(232, 246, 243)
        @ColorInt @JvmStatic val GREEN_SEA_100 = Color.rgb(208, 236, 231)
        @ColorInt @JvmStatic val GREEN_SEA_200 = Color.rgb(162, 217, 206)
        @ColorInt @JvmStatic val GREEN_SEA_300 = Color.rgb(115, 198, 182)
        @ColorInt @JvmStatic val GREEN_SEA_400 = Color.rgb(69, 179, 157)
        @ColorInt @JvmStatic val GREEN_SEA_500 = Color.rgb(22, 160, 133)
        @ColorInt @JvmStatic val GREEN_SEA_600 = Color.rgb(19, 141, 117)
        @ColorInt @JvmStatic val GREEN_SEA_700 = Color.rgb(17, 122, 101)
        @ColorInt @JvmStatic val GREEN_SEA_800 = Color.rgb(14, 102, 85)
        @ColorInt @JvmStatic val GREEN_SEA_900 = Color.rgb(11, 83, 69)

        @ColorInt @JvmStatic val NEPHRITIS_50 = Color.rgb(233, 247, 239)
        @ColorInt @JvmStatic val NEPHRITIS_100 = Color.rgb(212, 239, 223)
        @ColorInt @JvmStatic val NEPHRITIS_200 = Color.rgb(169, 223, 191)
        @ColorInt @JvmStatic val NEPHRITIS_300 = Color.rgb(125, 206, 160)
        @ColorInt @JvmStatic val NEPHRITIS_400 = Color.rgb(82, 190, 128)
        @ColorInt @JvmStatic val NEPHRITIS_500 = Color.rgb(39, 174, 96)
        @ColorInt @JvmStatic val NEPHRITIS_600 = Color.rgb(34, 153, 84)
        @ColorInt @JvmStatic val NEPHRITIS_700 = Color.rgb(30, 132, 73)
        @ColorInt @JvmStatic val NEPHRITIS_800 = Color.rgb(25, 111, 61)
        @ColorInt @JvmStatic val NEPHRITIS_900 = Color.rgb(20, 90, 50)

        @ColorInt @JvmStatic val EMERALD_50 = Color.rgb(234, 250, 241)
        @ColorInt @JvmStatic val EMERALD_100 = Color.rgb(213, 245, 227)
        @ColorInt @JvmStatic val EMERALD_200 = Color.rgb(171, 235, 198)
        @ColorInt @JvmStatic val EMERALD_300 = Color.rgb(130, 224, 170)
        @ColorInt @JvmStatic val EMERALD_400 = Color.rgb(88, 214, 141)
        @ColorInt @JvmStatic val EMERALD_500 = Color.rgb(46, 204, 113)
        @ColorInt @JvmStatic val EMERALD_600 = Color.rgb(40, 180, 99)
        @ColorInt @JvmStatic val EMERALD_700 = Color.rgb(35, 155, 86)
        @ColorInt @JvmStatic val EMERALD_800 = Color.rgb(29, 131, 72)
        @ColorInt @JvmStatic val EMERALD_900 = Color.rgb(24, 106, 59)

        @ColorInt @JvmStatic val SUNFLOWER_50 = Color.rgb(254, 249, 231)
        @ColorInt @JvmStatic val SUNFLOWER_100 = Color.rgb(252, 243, 207)
        @ColorInt @JvmStatic val SUNFLOWER_200 = Color.rgb(249, 231, 159)
        @ColorInt @JvmStatic val SUNFLOWER_300 = Color.rgb(247, 220, 111)
        @ColorInt @JvmStatic val SUNFLOWER_400 = Color.rgb(244, 208, 63)
        @ColorInt @JvmStatic val SUNFLOWER_500 = Color.rgb(241, 196, 15)
        @ColorInt @JvmStatic val SUNFLOWER_600 = Color.rgb(212, 172, 13)
        @ColorInt @JvmStatic val SUNFLOWER_700 = Color.rgb(183, 149, 11)
        @ColorInt @JvmStatic val SUNFLOWER_800 = Color.rgb(154, 125, 10)
        @ColorInt @JvmStatic val SUNFLOWER_900 = Color.rgb(125, 102, 8)

        @ColorInt @JvmStatic val ORANGE_50 = Color.rgb(254, 245, 231)
        @ColorInt @JvmStatic val ORANGE_100 = Color.rgb(253, 235, 208)
        @ColorInt @JvmStatic val ORANGE_200 = Color.rgb(250, 215, 160)
        @ColorInt @JvmStatic val ORANGE_300 = Color.rgb(248, 196, 113)
        @ColorInt @JvmStatic val ORANGE_400 = Color.rgb(245, 176, 65)
        @ColorInt @JvmStatic val ORANGE_500 = Color.rgb(243, 156, 18)
        @ColorInt @JvmStatic val ORANGE_600 = Color.rgb(214, 137, 16)
        @ColorInt @JvmStatic val ORANGE_700 = Color.rgb(185, 119, 14)
        @ColorInt @JvmStatic val ORANGE_800 = Color.rgb(156, 100, 12)
        @ColorInt @JvmStatic val ORANGE_900 = Color.rgb(126, 81, 9)

        @ColorInt @JvmStatic val CARROT_50 = Color.rgb(253, 242, 233)
        @ColorInt @JvmStatic val CARROT_100 = Color.rgb(250, 229, 211)
        @ColorInt @JvmStatic val CARROT_200 = Color.rgb(245, 203, 167)
        @ColorInt @JvmStatic val CARROT_300 = Color.rgb(240, 178, 122)
        @ColorInt @JvmStatic val CARROT_400 = Color.rgb(235, 152, 78)
        @ColorInt @JvmStatic val CARROT_500 = Color.rgb(230, 126, 34)
        @ColorInt @JvmStatic val CARROT_600 = Color.rgb(202, 111, 30)
        @ColorInt @JvmStatic val CARROT_700 = Color.rgb(175, 96, 26)
        @ColorInt @JvmStatic val CARROT_800 = Color.rgb(147, 81, 22)
        @ColorInt @JvmStatic val CARROT_900 = Color.rgb(120, 66, 18)

        @ColorInt @JvmStatic val PUMPKIN_50 = Color.rgb(251, 238, 230)
        @ColorInt @JvmStatic val PUMPKIN_100 = Color.rgb(246, 221, 204)
        @ColorInt @JvmStatic val PUMPKIN_200 = Color.rgb(237, 187, 153)
        @ColorInt @JvmStatic val PUMPKIN_300 = Color.rgb(229, 152, 102)
        @ColorInt @JvmStatic val PUMPKIN_400 = Color.rgb(220, 118, 51)
        @ColorInt @JvmStatic val PUMPKIN_500 = Color.rgb(211, 84, 0)
        @ColorInt @JvmStatic val PUMPKIN_600 = Color.rgb(186, 74, 0)
        @ColorInt @JvmStatic val PUMPKIN_700 = Color.rgb(160, 64, 0)
        @ColorInt @JvmStatic val PUMPKIN_800 = Color.rgb(135, 54, 0)
        @ColorInt @JvmStatic val PUMPKIN_900 = Color.rgb(110, 44, 0)

        @ColorInt @JvmStatic val CLOUD_50 = Color.rgb(253, 254, 254)
        @ColorInt @JvmStatic val CLOUD_100 = Color.rgb(251, 252, 252)
        @ColorInt @JvmStatic val CLOUD_200 = Color.rgb(247, 249, 249)
        @ColorInt @JvmStatic val CLOUD_300 = Color.rgb(244, 246, 247)
        @ColorInt @JvmStatic val CLOUD_400 = Color.rgb(240, 243, 244)
        @ColorInt @JvmStatic val CLOUD_500 = Color.rgb(236, 240, 241)
        @ColorInt @JvmStatic val CLOUD_600 = Color.rgb(208, 211, 212)
        @ColorInt @JvmStatic val CLOUD_700 = Color.rgb(179, 182, 183)
        @ColorInt @JvmStatic val CLOUD_800 = Color.rgb(151, 154, 154)
        @ColorInt @JvmStatic val CLOUD_900 = Color.rgb(123, 125, 125)

        @ColorInt @JvmStatic val SILVER_50 = Color.rgb(248, 249, 249)
        @ColorInt @JvmStatic val SILVER_100 = Color.rgb(242, 243, 244)
        @ColorInt @JvmStatic val SILVER_200 = Color.rgb(229, 231, 233)
        @ColorInt @JvmStatic val SILVER_300 = Color.rgb(215, 219, 221)
        @ColorInt @JvmStatic val SILVER_400 = Color.rgb(202, 207, 210)
        @ColorInt @JvmStatic val SILVER_500 = Color.rgb(189, 195, 199)
        @ColorInt @JvmStatic val SILVER_600 = Color.rgb(166, 172, 175)
        @ColorInt @JvmStatic val SILVER_700 = Color.rgb(144, 148, 151)
        @ColorInt @JvmStatic val SILVER_800 = Color.rgb(121, 125, 127)
        @ColorInt @JvmStatic val SILVER_900 = Color.rgb(98, 101, 103)

        @ColorInt @JvmStatic val CONCRETE_50 = Color.rgb(244, 246, 246)
        @ColorInt @JvmStatic val CONCRETE_100 = Color.rgb(234, 237, 237)
        @ColorInt @JvmStatic val CONCRETE_200 = Color.rgb(213, 219, 219)
        @ColorInt @JvmStatic val CONCRETE_300 = Color.rgb(191, 201, 202)
        @ColorInt @JvmStatic val CONCRETE_400 = Color.rgb(170, 183, 184)
        @ColorInt @JvmStatic val CONCRETE_500 = Color.rgb(149, 165, 166)
        @ColorInt @JvmStatic val CONCRETE_600 = Color.rgb(131, 145, 146)
        @ColorInt @JvmStatic val CONCRETE_700 = Color.rgb(113, 125, 126)
        @ColorInt @JvmStatic val CONCRETE_800 = Color.rgb(95, 106, 106)
        @ColorInt @JvmStatic val CONCRETE_900 = Color.rgb(77, 86, 86)

        @ColorInt @JvmStatic val ASBESTOS_50 = Color.rgb(242, 244, 244)
        @ColorInt @JvmStatic val ASBESTOS_100 = Color.rgb(229, 232, 232)
        @ColorInt @JvmStatic val ASBESTOS_200 = Color.rgb(204, 209, 209)
        @ColorInt @JvmStatic val ASBESTOS_300 = Color.rgb(178, 186, 187)
        @ColorInt @JvmStatic val ASBESTOS_400 = Color.rgb(153, 163, 164)
        @ColorInt @JvmStatic val ASBESTOS_500 = Color.rgb(127, 140, 141)
        @ColorInt @JvmStatic val ASBESTOS_600 = Color.rgb(112, 123, 124)
        @ColorInt @JvmStatic val ASBESTOS_700 = Color.rgb(97, 106, 107)
        @ColorInt @JvmStatic val ASBESTOS_800 = Color.rgb(81, 90, 90)
        @ColorInt @JvmStatic val ASBESTOS_900 = Color.rgb(66, 73, 73)

        @ColorInt @JvmStatic val WET_ASPHALT_50 = Color.rgb(235, 237, 239)
        @ColorInt @JvmStatic val WET_ASPHALT_100 = Color.rgb(214, 219, 223)
        @ColorInt @JvmStatic val WET_ASPHALT_200 = Color.rgb(174, 182, 191)
        @ColorInt @JvmStatic val WET_ASPHALT_300 = Color.rgb(133, 146, 158)
        @ColorInt @JvmStatic val WET_ASPHALT_400 = Color.rgb(93, 109, 126)
        @ColorInt @JvmStatic val WET_ASPHALT_500 = Color.rgb(52, 73, 94)
        @ColorInt @JvmStatic val WET_ASPHALT_600 = Color.rgb(46, 64, 83)
        @ColorInt @JvmStatic val WET_ASPHALT_700 = Color.rgb(40, 55, 71)
        @ColorInt @JvmStatic val WET_ASPHALT_800 = Color.rgb(33, 47, 60)
        @ColorInt @JvmStatic val WET_ASPHALT_900 = Color.rgb(27, 38, 49)

        @ColorInt @JvmStatic val MIDNIGHT_BLUE_50 = Color.rgb(234, 236, 238)
        @ColorInt @JvmStatic val MIDNIGHT_BLUE_100 = Color.rgb(213, 216, 220)
        @ColorInt @JvmStatic val MIDNIGHT_BLUE_200 = Color.rgb(171, 178, 185)
        @ColorInt @JvmStatic val MIDNIGHT_BLUE_300 = Color.rgb(128, 139, 150)
        @ColorInt @JvmStatic val MIDNIGHT_BLUE_400 = Color.rgb(86, 101, 115)
        @ColorInt @JvmStatic val MIDNIGHT_BLUE_500 = Color.rgb(44, 62, 80)
        @ColorInt @JvmStatic val MIDNIGHT_BLUE_600 = Color.rgb(39, 55, 70)
        @ColorInt @JvmStatic val MIDNIGHT_BLUE_700 = Color.rgb(33, 47, 61)
        @ColorInt @JvmStatic val MIDNIGHT_BLUE_800 = Color.rgb(28, 40, 51)
        @ColorInt @JvmStatic val MIDNIGHT_BLUE_900 = Color.rgb(23, 32, 42)

        /** An array containing all 10 FlatDesign POMEGRANATE colors. */
        @JvmStatic val pomegranateColorArray = intArrayOf( POMEGRANATE_50, POMEGRANATE_100, POMEGRANATE_200, POMEGRANATE_300, POMEGRANATE_400, POMEGRANATE_500, POMEGRANATE_600, POMEGRANATE_700, POMEGRANATE_800, POMEGRANATE_900)

        /** An array containing all 10 FlatDesign ALIZARIN colors. */
        @JvmStatic val alizarinColorArray = intArrayOf( ALIZARIN_50, ALIZARIN_100, ALIZARIN_200, ALIZARIN_300, ALIZARIN_400, ALIZARIN_500, ALIZARIN_600, ALIZARIN_700, ALIZARIN_800, ALIZARIN_900)

        /** An array containing all 10 FlatDesign AMETHYST colors. */
        @JvmStatic val amethystColorArray = intArrayOf( AMETHYST_50, AMETHYST_100, AMETHYST_200, AMETHYST_300, AMETHYST_400, AMETHYST_500, AMETHYST_600, AMETHYST_700, AMETHYST_800, AMETHYST_900)

        /** An array containing all 10 FlatDesign WISTERIA colors. */
        @JvmStatic val wisteriaColorArray = intArrayOf( WISTERIA_50, WISTERIA_100, WISTERIA_200, WISTERIA_300, WISTERIA_400, WISTERIA_500, WISTERIA_600, WISTERIA_700, WISTERIA_800, WISTERIA_900)

        /** An array containing all 10 FlatDesign BELIZE HOLE colors. */
        @JvmStatic val belizeHoleColorArray = intArrayOf( BELIZE_HOLE_50, BELIZE_HOLE_100, BELIZE_HOLE_200, BELIZE_HOLE_300, BELIZE_HOLE_400, BELIZE_HOLE_500, BELIZE_HOLE_600, BELIZE_HOLE_700, BELIZE_HOLE_800, BELIZE_HOLE_900)

        /** An array containing all 10 FlatDesign PETER RIVER colors. */
        @JvmStatic val peterRiverColorArray = intArrayOf( PETER_RIVER_50, PETER_RIVER_100, PETER_RIVER_200, PETER_RIVER_300, PETER_RIVER_400, PETER_RIVER_500, PETER_RIVER_600, PETER_RIVER_700, PETER_RIVER_800, PETER_RIVER_900)

        /** An array containing all 10 FlatDesign TORQUOISE colors. */
        @JvmStatic val torquoiseColorArray = intArrayOf( TORQUOISE_50, TORQUOISE_100, TORQUOISE_200, TORQUOISE_300, TORQUOISE_400, TORQUOISE_500, TORQUOISE_600, TORQUOISE_700, TORQUOISE_800, TORQUOISE_900)

        /** An array containing all 10 FlatDesign GREEN SEA colors. */
        @JvmStatic val greenSeaColorArray = intArrayOf( GREEN_SEA_50, GREEN_SEA_100, GREEN_SEA_200, GREEN_SEA_300, GREEN_SEA_400, GREEN_SEA_500, GREEN_SEA_600, GREEN_SEA_700, GREEN_SEA_800, GREEN_SEA_900)

        /** An array containing all 10 FlatDesign NEPHRITIS colors. */
        @JvmStatic val nephritisColorArray = intArrayOf( NEPHRITIS_50, NEPHRITIS_100, NEPHRITIS_200, NEPHRITIS_300, NEPHRITIS_400, NEPHRITIS_500, NEPHRITIS_600, NEPHRITIS_700, NEPHRITIS_800, NEPHRITIS_900)

        /** An array containing all 10 FlatDesign EMERALD colors. */
        @JvmStatic val emeraldColorArray = intArrayOf( EMERALD_50, EMERALD_100, EMERALD_200, EMERALD_300, EMERALD_400, EMERALD_500, EMERALD_600, EMERALD_700, EMERALD_800, EMERALD_900)

        /** An array containing all 10 FlatDesign SUNFLOWER colors. */
        @JvmStatic val sunflowerColorArray = intArrayOf( SUNFLOWER_50, SUNFLOWER_100, SUNFLOWER_200, SUNFLOWER_300, SUNFLOWER_400, SUNFLOWER_500, SUNFLOWER_600, SUNFLOWER_700, SUNFLOWER_800, SUNFLOWER_900)

        /** An array containing all 10 FlatDesign ORANGE colors. */
        @JvmStatic val orangeColorArray = intArrayOf( ORANGE_50, ORANGE_100, ORANGE_200, ORANGE_300, ORANGE_400, ORANGE_500, ORANGE_600, ORANGE_700, ORANGE_800, ORANGE_900)

        /** An array containing all 10 FlatDesign CARROT colors. */
        @JvmStatic val carrotColorArray = intArrayOf( CARROT_50, CARROT_100, CARROT_200, CARROT_300, CARROT_400, CARROT_500, CARROT_600, CARROT_700, CARROT_800, CARROT_900)

        /** An array containing all 10 FlatDesign PUMPKIN colors. */
        @JvmStatic val pumpkinColorArray = intArrayOf( PUMPKIN_50, PUMPKIN_100, PUMPKIN_200, PUMPKIN_300, PUMPKIN_400, PUMPKIN_500, PUMPKIN_600, PUMPKIN_700, PUMPKIN_800, PUMPKIN_900)

        /** An array containing all 10 FlatDesign CLOUD colors. */
        @JvmStatic val cloudColorArray = intArrayOf( CLOUD_50, CLOUD_100, CLOUD_200, CLOUD_300, CLOUD_400, CLOUD_500, CLOUD_600, CLOUD_700, CLOUD_800, CLOUD_900)

        /** An array containing all 10 FlatDesign SILVER colors. */
        @JvmStatic val silverColorArray = intArrayOf( SILVER_50, SILVER_100, SILVER_200, SILVER_300, SILVER_400, SILVER_500, SILVER_600, SILVER_700, SILVER_800, SILVER_900)

        /** An array containing all 10 FlatDesign CONCRETE colors. */
        @JvmStatic val concreteColorArray = intArrayOf( CONCRETE_50, CONCRETE_100, CONCRETE_200, CONCRETE_300, CONCRETE_400, CONCRETE_500, CONCRETE_600, CONCRETE_700, CONCRETE_800, CONCRETE_900)

        /** An array containing all 10 FlatDesign ASBESTOS colors. */
        @JvmStatic val asbestosColorArray = intArrayOf( ASBESTOS_50, ASBESTOS_100, ASBESTOS_200, ASBESTOS_300, ASBESTOS_400, ASBESTOS_500, ASBESTOS_600, ASBESTOS_700, ASBESTOS_800, ASBESTOS_900)

        /** An array containing all 10 FlatDesign WET ASPHALT colors. */
        @JvmStatic val wetAsphaltColorArray = intArrayOf( WET_ASPHALT_50, WET_ASPHALT_100, WET_ASPHALT_200, WET_ASPHALT_300, WET_ASPHALT_400, WET_ASPHALT_500, WET_ASPHALT_600, WET_ASPHALT_700, WET_ASPHALT_800, WET_ASPHALT_900)

        /** An array containing all 10 FlatDesign MIDNIGHT BLUE colors. */
        @JvmStatic val midNightBlueColorArray = intArrayOf( MIDNIGHT_BLUE_50, MIDNIGHT_BLUE_100, MIDNIGHT_BLUE_200, MIDNIGHT_BLUE_300, MIDNIGHT_BLUE_400, MIDNIGHT_BLUE_500, MIDNIGHT_BLUE_600, MIDNIGHT_BLUE_700, MIDNIGHT_BLUE_800, MIDNIGHT_BLUE_900)

        /**
         * Gets a random shade of FlatDesign POMEGRANATE from the [Pomegranate Color Array][pomegranateColorArray].
         *
         * @return @[ColorInt] POMEGRANATE.
         */
        @JvmStatic fun randomPomegranateColor() = pomegranateColorArray[(pomegranateColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign ALIZARIN from the [Alizarin Color Array][alizarinColorArray].
         *
         * @return @[ColorInt] ALIZARIN.
         */
        @JvmStatic fun randomAlizarinColor() = alizarinColorArray[(alizarinColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign AMETHYST from the [Amethyst Color Array][amethystColorArray].
         *
         * @return @[ColorInt] AMETHYST.
         */
        @JvmStatic fun randomAmethystColor() = amethystColorArray[(amethystColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign WISTERIA from the [Wisteria Color Array][wisteriaColorArray].
         *
         * @return @[ColorInt] WISTERIA.
         */
        @JvmStatic fun randomWisteriaColor() = wisteriaColorArray[(wisteriaColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign BELIZE HOLE from the [Belize Hole Color Array][belizeHoleColorArray].
         *
         * @return @[ColorInt] BELIZE HOLE.
         */
        @JvmStatic fun randomBelizeHoleColor() = belizeHoleColorArray[(belizeHoleColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign PETER RIVER from the [Peter River Color Array][peterRiverColorArray].
         *
         * @return @[ColorInt] PETER RIVER.
         */
        @JvmStatic fun randomPeterRiverColor() = peterRiverColorArray[(peterRiverColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign TORQUOISE from the [Torquoise Color Array][torquoiseColorArray].
         *
         * @return @[ColorInt] TORQUOISE.
         */
        @JvmStatic fun randomTorquoiseColor() = torquoiseColorArray[(torquoiseColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign GREEN SEA from the [Green Sea Color Array][greenSeaColorArray].
         *
         * @return @[ColorInt] GREEN SEA.
         */
        @JvmStatic fun randomGreenSeaColor() = greenSeaColorArray[(greenSeaColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign NEPHRITIS from the [Nephritis Color Array][nephritisColorArray].
         *
         * @return @[ColorInt] NEPHRITIS.
         */
        @JvmStatic fun randomNephritisColor() = nephritisColorArray[(nephritisColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign EMERALD from the [Emerald Color Array][emeraldColorArray].
         *
         * @return @[ColorInt] EMERALD.
         */
        @JvmStatic fun randomEmeraldColor() = emeraldColorArray[(emeraldColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign SUNFLOWER from the [Sunflower Color Array][sunflowerColorArray].
         *
         * @return @[ColorInt] SUNFLOWER.
         */
        @JvmStatic fun randomSunflowerColor() = sunflowerColorArray[(sunflowerColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign ORANGE from the [Orange Color Array][orangeColorArray].
         *
         * @return @[ColorInt] ORANGE.
         */
        @JvmStatic fun randomOrangeColor() = orangeColorArray[(orangeColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign CARROT from the [Carrot Color Array][carrotColorArray].
         *
         * @return @[ColorInt] CARROT.
         */
        @JvmStatic fun randomCarrotColor() = carrotColorArray[(carrotColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign PUMPKIN from the [Pumpkin Color Array][pumpkinColorArray].
         *
         * @return @[ColorInt] PUMPKIN.
         */
        @JvmStatic fun randomPumpkinColor() = pumpkinColorArray[(pumpkinColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign CLOUD from the [Cloud Color Array][cloudColorArray].
         *
         * @return @[ColorInt] CLOUD.
         */
        @JvmStatic fun randomCloudColor() = cloudColorArray[(cloudColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign SILVER from the [Silver Color Array][silverColorArray].
         *
         * @return @[ColorInt] SILVER.
         */
        @JvmStatic fun randomSilverColor() = silverColorArray[(silverColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign CONCRETE from the [Concrete Color Array][concreteColorArray].
         *
         * @return @[ColorInt] CONCRETE.
         */
        @JvmStatic fun randomConcreteColor() = concreteColorArray[(concreteColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign ASBESTOS from the [Asbestos Color Array][asbestosColorArray].
         *
         * @return @[ColorInt] ASBESTOS.
         */
        @JvmStatic fun randomAsbestosColor() = asbestosColorArray[(asbestosColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign WET ASPHALT from the [Wet Asphalt Color Array][wetAsphaltColorArray].
         *
         * @return @[ColorInt] WET ASPHALT.
         */
        @JvmStatic fun randomWetAsphaltColor() = wetAsphaltColorArray[(wetAsphaltColorArray.indices).random()]

        /**
         * Gets a random shade of FlatDesign MIDNIGHT BLUE from the [MidNight Blue Array][midNightBlueColorArray].
         *
         * @return @[ColorInt] MIDNIGHT BLUE.
         */
        @JvmStatic fun randomMidNightBlueColor() = midNightBlueColorArray[(midNightBlueColorArray.indices).random()]

        private val arrayOfAllColorArrays = arrayOf(
            pomegranateColorArray, alizarinColorArray, amethystColorArray,
            wisteriaColorArray, belizeHoleColorArray, peterRiverColorArray,
            torquoiseColorArray, greenSeaColorArray, nephritisColorArray,
            emeraldColorArray, sunflowerColorArray, orangeColorArray,
            carrotColorArray, pumpkinColorArray, cloudColorArray,
            silverColorArray, concreteColorArray, asbestosColorArray,
            wetAsphaltColorArray, midNightBlueColorArray

        )

        /**  Picks a random color from one of the [FlatDesign] colors.*/
        @JvmStatic fun selectRandomColor(): Int {
            val anyColorIntArray = arrayOfAllColorArrays[(arrayOfAllColorArrays.indices).random()]
            return anyColorIntArray[((anyColorIntArray.indices).random())]
        }
    }

    /** The official Google colors. */
    object Google {
        @ColorInt @JvmStatic val BLUE = Color.rgb(66, 133, 244)
        @ColorInt @JvmStatic val YELLOW = Color.rgb(244, 180, 0)
        @ColorInt @JvmStatic val RED = Color.rgb(219, 68, 55)
        @ColorInt @JvmStatic val GREEN = Color.rgb(15, 157, 88)
    }

    /** The official Twitter colors. */
    object Twitter {
        @ColorInt @JvmStatic val BLUE = Color.rgb(29, 161, 242)
        @ColorInt @JvmStatic val BLACK = Color.rgb(20, 23, 26)
        @ColorInt @JvmStatic val DARK_GRAY = Color.rgb(101, 119, 134)
        @ColorInt @JvmStatic val LIGHT_GRAY = Color.rgb(170, 184, 194)
        @ColorInt @JvmStatic val EXTRA_LIGHT_GRAY = Color.rgb(225, 232, 237)
        @ColorInt @JvmStatic val EXTRA_EXTRA_LIGHT_GRAY = Color.rgb(245, 248, 250)
    }

    /** The official Instagram colors. */
    object Instagram {
        @ColorInt @JvmStatic val ROYAL_BLUE = Color.rgb(5, 10, 230)
        @ColorInt @JvmStatic val BLUE = Color.rgb(88, 81, 216)
        @ColorInt @JvmStatic val PURPLE = Color.rgb(131, 58, 180)
        @ColorInt @JvmStatic val DARK_PINK = Color.rgb(193, 53, 132)
        @ColorInt @JvmStatic val PURPLE_RED = Color.rgb(225, 48, 108)
        @ColorInt @JvmStatic val RED = Color.rgb(253, 36, 76)
        @ColorInt @JvmStatic val DARK_ORANGE = Color.rgb(88, 81, 216)
        @ColorInt @JvmStatic val ORANGE = Color.rgb(247, 119, 55)
        @ColorInt @JvmStatic val YELLOW = Color.rgb(252, 175, 69)
        @ColorInt @JvmStatic val LIGHT_YELLOW = Color.rgb(225, 220, 128)
    }

    /** The official YouTube colors. */
    object YouTube {
        @ColorInt @JvmStatic val RED = Color.rgb(255, 0, 0)
    }

    /** The official Pinterest colors. */
    object Pinterest {
        @ColorInt @JvmStatic val RED = Color.rgb(230, 0, 35)
    }

    /** The official Netflix colors. */
    object Netflix {
        @ColorInt @JvmStatic val RED = Color.rgb(229, 9, 20)
    }

    /** The official Spotify colors. */
    object Spotify {
        @ColorInt @JvmStatic val GREEN = Color.rgb(30, 215, 96)
        @ColorInt @JvmStatic val BLACK = Color.rgb(25, 20, 20)
    }

    /** The official HP colors. */
    object HP {
        @ColorInt @JvmStatic val BLUE = Color.rgb(0, 150, 214)
    }

    /** The official Facebook colors. */
    object Facebook {
        @ColorInt @JvmStatic val BLUE = Color.rgb(66, 103, 178)
        @ColorInt @JvmStatic val GREY = Color.rgb(137, 143, 156)

        /** The official Facebook Messenger colors. */
        object Messenger {
            @ColorInt @JvmStatic val LIGHT_BLUE = Color.rgb(0, 178, 255)
            @ColorInt @JvmStatic val BLUE = Color.rgb(0, 106, 255)

        }
    }

    /** The official Snapchat colors. */
    object Snapchat {
        @ColorInt @JvmStatic val YELLOW = Color.rgb(255, 252, 0)
    }

    /** The official Android colors. */
    object Android {
        @ColorInt @JvmStatic val GREEN = Color.rgb(120, 194, 87)
    }

    /** The official Amazon colors. */
    object Amazon {
        @ColorInt @JvmStatic val ORANGE = Color.rgb(255, 153, 0)
    }

    /** The official Microsoft colors. */
    object Microsoft {
        @ColorInt @JvmStatic val ORANGE_RED = Color.rgb(242, 80, 34)
        @ColorInt @JvmStatic val GREEN = Color.rgb(127, 186, 0)
        @ColorInt @JvmStatic val BLUE = Color.rgb(0, 164, 239)
        @ColorInt @JvmStatic val YELLOW = Color.rgb(255, 185, 0)
        @ColorInt @JvmStatic val GREY = Color.rgb(115, 115, 115)
    }

    /** The official Xbox colors. */
    object Xbox {
        @ColorInt @JvmStatic val GREEN = Color.rgb(16, 124, 16)
        @ColorInt @JvmStatic val GRAY = Color.rgb(58, 58, 58)
    }

    /** The official Whatsapp colors. */
    object Whatsapp {
        @ColorInt @JvmStatic val TEAL_GREEN = Color.rgb(18, 140, 126)
        @ColorInt @JvmStatic val DARK_TEAL_GREEN = Color.rgb(7, 94, 84)
        @ColorInt @JvmStatic val LIGHT_GREEN = Color.rgb(37, 211, 102)
        @ColorInt @JvmStatic val BLUE = Color.rgb(52, 183, 241)
    }

    /** The official Lyft colors. */
    object Lyft {
        @ColorInt @JvmStatic val PINK = Color.rgb(255, 0, 191)
        @ColorInt @JvmStatic val BLACK = Color.rgb(17, 17, 31)
    }

    /** The official Airbnb colors. */
    object Airbnb {
        @ColorInt @JvmStatic val RAUSCH = Color.rgb(255, 90, 95)
        @ColorInt @JvmStatic val BABU = Color.rgb(0, 166, 153)
        @ColorInt @JvmStatic val ARCHES = Color.rgb(252, 100, 45)
        @ColorInt @JvmStatic val HOF = Color.rgb(72, 72, 72)
        @ColorInt @JvmStatic val FOGGY = Color.rgb(118, 118, 118)
    }

    /** The official Slack colors. */
    object Slack {
        @ColorInt @JvmStatic val LIGHT_BLUE = Color.rgb(54, 197, 240)
        @ColorInt @JvmStatic val GREEN = Color.rgb(46, 182, 125)
        @ColorInt @JvmStatic val RED = Color.rgb(224, 30, 90)
        @ColorInt @JvmStatic val YELLOW = Color.rgb(236, 178, 46)
    }

    /** The official IBM colors. */
    object IBM {
        @ColorInt @JvmStatic val BLUE = Color.rgb(75, 107, 175)
    }

    /** The official Oracle colors. */
    object Oracle {
        @ColorInt @JvmStatic val RED = Color.rgb(248, 0, 0)
    }

}