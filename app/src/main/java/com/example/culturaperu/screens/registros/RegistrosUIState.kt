package com.example.culturaperu.screens.registros

import com.example.culturaperu.models.Registro

sealed interface RegistrosUIState {

    data object Loading : RegistrosUIState

    data class Success(
        val registros: List<Registro>
    ) : RegistrosUIState

    data class Error(
        val mensaje: String
    ) : RegistrosUIState
}