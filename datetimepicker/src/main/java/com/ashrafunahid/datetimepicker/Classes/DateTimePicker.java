package com.ashrafunahid.datetimepicker.Classes;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import com.ashrafunahid.datetimepicker.Interfaces.OnDateTimePickedListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateTimePicker {
    public static void pickDateTime(Activity activity, OnDateTimePickedListener listener) {
        Calendar calendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, (view, selectedYear, selectedMonth, selectedDay) -> {

            TimePickerDialog timePickerDialog = new TimePickerDialog(activity, (timeView, selectedHour, selectedMinute) -> {
                Calendar selectedDateTime = Calendar.getInstance();
                selectedDateTime.set(selectedYear, selectedMonth, selectedDay, selectedHour, selectedMinute);

                String formatted = new SimpleDateFormat("EEEE, dd MMMM, yyyy hh:mm a", Locale.getDefault())
                        .format(selectedDateTime.getTime());

                long timestamp = selectedDateTime.getTimeInMillis();

                listener.onDateTimePicked(formatted, selectedYear, selectedMonth, selectedDay, selectedHour, selectedMinute, timestamp);

            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false);

            timePickerDialog.show();
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }
}
