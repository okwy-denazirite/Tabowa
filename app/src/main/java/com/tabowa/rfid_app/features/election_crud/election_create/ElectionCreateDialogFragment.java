package com.tabowa.rfid_app.features.election_crud.election_create;


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
import com.tabowa.rfid_app.features.election_crud.ElectionCrudListener;
import com.tabowa.rfid_app.model.Election;

import static android.app.Activity.RESULT_OK;
import static com.tabowa.rfid_app.util.Constants.*;


public class ElectionCreateDialogFragment extends DialogFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static ElectionCrudListener electionCrudListener;

    private EditText   registrationNumberEditText;
    private EditText   contestantNameEditText;
    private EditText   positionEditText;
    private EditText   electionDateEditText;
    private EditText   clearanceStatusEditText;
    private EditText   votingStatusEditText;




    private Button createButton;
    private Button cancelButton;




    private String registrationNumber = "";
    private String contestantName = "";
    private String position = "";
    private String electionDate = "";
    private String clearanceStatus = "";
    private String votingStatus = "";



    public ElectionCreateDialogFragment() {
        // Required empty public constructor
    }


    public static com.tabowa.rfid_app.features.election_crud.election_create.ElectionCreateDialogFragment newInstance(String title, ElectionCrudListener listener){
        electionCrudListener = listener;
        com.tabowa.rfid_app.features.election_crud.election_create.ElectionCreateDialogFragment electionCreateDialogFragment = new com.tabowa.rfid_app.features.election_crud.election_create.ElectionCreateDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        electionCreateDialogFragment.setArguments(args);

        electionCreateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return electionCreateDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_election_create_dialog, container, false);

//        nameEditText = view.findViewById(R.id.electionNameEditText);
//        registrationEditText = view.findViewById(R.id.registrationEditText);
//        phoneEditText = view.findViewById(R.id.phoneEditText);
//        emailEditText = view.findViewById(R.id.emailEditText);



        registrationNumberEditText = view.findViewById(R.id.electionRegNoEditText);
        contestantNameEditText   = view.findViewById(R.id.electionContestantNameEditText);
        positionEditText    = view.findViewById(R.id.electionPositionEditText);
        electionDateEditText   = view.findViewById(R.id.electionDateEditText);
        clearanceStatusEditText       = view.findViewById(R.id.electionClearanceStatusEditText);
        votingStatusEditText         = view.findViewById(R.id.electionVotingStatusEditText);


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

            registrationNumber =  registrationNumberEditText.getText().toString();
            contestantName  = contestantNameEditText.getText().toString();
            position  = positionEditText.getText().toString();
            electionDate  = electionDateEditText.getText().toString();
            clearanceStatus =  clearanceStatusEditText.getText().toString();
            votingStatus  = votingStatusEditText.getText().toString();







//                final Election election = new Election(-1, nameString, registrationNumber, phoneString, emailString);
//                final Election election = new Election(-1, photo, nameString, registrationString, phoneString, emailString, departmentString, schoolString, programString, categoryString, sessionString, bloodGroup, noK, noKAddr, noKPhoneNumber, state, lGA, homeTown, healthCardNo, doB, expiryDate, gender, niN, medicalCardNo, thumbPrint);
                final Election election = new Election(-1, registrationNumber, contestantName, position, electionDate, clearanceStatus, votingStatus);

                QueryContract.ElectionQuery electionQuery = new ElectionQueryImplementation();
                electionQuery.createElection(election, new QueryResponse<Boolean>() {
                    @Override
                    public void onSuccess(Boolean data) {
                        getDialog().dismiss();
                        electionCrudListener.onElectionListUpdate(data);
                        Toast.makeText(getContext(), "Election created successfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(String message) {
                        electionCrudListener.onElectionListUpdate(false);
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
