package com.example.mydiary;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.AnalogClock;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.DigitalClock;

import com.cookandroid.finish.R;

public class MainActivity extends AppCompatActivity {
    Button musiclist, diary, alarm, weather, madeby;
    CalendarView cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Yujin's app");

        final MediaPlayer mPlayer;
        mPlayer = MediaPlayer.create(this, R.raw.music1);

        final Switch music = (Switch) findViewById(R.id.music);

        musiclist = (Button) findViewById(R.id.musiclist);
        cal = (CalendarView) findViewById(R.id.cal);
        diary = (Button) findViewById(R.id.diary);
        alarm = (Button) findViewById(R.id.alarm);
        weather = (Button) findViewById(R.id.weather);
        madeby = (Button) findViewById(R.id.madeby);

        music.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (music.isChecked() == true)
                    mPlayer.start();
                else
                    mPlayer.pause();
            }
        });

        musiclist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), MusicListActivity.class);
                startActivity(intent2);
                mPlayer.pause();
            }
        });

        diary.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), CheckListActivity.class);
                startActivity(intent3);
            }
        });

        alarm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(), AlarmActivity.class);
                startActivity(intent4);
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent6 = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent6);
            }
        });

        madeby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent5 = new Intent(getApplicationContext(), WebActivity.class);
                startActivity(intent5);
            }
        });
    }
}

