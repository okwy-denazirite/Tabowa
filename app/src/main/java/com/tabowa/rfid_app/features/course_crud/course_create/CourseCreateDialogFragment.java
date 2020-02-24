package com.tabowa.rfid_app.features.course_crud.course_create;


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
import com.tabowa.rfid_app.features.course_crud.CourseCrudListener;
import com.tabowa.rfid_app.model.Course;

import static android.app.Activity.RESULT_OK;
import static com.tabowa.rfid_app.util.Constants.*;


public class CourseCreateDialogFragment extends DialogFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static CourseCrudListener courseCrudListener;

    private EditText regNoEditText;
    private EditText programEditText;
    private EditText categoryEditText;
    private EditText sessionEditText;
    private EditText semesterEditText;
    private EditText courseTitleEditText;
    private EditText courseCodeEditText;
    private EditText courseUnitsEditText;



    private Button createButton;
    private Button cancelButton;




    private String regNoString = "";
    private String programString = "";
    private String categoryString = "";
    private String sessionString = "";
    private String semesterString = "";
    private String courseTitleString = "";
    private String courseCodeString = "";
    private String courseUnitsString = "";



    public CourseCreateDialogFragment() {
        // Required empty public constructor
    }


    public static com.tabowa.rfid_app.features.course_crud.course_create.CourseCreateDialogFragment newInstance(String title, CourseCrudListener listener){
        courseCrudListener = listener;
        com.tabowa.rfid_app.features.course_crud.course_create.CourseCreateDialogFragment courseCreateDialogFragment = new com.tabowa.rfid_app.features.course_crud.course_create.CourseCreateDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        courseCreateDialogFragment.setArguments(args);

        courseCreateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return courseCreateDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_course_create_dialog, container, false);

//        nameEditText = view.findViewById(R.id.courseNameEditText);
//        registrationEditText = view.findViewById(R.id.registrationEditText);
//        phoneEditText = view.findViewById(R.id.phoneEditText);
//        emailEditText = view.findViewById(R.id.emailEditText);



        regNoEditText = view.findViewById(R.id.courseRegNoEditText);
        programEditText   = view.findViewById(R.id.courseProgramEditText);
        categoryEditText    = view.findViewById(R.id.courseCategoryEditText);
        sessionEditText   = view.findViewById(R.id.courseSessionEditText);
        semesterEditText       = view.findViewById(R.id.courseSemesterEditText);
        courseTitleEditText         = view.findViewById(R.id.courseTitleEditText);
        courseCodeEditText    = view.findViewById(R.id.courseCodeEditText);
        courseUnitsEditText = view.findViewById(R.id.courseUnitsLayout);

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
                courseUnitsString = courseUnitsEditText.getText().toString();






//                final Course course = new Course(-1, nameString, registrationNumber, phoneString, emailString);
//                final Course course = new Course(-1, photo, nameString, registrationString, phoneString, emailString, departmentString, schoolString, programString, categoryString, sessionString, bloodGroup, noK, noKAddr, noKPhoneNumber, state, lGA, homeTown, healthCardNo, doB, expiryDate, gender, niN, medicalCardNo, thumbPrint);
                final Course course = new Course(-1, regNoString, programString, categoryString, sessionString, semesterString, courseTitleString, courseCodeString, courseUnitsString);

                QueryContract.CourseQuery courseQuery = new CourseQueryImplementation();
                courseQuery.createCourse(course, new QueryResponse<Boolean>() {
                    @Override
                    public void onSuccess(Boolean data) {
                        getDialog().dismiss();
                        courseCrudListener.onCourseListUpdate(data);
                        Toast.makeText(getContext(), "Course created successfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(String message) {
                        courseCrudListener.onCourseListUpdate(false);
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
