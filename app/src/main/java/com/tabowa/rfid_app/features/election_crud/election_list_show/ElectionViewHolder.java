package com.tabowa.rfid_app.features.election_crud.election_list_show;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tabowa.rfid_app.R;

class ElectionViewHolder extends RecyclerView.ViewHolder {

//    TextView nameTextView;
//    TextView registrationNumTextView;
//    TextView emailTextView;
//    TextView phoneTextView;
//    ImageView editImageView;
//    ImageView deleteImageView;

    TextView nameTextView;
    TextView registrationNumTextView;
    TextView departmentTextView;
    TextView schoolTextView;
    TextView emailTextView;
    TextView phoneTextView;
    ImageView editImageView;
    ImageView deleteImageView;
    ImageView election_ImageView;



    ElectionViewHolder(View itemView) {
        super(itemView);
//        nameTextView = itemView.findViewById(R.id.nameTextView);
//        registrationNumTextView = itemView.findViewById(R.id.registrationNumTextView);
//        emailTextView = itemView.findViewById(R.id.emailTextView);
//        phoneTextView = itemView.findViewById(R.id.phoneTextView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        registrationNumTextView = itemView.findViewById(R.id.registrationNumTextView);
        departmentTextView = itemView.findViewById(R.id.departmentTextView);
        schoolTextView = itemView.findViewById(R.id.schoolTextView);
        emailTextView = itemView.findViewById(R.id.emailTextView);
        phoneTextView = itemView.findViewById(R.id.phoneTextView);
        editImageView = itemView.findViewById(R.id.editImageView);
        deleteImageView = itemView.findViewById(R.id.deleteImageView);
        election_ImageView = itemView.findViewById(R.id.imageView);
    }
}
