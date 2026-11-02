package com.example.culturaperu.screens.registros

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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.culturaperu.R
import com.example.culturaperu.components.BotonCircular
import com.example.culturaperu.models.Registro
import com.example.culturaperu.ui.theme.Blanco
import com.example.culturaperu.ui.theme.Bronce
import com.example.culturaperu.ui.theme.CulturaPeruTheme
import com.example.culturaperu.ui.theme.Fondo
import com.example.culturaperu.ui.theme.Gris
import com.example.culturaperu.ui.theme.GrisClaro
import com.example.culturaperu.ui.theme.Negro

class DatosActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel =
            ViewModelProvider(this)[RegistrosViewModel::class.java]

        setContent {

            CulturaPeruTheme {

                val uiState by
                viewModel.uiState.collectAsStateWithLifecycle()

                PantallaDatos(
                    uiState = uiState,
                    onVolver = {
                        finish()
                    },
                    onReintentar = {
                        viewModel.cargarRegistros()
                    }
                )
            }
        }
    }
}

@Composable
fun PantallaDatos(
    uiState: RegistrosUIState,
    onVolver: () -> Unit,
    onReintentar: () -> Unit
) {

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
                stringResource(
                    R.string.datos_titulo
                ),
                style =
                    MaterialTheme.typography.headlineLarge
            )

            Text(
                stringResource(
                    R.string.datos_subtitulo
                ),
                color = Gris
            )

            Spacer(
                Modifier.height(12.dp)
            )
        }

        when (uiState) {

            RegistrosUIState.Loading -> {

                item {

                    CircularProgressIndicator(
                        color = Negro
                    )

                    Spacer(
                        Modifier.height(8.dp)
                    )

                    Text(
                        stringResource(
                            R.string.cargando
                        )
                    )
                }
            }

            is RegistrosUIState.Error -> {

                item {

                    Text(
                        stringResource(
                            R.string.error_conexion
                        )
                    )

                    Spacer(
                        Modifier.height(12.dp)
                    )

                    Button(
                        onClick = onReintentar
                    ) {

                        Text(
                            stringResource(
                                R.string.reintentar
                            )
                        )
                    }
                }
            }

            is RegistrosUIState.Success -> {

                if (uiState.registros.isEmpty()) {

                    item {

                        Text(
                            stringResource(
                                R.string.sin_registros
                            )
                        )
                    }

                } else {

                    items(
                        uiState.registros,
                        key = { it.id }
                    ) { registro ->

                        TarjetaRegistro(
                            registro
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TarjetaRegistro(
    registro: Registro
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Blanco,
                RoundedCornerShape(24.dp)
            )
            .padding(20.dp)
    ) {

        Text(
            stringResource(
                R.string.registro,
                registro.id
            ),
            color = Bronce
        )

        Spacer(
            Modifier.height(6.dp)
        )

        Text(
            registro.nombre,
            style =
                MaterialTheme.typography.titleMedium
        )

        Spacer(
            Modifier.height(12.dp)
        )

        HorizontalDivider(
            color = GrisClaro
        )

        Spacer(
            Modifier.height(12.dp)
        )

        Campo(
            stringResource(R.string.categoria),
            registro.categoria
        )

        Campo(
            stringResource(R.string.periodo),
            registro.periodo
        )

        Campo(
            stringResource(R.string.procedencia),
            registro.procedencia
        )

        Campo(
            stringResource(R.string.sala),
            registro.sala
        )
    }
}

@Composable
fun Campo(
    titulo: String,
    valor: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
    ) {

        Text(
            titulo,
            color = Gris
        )

        Text(valor)
    }
}