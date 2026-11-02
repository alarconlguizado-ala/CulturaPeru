package com.example.culturaperu.screens.colecciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.culturaperu.components.BotonCircular
import com.example.culturaperu.components.ModalCultural
import com.example.culturaperu.components.TarjetaCultural
import com.example.culturaperu.data.local.DatosCulturales
import com.example.culturaperu.models.PiezaCultural
import com.example.culturaperu.ui.theme.CulturaPeruTheme
import com.example.culturaperu.ui.theme.Fondo
import com.example.culturaperu.ui.theme.Gris

class ColeccionesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CulturaPeruTheme {

                PantallaColecciones(
                    onVolver = {
                        finish()
                    }
                )
            }
        }
    }
}

@Composable
fun PantallaColecciones(
    onVolver: () -> Unit
) {

    var piezaSeleccionada by remember {
        mutableStateOf<PiezaCultural?>(null)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .statusBarsPadding()
            .navigationBarsPadding(),

        contentPadding = PaddingValues(20.dp),

        verticalArrangement =
            Arrangement.spacedBy(14.dp)
    ) {

        item {

            BotonCircular(
                "←",
                false
            ) {
                onVolver()
            }

            Spacer(
                Modifier.height(24.dp)
            )

            Text(
                text = "Colecciones",
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = "Explora piezas de nuestro patrimonio cultural",
                color = Gris
            )

            Spacer(
                Modifier.height(12.dp)
            )
        }

        items(
            DatosCulturales.piezas,
            key = { it.id }
        ) { pieza ->

            TarjetaCultural(
                pieza = pieza,
                onClick = {
                    piezaSeleccionada = pieza
                }
            )
        }
    }

    piezaSeleccionada?.let { pieza ->

        ModalCultural(
            titulo = pieza.nombre,
            mensaje =
                "${pieza.categoria}\n" +
                        "${pieza.periodo}\n\n" +
                        pieza.descripcion,
            textoBoton = "Cerrar",
            onCerrar = {
                piezaSeleccionada = null
            }
        )
    }
}