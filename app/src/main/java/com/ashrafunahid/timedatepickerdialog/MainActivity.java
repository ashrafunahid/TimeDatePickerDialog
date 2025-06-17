package com.ashrafunahid.timedatepickerdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ashrafunahid.datetimepicker.Classes.DatePicker;
import com.ashrafunahid.datetimepicker.Classes.DateTimePicker;
import com.ashrafunahid.datetimepicker.Classes.TimePicker;
import com.ashrafunahid.datetimepicker.Interfaces.OnDatePickedListener;
import com.ashrafunahid.datetimepicker.Interfaces.OnDateTimePickedListener;
import com.ashrafunahid.datetimepicker.Interfaces.OnTimePickedListener;

public class MainActivity extends AppCompatActivity {

    TextView showTime, showDate, showDateTime;
    Button timePicker, datePicker, dateTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        showTime = findViewById(R.id.show_time);
        showDate = findViewById(R.id.show_date);
        showDateTime = findViewById(R.id.show_date_time);
        dateTimePicker = findViewById(R.id.date_time_picker);
        timePicker = findViewById(R.id.time_picker);
        datePicker = findViewById(R.id.date_picker);

        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePicker.pickTime12hr(MainActivity.this, new OnTimePickedListener() {
                    @Override
                    public void onTimePicked(int hour, int minute, String MeridiemIndicator) {
                        showTime.setText(String.format("Picked Time is: %d:%d %s", hour, minute, MeridiemIndicator));
                    }
                });
            }
        });

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker.pickDate(MainActivity.this, new OnDatePickedListener() {
                    @Override
                    public void onDatePicked(String formattedDate, int year, int month, int day) {
                        showDate.setText(String.format("Picked Date is: %s", formattedDate));
                    }
                });
            }

        });

        dateTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateTimePicker.pickDateTime(MainActivity.this, new OnDateTimePickedListener() {
                    @Override
                    public void onDateTimePicked(String formattedDateTime, int year, int month, int day, int hour, int minute, long timestamp) {
                        showDateTime.setText(String.format("Picked: %s \n TimeStamp is: %d", formattedDateTime, timestamp));
                    }
                });
            }
        });

    }
}