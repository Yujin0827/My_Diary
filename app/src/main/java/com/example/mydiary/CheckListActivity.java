package com.example.mydiary;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.cookandroid.finish.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class CheckListActivity extends AppCompatActivity {
    ImageView back;
    DatePicker dp;
    EditText list1, list2, list3, list4, todaydiary;
    Button weather, save;
    String l1, l2, l3, l4, fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list);
        final RatingBar todo1, todo2, todo3, todo4;
        Button ch1, ch2, ch3, ch4;

        back = (ImageView) findViewById(R.id.back);
        weather = (Button) findViewById(R.id.weather);
        save = (Button) findViewById(R.id.save);

        dp = (DatePicker) findViewById(R.id.cal);

        list1 = (EditText) findViewById(R.id.list1);
        list2 = (EditText) findViewById(R.id.list2);
        list3 = (EditText) findViewById(R.id.list3);
        list4 = (EditText) findViewById(R.id.list4);
        todaydiary = (EditText) findViewById(R.id.todaydiary);

        todo1 = (RatingBar) findViewById(R.id.todo1);
        todo2 = (RatingBar) findViewById(R.id.todo2);
        todo3 = (RatingBar) findViewById(R.id.todo3);
        todo4 = (RatingBar) findViewById(R.id.todo4);

        ch1 = (Button) findViewById(R.id.ch1);
        ch2 = (Button) findViewById(R.id.ch2);
        ch3 = (Button) findViewById(R.id.ch3);
        ch4 = (Button) findViewById(R.id.ch4);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + '_' + Integer.toString(monthOfYear + 1) + '_' + Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(fileName);
                todaydiary.setText(str);
                save.setEnabled(true);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = todaydiary.getText().toString();
                    l1 = list1.getText().toString();
                    l2 = list2.getText().toString();
                    l3 = list3.getText().toString();
                    l4 = list4.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), fileName + " 이 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });

        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todo1.setRating(todo1.getRating()+todo1.getStepSize());
            }
        });

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todo2.setRating(todo2.getRating()+todo2.getStepSize());
            }
        });

        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todo3.setRating(todo3.getRating()+todo3.getStepSize());
            }
        });

        ch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todo4.setRating(todo4.getRating()+todo4.getStepSize());
            }
        });
    }

    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            save.setText("Fixing a diary");
        } catch (IOException e) {
            todaydiary.setHint("일기 없음");
        }
        return diaryStr;
    }
}
