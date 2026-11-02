package com.example.culturaperu

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.culturaperu.components.BotonCircular
import com.example.culturaperu.screens.colecciones.ColeccionesActivity
import com.example.culturaperu.screens.favoritos.FavoritosActivity
import com.example.culturaperu.screens.registros.DatosActivity
import com.example.culturaperu.screens.visita.VisitaActivity
import com.example.culturaperu.ui.theme.AppSpacing
import com.example.culturaperu.ui.theme.Blanco
import com.example.culturaperu.ui.theme.CulturaPeruTheme
import com.example.culturaperu.ui.theme.Fondo
import com.example.culturaperu.ui.theme.Gris
import com.example.culturaperu.ui.theme.Negro

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            CulturaPeruTheme {

                PantallaInicio(

                    onDetalle = { id ->

                        val intent = Intent(
                            this,
                            DetalleActivity::class.java
                        )

                        intent.putExtra(
                            "id_museo",
                            id
                        )

                        startActivity(intent)
                    },

                    onDatos = {

                        startActivity(
                            Intent(
                                this,
                                DatosActivity::class.java
                            )
                        )
                    },

                    onColecciones = {

                        startActivity(
                            Intent(
                                this,
                                ColeccionesActivity::class.java
                            )
                        )
                    },

                    onVisita = {

                        startActivity(
                            Intent(
                                this,
                                VisitaActivity::class.java
                            )
                        )
                    },

                    onFavoritos = {

                        startActivity(
                            Intent(
                                this,
                                FavoritosActivity::class.java
                            )
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun PantallaInicio(
    onDetalle: (Int) -> Unit,
    onDatos: () -> Unit,
    onColecciones: () -> Unit,
    onVisita: () -> Unit,
    onFavoritos: () -> Unit
) {

    var favorito by remember {
        mutableStateOf(false)
    }

    var mostrarMenu by remember {
        mutableStateOf(false)
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
            .padding(AppSpacing.large)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =
                Arrangement.SpaceBetween,
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Blanco),
                contentAlignment =
                    Alignment.Center
            ) {

                Text(
                    text = stringResource(
                        R.string.logo
                    ),
                    color = Negro
                )
            }

            Box {

                BotonCircular(
                    "≡",
                    true
                ) {
                    mostrarMenu = true
                }

                DropdownMenu(
                    expanded = mostrarMenu,
                    onDismissRequest = {
                        mostrarMenu = false
                    }
                ) {

                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "Museo de la Nación"
                            )
                        },
                        onClick = {

                            mostrarMenu = false

                            onDetalle(1)
                        }
                    )

                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "Museo de Sitio Pachacámac"
                            )
                        },
                        onClick = {

                            mostrarMenu = false

                            onDetalle(2)
                        }
                    )

                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "Colecciones"
                            )
                        },
                        onClick = {

                            mostrarMenu = false

                            onColecciones()
                        }
                    )

                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "Planifica tu visita"
                            )
                        },
                        onClick = {

                            mostrarMenu = false

                            onVisita()
                        }
                    )

                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "Mis favoritos"
                            )
                        },
                        onClick = {

                            mostrarMenu = false

                            onFavoritos()
                        }
                    )
                }
            }
        }

        Spacer(
            Modifier.height(24.dp)
        )

        Column(
            modifier =
                Modifier.fillMaxWidth(),
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(
                    R.string.bienvenida
                ),
                color = Gris,
                textAlign = TextAlign.Center
            )

            Text(
                text = stringResource(
                    R.string.app_name
                ),
                style =
                    MaterialTheme.typography.headlineLarge,
                textAlign =
                    TextAlign.Center
            )

            Text(
                text = stringResource(
                    R.string.subtitulo
                ),
                color = Gris,
                textAlign =
                    TextAlign.Center
            )
        }

        Spacer(
            Modifier.height(24.dp)
        )

        Text(
            text = stringResource(
                R.string.destacado
            ),
            color = Gris
        )

        Spacer(
            Modifier.height(8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
        ) {

            Image(
                painter = painterResource(
                    R.drawable.museo_nacion
                ),
                contentDescription =
                    stringResource(
                        R.string.museo_nacion
                    ),
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            24.dp
                        )
                    )
                    .clickable {
                        onDetalle(1)
                    },
                contentScale =
                    ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .align(
                        Alignment.TopEnd
                    )
                    .padding(12.dp)
            ) {

                BotonCircular(
                    if (favorito) {
                        "♥"
                    } else {
                        "♡"
                    },
                    false
                ) {
                    favorito = !favorito
                }
            }
        }

        Spacer(
            Modifier.height(8.dp)
        )

        Row(
            modifier =
                Modifier.fillMaxWidth(),
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(76.dp)
                    .clip(
                        RoundedCornerShape(
                            24.dp
                        )
                    )
                    .background(Blanco)
                    .padding(14.dp),
                verticalArrangement =
                    Arrangement.Center
            ) {

                Text(
                    text =
                        stringResource(
                            R.string.museo_nacion
                        ),
                    style =
                        MaterialTheme.typography.titleMedium
                )

                Text(
                    text =
                        stringResource(
                            R.string.ubicacion
                        ),
                    color = Gris,
                    style =
                        MaterialTheme.typography.bodySmall
                )
            }

            Spacer(
                Modifier.width(8.dp)
            )

            BotonCircular(
                "▶",
                true,
                54
            ) {
                onDetalle(1)
            }
        }

        Spacer(
            Modifier.height(24.dp)
        )

        Text(
            text = stringResource(
                R.string.coleccion
            ),
            style =
                MaterialTheme.typography.titleLarge
        )

        Spacer(
            Modifier.height(12.dp)
        )

        Image(
            painter = painterResource(
                R.drawable.museo_pachacamac
            ),
            contentDescription =
                stringResource(
                    R.string.museo_pachacamac
                ),
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .clip(
                    RoundedCornerShape(
                        24.dp
                    )
                )
                .clickable {
                    onDetalle(2)
                },
            contentScale =
                ContentScale.Crop
        )

        Spacer(
            Modifier.height(10.dp)
        )

        Text(
            text = stringResource(
                R.string.museo_pachacamac
            ),
            style =
                MaterialTheme.typography.titleMedium
        )

        Text(
            text = stringResource(
                R.string.ubicacion_pachacamac
            ),
            color = Gris,
            style =
                MaterialTheme.typography.bodySmall
        )

        Spacer(
            Modifier.height(24.dp)
        )

        Button(
            onClick = onDatos,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = CircleShape,
            colors =
                ButtonDefaults.buttonColors(
                    containerColor = Negro
                )
        ) {

            Text(
                text =
                    stringResource(
                        R.string.registros
                    )
            )
        }

        Spacer(
            Modifier.height(16.dp)
        )

        Text(
            text = "Explora más",
            style =
                MaterialTheme.typography.titleLarge
        )

        Spacer(
            Modifier.height(12.dp)
        )

        Button(
            onClick = onColecciones,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = CircleShape,
            colors =
                ButtonDefaults.buttonColors(
                    containerColor = Negro
                )
        ) {

            Text(
                text = "Colecciones"
            )
        }

        Spacer(
            Modifier.height(10.dp)
        )

        Button(
            onClick = onVisita,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = CircleShape,
            colors =
                ButtonDefaults.buttonColors(
                    containerColor = Negro
                )
        ) {

            Text(
                text = "Planifica tu visita"
            )
        }

        Spacer(
            Modifier.height(10.dp)
        )

        Button(
            onClick = onFavoritos,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = CircleShape,
            colors =
                ButtonDefaults.buttonColors(
                    containerColor = Negro
                )
        ) {

            Text(
                text = "Mis favoritos"
            )
        }

        Spacer(
            Modifier.height(20.dp)
        )
    }
}