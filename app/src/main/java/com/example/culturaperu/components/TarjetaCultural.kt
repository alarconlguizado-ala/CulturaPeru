package com.example.culturaperu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.culturaperu.models.PiezaCultural
import com.example.culturaperu.ui.theme.Blanco
import com.example.culturaperu.ui.theme.Gris

@Composable
fun TarjetaCultural(
    pieza: PiezaCultural,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Blanco,
                RoundedCornerShape(24.dp)
            )
            .clickable {
                onClick()
            }
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(pieza.imagen),
            contentDescription = pieza.nombre,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(18.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(
            Modifier.height(12.dp)
        )

        Text(
            text = pieza.nombre,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(
            Modifier.height(4.dp)
        )

        Text(
            text = pieza.categoria,
            color = Gris
        )

        Text(
            text = pieza.periodo,
            color = Gris,
            style = MaterialTheme.typography.bodySmall
        )
    }
}