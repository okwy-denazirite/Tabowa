package com.tabowa.rfid_app.mainMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tabowa.rfid_app.R;
import com.tabowa.rfid_app.features.student_crud.student_list_show.StudentListActivity;


public class MainMenu extends AppCompatActivity {


    private Button mStudentnfo;
    private Button mElection;
    private Button mTools;
    private Button mHelp;
    private Button mAccounts;

    private Intent mOldIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    public void onShowAccounts(View view) {
        Intent intent = new Intent(this, com.tabowa.rfid_app.features.student_crud.student_create.StudentCreateDialogFragment.class);
        startActivity(intent);
    }

    public void onShowStudentinfo(View view) {
        Intent intent = new Intent(MainMenu.this, StudentListActivity.class);
        startActivity(intent);
    }

    public void onOpenElection(View view) {
    }

    public void onOpenNYI(View view) {
    }

    public void onShowTools(View view) {
    }

    public void onShowHelp(View view) {
    }
}
