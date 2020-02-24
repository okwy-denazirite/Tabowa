package com.tabowa.rfid_app.features.security_crud.security_create;


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
import com.tabowa.rfid_app.features.security_crud.SecurityCrudListener;
import com.tabowa.rfid_app.model.Security;

import static android.app.Activity.RESULT_OK;
import static com.tabowa.rfid_app.util.Constants.*;


public class SecurityCreateDialogFragment extends DialogFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static SecurityCrudListener securityCrudListener;

    private EditText wantedEditText ;
    private EditText wantedDateEditText ;
    private EditText acquittedEditText ;
    private EditText close_investigationDateEditText ;
    private EditText crimeNameEditText ;
    private EditText num_registerdOffencesEditText ;
    private EditText listOfCrimesEditText ;
    private EditText dateOfArrestEditText ;



    private Button createButton;
    private Button cancelButton;



    private String wantedString = "";
    private String wantedDateString = "";
    private String acquittedString = "";
    private String close_investigationDateString = "";
    private String crimeNameString = "";
    private String num_registerdOffencesString = "";
    private String listOfCrimesString = "";
    private String dateOfArrestString = "";




    public SecurityCreateDialogFragment() {
        // Required empty public constructor
    }


    public static com.tabowa.rfid_app.features.security_crud.security_create.SecurityCreateDialogFragment newInstance(String title, SecurityCrudListener listener){
        securityCrudListener = listener;
        com.tabowa.rfid_app.features.security_crud.security_create.SecurityCreateDialogFragment securityCreateDialogFragment = new com.tabowa.rfid_app.features.security_crud.security_create.SecurityCreateDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        securityCreateDialogFragment.setArguments(args);

        securityCreateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return securityCreateDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_security_create_dialog, container, false);

//        nameEditText = view.findViewById(R.id.securityNameEditText);
//        registrationEditText = view.findViewById(R.id.registrationEditText);
//        phoneEditText = view.findViewById(R.id.phoneEditText);
//        emailEditText = view.findViewById(R.id.emailEditText);

        wantedEditText = view.findViewById(R.id.securityWantedEditText);
        wantedDateEditText = view.findViewById(R.id.securitydateOfArrestEditText);
        acquittedEditText = view.findViewById(R.id.securitydateOfAcquittalEditText);
        close_investigationDateEditText = view.findViewById(R.id.securityCloseInvestigationDateEditText);
        crimeNameEditText = view.findViewById(R.id.securityCrimeNameEditText);
        num_registerdOffencesEditText = view.findViewById(R.id.securityNumRegisterdOffencesEditText);
        listOfCrimesEditText = view.findViewById(R.id.securityListOfCrimesEditText);
        dateOfArrestEditText = view.findViewById(R.id.securitydateOfArrestEditText);

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

              wantedString 	= wantedEditText.getText().toString();
              wantedDateString  = wantedDateEditText.getText().toString();
              acquittedString  = acquittedEditText.getText().toString();
              close_investigationDateString = close_investigationDateEditText.getText().toString();
              crimeNameString  = crimeNameEditText.getText().toString();
              num_registerdOffencesString = num_registerdOffencesEditText.getText().toString();
              listOfCrimesString  = listOfCrimesEditText.getText().toString();
              dateOfArrestString  = dateOfArrestEditText.getText().toString();







//                final Security security = new Security(-1, nameString, registrationNumber, phoneString, emailString);
//                final Security security = new Security(-1, photo, nameString, registrationString, phoneString, emailString, departmentString, schoolString, programString, categoryString, sessionString, bloodGroup, noK, noKAddr, noKPhoneNumber, state, lGA, homeTown, healthCardNo, doB, expiryDate, gender, niN, securityCardNo, thumbPrint);
                final Security security = new Security(-1, wantedString, wantedDateString, acquittedString, close_investigationDateString, crimeNameString, num_registerdOffencesString, listOfCrimesString, dateOfArrestString);

                QueryContract.SecurityQuery securityQuery = new SecurityQueryImplementation();
                securityQuery.createSecurity(security, new QueryResponse<Boolean>() {
                    @Override
                    public void onSuccess(Boolean data) {
                        getDialog().dismiss();
                        securityCrudListener.onSecurityListUpdate(data);
                        Toast.makeText(getContext(), "Security created successfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(String message) {
                        securityCrudListener.onSecurityListUpdate(false);
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
