package com.leocoesta.consultacepcomretrofit;

import retrofit2.Retrofit;

public class RetrofitConfig {

    public RetrofitConfig() {
        new Retrofit.Builder().baseUrl("http://ws.matheuscastiglioni.com.br/ws/");
    }

}
