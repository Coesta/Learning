package com.leocoesta.consultaviacep.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.leocoesta.consultaviacep.R
import com.leocoesta.consultaviacep.models.CEP
import com.leocoesta.consultaviacep.retrofit.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        consultaBT.setOnClickListener {

            if (!cepET.text.isNullOrEmpty()) {
                val call = RetrofitConfig().getCEPService().buscarCEP(cepET.text.toString())
                call.enqueue(object: Callback<CEP?> {
                    override fun onFailure(call: Call<CEP?>, t: Throwable) {
                        Log.e("cep_service", "Erro ao buscar CEP! \n ${t.message}", t)
                    }

                    override fun onResponse(call: Call<CEP?>, response: Response<CEP?>) {
                        var cep = response.body()?.let {
                            resultadoTV.text = it.toString()
                        }
                    }

                })
            } else {
                Toast.makeText(this, "Informe o CEP", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
