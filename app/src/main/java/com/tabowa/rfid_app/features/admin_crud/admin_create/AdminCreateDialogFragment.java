package com.tabowa.rfid_app.features.admin_crud.admin_create;


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
import com.tabowa.rfid_app.features.admin_crud.AdminCrudListener;
import com.tabowa.rfid_app.model.Admin;

import static android.app.Activity.RESULT_OK;
import static com.tabowa.rfid_app.util.Constants.*;


public class AdminCreateDialogFragment extends DialogFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static AdminCrudListener adminCrudListener;

    private EditText regNoEditText;
    private EditText programEditText;
    private EditText categoryEditText;
    private EditText sessionEditText;
    private EditText datePaymentEditText;
    private EditText modeOfPaymentEditText;
    private EditText amountPaidEditText;
    private EditText purposePaymentEditText;


    private Button createButton;
    private Button cancelButton;




    private String regNoString = "";
    private String programString = "";
    private String categoryString = "";
    private String sessionString = "";
    private String datePaymentString = "";
    private String modeOfPaymentString = "";
    private String amountPaidString = "";
    private String purposePaymentString = "";


    public AdminCreateDialogFragment() {
        // Required empty public constructor
    }


    public static com.tabowa.rfid_app.features.admin_crud.admin_create.AdminCreateDialogFragment newInstance(String title, AdminCrudListener listener){
        adminCrudListener = listener;
        com.tabowa.rfid_app.features.admin_crud.admin_create.AdminCreateDialogFragment adminCreateDialogFragment = new com.tabowa.rfid_app.features.admin_crud.admin_create.AdminCreateDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        adminCreateDialogFragment.setArguments(args);

        adminCreateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return adminCreateDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_create_dialog, container, false);

//        nameEditText = view.findViewById(R.id.adminNameEditText);
//        registrationEditText = view.findViewById(R.id.registrationEditText);
//        phoneEditText = view.findViewById(R.id.phoneEditText);
//        emailEditText = view.findViewById(R.id.emailEditText);



        regNoEditText = view.findViewById(R.id.adminRegNoEditText);
        sessionEditText = view.findViewById(R.id.adminSessionEditText);
        categoryEditText = view.findViewById(R.id.adminCategoryEditText);
        programEditText = view.findViewById(R.id.adminProgramEditText);
        datePaymentEditText = view.findViewById(R.id.adminDatePaymentLayout);
        modeOfPaymentEditText = view.findViewById(R.id.adminModeOfPaymentEditText);
        categoryEditText = view.findViewById(R.id.adminCategoryEditText);
        amountPaidEditText = view.findViewById(R.id.adminAmountPaidEditText);
        purposePaymentEditText = view.findViewById(R.id.adminPurposePaymentEditText);


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

                regNoString = regNoEditText .getText().toString();
                programString = programEditText .getText().toString();
                categoryString = categoryEditText .getText().toString();
                sessionString = sessionEditText .getText().toString();
                datePaymentString = datePaymentEditText .getText().toString();
                modeOfPaymentString = modeOfPaymentEditText .getText().toString();
                amountPaidString = amountPaidEditText .getText().toString();


//                final Admin admin = new Admin(-1, nameString, registrationNumber, phoneString, emailString);
//                final Admin admin = new Admin(-1, photo, nameString, registrationString, phoneString, emailString, departmentString, schoolString, programString, categoryString, sessionString, bloodGroup, noK, noKAddr, noKPhoneNumber, state, lGA, homeTown, healthCardNo, doB, expiryDate, gender, niN, medicalCardNo, thumbPrint);
                final Admin admin = new Admin(-1, regNoString, programString, categoryString, sessionString, datePaymentString, modeOfPaymentString, amountPaidString, purposePaymentString);

                QueryContract.AdminQuery adminQuery = new AdminQueryImplementation();
                adminQuery.createAdmin(admin, new QueryResponse<Boolean>() {
                    @Override
                    public void onSuccess(Boolean data) {
                        getDialog().dismiss();
                        adminCrudListener.onAdminListUpdate(data);
                        Toast.makeText(getContext(), "Admin created successfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(String message) {
                        adminCrudListener.onAdminListUpdate(false);
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
