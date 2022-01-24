package com.example.mydiary;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.cookandroid.finish.R;

public class MusicListActivity extends AppCompatActivity {
    ImageView back;
    Button music1, music2, music3, music4, music5, music6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

        final MediaPlayer m, m1, m2, m3, m4, m5, m6;
        m1 = MediaPlayer.create(this, R.raw.music1);
        m2 = MediaPlayer.create(this, R.raw.music2);
        m3 = MediaPlayer.create(this, R.raw.music3);
        m4 = MediaPlayer.create(this, R.raw.music4);
        m5 = MediaPlayer.create(this, R.raw.music5);
        m6 = MediaPlayer.create(this, R.raw.music6);

        back = (ImageView) findViewById(R.id.back);
        music1 = (Button) findViewById(R.id.music1);
        music2 = (Button) findViewById(R.id.music2);
        music3 = (Button) findViewById(R.id.music3);
        music4 = (Button) findViewById(R.id.music4);
        music5 = (Button) findViewById(R.id.music5);
        music6 = (Button) findViewById(R.id.music6);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        music1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                m1.start();
                m2.pause();
                m3.pause();
                m4.pause();
                m5.pause();
                m6.pause();
                Toast.makeText(MusicListActivity.this, "'All I Want For Christmas Is You' START", Toast.LENGTH_LONG).show();
            }
        });

        music2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                m1.pause();
                m2.start();
                m3.pause();
                m4.pause();
                m5.pause();
                m6.pause();
                Toast.makeText(MusicListActivity.this, "'Blueming' START", Toast.LENGTH_LONG).show();
            }
        });

        music3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                m1.pause();
                m2.pause();
                m3.start();
                m4.pause();
                m5.pause();
                m6.pause();
                Toast.makeText(MusicListActivity.this, "'Dynamite' START", Toast.LENGTH_LONG).show();
            }
        });

        music4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                m1.pause();
                m2.pause();
                m3.pause();
                m4.start();
                m5.pause();
                m6.pause();
                Toast.makeText(MusicListActivity.this, "'Santa Tell Me' START", Toast.LENGTH_LONG).show();
            }
        });

        music5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                m1.pause();
                m2.pause();
                m3.pause();
                m4.pause();
                m5.start();
                m6.pause();
                Toast.makeText(MusicListActivity.this, "'Savage Love' START", Toast.LENGTH_LONG).show();
            }
        });

        music6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                m1.pause();
                m2.pause();
                m3.pause();
                m4.pause();
                m5.pause();
                m6.start();
                Toast.makeText(MusicListActivity.this, "'취기를 빌려' START", Toast.LENGTH_LONG).show();
            }
        });
    }
}
