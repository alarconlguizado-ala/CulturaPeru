package com.example.culturaperu.models

data class PiezaCultural(
    val id: Int,
    val nombre: String,
    val categoria: String,
    val periodo: String,
    val descripcion: String,
    val imagen: Int
)