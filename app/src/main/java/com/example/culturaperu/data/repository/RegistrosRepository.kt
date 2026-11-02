package com.example.culturaperu.data.repository

import com.example.culturaperu.data.remote.RegistrosService
import com.example.culturaperu.data.remote.RetrofitClient
import com.example.culturaperu.models.Registro

class RegistrosRepository(
    private val service: RegistrosService =
        RetrofitClient.registrosService
) {

    suspend fun listarRegistros(): List<Registro> {
        return service.getRegistros()
    }
}