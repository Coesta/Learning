package com.leocoesta.bioauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import java.util.concurrent.Executor

class AutenticacaoActivity : AppCompatActivity() {

    companion object {
        const val TAG = "AutenticacaoActivity"
    }

    private val executor = Executor {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autenticacao)
    }



    private fun showBiometricPrompt() {
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(getString(R.string.dialogo_biometria_titulo))
            .setSubtitle(getString(R.string.dialogo_biometria_subtitulo))
//            .setNegativeButtonText(getString(R.string.cancelar))
            .setDeviceCredentialAllowed(true)
            .build()

        val biometricPrompt =
            BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Log.d(TAG, errString.toString())
                    exibirToastMsgResultado(getString(R.string.dialogo_biometria_erro_mensagem) + errString.toString())
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Log.d(TAG, getString(R.string.dialogo_biometria_falha_mensagem))
                    exibirToastMsgResultado(getString(R.string.dialogo_biometria_falha_mensagem))
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)

                    val authenticatedCryptoObject : BiometricPrompt.CryptoObject? = result.cryptoObject
                    startActivity(Intent(this@AutenticacaoActivity, MainActivity::class.java))

                    Log.d(TAG, authenticatedCryptoObject.toString())
                    println(TAG + authenticatedCryptoObject.toString())
                }

            })

        biometricPrompt.authenticate(promptInfo)

    }

    override fun onResume() {
        super.onResume()
        showBiometricPrompt()
    }

    private fun exibirToastMsgResultado(mensagemResultado: String) {
        Toast.makeText(applicationContext, mensagemResultado, Toast.LENGTH_LONG).show()
    }
}
