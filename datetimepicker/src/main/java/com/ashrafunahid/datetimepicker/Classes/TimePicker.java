package com.ashrafunahid.datetimepicker.Classes;

import android.app.TimePickerDialog;
import android.content.Context;

import com.ashrafunahid.datetimepicker.Interfaces.OnTimePickedListener;

import java.util.Calendar;

public class TimePicker {
    public static void pickTime12hr(Context context, OnTimePickedListener timeListener) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timeDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
                int hoursToShow = (hourOfDay % 12 == 0) ? 12 : hourOfDay % 12;
                String AmPm = (hourOfDay >= 12) ? "PM" : "AM";
                timeListener.onTimePicked(hoursToShow, minute, AmPm);
            }
        }, hour, minute, false);
        timeDialog.show();
    }

    public static void pickTime24hr(Context context, OnTimePickedListener timeListener) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timeDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
                timeListener.onTimePicked(hourOfDay, minute, "NA");
            }
        }, hour, minute, true);
        timeDialog.show();
    }
}
