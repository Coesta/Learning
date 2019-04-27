package com.leocoesta.consultacep;

import android.os.AsyncTask;

import java.net.MalformedURLException;
import java.net.URL;

public class HttpService extends AsyncTask<Void, Void, CEP> {

    private final String cep;

    public HttpService(String cep) {
        this.cep = cep;
    }

    @Override
    protected CEP doInBackground(Void... voids) {

        if (this.cep != null && this.cep.length() == 8) {
            // realizar busca
        }

        try {
            URL url = new URL("http://ws.matheuscastiglioni.com.br/ws/cep/find/" + this.cep + "/json/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
