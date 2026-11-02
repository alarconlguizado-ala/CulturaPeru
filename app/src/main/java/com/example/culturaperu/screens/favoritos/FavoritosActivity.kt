package com.example.culturaperu.screens.favoritos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import com.example.culturaperu.ui.theme.Blanco
import com.example.culturaperu.ui.theme.CulturaPeruTheme
import com.example.culturaperu.ui.theme.Fondo
import com.example.culturaperu.ui.theme.Gris
import com.example.culturaperu.ui.theme.Negro

class FavoritosActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CulturaPeruTheme {
                PantallaFavoritos(
                    onVolver = {
                        finish()
                    }
                )
            }
        }
    }
}

@Composable
fun PantallaFavoritos(
    onVolver: () -> Unit
) {

    val favoritos = remember {
        mutableStateListOf(
            DatosCulturales.piezas[0],
            DatosCulturales.piezas[2],
            DatosCulturales.piezas[5]
        )
    }

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
            Arrangement.spacedBy(16.dp)
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
                text = "Mis favoritos",
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = "Tus piezas culturales guardadas",
                color = Gris
            )

            Spacer(
                Modifier.height(12.dp)
            )
        }

        if (favoritos.isEmpty()) {

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Blanco,
                            RoundedCornerShape(24.dp)
                        )
                        .padding(24.dp)
                ) {

                    Text(
                        text = "No tienes favoritos",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        Modifier.height(6.dp)
                    )

                    Text(
                        text = "Las piezas que guardes aparecerán aquí.",
                        color = Gris
                    )
                }
            }

        } else {

            items(
                favoritos,
                key = { it.id }
            ) { pieza ->

                Column {

                    TarjetaCultural(
                        pieza = pieza,
                        onClick = {
                            piezaSeleccionada = pieza
                        }
                    )

                    Spacer(
                        Modifier.height(8.dp)
                    )

                    Button(
                        onClick = {
                            favoritos.remove(pieza)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Negro,
                            contentColor = Blanco
                        )
                    ) {

                        Text(
                            text = "Quitar de favoritos"
                        )
                    }
                }
            }
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