package com.lyst.cat.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Primary1, primaryVariant = PrimaryVar, secondary = Secondary1
)

@Composable
fun LystCatApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
)
{
    val colors = LightColorPalette

    MaterialTheme(
        colors = colors, content = content
    )
}
