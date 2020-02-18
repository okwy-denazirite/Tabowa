package com.tabowa.rfid_app.features.election_crud.election_create;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tabowa.rfid_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElectionCreateDialogFragment extends Fragment {


    public ElectionCreateDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_election_create_dialog, container, false);
    }

}
