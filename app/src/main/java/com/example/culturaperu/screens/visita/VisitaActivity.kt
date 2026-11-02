package com.example.culturaperu.screens.visita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.culturaperu.components.CampoFormulario
import com.example.culturaperu.components.ModalCultural
import com.example.culturaperu.ui.theme.Blanco
import com.example.culturaperu.ui.theme.CulturaPeruTheme
import com.example.culturaperu.ui.theme.Fondo
import com.example.culturaperu.ui.theme.Gris
import com.example.culturaperu.ui.theme.Negro

class VisitaActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CulturaPeruTheme {

                PantallaVisita(
                    onVolver = {
                        finish()
                    }
                )
            }
        }
    }
}

@Composable
fun PantallaVisita(
    onVolver: () -> Unit
) {

    var nombre by remember {
        mutableStateOf("")
    }

    var correo by remember {
        mutableStateOf("")
    }

    var visitantes by remember {
        mutableStateOf("")
    }

    var museo by remember {
        mutableStateOf("")
    }

    var mostrarModal by remember {
        mutableStateOf(false)
    }

    var tituloModal by remember {
        mutableStateOf("")
    }

    var mensajeModal by remember {
        mutableStateOf("")
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
            .padding(20.dp)
    ) {

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
            text = "Planifica tu visita",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Organiza tu próxima experiencia cultural",
            color = Gris
        )

        Spacer(
            Modifier.height(24.dp)
        )

        CampoFormulario(
            valor = nombre,
            etiqueta = "Nombre completo",
            onValorCambio = {
                nombre = it
            }
        )

        Spacer(
            Modifier.height(14.dp)
        )

        CampoFormulario(
            valor = correo,
            etiqueta = "Correo electrónico",
            onValorCambio = {
                correo = it
            }
        )

        Spacer(
            Modifier.height(14.dp)
        )

        CampoFormulario(
            valor = visitantes,
            etiqueta = "Cantidad de visitantes",
            onValorCambio = {
                visitantes = it
            }
        )

        Spacer(
            Modifier.height(14.dp)
        )

        CampoFormulario(
            valor = museo,
            etiqueta = "Museo",
            onValorCambio = {
                museo = it
            }
        )

        Spacer(
            Modifier.height(24.dp)
        )

        Button(
            onClick = {

                if (
                    nombre.isBlank() ||
                    correo.isBlank() ||
                    visitantes.isBlank() ||
                    museo.isBlank()
                ) {

                    tituloModal =
                        "Datos incompletos"

                    mensajeModal =
                        "Por favor, completa todos los campos antes de registrar tu visita."

                } else {

                    tituloModal =
                        "Reserva registrada"

                    mensajeModal =
                        "Tu visita fue registrada correctamente."
                }

                mostrarModal = true
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),

            shape =
                RoundedCornerShape(24.dp),

            colors =
                ButtonDefaults.buttonColors(
                    containerColor = Negro,
                    contentColor = Blanco
                )
        ) {

            Text(
                text = "Reservar visita"
            )
        }
    }

    if (mostrarModal) {

        ModalCultural(
            titulo = tituloModal,
            mensaje = mensajeModal,
            onCerrar = {
                mostrarModal = false
            }
        )
    }
}