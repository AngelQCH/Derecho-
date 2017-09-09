package com.arteyciencia.a2jqch.derechobolivia;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class ContenidoActivity extends AppCompatActivity implements View.OnClickListener {
    TextView texto;
    Button escuchar;
    TextToSpeech ttbj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);
        texto=(TextView)findViewById(R.id.texto);
        escuchar=(Button)findViewById(R.id.escuchar);
        ttbj=new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                ttbj.setLanguage(Locale.getDefault());

            }
        });
        escuchar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.escuchar:
                String deletrear=texto.getText().toString();
                ttbj.speak(deletrear, TextToSpeech.QUEUE_ADD,null);
                //obtenemos una copia de resultado (sólo por seguridad)
        }
    }
}
