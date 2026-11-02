package com.example.culturaperu.data.remote

import com.example.culturaperu.models.Registro
import retrofit2.http.GET

interface RegistrosService {

    @GET("get_registros.php")
    suspend fun getRegistros(): List<Registro>
}