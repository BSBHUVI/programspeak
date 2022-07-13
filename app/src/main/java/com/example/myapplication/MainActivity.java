package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public EditText txtSpeak;
    public Button btnSpeak;
    public TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSpeak=findViewById(R.id.speak);
        btnSpeak=findViewById(R.id.button);
        textToSpeech=new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
                }
            }
        });
        textToSpeech.setLanguage(Locale.UK);
    }
    public void speak(View view){
        String text=txtSpeak.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);

    }

}