package br.com.uniciv.meuprimeiroaplicativo

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SegundaTelaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)

        val msg = intent.getStringExtra("msg")
        Toast.makeText(applicationContext, "Bem vindo : $msg", Toast.LENGTH_LONG).show()

        val botaoAbrirSite = findViewById<Button>(R.id.btnAbrirUrl)
        botaoAbrirSite.setOnClickListener {
            val edtSite = findViewById<EditText>(R.id.edtSite)
            val uri = Uri.parse(edtSite.text.toString())
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        val botaoLigar = findViewById<View>(R.id.btnLigar) as Button
        botaoLigar.setOnClickListener {
            val edtLigar = findViewById<EditText>(R.id.edtLigar)
            val uri = Uri.parse("tel:" + edtLigar.text.toString())
            val intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
        }

        val botaoCamera = findViewById<View>(R.id.btnCamera) as Button
        botaoCamera.setOnClickListener {
            val fotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(fotoIntent)
        }

    }
}
