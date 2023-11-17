package com.example.toyproject.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.toyproject.ui.theme.color.ColorSet
import com.example.toyproject.ui.theme.color.MyColors

private val LocalColors = staticCompositionLocalOf { ColorSet.Default.LightColors }

@Composable
fun ToyProjectTheme(
    myColors: ColorSet = ColorSet.Default,
    typography: Typography = Typography,
    shapes: Shapes = Shapes,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        myColors.DarkColors
    } else {
        myColors.LightColors
    }

    CompositionLocalProvider(LocalColors provides colors) {
        MaterialTheme(
            colors = colors.material,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }

}

val colorScheme: MyColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current