package com.example.culturaperu.data.local

import com.example.culturaperu.R
import com.example.culturaperu.models.PiezaCultural

object DatosCulturales {

    val piezas = listOf(

        PiezaCultural(
            id = 1,
            nombre = "Vasija ceremonial",
            categoria = "Cerámica",
            periodo = "Prehispánico",
            descripcion = "Pieza de cerámica inspirada en el patrimonio cultural del antiguo Perú.",
            imagen = R.drawable.vasija_ceremonial
        ),

        PiezaCultural(
            id = 2,
            nombre = "Botella escultórica",
            categoria = "Cerámica",
            periodo = "Prehispánico",
            descripcion = "Representación de una botella escultórica utilizada en contextos ceremoniales.",
            imagen = R.drawable.botella_escultorica
        ),

        PiezaCultural(
            id = 3,
            nombre = "Manto ceremonial",
            categoria = "Textilería",
            periodo = "Prehispánico",
            descripcion = "Textil decorativo inspirado en diseños tradicionales de las culturas andinas.",
            imagen = R.drawable.textil_andino
        ),

        PiezaCultural(
            id = 4,
            nombre = "Tejido ceremonial",
            categoria = "Textilería",
            periodo = "Prehispánico",
            descripcion = "Pieza textil caracterizada por sus figuras geométricas y colores tradicionales.",
            imagen = R.drawable.tejido_ceremonial
        ),

        PiezaCultural(
            id = 5,
            nombre = "Escultura lítica",
            categoria = "Escultura",
            periodo = "Prehispánico",
            descripcion = "Representación tallada en piedra inspirada en antiguas culturas del Perú.",
            imagen = R.drawable.escultura_litica
        ),

        PiezaCultural(
            id = 6,
            nombre = "Máscara ceremonial",
            categoria = "Orfebrería",
            periodo = "Prehispánico",
            descripcion = "Máscara ceremonial inspirada en piezas elaboradas mediante técnicas de orfebrería.",
            imagen = R.drawable.mascara_oro
        )
    )
}