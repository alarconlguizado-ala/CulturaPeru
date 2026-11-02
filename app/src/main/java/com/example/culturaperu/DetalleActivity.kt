package com.example.culturaperu

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.culturaperu.components.BotonCircular
import com.example.culturaperu.components.ModalCultural
import com.example.culturaperu.screens.registros.DatosActivity
import com.example.culturaperu.ui.theme.Blanco
import com.example.culturaperu.ui.theme.CulturaPeruTheme
import com.example.culturaperu.ui.theme.Fondo
import com.example.culturaperu.ui.theme.Gris
import com.example.culturaperu.ui.theme.GrisClaro
import com.example.culturaperu.ui.theme.Negro

class DetalleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = intent.getIntExtra(
            "id_museo",
            1
        )

        setContent {

            CulturaPeruTheme {

                PantallaDetalle(
                    id = id,

                    onVolver = {
                        finish()
                    },

                    onDatos = {
                        startActivity(
                            Intent(
                                this,
                                DatosActivity::class.java
                            )
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun PantallaDetalle(
    id: Int,
    onVolver: () -> Unit,
    onDatos: () -> Unit
) {

    var favorito by remember {
        mutableStateOf(false)
    }

    var mostrarInfo by remember {
        mutableStateOf(false)
    }

    val esNacion = id == 1

    val nombre =
        if (esNacion) {
            R.string.museo_nacion
        } else {
            R.string.museo_pachacamac
        }

    val ubicacion =
        if (esNacion) {
            R.string.ubicacion
        } else {
            R.string.ubicacion_pachacamac
        }

    val descripcion =
        if (esNacion) {
            R.string.descripcion_nacion
        } else {
            R.string.descripcion_pachacamac
        }

    val imagen =
        if (esNacion) {
            R.drawable.museo_nacion
        } else {
            R.drawable.museo_pachacamac
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(
                rememberScrollState()
            )
            .padding(
                horizontal = 20.dp,
                vertical = 16.dp
            )
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp)
        ) {

            Image(
                painter = painterResource(
                    imagen
                ),
                contentDescription = stringResource(
                    nombre
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(24.dp)
                    ),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {

                BotonCircular(
                    "←",
                    false
                ) {
                    onVolver()
                }

                BotonCircular(
                    if (favorito) "♥" else "♡",
                    false
                ) {
                    favorito = !favorito
                }
            }
        }

        Spacer(
            Modifier.height(20.dp)
        )

        Text(
            text = stringResource(
                nombre
            ),
            style =
                MaterialTheme.typography.headlineLarge
        )

        Spacer(
            Modifier.height(2.dp)
        )

        Text(
            text = stringResource(
                ubicacion
            ),
            color = Gris
        )

        Spacer(
            Modifier.height(16.dp)
        )

        HorizontalDivider(
            color = GrisClaro
        )

        Spacer(
            Modifier.height(16.dp)
        )

        Text(
            text = "Información del museo",
            style =
                MaterialTheme.typography.titleMedium
        )

        Spacer(
            Modifier.height(6.dp)
        )

        Text(
            text = stringResource(
                descripcion
            ),
            color = Gris
        )

        Spacer(
            Modifier.height(16.dp)
        )

        Text(
            text = "Horarios y tarifas",
            style =
                MaterialTheme.typography.titleMedium
        )

        Spacer(
            Modifier.height(6.dp)
        )

        Text(
            text = "Consulta el horario de atención y la información para tu visita.",
            color = Gris
        )

        Spacer(
            Modifier.height(18.dp)
        )

        HorizontalDivider(
            color = GrisClaro
        )

        Spacer(
            Modifier.height(18.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment =
                Alignment.CenterVertically,
            horizontalArrangement =
                Arrangement.SpaceBetween
        ) {

            BotonCircular(
                "+",
                false,
                58
            ) {
                mostrarInfo = true
            }

            Button(
                onClick = {
                    onDatos()
                },
                modifier = Modifier
                    .width(190.dp)
                    .height(54.dp),
                shape =
                    RoundedCornerShape(22.dp),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Blanco,
                        contentColor = Negro
                    )
            ) {

                Text(
                    text = "Ver registros"
                )
            }

            BotonCircular(
                "▶",
                true,
                58
            ) {
                onDatos()
            }
        }

        Spacer(
            Modifier.height(12.dp)
        )
    }

    if (mostrarInfo) {

        ModalCultural(
            titulo = "Horario de atención",
            mensaje =
                "Horario del museo\n\n" +
                        "7:00 a. m. - 7:00 p. m.\n\n" +
                        "Te recomendamos llegar con anticipación para realizar tu visita.",
            textoBoton = "Cerrar",
            onCerrar = {
                mostrarInfo = false
            }
        )
    }
}