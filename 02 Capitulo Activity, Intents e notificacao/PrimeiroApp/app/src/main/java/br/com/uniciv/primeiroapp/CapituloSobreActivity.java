package br.com.uniciv.primeiroapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.unicesumar.primeiroapp.R;

public class CapituloSobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo_sobre);

        Button btnExibirValor = (Button) findViewById(R.id.btnAutenticar);
        btnExibirValor.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText edtDigiteValor = (EditText) findViewById(R.id.edtLogin);
                Toast.makeText(getApplicationContext(), edtDigiteValor.getText().toString(), Toast.LENGTH_LONG).show();

                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                it.putExtra("msg", edtDigiteValor.getText().toString());
                startActivity(it);


            }

        });

        Snackbar.make(findViewById(R.id.activity_capitulo_sobre), "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();

        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.activity_capitulo_sobre), "Message is deleted", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(findViewById(R.id.activity_capitulo_sobre), "Message is restored!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });

        snackbar.show();

        Button botaoAbrirSite = (Button) findViewById(R.id.btnAbrirUrl);
        botaoAbrirSite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Uri uri = Uri.parse("https://site.uniciv.com.br/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        Button botaoLigar = (Button) findViewById(R.id.btnLigar);
        botaoLigar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Uri uri = Uri.parse("tel:1199889977");
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);
            }
        });


        Button botaoCamera = (Button) findViewById(R.id.btnCamera);
        botaoCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent fotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(fotoIntent);
            }
        });

        Button botaoNotificacaoSimples = (Button) findViewById(R.id.btnNotificacaoSimples);
        botaoNotificacaoSimples.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                int notifyID = 1;
                String CHANNEL_ID = "my_channel_01";// The id of the channel.
                CharSequence name = "Nome canal";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Titulo")
                        .setContentText("um texto qualquer")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.createNotificationChannel(mChannel);
                mNotificationManager.notify(notifyID, builder.build());
            }

        });

        Button botaoNotificacaoBig = (Button) findViewById(R.id.btnNotificacaoBig);
        botaoNotificacaoBig.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                int notifyID = 2;
                String CHANNEL_ID = "my_channel_02";// The id of the channel.
                CharSequence name = "Nome canal2";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);

                List<String> list = new ArrayList<>();
                list.add("Mensagem 1");
                list.add("Mensagem 2");
                list.add("Mensagem 3");
                String contentTitle = "Nova mensagem big";
                String contentText = String.format("Você possui %s novas mensagens", list.size());

                // Configura o estilo Inbox
                int size = list.size();
                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                inboxStyle.setBigContentTitle(contentTitle);
                for (String s : list) {
                    inboxStyle.addLine(s);
                }
                inboxStyle.setSummaryText(contentText);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(contentTitle)
                        .setContentText(contentText)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setNumber(size) // Número para aparecer na notificação
                        .setStyle(inboxStyle); // Estilo customizado

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.createNotificationChannel(mChannel);
                mNotificationManager.notify(notifyID, builder.build());
            }

        });

        Button botaoNotificacaoComAcao = (Button) findViewById(R.id.btnNotificacaoComAcao);
        botaoNotificacaoComAcao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                int notifyID = 3;
                String CHANNEL_ID = "my_channel_03";// The id of the channel.
                CharSequence name = "Nome canal3";// The user-visible name of the channel.
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);

                PendingIntent actionIntent = PendingIntent.getBroadcast(
                        getApplicationContext(), 0, new Intent(Intent.ACTION_VIEW), 0);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Nome da música")
                        .setContentText("Nome do artista")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .addAction(android.R.drawable.ic_media_pause, "Pause", actionIntent)
                        .addAction(android.R.drawable.ic_media_play, "Play", actionIntent);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.createNotificationChannel(mChannel);
                mNotificationManager.notify(notifyID, builder.build());
            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_pesquisar:
                Toast.makeText(this, "pesquisar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_sair:
                finish();
                break;
            default:
                break;
        }
        return true;
    }

}
