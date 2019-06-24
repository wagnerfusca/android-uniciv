package br.com.uniciv.primeiroapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.v4.app.NotificationCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import java.util.ArrayList


class CapituloSobreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capitulo_sobre)

        val btnExibirValor = findViewById<View>(R.id.btnAutenticar) as Button
        btnExibirValor.setOnClickListener(object : Button.OnClickListener {
            override fun onClick(arg0: View) {
                val edtDigiteValor = findViewById<View>(R.id.edtLogin) as EditText
                Toast.makeText(applicationContext, edtDigiteValor.text.toString(), Toast.LENGTH_LONG).show()

                val it = Intent(applicationContext, MainActivity::class.java)
                it.putExtra("msg", edtDigiteValor.text.toString())
                startActivity(it)


            }

        })

        Snackbar.make(findViewById(R.id.activity_capitulo_sobre), "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()

        val snackbar = Snackbar
                .make(findViewById(R.id.activity_capitulo_sobre), "Message is deleted", Snackbar.LENGTH_LONG)
                .setAction("UNDO") {
                    val snackbar1 = Snackbar.make(findViewById(R.id.activity_capitulo_sobre), "Message is restored!", Snackbar.LENGTH_SHORT)
                    snackbar1.show()
                }

        snackbar.show()

        val botaoAbrirSite = findViewById<View>(R.id.btnAbrirUrl) as Button
        botaoAbrirSite.setOnClickListener {
            val uri = Uri.parse("https://site.uniciv.com.br/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        val botaoLigar = findViewById<View>(R.id.btnLigar) as Button
        botaoLigar.setOnClickListener {
            val uri = Uri.parse("tel:1199889977")
            val intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
        }


        val botaoCamera = findViewById<View>(R.id.btnCamera) as Button
        botaoCamera.setOnClickListener {
            val fotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(fotoIntent)
        }

        val botaoNotificacaoSimples = findViewById<View>(R.id.btnNotificacaoSimples) as Button
        botaoNotificacaoSimples.setOnClickListener {
            val notifyID = 1
            val CHANNEL_ID = "my_channel_01"// The id of the channel.
            val name = "Nome canal"// The user-visible name of the channel.
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)

            val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Titulo")
                    .setContentText("um texto qualquer")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.createNotificationChannel(mChannel)
            mNotificationManager.notify(notifyID, builder.build())
        }

        val botaoNotificacaoBig = findViewById<View>(R.id.btnNotificacaoBig) as Button
        botaoNotificacaoBig.setOnClickListener {
            val notifyID = 2
            val CHANNEL_ID = "my_channel_02"// The id of the channel.
            val name = "Nome canal2"// The user-visible name of the channel.
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)

            val list = ArrayList<String>()
            list.add("Mensagem 1")
            list.add("Mensagem 2")
            list.add("Mensagem 3")
            val contentTitle = "Nova mensagem big"
            val contentText = String.format("Você possui %s novas mensagens", list.size)

            // Configura o estilo Inbox
            val size = list.size
            val inboxStyle = NotificationCompat.InboxStyle()
            inboxStyle.setBigContentTitle(contentTitle)
            for (s in list) {
                inboxStyle.addLine(s)
            }
            inboxStyle.setSummaryText(contentText)

            val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(contentTitle)
                    .setContentText(contentText)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setNumber(size) // Número para aparecer na notificação
                    .setStyle(inboxStyle) // Estilo customizado

            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.createNotificationChannel(mChannel)
            mNotificationManager.notify(notifyID, builder.build())
        }

        val botaoNotificacaoComAcao = findViewById<View>(R.id.btnNotificacaoComAcao) as Button
        botaoNotificacaoComAcao.setOnClickListener {
            val notifyID = 3
            val CHANNEL_ID = "my_channel_03"// The id of the channel.
            val name = "Nome canal3"// The user-visible name of the channel.
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)

            val actionIntent = PendingIntent.getBroadcast(
                    applicationContext, 0, Intent(Intent.ACTION_VIEW), 0)

            val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Nome da música")
                    .setContentText("Nome do artista")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .addAction(android.R.drawable.ic_media_pause, "Pause", actionIntent)
                    .addAction(android.R.drawable.ic_media_play, "Play", actionIntent)

            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.createNotificationChannel(mChannel)
            mNotificationManager.notify(notifyID, builder.build())
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_pesquisar -> Toast.makeText(this, "pesquisar", Toast.LENGTH_SHORT).show()
            R.id.action_settings -> Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show()
            R.id.action_sair -> finish()
            else -> {
            }
        }
        return true
    }

}
