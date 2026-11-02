package com.example.culturaperu.screens.registros

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.culturaperu.data.repository.RegistrosRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegistrosViewModel(
    private val repository: RegistrosRepository =
        RegistrosRepository()
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<RegistrosUIState>(
            RegistrosUIState.Loading
        )

    val uiState: StateFlow<RegistrosUIState> =
        _uiState.asStateFlow()

    fun cargarRegistros() {

        viewModelScope.launch {

            _uiState.value =
                RegistrosUIState.Loading

            _uiState.value = try {

                RegistrosUIState.Success(
                    repository.listarRegistros()
                )

            } catch (e: CancellationException) {

                throw e

            } catch (e: Exception) {

                RegistrosUIState.Error(
                    e.message
                        ?: "No se pudieron cargar los registros"
                )
            }
        }
    }

    init {
        cargarRegistros()
    }
}