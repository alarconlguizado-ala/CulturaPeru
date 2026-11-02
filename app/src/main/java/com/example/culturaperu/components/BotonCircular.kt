package com.example.culturaperu.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.culturaperu.ui.theme.Blanco
import com.example.culturaperu.ui.theme.Negro

@Composable
fun BotonCircular(
    texto: String,
    oscuro: Boolean,
    tamano: Int = 48,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(tamano.dp)
            .clip(CircleShape)
            .background(
                if (oscuro) Negro else Blanco
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = texto,
            color = if (oscuro) Blanco else Negro,
            fontSize = if (tamano <= 54) 18.sp else 22.sp
        )
    }
}