package com.tabowa.rfid_app.features.student_crud.student_update;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
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
import com.tabowa.rfid_app.features.student_crud.StudentCrudListener;
import com.tabowa.rfid_app.model.Student;

import static android.app.Activity.RESULT_OK;
import static com.tabowa.rfid_app.util.Constants.TITLE;

public class StudentUpdateDialogFragment  extends DialogFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static StudentCrudListener studentCrudListener;

//    private EditText nameEditText;
//    private EditText registrationEditText;
//    private EditText phoneEditText;
//    private EditText emailEditText;

//    private String nameString = "";
//    private String registrationNumber = "";
//    private String phoneString = "";
//    private String emailString = "";

    private ImageView photoimageView;
    private EditText nameEditText;
    private EditText registrationEditText;
    private EditText phoneEditText;
    private EditText emailEditText;
    private EditText departmentEditText;
    private EditText schoolEditText;
    private EditText programEditText;
    private EditText categoryEditText;
    private EditText sessionEditText;
    private EditText bloodGroupEditText;
    private EditText nOKEditText;
    private EditText nOKAddrEditText;
    private EditText nOKPhoneEditText;
    private Spinner stateSpinner;
    private Spinner lgASpinner;
    private EditText homeTownEditText;
    private EditText healthCardNoEditText;
    private EditText dOBEditText;
    private EditText expiryDateEditText;
    private Spinner genderSpinner;
    private EditText nINEditText;
    private EditText medicalCardNoEditText;


    private Button updateButton;
    private Button cancelButton;


    private Uri photo;
    private String nameString = "";
    private String registrationString = "";
    private String phoneString = "";
    private String emailString = "";
    private String departmentString = "";
    private String schoolString = "";
    private String programString = "";
    private String categoryString = "";
    private String sessionString = "";
    private String bloodGroup = "";
    private String noK = "";
    private String noKAddr = "";
    private String noKPhoneNumber = "";
    private String state = "";
    private String lGA = "";
    private String homeTown = "";
    private String healthCardNo = "";
    private String doB = "";
    private String expiryDate = "";
    private String gender = "";
    private long   niN = -1;
    private String medicalCardNo = "";
    private static final int PICK_IMAGE = 100;


    private static Student student;

    public StudentUpdateDialogFragment() {
        // Required empty public constructor
    }

    public static StudentUpdateDialogFragment newInstance(Student std, String title, StudentCrudListener listener){
        student = std;
        studentCrudListener = listener;
        StudentUpdateDialogFragment studentUpdateDialogFragment = new StudentUpdateDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        studentUpdateDialogFragment.setArguments(args);

        studentUpdateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return studentUpdateDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_update_dialog, container, false);
        String title = getArguments().getString(TITLE);
        getDialog().setTitle(title);

//        nameEditText = view.findViewById(R.id.studentNameEditText);
//        registrationEditText = view.findViewById(R.id.registrationEditText);
//        phoneEditText = view.findViewById(R.id.phoneEditText);
//        emailEditText = view.findViewById(R.id.emailEditText);
        photoimageView = view.findViewById(R.id.studentimageView);
        nameEditText = view.findViewById(R.id.studentNameEditText);
        registrationEditText = view.findViewById(R.id.studentRegistrationEditText);
        phoneEditText = view.findViewById(R.id.studentPhoneEditText);
        emailEditText = view.findViewById(R.id.studentEmailEditText);
        departmentEditText = view.findViewById(R.id.studentDepartmentEditText);
        schoolEditText = view.findViewById(R.id.studentSchoolEditText);
        programEditText = view.findViewById(R.id.studentProgramEditText);
        categoryEditText = view.findViewById(R.id.studentCategoryEditText);
        sessionEditText = view.findViewById(R.id.studentSessionEditText);
        bloodGroupEditText = view.findViewById(R.id.studentBloodGroup);
        nOKEditText = view.findViewById(R.id.studentNOK);
        nOKAddrEditText = view.findViewById(R.id.studentNOKAddr);
        nOKPhoneEditText = view.findViewById(R.id.studentNOKPhone);
        stateSpinner = view.findViewById(R.id.studentState);
        lgASpinner= view.findViewById(R.id.studentLGA);
        homeTownEditText = view.findViewById(R.id.studentHomeTown);
        healthCardNoEditText = view.findViewById(R.id.studentHealthCardNo);
        dOBEditText = view.findViewById(R.id.studentDOB);
        expiryDateEditText = view.findViewById(R.id.studentExpiryDate);
        genderSpinner = view.findViewById(R.id.studentGender);
        nINEditText = view.findViewById(R.id.studentNIN);
        medicalCardNoEditText = view.findViewById(R.id.studentMedicalCardNo);

        updateButton = view.findViewById(R.id.updateButton);
        cancelButton = view.findViewById(R.id.cancelButton);

//        nameEditText.setText(student.getName());
//        registrationEditText.setText(String.valueOf(student.getRegistrationNumber()));
//        phoneEditText.setText(student.getPhone());
//        emailEditText.setText(student.getEmail());


        //photoimageView.setText(student.);
        nameEditText.setText(student.getName());
        Log.d("null err", "onCreateView: " + student.getRegistrationNumber());
        registrationEditText.setText(student.getRegistrationNumber());
        phoneEditText.setText(student.getPhone());
        emailEditText.setText(student.getEmail());
        departmentEditText.setText(student.getDepartment());
        schoolEditText.setText(student.getSchool());
        programEditText .setText(student.getProgram());
        categoryEditText .setText(student.getCategory());
        sessionEditText .setText(student.getSession());
        bloodGroupEditText.setText(student.getBloodGroup());
        nOKEditText.setText(student.getNoK());
        nOKAddrEditText.setText(student.getNoKAddr());
        nOKPhoneEditText.setText(student.getNoKPhone());
        stateSpinner.setSelection(0);
        lgASpinner.setSelection(0);
        homeTownEditText .setText(student.getHomeTown());
        healthCardNoEditText.setText(student.getHealthCardNo());
        dOBEditText.setText(student.getDoB());
        expiryDateEditText .setText(student.getExpiryDate());
        genderSpinner.setSelection(0);
        nINEditText.setText(String.valueOf(student.getNiN()));
        medicalCardNoEditText.setText(String.valueOf(student.getMedicalCardNo()));

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                nameString = nameEditText.getText().toString();
//                registrationString = registrationEditText.getText().toString();
//                phoneString = phoneEditText.getText().toString();
//                emailString = emailEditText.getText().toString();

//                photo = " ";  //photoimageView.getText().toString();
                nameString = nameEditText.getText().toString();
                registrationString = registrationEditText .getText().toString();
                phoneString = phoneEditText.getText().toString();
                emailString = emailEditText.getText().toString();
                departmentString = departmentEditText.getText().toString();
                schoolString = schoolEditText.getText().toString();
                programString = programEditText .getText().toString();
                categoryString = categoryEditText .getText().toString();
                sessionString = sessionEditText .getText().toString();
                bloodGroup = bloodGroupEditText.getText().toString();
                noK = nOKEditText.getText().toString();
                noKAddr = nOKAddrEditText.getText().toString();
                noKPhoneNumber = nOKPhoneEditText.getText().toString();
                state = stateSpinner.getSelectedItem().toString();
                lGA = lgASpinner.getSelectedItem().toString();
                homeTown = homeTownEditText .getText().toString();
                healthCardNo = healthCardNoEditText.getText().toString();
                doB = dOBEditText.getText().toString();
                expiryDate = expiryDateEditText .getText().toString();
                gender = genderSpinner.getSelectedItem().toString();
                niN = Integer.parseInt(nINEditText.getText().toString());
                medicalCardNo = medicalCardNoEditText.getText().toString();


//                student.setName(nameString);
//                student.setRegistrationNumber(registrationString);
//                student.setPhone(phoneString);
//                student.setEmail(emailString);

                student.setPhoto(photo);
                student.setName(nameString);
                student.setRegistrationNumber(registrationString);
                student.setPhone(phoneString);
                student.setEmail(emailString);
                student.setDepartment(departmentString);
                student.setSchool(schoolString);
                student.setProgram(programString);
                student.setCategory(categoryString);
                student.setSession(sessionString);
                student.setBloodGroup(bloodGroup);
                student.setNoK(noK);
                student.setNoKAddr(noKAddr);
                student.setNoKPhone(noKPhoneNumber);
                student.setState(state);
                student.setlGA(lGA);
                student.setHomeTown(homeTown);
                student.setHealthCardNo(healthCardNo);
                student.setDoB(doB);
                student.setExpiryDate(expiryDate);
                student.setGender(gender);
                student.setNiN(niN);
                student.setMedicalCardNo(medicalCardNo);


                QueryContract.StudentQuery studentQuery = new StudentQueryImplementation();
                studentQuery.updateStudent(student, new QueryResponse<Boolean>() {
                    @Override
                    public void onSuccess(Boolean data) {
                        getDialog().dismiss();
                        studentCrudListener.onStudentListUpdate(data);
                        Toast.makeText(getContext(), "Student updated successfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(String message) {
                        studentCrudListener.onStudentListUpdate(false);
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
    public void onClick(View v) {
        int id = v.getId();

        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            Uri imageUri;
            if (data != null) {
                imageUri = data.getData();
                photo = imageUri;
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
