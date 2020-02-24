package com.tabowa.rfid_app.features.grade_crud.grade_create;


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
import com.tabowa.rfid_app.features.grade_crud.GradeCrudListener;
import com.tabowa.rfid_app.model.Grade;

import static android.app.Activity.RESULT_OK;
import static com.tabowa.rfid_app.util.Constants.*;


public class GradeCreateDialogFragment extends DialogFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static GradeCrudListener gradeCrudListener;

    private EditText regNoEditText;
    private EditText programEditText;
    private EditText categoryEditText;
    private EditText sessionEditText;
    private EditText semesterEditText;
    private EditText gradeTitleEditText;
    private EditText gradeCodeEditText;
    private EditText gradeUnitsEditText;
    private EditText gradeclass_attendanceEditText;
    private EditText gradescoreEditText;
    private EditText gradeexaminationEditText;
    private EditText gradetotalEditText;
    private EditText gradegradeEditText;



    private Button createButton;
    private Button cancelButton;




    private String regNoString ="";
    private String programString ="";
    private String categoryString ="";
    private String sessionString ="";
    private String semesterString ="";
    private String gradeTitleString ="";
    private String gradeCodeString ="";
    private String gradeUnitsString ="";
    private String gradeclass_attendanceString="";
    private String gradescoreString="";
    private String gradeexaminationString="";
    private String gradetotalString="";
    private String gradegradeString="";




    public GradeCreateDialogFragment() {
        // Required empty public constructor
    }


    public static com.tabowa.rfid_app.features.grade_crud.grade_create.GradeCreateDialogFragment newInstance(String title, GradeCrudListener listener){
        gradeCrudListener = listener;
        com.tabowa.rfid_app.features.grade_crud.grade_create.GradeCreateDialogFragment gradeCreateDialogFragment = new com.tabowa.rfid_app.features.grade_crud.grade_create.GradeCreateDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        gradeCreateDialogFragment.setArguments(args);

        gradeCreateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return gradeCreateDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_grade_create_dialog, container, false);

//        nameEditText = view.findViewById(R.id.gradeNameEditText);
//        registrationEditText = view.findViewById(R.id.registrationEditText);
//        phoneEditText = view.findViewById(R.id.phoneEditText);
//        emailEditText = view.findViewById(R.id.emailEditText);



        regNoEditText = view.findViewById(R.id.gradeRegNoEditText);
        programEditText   = view.findViewById(R.id.gradeProgramEditText);
        categoryEditText    = view.findViewById(R.id.gradeCategoryEditText);
        sessionEditText   = view.findViewById(R.id.gradeSessionEditText);
        semesterEditText       = view.findViewById(R.id.gradeSemesterEditText);
        gradeTitleEditText         = view.findViewById(R.id.gradeTitleEditText);
        gradeCodeEditText    = view.findViewById(R.id.gradeCodeEditText);
        gradeUnitsEditText = view.findViewById(R.id.gradeUnitsLayout);
        gradeclass_attendanceEditText = view.findViewById(R.id.gradeUnitsLayout);
        gradescoreEditText = view.findViewById(R.id.gradeUnitsLayout);
        gradeexaminationEditText = view.findViewById(R.id.gradeUnitsLayout);
        gradetotalEditText = view.findViewById(R.id.gradeUnitsLayout);
        gradegradeEditText = view.findViewById(R.id.gradeUnitsLayout);

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

                regNoString= regNoEditText.getText().toString();
                programString= programEditText.getText().toString();
                categoryString= categoryEditText.getText().toString();
                sessionString= sessionEditText.getText().toString();
                semesterString= semesterEditText.getText().toString();
                gradeTitleString= gradeTitleEditText.getText().toString();
                gradeCodeString= gradeCodeEditText.getText().toString();
                gradeUnitsString= gradeUnitsEditText.getText().toString();
                gradeclass_attendanceString= gradeclass_attendanceEditText.getText().toString();
                gradescoreString= gradescoreEditText.getText().toString();
                gradeexaminationString= gradeexaminationEditText.getText().toString();
                gradetotalString= gradetotalEditText.getText().toString();
                gradegradeString= gradegradeEditText.getText().toString();






//                final Grade grade = new Grade(-1, nameString, registrationNumber, phoneString, emailString);
//                final Grade grade = new Grade(-1, photo, nameString, registrationString, phoneString, emailString, departmentString, schoolString, programString, categoryString, sessionString, bloodGroup, noK, noKAddr, noKPhoneNumber, state, lGA, homeTown, healthCardNo, doB, expiryDate, gender, niN, medicalCardNo, thumbPrint);
                final Grade grade = new Grade(-1, regNoString, programString, categoryString, sessionString, semesterString, gradeTitleString, gradeCodeString, gradeUnitsString, gradeclass_attendanceString, gradescoreString, gradeexaminationString, gradetotalString, gradegradeString);

                QueryContract.GradeQuery gradeQuery = new GradeQueryImplementation();
                gradeQuery.createGrade(grade, new QueryResponse<Boolean>() {
                    @Override
                    public void onSuccess(Boolean data) {
                        getDialog().dismiss();
                        gradeCrudListener.onGradeListUpdate(data);
                        Toast.makeText(getContext(), "Grade created successfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(String message) {
                        gradeCrudListener.onGradeListUpdate(false);
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
