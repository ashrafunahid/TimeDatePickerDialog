package com.ashrafunahid.datetimepicker.Classes;

import android.app.DatePickerDialog;
import android.content.Context;

import com.ashrafunahid.datetimepicker.Interfaces.OnDatePickedListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DatePicker {
    public static void pickDate(Context context, OnDatePickedListener dateListener) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dateDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                Calendar selectedDateTime = Calendar.getInstance();
                selectedDateTime.set(year, month, dayOfMonth);

                String formatted = new SimpleDateFormat("dd MMMM, yyyy", Locale.getDefault())
                        .format(selectedDateTime.getTime());
                dateListener.onDatePicked(formatted, year, month, dayOfMonth);
            }
        }, year, month, day);
        dateDialog.show();
    }
}
