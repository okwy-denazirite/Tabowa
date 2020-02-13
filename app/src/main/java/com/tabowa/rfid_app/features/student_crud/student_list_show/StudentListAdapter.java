package com.tabowa.rfid_app.features.student_crud.student_list_show;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tabowa.rfid_app.R;
import com.tabowa.rfid_app.database.*;
import com.tabowa.rfid_app.features.student_crud.StudentCrudListener;
import com.tabowa.rfid_app.features.student_crud.student_update.StudentUpdateDialogFragment;
import com.tabowa.rfid_app.features.taken_subject_crud.taken_subject_show.StudentTakenSubjectActivity;
import com.tabowa.rfid_app.model.Student;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.tabowa.rfid_app.util.Constants.*;

public class StudentListAdapter extends RecyclerView.Adapter<StudentViewHolder> {


    private Context context;
    private List<Student> studentList;
    private StudentCrudListener listener;
    final int REQUEST_CODE = 123;

    StudentListAdapter(Context context, List<Student> studentList, StudentCrudListener listener) {
        this.context = context;
        this.studentList = studentList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student_card_view, parent, false);
        return new StudentViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        final Student student = studentList.get(position);

        holder.nameTextView.setText(student.getName());
        holder.registrationNumTextView.setText(String.valueOf(student.getRegistrationNumber()));
        holder.departmentTextView.setText(student.getDepartment());
        holder.schoolTextView.setText(student.getSchool());
        holder.emailTextView.setText(student.getEmail());
        holder.phoneTextView.setText(student.getPhone());
        if (!student.getPhoto().toString().equals(" ")) {
            Uri uri = student.getPhoto();

            Picasso.get().setLoggingEnabled(true);
            Picasso.get().load(uri).into(holder.student_ImageView);
//            holder.student_ImageView.setImageURI(uri);
        }




        holder.editImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentUpdateDialogFragment dialogFragment = StudentUpdateDialogFragment.newInstance(student, "Update Student", new StudentCrudListener() {
                    @Override
                    public void onStudentListUpdate(boolean inUpdated) {
                        listener.onStudentListUpdate(inUpdated);
                    }
                });
                dialogFragment.show(((StudentListActivity) context).getSupportFragmentManager(), UPDATE_STUDENT);
            }
        });

        holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog(student.getId());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StudentTakenSubjectActivity.class);
                intent.putExtra(STUDENT_ID, student.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    private void showConfirmationDialog(final int studentId) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setMessage("Are you sure, You wanted to delete this student?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        QueryContract.StudentQuery query = new StudentQueryImplementation();
                        query.deleteStudent(studentId, new QueryResponse<Boolean>() {
                            @Override
                            public void onSuccess(Boolean data) {
                                if(data) {
                                    Toast.makeText(context, "Student deleted successfully", Toast.LENGTH_SHORT).show();
                                    listener.onStudentListUpdate(true);
                                }
                            }

                            @Override
                            public void onFailure(String message) {
                                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }



}
