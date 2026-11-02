
package com.example.culturaperu.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.culturaperu.R

val FuenteTitulos = FontFamily(
    Font(R.font.playfair_display_regular, FontWeight.Normal)
)

val FuenteTextos = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_bold, FontWeight.Bold)
)

val CulturaTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = FuenteTitulos,
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal
    ),
    headlineMedium = TextStyle(
        fontFamily = FuenteTitulos,
        fontSize = 28.sp,
        fontWeight = FontWeight.Normal
    ),
    titleLarge = TextStyle(
        fontFamily = FuenteTextos,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    ),
    titleMedium = TextStyle(
        fontFamily = FuenteTextos,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    bodyLarge = TextStyle(
        fontFamily = FuenteTextos,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = TextStyle(
        fontFamily = FuenteTextos,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    bodySmall = TextStyle(
        fontFamily = FuenteTextos,
        fontSize = 11.sp,
        fontWeight = FontWeight.Normal
    )
)