package com.example.a001.criminal;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public static final String EXTRA_DATE = "com.bignerdranch.android.criminalintent.date";
    private Date mDate;

    public static DatePickerFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATE, date);
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void sendResult(int resultCode) {
        if (getTargetFragment() == null)
            return;

        Intent i = new Intent();
        i.putExtra(EXTRA_DATE, mDate);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mDate = (Date)getArguments().getSerializable(EXTRA_DATE);

        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        c.setTime(mDate);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        {
//            View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_date, null);
//
//            DatePicker datePicker = (DatePicker)v.findViewById(R.id.dialog_date_datePicker);
//            datePicker.init(year, month, day, null);
            //new DatePicker.OnDateChangedListener() {
//            public void onDateChanged(DatePicker view, int year, int month, int day) {
//                // Translate year, month, day into a Date object using a calendar
//                mDate = new GregorianCalendar(year, month, day).getTime();
//                // Update argument to preserve selected value on rotation
//                getArguments().putSerializable(EXTRA_DATE, mDate);
//            }
//        });

//            return new AlertDialog.Builder(getActivity())
//                    .setView(v)
//                    .setTitle(R.string.date_picker_title)
//                    .setPositiveButton(
//                            android.R.string.ok,
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    sendResult(Activity.RESULT_OK);
//                                }
//                            })
//                    .create();
        }
        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Translate year, month, day into a Date object using a calendar
        mDate = new GregorianCalendar(year, month, day).getTime();
        // Update argument to preserve selected value on rotation
        getArguments().putSerializable(EXTRA_DATE, mDate);

        sendResult(Activity.RESULT_OK);
    }
}
