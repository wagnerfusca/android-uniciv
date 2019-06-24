package br.com.uniciv.meuprimeiroaplicativo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("categoria", "mensagem de debug")
        Log.i("categoria", "mensagem de informacao")
        Log.w("categoria", "mensagem de aviso")
        Log.e("categoria", "mensagem de erro")


    }
}
