package com.example.appcontacts;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView name;
    TextView phone;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.textViewName);
        phone = itemView.findViewById(R.id.textViewPhone);
    }

    public void setName(String name){
        this.name.setText(name);
    }

    public void setPhone(String phone){
        this.phone.setText(phone);
    }

}