package com.example.finalprojection;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button findJoby,postJoby;
    VideoView video20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findJoby=findViewById(R.id.findJob);
        postJoby=findViewById(R.id.postJob);
        video20=findViewById(R.id.video2);

        String path="android.resource://com.example.finalprojection/"+R.raw.kboard;
        Uri u=Uri.parse(path);
        video20.setVideoURI(u);
        video20.start();

        video20.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        postJoby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(MainActivity.this,postJob.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

    }

    @Override
    protected void onResume() {
        video20.resume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        video20.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        video20.stopPlayback();
        super.onDestroy();
    }
    /*
    public void posting(View view) {
        Intent u=new Intent(this,postJob.class);
        startActivity(u);
    }*/
}
