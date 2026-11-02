package com.example.culturaperu.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ModalCultural(
    titulo: String,
    mensaje: String,
    textoBoton: String = "Aceptar",
    onCerrar: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onCerrar,
        title = {
            Text(
                text = titulo
            )
        },
        text = {
            Text(
                text = mensaje
            )
        },
        confirmButton = {
            Button(
                onClick = onCerrar
            ) {
                Text(
                    text = textoBoton
                )
            }
        }
    )
}