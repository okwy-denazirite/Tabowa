package com.tabowa.rfid_app.features.student_crud.student_create;

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
import com.tabowa.rfid_app.features.student_crud.StudentCrudListener;
import com.tabowa.rfid_app.model.Student;

import static android.app.Activity.RESULT_OK;
import static com.tabowa.rfid_app.util.Constants.*;


public class StudentCreateDialogFragment extends DialogFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static StudentCrudListener studentCrudListener;


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


    private Button createButton;
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
    private String thumbPrint = " ";

    private static final int PICK_IMAGE = 100;

    public StudentCreateDialogFragment() {
        // Required empty public constructor
    }

    public static StudentCreateDialogFragment newInstance(String title, StudentCrudListener listener){
        studentCrudListener = listener;
        StudentCreateDialogFragment studentCreateDialogFragment = new StudentCreateDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        studentCreateDialogFragment.setArguments(args);

        studentCreateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return studentCreateDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_student_create_dialog, container, false);

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



        createButton = view.findViewById(R.id.createButton);
        cancelButton = view.findViewById(R.id.cancelButton);


        String title = getArguments().getString(TITLE);
        getDialog().setTitle(title);

        photoimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                nameString = nameEditText.getText().toString();
//                registrationNumber = Integer.parseInt(registrationEditText.getText().toString());
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
                thumbPrint = "X";

//                final Student student = new Student(-1, nameString, registrationNumber, phoneString, emailString);
                final Student student = new Student(-1, photo, nameString, registrationString, phoneString, emailString, departmentString, schoolString, programString, categoryString, sessionString, bloodGroup, noK, noKAddr, noKPhoneNumber, state, lGA, homeTown, healthCardNo, doB, expiryDate, gender, niN, medicalCardNo, thumbPrint);

                QueryContract.StudentQuery studentQuery = new StudentQueryImplementation();
                studentQuery.createStudent(student, new QueryResponse<Boolean>() {
                    @Override
                    public void onSuccess(Boolean data) {
                        getDialog().dismiss();
                        studentCrudListener.onStudentListUpdate(data);
                        Toast.makeText(getContext(), "Student created successfully", Toast.LENGTH_LONG).show();
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

        Intent gallery;
     //   gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);



        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            gallery = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            gallery.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            gallery.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
        }else{
            gallery = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        }
        gallery.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        gallery.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        gallery.setType("image/*");
//        startActivityForResult(gallery, PICK_IMAGE);
        startActivityForResult(Intent.createChooser(gallery, getResources().getString(R.string.form_pick_photos)), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            Uri imageUri;
            if (data != null) {
                imageUri = data.getData();
                photo = imageUri;
                photoimageView.setImageURI(imageUri);

                // kitkat fixed (broke) content access; to keep the URIs valid over restarts need to persist access permission
                if(Build.VERSION.SDK_INT >= 19) {
                    final int takeFlags = data.getFlags() & Intent.FLAG_GRANT_READ_URI_PERMISSION;
                    ContentResolver resolver = getActivity().getContentResolver();
                //    for (Uri uri : images) {
                        resolver.takePersistableUriPermission(imageUri, takeFlags);
                  //  }
                }

//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {getContext().getContentResolver()
//                        .takePersistableUriPermission (imageUri,
//                        Intent.FLAG_GRANT_READ_URI_PERMISSION|Intent.FLAG_GRANT_WRITE_URI_PERMISSION); }
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
