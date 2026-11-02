
package com.example.culturaperu.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val Colores = lightColorScheme(
    primary = Negro,
    onPrimary = Blanco,
    background = Fondo,
    onBackground = Negro,
    surface = Blanco,
    onSurface = Negro
)

@Composable
fun CulturaPeruTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = Colores,
        typography = CulturaTypography,
        content = content
    )
}