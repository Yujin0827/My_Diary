package com.example.mydiary;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.cookandroid.finish.R;

public class AlarmActivity extends AppCompatActivity {
    ImageView back;
    RadioButton rdoDate, rdoTime;
    DatePicker dPicker;
    TimePicker tPicker;
    Button btnEnd;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        back = (ImageView) findViewById(R.id.back);

        rdoDate = (RadioButton) findViewById(R.id.rdoDate);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        dPicker = (DatePicker) findViewById(R.id.datePicker1);
        tPicker = (TimePicker) findViewById(R.id.timePicker1);

        btnEnd = (Button) findViewById(R.id.btnEnd);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        dPicker.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rdoDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dPicker.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                tvYear.setText(Integer.toString(dPicker.getYear()));
                tvMonth.setText(Integer.toString(dPicker.getMonth()+1));
                tvDay.setText(Integer.toString(dPicker.getDayOfMonth()));
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
            }
        });
    }
}
