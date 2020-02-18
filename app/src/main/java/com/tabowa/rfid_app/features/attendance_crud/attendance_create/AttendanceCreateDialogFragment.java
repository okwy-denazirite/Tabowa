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
import com.tabowa.rfid_app.features.student_crud.StudentCrudListener;
import com.tabowa.rfid_app.model.Attendance;

import static android.app.Activity.RESULT_OK;
import static com.tabowa.rfid_app.util.Constants.*;


public class AttendanceCreateDialogFragment extends DialogFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    private static AttendanceCrudListener attendanceCrudListener;

    public AttendanceCreateDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendance_create_dialog, container, false);

        return view;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
