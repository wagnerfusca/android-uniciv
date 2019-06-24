package br.com.uniciv.meuprimeiroaplicativo

import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtLogin123 = findViewById<EditText>(R.id.edtLogin)
        val edtSenha123 = findViewById<EditText>(R.id.edtSenha)

        val btnLogar = findViewById<Button>(R.id.btnAutenticar)

        btnLogar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (edtLogin123.text.toString() == "ALUNO" && edtSenha123.text.toString() == "123") {

                    val it = Intent(applicationContext, SegundaTelaActivity::class.java)
                    it.putExtra("msg", edtLogin123.text.toString())
                    startActivity(it)
                } else {
                    Snackbar.make(findViewById(R.id.activity_login),
                            "Usuário e senha inválidos",
                            Snackbar.LENGTH_LONG).show()
                }
                /*Toast.makeText(getApplicationContext(),
                        "Login digitado:" + edtLogin123.getText(),
                        Toast.LENGTH_LONG).show();


                Snackbar.make(findViewById(R.id.activity_login),
                        "Senha digitada: " + edtSenha123.getText(),
                        Snackbar.LENGTH_LONG)
                        .setAction("Acao", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Snackbar.make(findViewById(R.id.activity_login),
                                                "acao desfeita",
                                                Snackbar.LENGTH_SHORT).show();
                                    }
                                }

                        )
                        .show();
*/
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_login, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_pesquisar -> Toast.makeText(this, "pesquisar",
                    Toast.LENGTH_SHORT).show()
            R.id.action_settings -> Toast.makeText(this, "settings",
                    Toast.LENGTH_SHORT).show()
            R.id.action_sair -> finish()
            else -> {
            }
        }
        return true
    }

}
