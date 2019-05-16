package com.leocoesta.consultaviacep.services

import com.leocoesta.consultaviacep.models.CEP
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CEPService {

    @GET("{cep}/json")
    fun buscarCEP(@Path("cep") cep: String): Call<CEP>
}