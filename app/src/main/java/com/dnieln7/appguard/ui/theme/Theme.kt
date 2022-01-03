package com.dnieln7.appguard.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = primary,
    primaryVariant = primaryLight,
    secondary = secondary,
    secondaryVariant = secondaryLight,
    background = backgroundDark,
    surface = backgroundDark,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = textWhite,
    onSurface = textWhite,
)

private val LightColorPalette = lightColors(
    primary = primary,
    primaryVariant = primaryLight,
    secondary = secondary,
    secondaryVariant = secondaryLight,
    background = backgroundLight,
    surface = backgroundLight,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = textDark,
    onSurface = textDark,
)

@Composable
fun AppGuardTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val typography = if (darkTheme) {
        TypographyDark
    } else {
        TypographyLight
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}