package com.tabowa.rfid_app.features.medical_crud.medical_create;


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
import com.tabowa.rfid_app.features.medical_crud.MedicalCrudListener;
import com.tabowa.rfid_app.model.Medical;

import static android.app.Activity.RESULT_OK;
import static com.tabowa.rfid_app.util.Constants.*;


public class MedicalCreateDialogFragment extends DialogFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static MedicalCrudListener medicalCrudListener;

    private EditText medicalCardNumberEditText;
    private EditText bloodGroupEditText;
    private EditText conditionEditText;
    private EditText allergyEditText;
    private EditText medicalHistoryEditText;
    private EditText attendantDoctorEditText;
    private EditText attendantDoctorPhoneEditText;



    private Button createButton;
    private Button cancelButton;




    private String medicalCardNumberString = "";
    private String bloodGroupString = "";
    private String conditionString = "";
    private String allergyString = "";
    private String medicalHistoryString = "";
    private String attendantDoctorString = "";
    private String attendantDoctorPhoneString = "";




    public MedicalCreateDialogFragment() {
        // Required empty public constructor
    }


    public static com.tabowa.rfid_app.features.medical_crud.medical_create.MedicalCreateDialogFragment newInstance(String title, MedicalCrudListener listener){
        medicalCrudListener = listener;
        com.tabowa.rfid_app.features.medical_crud.medical_create.MedicalCreateDialogFragment medicalCreateDialogFragment = new com.tabowa.rfid_app.features.medical_crud.medical_create.MedicalCreateDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        medicalCreateDialogFragment.setArguments(args);

        medicalCreateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return medicalCreateDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_medical_create_dialog, container, false);

//        nameEditText = view.findViewById(R.id.medicalNameEditText);
//        registrationEditText = view.findViewById(R.id.registrationEditText);
//        phoneEditText = view.findViewById(R.id.phoneEditText);
//        emailEditText = view.findViewById(R.id.emailEditText);




        medicalCardNumberEditText       = view.findViewById(R.id.medicalMedicalCardNumberEditText);
        bloodGroupEditText     = view.findViewById(R.id.medicalBloodGroupEditText);
        conditionEditText          = view.findViewById(R.id.medicalConditionEditText);
        allergyEditText                = view.findViewById(R.id.medicalAllergyLEditText);
        medicalHistoryEditText          = view.findViewById(R.id.medicalHistoryEditText);
        attendantDoctorEditText        = view.findViewById(R.id.medicalAttendantDoctorEditText);
        attendantDoctorPhoneEditText                   = view.findViewById(R.id.medicalAttendantDoctorPhoneEditText);

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

                medicalCardNumberString = medicalCardNumberEditText.getText().toString();
                bloodGroupString = bloodGroupEditText.getText().toString();
                conditionString = conditionEditText.getText().toString();
                allergyString = allergyEditText.getText().toString();
                medicalHistoryString = medicalHistoryEditText.getText().toString();
                attendantDoctorString = attendantDoctorEditText.getText().toString();
                attendantDoctorPhoneString = attendantDoctorPhoneEditText.getText().toString();







//                final Medical medical = new Medical(-1, nameString, registrationNumber, phoneString, emailString);
//                final Medical medical = new Medical(-1, photo, nameString, registrationString, phoneString, emailString, departmentString, schoolString, programString, categoryString, sessionString, bloodGroup, noK, noKAddr, noKPhoneNumber, state, lGA, homeTown, healthCardNo, doB, expiryDate, gender, niN, medicalCardNo, thumbPrint);
                final Medical medical = new Medical(-1, medicalCardNumberString, bloodGroupString, conditionString, allergyString, medicalHistoryString, attendantDoctorString, attendantDoctorPhoneString);

                QueryContract.MedicalQuery medicalQuery = new MedicalQueryImplementation();
                medicalQuery.createMedical(medical, new QueryResponse<Boolean>() {
                    @Override
                    public void onSuccess(Boolean data) {
                        getDialog().dismiss();
                        medicalCrudListener.onMedicalListUpdate(data);
                        Toast.makeText(getContext(), "Medical created successfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(String message) {
                        medicalCrudListener.onMedicalListUpdate(false);
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
