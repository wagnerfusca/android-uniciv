package br.com.uniciv.meuprimeiroaplicativo;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SegundaTelaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        String msg = getIntent().getStringExtra( "msg" );
        Toast.makeText(getApplicationContext(), "Bem vindo : " + msg, Toast.LENGTH_LONG ).show();

        Button botaoAbrirSite = findViewById(R.id.btnAbrirUrl);
        botaoAbrirSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText edtSite = findViewById(R.id.edtSite);
                Uri uri = Uri.parse(edtSite.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW , uri);
                startActivity(intent);
            }
        });

        Button botaoLigar = (Button) findViewById(R.id.btnLigar );
        botaoLigar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText edtLigar = findViewById(R.id.edtLigar);
                Uri uri = Uri.parse("tel:" +  edtLigar.getText().toString());
                Intent intent = new Intent(Intent.ACTION_CALL , uri);
                startActivity(intent);
            }
        });

        Button botaoCamera = (Button) findViewById(R.id.btnCamera );
        botaoCamera.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent fotoIntent = new
                        Intent(MediaStore.ACTION_IMAGE_CAPTURE );
                startActivity(fotoIntent);

            }
        });

    }
}
