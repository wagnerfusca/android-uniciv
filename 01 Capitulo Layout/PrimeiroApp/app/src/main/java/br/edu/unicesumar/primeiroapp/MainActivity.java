package br.edu.unicesumar.primeiroapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_main);


        Log.d("categoria", "mensagem de debug");
        Log.i("categoria", "mensagem de informação");
        Log.w("categoria", "mensagem de aviso");
        Log.e("categoria", "mensagem de erro");
        Log.e("categoria", "mensagem de erro", new RuntimeException("erro"));

    }
}
