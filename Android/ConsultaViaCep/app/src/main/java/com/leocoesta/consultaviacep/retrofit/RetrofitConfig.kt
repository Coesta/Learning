package com.leocoesta.consultaviacep.retrofit

import com.leocoesta.consultaviacep.services.CEPService
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitConfig {

    private val jsonMapper = com.fasterxml.jackson.module.kotlin.jacksonObjectMapper()

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(JacksonConverterFactory.create(jsonMapper))
            .build()


    fun getCEPService(): CEPService {
        return retrofit.create(CEPService::class.java)
    }
}