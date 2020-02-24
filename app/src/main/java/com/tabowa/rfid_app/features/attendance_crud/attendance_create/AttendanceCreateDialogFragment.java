package com.tabowa.rfid_app.features.attendance_crud.attendance_create;


import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.tabowa.rfid_app.R;
import com.tabowa.rfid_app.database.*;
import com.tabowa.rfid_app.features.attendance_crud.AttendanceCrudListener;
import com.tabowa.rfid_app.model.Attendance;

import static android.app.Activity.RESULT_OK;
import static com.tabowa.rfid_app.util.Constants.*;


public class AttendanceCreateDialogFragment extends DialogFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static AttendanceCrudListener attendanceCrudListener;

    private EditText regNoEditText;
    private EditText programEditText;
    private EditText categoryEditText;
    private EditText sessionEditText;
    private EditText semesterEditText;
    private EditText courseTitleEditText;
    private EditText courseCodeEditText;
    private EditText attendaceEditText;
    private EditText dateAttendanceEditText;


    private Button createButton;
    private Button cancelButton;




    private String regNoString = "";
    private String programString = "";
    private String categoryString = "";
    private String sessionString = "";
    private String semesterString = "";
    private String courseTitleString = "";
    private String courseCodeString = "";
    private String attendaceString = "";
    private String dateattendaceString = "";


    public AttendanceCreateDialogFragment() {
        // Required empty public constructor
    }


    public static com.tabowa.rfid_app.features.attendance_crud.attendance_create.AttendanceCreateDialogFragment newInstance(String title, AttendanceCrudListener listener){
        attendanceCrudListener = listener;
        com.tabowa.rfid_app.features.attendance_crud.attendance_create.AttendanceCreateDialogFragment attendanceCreateDialogFragment = new com.tabowa.rfid_app.features.attendance_crud.attendance_create.AttendanceCreateDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        attendanceCreateDialogFragment.setArguments(args);

        attendanceCreateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return attendanceCreateDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_attendance_create_dialog, container, false);

//        nameEditText = view.findViewById(R.id.attendanceNameEditText);
//        registrationEditText = view.findViewById(R.id.registrationEditText);
//        phoneEditText = view.findViewById(R.id.phoneEditText);
//        emailEditText = view.findViewById(R.id.emailEditText);



        regNoEditText = view.findViewById(R.id.attendanceRegNoEditText);
        programEditText   = view.findViewById(R.id.attendanceProgramEditText);
        categoryEditText    = view.findViewById(R.id.attendanceCategoryEditText);
        sessionEditText   = view.findViewById(R.id.attendanceSessionEditText);
        semesterEditText       = view.findViewById(R.id.attendanceSemesterEditText);
        courseTitleEditText         = view.findViewById(R.id.attendanceTitleEditText);
        courseCodeEditText    = view.findViewById(R.id.attendanceCodeEditText);
        attendaceEditText      = view.findViewById(R.id.attendanceClassAttendanceEditText);
        dateAttendanceEditText          = view.findViewById(R.id.attendanceDateofAttendanceEditText);

        createButton = view.findViewById(R.id.createButton);
        cancelButton = view.findViewById(R.id.cancelButton);


        String title = getArguments().getString(TITLE);
        getDialog().setTitle(title);



        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                nameString = nameEditText.getText().toString();
//                registrationNumber = Integer.parseInt(registrationEditText.getText().toString());
//                phoneString = phoneEditText.getText().toString();
//                emailString = emailEditText.getText().toString();


//                photo = " ";  //photoimageView.getText().toString();

                regNoString = regNoEditText.getText().toString();
                programString = programEditText.getText().toString();
                categoryString = categoryEditText.getText().toString();
                sessionString = sessionEditText.getText().toString();
                semesterString = semesterEditText.getText().toString();
                courseTitleString = courseTitleEditText.getText().toString();
                courseCodeString = courseCodeEditText.getText().toString();
                attendaceString = attendaceEditText.getText().toString();
                dateattendaceString = dateAttendanceEditText.getText().toString();






//                final Attendance attendance = new Attendance(-1, nameString, registrationNumber, phoneString, emailString);
//                final Attendance attendance = new Attendance(-1, photo, nameString, registrationString, phoneString, emailString, departmentString, schoolString, programString, categoryString, sessionString, bloodGroup, noK, noKAddr, noKPhoneNumber, state, lGA, homeTown, healthCardNo, doB, expiryDate, gender, niN, medicalCardNo, thumbPrint);
                final Attendance attendance = new Attendance(-1, regNoString, programString, categoryString, sessionString, semesterString, courseTitleString, courseCodeString, attendaceString, dateattendaceString);

                QueryContract.AttendanceQuery attendanceQuery = new AttendanceQueryImplementation();
                attendanceQuery.createAttendance(attendance, new QueryResponse<Boolean>() {
                    @Override
                    public void onSuccess(Boolean data) {
                        getDialog().dismiss();
                        attendanceCrudListener.onAttendanceListUpdate(data);
                        Toast.makeText(getContext(), "Attendance created successfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(String message) {
                        attendanceCrudListener.onAttendanceListUpdate(false);
                        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            //noinspection ConstantConditions
            dialog.getWindow().setLayout(width, height);
        }
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

    }
}
