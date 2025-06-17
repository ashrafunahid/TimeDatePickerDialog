package com.ashrafunahid.datetimepicker.Interfaces;

public interface OnDateTimePickedListener {
    void onDateTimePicked(String formattedDateTime, int year, int month, int day, int hour, int minute, long timestamp);
}
