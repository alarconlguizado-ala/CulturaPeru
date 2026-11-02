package com.example.culturaperu.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CampoFormulario(
    valor: String,
    etiqueta: String,
    onValorCambio: (String) -> Unit
) {

    OutlinedTextField(
        value = valor,
        onValueChange = onValorCambio,
        label = {
            Text(
                text = etiqueta
            )
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        singleLine = true
    )
}